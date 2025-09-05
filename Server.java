package SuDungRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;

public class Server {
    public static void main(String[] args) {
        int port = 1099;
        Registry registry = null;

        while (true) {
            try {
                registry = LocateRegistry.createRegistry(port);
                System.out.println("Registry RMI chạy trên cổng " + port);
                break;
            } catch (ExportException e) {
                System.out.println("Cổng " + port + " đã bị chiếm, thử cổng khác...");
                port++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }

        try {
            FractionService service = new FractionServiceImpl();
            registry.rebind("FractionService", service);
            System.out.println("Server sẵn sàng để cộng phân số!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
