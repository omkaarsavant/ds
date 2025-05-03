import java.io.*;
import java.util.*;

public class Berkley {
    // Method to calculate time difference
    float diff(int h, int m, int s, int nh, int nm, int ns) {
        return (h - nh) * 3600 + (m - nm) * 60 + (s - ns);
    }

    public static void main(String[] args) throws IOException {
        Berkley b = new Berkley();
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        Date date = new Date();
        System.out.print("Enter number of nodes: ");
        int n = Integer.parseInt(obj.readLine()), h = date.getHours(), m = date.getMinutes(), s = date.getSeconds();
        
        int[] nh = new int[n], nm = new int[n], ns = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter time for node " + (i + 1));
            System.out.print("Hours: ");
            nh[i] = Integer.parseInt(obj.readLine());
            System.out.print("Minutes: ");
            nm[i] = Integer.parseInt(obj.readLine());
            System.out.print("Seconds: ");
            ns[i] = Integer.parseInt(obj.readLine());
        }

        // Calculate time difference for each node
        float[] diff = new float[n];
        for (int i = 0; i < n; i++) {
            diff[i] = b.diff(h, m, s, nh[i], nm[i], ns[i]);
            System.out.println("Node " + (i + 1) + " sent time difference of " + (int) diff[i] + " to Time Server.");
        }

        // Calculate the average time difference manually
        float sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
        }
        float avg = sum / n;
        System.out.println("The average of all time differences is " + avg);

        // Synchronize the clocks
        for (int i = 0; i < n; i++) {
            diff[i] += avg;
            nh[i] = (nh[i] + (int) (diff[i] / 3600) + 24) % 24;
            nm[i] = (nm[i] + (int) (diff[i] / 60) + 60) % 60;
            ns[i] = (ns[i] + (int) (diff[i] % 60) + 60) % 60;
        }

        h = (h + (int) (avg / 3600) + 24) % 24;
        m = (m + (int) (avg / 60) + 60) % 60;
        s = (s + (int) (avg % 60) + 60) % 60;

        // Print the synchronized time
        System.out.println("The synchronized clocks are:");
        System.out.println("Time Server ---> " + h + " : " + m + " : " + s);
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + (i + 1) + " ---> " + nh[i] + " : " + nm[i] + " : " + ns[i]);
        }
    }
}
