import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMIServer {
    public static final String RMI_HOSTNAME = "java.rmi.server.hostname";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {

        final ServiceImpl server = new ServiceImpl();

        final Registry registry = LocateRegistry.createRegistry(8080);

        Remote stub = UnicastRemoteObject.exportObject(server, 0);

        registry.bind(RMI_HOSTNAME, stub);

        Thread.sleep(Integer.MAX_VALUE);

    }

}