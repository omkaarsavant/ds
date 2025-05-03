package Client;
import Server.AddServerIntf;
import java.rmi.*;

public class AddClient {
    public static void main(String[] args) throws Exception {
        AddServerIntf addServer = (AddServerIntf) Naming.lookup("rmi://" + args[0] + "/AddServer");
        System.out.println("The sum is: " + addServer.add(Double.parseDouble(args[1]), Double.parseDouble(args[2])));
    }
}
