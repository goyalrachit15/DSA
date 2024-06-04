package alpha.loop;

import java.util.Scanner;

public class for_loop {
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int n=br.nextInt();
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }



        // for (; n>0; n=n/10) {
        //     System.out.print(n%10);
        // }


        int rev=0;
        while (n>0) {
            int rem=n%10;
            rev=(rev*10)+rem;
            n/=10;
        }
        n=rev;
        System.out.println(n);
        br.close();
    }
}
