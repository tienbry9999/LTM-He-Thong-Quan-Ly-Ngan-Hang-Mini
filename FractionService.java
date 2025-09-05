package SuDungRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface RMI: chỉ cần phương thức cộng
public interface FractionService extends Remote {
    Fraction addFractions(Fraction a, Fraction b) throws RemoteException;
}
