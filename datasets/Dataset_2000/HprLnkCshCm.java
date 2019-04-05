@DecrypterPlugin(revision = "$Revision$", interfaceVersion = 2, names = { "HyperLinkCash.com" }, urls = { "http:public class HprLnkCshCm extends PluginForDecrypt {
    public HprLnkCshCm(PluginWrapper wrapper) {
        super(wrapper);
    }
    public ArrayList<DownloadLink> decryptIt(CryptedLink param, ProgressController progress) throws Exception {
        ArrayList<DownloadLink> decryptedLinks = new ArrayList<DownloadLink>();
        String parameter = param.toString();
        br.getPage(parameter);
        String dlink = br.getRegex("<center>.*?<br>.*?<a href=\"(.*?)\"").getMatch(0);
        if (dlink == null) dlink = br.getRegex("<a href=\"(.*?)\"").getMatch(0);
        if (dlink == null || dlink.equals("http:            Form form = br.getForm(0);
            if (form == null) return null;
            br.submitForm(form);
            dlink = br.getRegex("<center>.*?<br>.*?<a href=\"(.*?)\"").getMatch(0);
            if (dlink == null) dlink = br.getRegex("<a href=\"(.*?)\"").getMatch(0);
            if (dlink == null) return null;
        }
        decryptedLinks.add(createDownloadlink(dlink));
        return decryptedLinks;
    }
}