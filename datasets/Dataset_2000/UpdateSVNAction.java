public class UpdateSVNAction extends AbstractAction {
    private TranslatorGui gui;
    public UpdateSVNAction(TranslatorGui gui) {
        super("Update");
        this.gui = gui;
    }
    public void actionPerformed(ActionEvent e) {
        new Thread(new Runnable() {
            public void run() {
                gui.setSvnBusy(true);
                File wd = new File(Application.getHome());
                if (!wd.exists()) wd.mkdirs();
                Subversion svn = null;
                try {
                    svn = new Subversion("svn:                    svn.update(wd, null);
                    svn.dispose();
                } catch (SVNException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        svn.dispose();
                    } catch (final Throwable e) {
                    }
                }
                gui.setSvnBusy(false);
            }
        }).start();
    }
}