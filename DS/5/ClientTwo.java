import java.io.*;
import java.net.*;

public class ClientTwo {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 7000);
        PrintStream out = new PrintStream(s.getOutputStream());
        Socket s2 = new Socket("localhost", 7001);
        BufferedReader in2 = new BufferedReader(new InputStreamReader(s2.getInputStream()));
        PrintStream out2 = new PrintStream(s2.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while (true) {
            System.out.println("Waiting for Token...");
            str = in2.readLine();
            if ("Token".equalsIgnoreCase(str)) {
                System.out.println("Do you want to send some data? (Yes/No)");
                str = br.readLine();
                if ("Yes".equalsIgnoreCase(str)) {
                    System.out.println("Enter the data:");
                    out.println(br.readLine());
                }
                out2.println("Token");
            }
        }
    }
}
