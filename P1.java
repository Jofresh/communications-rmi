import java.rmi.RemoteException;

public class P1 extends Thread {
    private OD1I od1;
    private OD2I od2;
    private OD3I od3;

    public P1(OD1I od1, OD2I od2, OD3I od3) {
        this.od1 = od1;
        this.od2 = od2;
        this.od3 = od3;
    }

    @Override
    public void run() {
        try {
            od1.waitA();
            od1.waitB();
            od3.waitE();
            od2.G();
            od1.waitC();
            od3.waitF();
        } catch (RemoteException e) { e.printStackTrace(); }
    }
}
