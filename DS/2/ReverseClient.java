import ReverseModule.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.io.*;

public class ReverseClient {
    public static void main(String[] args) throws Exception {
        Reverse reverseImpl = ReverseHelper.narrow(
            NamingContextExtHelper.narrow(
                ORB.init(args, null).resolve_initial_references("NameService")
            ).resolve_str("Reverse")
        );
        System.out.println(reverseImpl.reverse_string(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }
}

