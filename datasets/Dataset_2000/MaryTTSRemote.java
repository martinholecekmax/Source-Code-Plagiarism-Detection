public class MaryTTSRemote {
	
	public static void main(String[] args) throws Exception {
		if (args.length < 2) {
			System.err.println("Usage: java example.MaryTTSRemote hostname portnumber");
			System.exit(1);
		}
		String hostname = args[0];
		int port = Integer.valueOf(args[1]);
		MaryInterface marytts = new RemoteMaryInterface(hostname, port);
		Set<String> voices = marytts.getAvailableVoices();
		marytts.setVoice(voices.iterator().next());
		AudioInputStream audio = marytts.generateAudio("Hello world.");
		AudioPlayer player = new AudioPlayer(audio);
		player.start();
		player.join();
		System.exit(0);
	}
}