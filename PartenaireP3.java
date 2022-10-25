import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PartenaireP3 {
    public static void main(String[] args) {
        OD1I od1; OD2I od2; OD3I od3;

        try {
            od3 = new OD3Impl();

            Registry reg3 = LocateRegistry.createRegistry(1099);
            reg3.rebind("OD3I", od3);

            Registry reg1 = LocateRegistry.getRegistry("adresse P1");
            Registry reg2 = LocateRegistry.getRegistry("adresse P2");

            od1 = (OD1I) reg1.lookup("OD1I");
            od2 = (OD2I) reg2.lookup("OD2I");

            P3 p3 = new P3(od1, od2, od3);
            p3.start();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
