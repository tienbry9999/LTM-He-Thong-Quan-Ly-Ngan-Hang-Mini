package SuDungRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Server triển khai phương thức cộng phân số
public class FractionServiceImpl extends UnicastRemoteObject implements FractionService {
    protected FractionServiceImpl() throws RemoteException { super(); }

    @Override
    public Fraction addFractions(Fraction a, Fraction b) throws RemoteException {
        int tu = a.getNumerator() * b.getDenominator() + b.getNumerator() * a.getDenominator();
        int mau = a.getDenominator() * b.getDenominator();
        return new Fraction(tu, mau);
    }
}
