import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OD1Impl extends UnicastRemoteObject implements OD1I {
    private boolean doneA = false, doneB = false, doneC = false;

    public OD1Impl() throws RemoteException {
        super();
    }

    @Override
    synchronized public void A() throws RemoteException {
        System.out.println("La méthode A vient d'être invoquée.");
        doneA = true;
        notifyAll();
    }

    @Override
    synchronized public void B() throws RemoteException {
        System.out.println("La méthode B vient d'être invoquée.");
        doneB = true;
        notifyAll();
    }

    @Override
    synchronized public void C() throws RemoteException {
        System.out.println("La méthode C vient d'être invoquée.");
        doneC = true;
        notifyAll();
    }

    @Override
    synchronized public void waitA() throws RemoteException {
        if (!doneA) {
            try {
                wait();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    @Override
    synchronized public void waitB() throws RemoteException {
        if (!doneB) {
            try {
                wait();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    @Override
    synchronized public void waitC() throws RemoteException {
        if (!doneC) {
            try {
                wait();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
