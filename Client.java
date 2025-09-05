package SuDungRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            FractionService service = (FractionService) registry.lookup("FractionService");

            // Tạo 2 phân số
            Fraction f1 = new Fraction(1, 2);
            Fraction f2 = new Fraction(3, 4);

            // Gọi phương thức cộng từ server
            Fraction result = service.addFractions(f1, f2);

            System.out.println(f1 + " + " + f2 + " = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
