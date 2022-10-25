import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OD3I extends Remote {
    public void E() throws RemoteException;
    public void F() throws RemoteException;

    public void waitE() throws RemoteException;
    public void waitF() throws RemoteException;
}
