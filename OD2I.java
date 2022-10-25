import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OD2I extends Remote {
    public void G() throws RemoteException;

    public void waitG() throws RemoteException;
}
