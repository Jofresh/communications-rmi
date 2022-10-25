import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PartenaireP1 {
    public static void main(String[] args) {
        OD1I od1; OD2I od2; OD3I od3;
        
        try {
            od1 = new OD1Impl();
            
            Registry reg1 = LocateRegistry.createRegistry(1099);
            reg1.rebind("OD1I", od1);
            
            Registry reg2 = LocateRegistry.getRegistry("adresse P2");
            Registry reg3 = LocateRegistry.getRegistry("adresse P3");

            od2 = (OD2I) reg2.lookup("OD2I");
            od3 = (OD3I) reg3.lookup("OD3I");

            P1 p1 = new P1(od1, od2, od3);
            p1.start();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}