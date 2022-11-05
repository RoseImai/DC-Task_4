import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class RMIClient {
    public static final String RMI_HOSTNAME = "java.rmi.server.hostname";
    public static void main(String[] args) throws RemoteException, NotBoundException {

        final Registry registry = LocateRegistry.getRegistry(8080);

        Service calculator = (Service) registry.lookup(RMI_HOSTNAME);

        Random rand = new Random();
        Instant str = Instant.now();
        for(int i = 1; i<=100000; i++)
        {
            int multiplyResult = calculator.multiply(rand.nextInt(1000), rand.nextInt(1000));
            double addResult = calculator.add(rand.nextInt(1000), rand.nextInt(1000));
            System.out.println("Multiplication " + i + " : " + multiplyResult + "     Summation " + i + " : " + addResult);
        }
        Instant end = Instant.now();
        System.out.println("Time spent : " + Duration.between(str, end));
    }
}