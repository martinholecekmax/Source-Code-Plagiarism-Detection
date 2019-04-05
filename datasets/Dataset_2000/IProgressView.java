public interface IProgressView extends Remote {
    public boolean existsPorgress() throws RemoteException;
    
    public void removeProgress() throws RemoteException;
    public void removeProcess(int index) throws RemoteException;
    
    public void waitUntilNotExistsProgress() throws RemoteException;
}