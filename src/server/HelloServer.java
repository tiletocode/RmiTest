package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class HelloServer {
    public static void main(String[] args) {
        try {
            HelloImpl remoteObj = new HelloImpl();
            Naming.rebind("rmi://localhost:1099/HelloRemote", remoteObj);
            System.out.println("Hello Remote Object bound to the registry and ready to service incoming client calls...");
        } catch (RemoteException e) {
            System.err.println("Exception occurred during processing incoming method call");
        } catch (MalformedURLException e) {
            System.err.println("Check the url String...");
        }
    }
}
