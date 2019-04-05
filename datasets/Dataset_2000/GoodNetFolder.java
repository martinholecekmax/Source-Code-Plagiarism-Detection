@DecrypterPlugin(revision = "$Revision$", interfaceVersion = 2, names = { "good.net" }, urls = { "http:public class GoodNetFolder extends PluginForDecrypt {
    public GoodNetFolder(PluginWrapper wrapper) {
        super(wrapper);
    }
            public ArrayList<DownloadLink> decryptIt(CryptedLink param, ProgressController progress) throws Exception {
        ArrayList<DownloadLink> decryptedLinks = new ArrayList<DownloadLink>();
        String parameter = param.toString();
        br.setFollowRedirects(false);
        if (parameter.endsWith("/")) {
            br.getPage(parameter);
            String[] filenames = br.getRegex("<img src=\".*?\" alt=\".*?\"> <a href=\"(.*?)\">").getColumn(0);
            if (filenames == null || filenames.length == 0) br.getRegex("href=\".*?\">(.*?\\..*?)</a>").getColumn(0);
            if (filenames == null || filenames.length == 0) return null;
            progress.setRange(filenames.length);
            for (String filename : filenames) {
                br.getPage(parameter + filename);
                String finallink = br.getRedirectLocation();
                if (finallink != null) decryptedLinks.add(createDownloadlink(finallink.replace("good.net", "gjerzu4zr4jk555hd")));
                progress.increase(1);
            }
        } else {
            decryptedLinks.add(createDownloadlink(parameter.replace("good.net", "gjerzu4zr4jk555hd")));
        }
        return decryptedLinks;
    }
}