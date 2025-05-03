import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter serv time");
        int sh=sc.nextInt();
        int sm=sc.nextInt();
        int ss=sc.nextInt();
        System.out.println("Enter no of nodes");
        int no=sc.nextInt();
        
        int[]nh = new int[no];
        int[]nm = new int[no];
        int[]ns = new int[no];
        int[]difference = new int[no];
        
        for(int i=0;i<no;i++){
            System.out.println("Enter time for node"+(i+1));
            nh[i]=sc.nextInt();
            nm[i]=sc.nextInt();
            ns[i]=sc.nextInt();
            
            difference[i]=(sh-nh[i])*3600+(sm-nm[i])*60+(ss-ns[i]);
            System.out.println("difference for node"+(i+1)+" is "+difference[i]);
        }
//avg
        int totaldiff=0;
        for(int i=0;i<no;i++){
            totaldiff+=difference[i];
        }
        int avgdiff=totaldiff/(no+1);
        System.out.println("Avg difference is "+avgdiff);
        
//server sync
        int totalss=sh*3600+sm*60+ss+avgdiff;
        sh=(totalss/3600)%24;
        sm=(totalss/60)%60;
        ss=totalss%60;
        
//nodesync
        for(int i=0;i<no;i++){
            int totalns=nh[i]*3600+nm[i]*60+ns[i]+avgdiff;
        nh[i]=(totalns/3600)%24;
        nm[i]=(totalns/60)%60;
        ns[i]=totalns%60;
        }
        System.out.println("Sync server is "+sh+" "+sm+" "+ss);
        for(int i=0;i<no;i++){
            System.out.println("Sync Node is "+(i+1)+" "+nh[i]+" "+nm[i]+" "+ns[i]);
        }
        
    }
    
}