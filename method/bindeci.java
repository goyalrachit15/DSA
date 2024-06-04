package alpha.method;

import java.util.Scanner;

public class bindeci {

    public static void bintodec(int n) {
        double dec=0;
        int i=0;
        while(n>0){
            int rem=n%10;
            dec+=(rem*Math.pow(2,i));
            i++;
            n/=10;
        }
        System.out.println(dec);
    }

    public static void dectobin(int n) {
        int bin=0;
        int i=0;
        while(n>0){
            int rem=n%2;
            bin+=rem*Math.pow(10,i);
            n/=2;
            i++;
        }
        System.out.println(bin);
    }
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int n=br.nextInt();
        // bintodec(n);
        dectobin(n);
        br.close();
        
    }
}
