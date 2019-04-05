public class T6402077 {
    public static void main(String... args) throws IOException {
        class MyFileObject extends SimpleJavaFileObject {
            MyFileObject() {
                super(URI.create("myfo:            }
            @Override
            public String getCharContent(boolean ignoreEncodingErrors) {
                                                return "class Test { Test() { } }";
            }
        }
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        List<JavaFileObject> compilationUnits =
                Collections.<JavaFileObject>singletonList(new MyFileObject());
        JavacTask task = (JavacTask)javac.getTask(null, null, null, null, null,
                                                  compilationUnits);
        Trees trees = Trees.instance(task);
        CompilationUnitTree toplevel = task.parse().iterator().next();
        Tree tree = ((ClassTree)toplevel.getTypeDecls().get(0)).getMembers().get(0);
        long pos = trees.getSourcePositions().getStartPosition(toplevel, tree);
        if (pos != 13)
            throw new AssertionError(String.format("Start pos for %s is incorrect (%s)!",
                                                   tree, pos));
        pos = trees.getSourcePositions().getEndPosition(toplevel, tree);
        if (pos != 23)
            throw new AssertionError(String.format("End pos for %s is incorrect (%s)!",
                                                   tree, pos));
    }
}