import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PartenaireP2 {
    public static void main(String[] args) {
        OD1I od1; OD2I od2; OD3I od3;

        try {
            od2 = new OD2Impl();

            Registry reg2 = LocateRegistry.createRegistry(1099);
            reg2.rebind("OD2I", od2);

            Registry reg1 = LocateRegistry.getRegistry("adresse P1");
            Registry reg3 = LocateRegistry.getRegistry("adresse P3");

            od1 = (OD1I) reg1.lookup("OD1I");
            od3 = (OD3I) reg3.lookup("OD3I");

            P2 p2 = new P2(od1, od2, od3);
            p2.start();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
