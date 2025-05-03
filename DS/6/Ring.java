import java.util.Scanner;

public class Ring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of processes:");
        int num = in.nextInt();
        int[] ids = new int[num];
        String[] states = new String[num];
        int[] flags = new int[num];
        System.out.println("Enter the ID of each process:");
        for (int i = 0; i < num; i++) {
            ids[i] = in.nextInt();
            states[i] = "active";
            flags[i] = 0;
        }

        // Sort processes by ID
        java.util.Arrays.sort(ids);

        states[num - 1] = "inactive"; // Last process is the coordinator
        System.out.println("Process " + ids[num - 1] + " is the coordinator.");

        while (true) {
            System.out.println("Start Election (Enter process number):");
            int init = in.nextInt() - 1;
            int[] arr = new int[num];
            int count = 0;

            for (int temp1 = init; states[temp1].equals("active"); temp1 = (temp1 + 1) % num) {
                if (flags[temp1] == 0) {
                    System.out.println("Process " + ids[init] + " sends message to " + ids[temp1]);
                    flags[temp1] = 1;
                    arr[count++] = ids[temp1];
                }
            }

            int max = -1;
            for (int id : arr) max = Math.max(max, id);
            System.out.println("Process " + max + " is the new coordinator.");

            // Set the new coordinator
            for (int i = 0; i < num; i++) {
                if (ids[i] == max) states[i] = "inactive";
            }
        }
    }
}
