import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OD1I extends Remote {
    public void A() throws RemoteException;
    public void B() throws RemoteException;
    public void C() throws RemoteException;

    void waitA() throws RemoteException;
    void waitB() throws RemoteException;
    void waitC() throws RemoteException;
}
