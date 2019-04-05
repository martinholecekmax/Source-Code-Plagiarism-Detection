public class CommandParticipantA2 extends CommandParticipant {
	public CommandParticipantA2(SequenceDiagram sequenceDiagram) {
		super(sequenceDiagram, getRegexConcat());
	}
	static RegexConcat getRegexConcat() {
		return new RegexConcat(new RegexLeaf("^"), 				new RegexLeaf("TYPE", "(participant|actor|create)"), 				new RegexLeaf("\\s+"), 				new RegexLeaf("CODE", "([\\p{L}0-9_.@]+)"), 				new RegexLeaf("\\s+as\\s+"), 				new RegexLeaf("FULL", "\"([^\"]+)\""), 				new RegexLeaf("STEREO", "(?:\\s*(\\<\\<.*\\>\\>))?"), 				new RegexLeaf("\\s*"), 				new RegexLeaf("COLOR", "(#\\w+)?"), 				new RegexLeaf("$"));
	}
}