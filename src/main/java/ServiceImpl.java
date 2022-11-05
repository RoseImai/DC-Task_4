import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ServiceImpl implements Service
{
    @Override
   public int multiply(int x, int y) throws RemoteException {
       return x*y;
   }

   @Override
    public double add(int x, int y) throws RemoteException
   {
       return x+y;
   }
}