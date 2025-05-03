package Server;
import java.rmi.server.*;
import java.rmi.*;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf {
    public AddServerImpl() throws RemoteException {}

    public double add(double a, double b) {
        return a + b;
    }
}
