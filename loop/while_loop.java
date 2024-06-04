package alpha.loop;

import java.util.Scanner;

public class while_loop {
    public static void main(String[] args) {
        int i=1;
        Scanner br=new Scanner(System.in);
        int n=br.nextInt();


        // while (i<=10) {
        //     System.out.println(i);
        //     i++;
        // }


        // while (i<=n) {
        //     System.out.println(i);
        //     i++;
        // }
    
        int sum=0;
        while (i<=n) {
            sum=sum+i;
            i++;
        }
        System.out.println(sum);
        
        br.close();
    }
}
