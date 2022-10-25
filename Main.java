import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) {
        OD1I od1 = null;
        OD2I od2 = null;
        OD3I od3 = null;

        try {
            od1 = new OD1Impl();
            od2 = new OD2Impl();
            od3 = new OD3Impl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        P1 p1 = new P1(od1, od2, od3);
        P2 p2 = new P2(od1, od2, od3);
        P3 p3 = new P3(od1, od2, od3);

        p1.start();
        p2.start();
        p3.start();

        try {
            p1.join();
            p2.join();
            p3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
