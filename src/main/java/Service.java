
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service extends Remote {
    int multiply(int x, int y) throws RemoteException;
    double add(int x, int y) throws RemoteException;

}
