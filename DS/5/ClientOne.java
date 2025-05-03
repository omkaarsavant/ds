import java.io.*;
import java.net.*;

public class ClientOne {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 7000);
        PrintStream out = new PrintStream(s.getOutputStream());
        ServerSocket ss = new ServerSocket(7001);
        Socket s1 = ss.accept();
        BufferedReader in1 = new BufferedReader(new InputStreamReader(s1.getInputStream()));
        PrintStream out1 = new PrintStream(s1.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "Token";

        while (true) {
            if ("Token".equalsIgnoreCase(str)) {
                System.out.println("Do you want to send some data? (Yes/No)");
                str = br.readLine();
                if ("Yes".equalsIgnoreCase(str)) {
                    System.out.println("Enter the data:");
                    out.println(br.readLine());
                }
                out1.println("Token");
            }
            System.out.println("Waiting for Token...");
            str = in1.readLine();
        }
    }
}
