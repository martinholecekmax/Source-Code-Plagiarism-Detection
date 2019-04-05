class GherkinFormatTask implements ReformatTask {
    private final Context context;
    public GherkinFormatTask(Context context) {
        this.context = context;
    }
    private boolean doReformat() {
        boolean format = true;
        StackTraceElement[] calling_stack = new Exception().getStackTrace();
        for (StackTraceElement stackTraceElement : calling_stack) {
            if (stackTraceElement.getClassName().equals("org.netbeans.lib.editor.codetemplates.CodeTemplateInsertHandler")) {
                format = false;
                break;
            }
        }
        return format;
    }
    public void reformat() throws BadLocationException {
        if (doReformat()) {
            try {
                String source = context.document().getText(0, context.document().getLength());
                StringWriter reformattedWriter = new StringWriter();
                PrettyFormatter formatter = new PrettyFormatter(reformattedWriter, true);
                Parser parser = new Parser(formatter, true);
                parser.parse(source, "UNKNOWN", 0);                 writeSource(reformattedWriter.getBuffer().toString());
            } catch (Exception e) {
                showError(e);
            }
        }
    }
    private void writeSource(String reformattedSource) throws BadLocationException {
        context.document().remove(0, context.document().getLength());
        context.document().insertString(0, reformattedSource, null);
    }
    public ExtraLock reformatLock() {
        return null;
    }
    private void showError(Exception e) {
        InputOutput io;
        OutputWriter outputWriter;
        io = IOProvider.getDefault().getIO("Cucumber", false);
        io.select();
        outputWriter = io.getOut();
        e.printStackTrace(outputWriter);
                    }
}