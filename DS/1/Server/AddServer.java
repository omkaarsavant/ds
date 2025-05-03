package Server;
import java.rmi.*;
import java.rmi.registry.*;

public class AddServer {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1100); // Use port 1100
        Naming.rebind("//localhost:1100/AddServer", new AddServerImpl());
        System.out.println("Server is ready.");
    }
}


