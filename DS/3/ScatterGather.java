import mpi.MPI;
import java.util.Arrays; // Import the Arrays class

public class ScatterGather {
    public static void main(String[] args) {
        MPI.Init(args); // Initialize MPI environment
        int rank = MPI.COMM_WORLD.Rank(); // Get the rank of the current process
        int size = MPI.COMM_WORLD.Size(); // Get the total number of processes

        int[] sendbuf = new int[size]; // Buffer for sending data

        if (rank == 0) {
            // Initialize data on the master process
            for (int i = 0; i < size; i++) {
                sendbuf[i] = (i + 1) * 10; 
            }
            System.out.println("Processor " + rank + " has data: " + Arrays.toString(sendbuf));
        }

        int[] recvbuf = new int[1]; // Buffer for receiving data
        
        MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.INT, recvbuf, 0, 1, MPI.INT, 0);
        System.out.println("Processor " + rank + " received data: " + recvbuf[0]);

        recvbuf[0] *= 2; // Modify the data (double it)
        System.out.println("Processor " + rank + " doubled data to: " + recvbuf[0]);

        MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.INT, sendbuf, 0, 1, MPI.INT, 0);

        if (rank == 0) {
            // Master process prints the gathered data
            System.out.println("Final gathered data: " + Arrays.toString(sendbuf));
        }

        MPI.Finalize(); // Finalize the MPI environment
    }
}
