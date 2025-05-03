import ReverseModule.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

public class ReverseServer {
    public static void main(String[] args) throws Exception {
        ORB orb = ORB.init(args, null);
        POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        rootpoa.the_POAManager().activate();

        NamingContextExt ncRef = NamingContextExtHelper.narrow(
            orb.resolve_initial_references("NameService")
        );
        ncRef.rebind(
            ncRef.to_name("Reverse"),
            ReverseHelper.narrow(rootpoa.servant_to_reference(new ReverseImpl()))
        );
        System.out.println("ReverseServer ready and waiting...");
        orb.run();
    }
}
