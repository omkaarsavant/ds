import java.util.Scanner;

public class Bully {
    static boolean[] state = new boolean[5]; // Tracks process states (active/inactive)
    static int leader = 5; // Initial leader is process 5

    // Bring a process down
    public static void down(int down) {
        if (state[down - 1]) {
            state[down - 1] = false;
            if (down == leader) {
                leader = -1; // No leader if leader is down
                System.out.println("Process " + down + " is down. New leader election triggered.");
            }
        } else {
            System.out.println("Process " + down + " is already down.");
        }
    }

    // Send a message
    public static void mess(int mess) {
        if (!state[mess - 1]) {
            System.out.println("Process " + mess + " is down.");
            return;
        }
        if (leader == -1) {
            System.out.println("Process " + mess + " initiated an election.");
            for (int i = 4; i >= 0; --i) {
                if (state[i]) {
                    leader = i + 1;
                    System.out.println("Process " + (i + 1) + " becomes the leader.");
                    break;
                }
            }
        } else {
            System.out.println(leader == mess ? "Process " + mess + " is the leader." : "OK");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; ++i) state[i] = true; // All processes active
        System.out.println("5 active processes are: P1 P2 P3 P4 P5\nProcess 5 is the coordinator.");

        int choice;
        while ((choice = sc.nextInt()) != 3) {
            if (choice == 1) {
                System.out.println("Bring a process down:");
                down(sc.nextInt());
            } else if (choice == 2) {
                System.out.println("Which process will send a message?");
                mess(sc.nextInt());
            }
        }
    }
}
