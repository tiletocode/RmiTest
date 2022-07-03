package client;

import server.Hello;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class HelloClient {
    public static void main(String[] args) {
        try {
            Object obj = Naming.lookup("rmi://localhost:1099/HelloRemote");
            Hello remoteObj = (Hello) obj;
            String msg = remoteObj.sayHello(args[0]);
            System.out.println(msg);
        } catch (RemoteException e) {
            System.out.println("Something has gone wrong during remote method call...");
        } catch (NotBoundException e) {
            System.out.println("Couldn't bound...");
        } catch (MalformedURLException e) {
            System.out.println("Check url string...");
        }
    }
}
