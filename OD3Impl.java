import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OD3Impl extends UnicastRemoteObject implements OD3I {
    private boolean doneE = false, doneF = false;

    public OD3Impl() throws RemoteException {
        super();
    }

    @Override
    synchronized public void E() throws RemoteException {
        System.out.println("La méthode E vient d'être invoquée.");
        doneE = true;
        notifyAll();
    }

    @Override
    synchronized public void waitE() throws RemoteException {
        if (!doneE) {
            try {
                wait();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    @Override
    synchronized public void F() throws RemoteException {
        System.out.println("La méthode F vient d'être invoquée.");
        doneF = true;
        notifyAll();
    }

    @Override
    synchronized public void waitF() throws RemoteException {
        if (!doneF) {
            try {
                wait();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
