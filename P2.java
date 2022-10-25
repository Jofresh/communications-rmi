import java.rmi.RemoteException;

public class P2 extends Thread {
    private OD1Impl od1;
    private OD2Impl od2;
    private OD3Impl od3;

    public P2(OD1Impl od1, OD2Impl od2, OD3Impl od3) {
        this.od1 = od1;
        this.od2 = od2;
        this.od3 = od3;
    }

    @Override
    public void run() {
        try {
            od1.A();
            od1.waitB();
            od3.E();
            od2.waitG();
            od1.waitC();
            od3.F();
        } catch (RemoteException e) { e.printStackTrace(); }
    }
}
