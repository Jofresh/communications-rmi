import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OD2Impl extends UnicastRemoteObject implements OD2I {
    private boolean doneG = false;

    public OD2Impl() throws RemoteException {
        super();
    }

    @Override
    synchronized public void G() throws RemoteException {
        System.out.println("La méthode G vient d'être invoquée.");
        doneG = true;
        notifyAll();
    }

    @Override
    synchronized public void waitG() throws RemoteException {
        if (!doneG) {
            try {
                wait();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
