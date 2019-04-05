public class FeatureTransformer {
    public static void transform(URL url, OutputStream os) throws Exception {
                String name = url.getPath();
        int idx = name.lastIndexOf('/');
        if (idx >= 0) {
            name = name.substring(idx + 1);
        }
        String[] str = DeployerUtils.extractNameVersionType(name);
                Manifest m = new Manifest();
        m.getMainAttributes().putValue("Manifest-Version", "2");
        m.getMainAttributes().putValue(Constants.BUNDLE_MANIFESTVERSION, "2");
        m.getMainAttributes().putValue(Constants.BUNDLE_SYMBOLICNAME, str[0]);
        m.getMainAttributes().putValue(Constants.BUNDLE_VERSION, str[1]);
                JarOutputStream out = new JarOutputStream(os);
        ZipEntry e = new ZipEntry(JarFile.MANIFEST_NAME);
        out.putNextEntry(e);
        m.write(out);
        out.closeEntry();
        e = new ZipEntry("META-INF/");
        out.putNextEntry(e);
        e = new ZipEntry("META-INF/" + FeatureDeploymentListener.FEATURE_PATH + "/");
        out.putNextEntry(e);
        out.closeEntry();
        e = new ZipEntry("META-INF/" + FeatureDeploymentListener.FEATURE_PATH + "/" + name);
        out.putNextEntry(e);
        InputStream fis = url.openStream();
        try {
            copyInputStream(fis, out);
        } finally {
            fis.close();
        }
        out.closeEntry();
        out.close();
        os.close();
    }
    private static void copyInputStream(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8192];
        int len = in.read(buffer);
        while (len >= 0) {
            out.write(buffer, 0, len);
            len = in.read(buffer);
        }
    }
}