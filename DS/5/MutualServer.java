import java.io.*;
import java.net.*;

public class MutualServer implements Runnable {
    private Socket socket;

    public MutualServer(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(7000);
        System.out.println("Server Started");
        while (true) {
            new Thread(new MutualServer(ss.accept())).start();
        }
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            while (true) {
                System.out.println(in.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
