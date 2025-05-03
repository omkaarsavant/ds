import java.util.Scanner;

public class Main {
    static int[] process = {1, 2, 3, 4, 5}; 
    static int leader = 5;

    public static void down(int[] process, int p) {
        boolean processFound = false;
        for (int i = 0; i < process.length; i++) {
            if (process[i] == p) {
                process[i] = 0;  
                processFound = true;
                System.out.println("Process " + p + " has been downed.");
                break;
            }
        }
        if (!processFound) {
            System.out.println("Process " + p + " was not found.");
        }
    }
    
    public static void msg(int[] process, int p) {
        int currentLeader = p; 
        boolean leaderFound = false; 

        System.out.println(p + " is initiating the election...");

       
        for (int i = 0; i < process.length; i++) {
            if (process[i] > p && process[i] != 0) { 
                System.out.println(p + " has sent an election message to process " + process[i]);
                if (process[i] > currentLeader) {
                    currentLeader = process[i]; 
                }
                leaderFound = true;
            }
        }

        if (!leaderFound) {
            System.out.println("No higher-priority processes found. Process " + p + " becomes the new leader.");
            currentLeader = p; 
        }
       
        System.out.println("The new leader is: " + currentLeader);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

      
        System.out.println("The Processes are P1, P2, P3, P4, P5, Current Leader is P5");

        do {
            
            System.out.println("\nEnter your choice:");
            System.out.println("1. Down a process");
            System.out.println("2. Send Message");
            System.out.println("3. Exit");

           
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Which process to down?");
                int p = sc.nextInt();
                down(process, p); 
            } else if (choice == 2) {
                System.out.println("Which process will send a message?");
                int p = sc.nextInt();
                msg(process, p); 
            } else if (choice == 3) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }

            
            

        } while (choice != 3); 
    }
}
