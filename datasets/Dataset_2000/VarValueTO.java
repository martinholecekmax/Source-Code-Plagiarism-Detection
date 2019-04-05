public class VarValueTO {
	public String name;
	public int valueId;
	public String stringRep;
	public String simpleRep;
	public boolean hasMembers;
		public VarValueTO() {
	}
	public VarValueTO(String name) {
		this.name = name;
	}
		public void writeContent(DataOutputStream out) throws IOException {
		out.writeUTF(name);
		out.writeInt(valueId);
		out.writeUTF(stringRep);
		if (simpleRep == null) {
			System.out.println("simpleRep of " + stringRep + " is null.");
		}
		out.writeUTF(simpleRep);
		out.writeBoolean(hasMembers);
	}
	public void readContent(DataInputStream in) throws IOException {
		name = in.readUTF();
		valueId = in.readInt();
		stringRep = in.readUTF();
		simpleRep = in.readUTF();
		hasMembers = in.readBoolean();
	}
}