public interface DataTransferCallback {
	public class TransferParameters{
		public final Socket clientSocket;
		public final BufferedReader inFromHost;
		public final DataOutputStream outToHost;
		public TransferParameters(Socket socket, BufferedReader inFromHost, DataOutputStream outToHost){
			this.clientSocket = socket;
			this.inFromHost = inFromHost;
			this.outToHost = outToHost;
		}
	}
	public void transferData(TransferParameters parameters);
}