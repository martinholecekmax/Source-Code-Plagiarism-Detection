public class UserHomeInitScriptFinder extends DirectoryInitScriptFinder implements InitScriptFinder {
    public void findScripts(GradleInternal gradle, Collection<ScriptSource> scripts) {
        File userHomeDir = gradle.getStartParameter().getGradleUserHomeDir();
        File userInitScript = new File(userHomeDir, "init.gradle");
        if (userInitScript.isFile()) {
            scripts.add(new UriScriptSource("initialization script", userInitScript));
        }
        findScriptsInDir(new File(userHomeDir, "init.d"), scripts);
    }
}