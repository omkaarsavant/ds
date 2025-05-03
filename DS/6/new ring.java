import java.util.Scanner;

public class Main{
    static int[]process={1,2,3,4,5};
    static int leader=-1;
    
    public static void election(int[] process, int p){
        int current=p;
        int highest=current;
        System.out.println(current+" started election");
        for(int i=1; i<process.length;i++){
            current=(current%process.length)+1;
            while(process[current-1]==0){
                current=(current%process.length)+1;    
            }
            System.out.println(current+" recieved msg");
            if(current>highest){
                highest=current;
            }
        }
        leader=highest;
        System.out.println("he leader is"+leader);
    }
    
    public static void down(int[] process, int p){
        boolean found=false;
        for(int i=0;i<process.length;i++){
            if(process[i]==p){
                process[i]=0;
                found=true;
                System.out.println(p+"is down");
                break;
            }
        }
        if(!found)
        {
            System.out.println("No process to down");
        }
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int choice;
        System.out.println("p1,p2,p3,p4,p5 leader is none");
        do{
            
            
            System.out.println("1. Down");
            System.out.println("2. Elect");
            System.out.println("3. exit");
            
            choice=sc.nextInt();
            if(choice==1){
                System.out.println("which to down?");
                int p=sc.nextInt();
                down(process,p);
            }else if(choice==2){
                System.out.println("which to elect");
                int p=sc.nextInt();
                election(process,p);
            }
        }while(choice!=3);
    }
    
}