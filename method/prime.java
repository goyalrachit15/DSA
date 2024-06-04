package alpha.method;

import java.util.*;

public class prime {

    public static boolean isprime(int n) {
        for (int i =2; i <= Math.sqrt(n); i++) {
            if(n%i==0){
            return false;
            }
        }
        return true;
    }

    public static void primeinrange(int n) {
        for(int i=2;i<=n;i++){
            boolean check=isprime(i);
            if(check==true){
                System.out.println(i);
            }
        }
        
    }
    public static void main(String[] args) {
        Scanner br =new Scanner(System.in);
        int n=br.nextInt();

        primeinrange(n);
        // boolean prime=isprime(n);   
        // if(prime==true){
        //     System.out.println("NUMEBR IS PRIME");
        // }else{
        //     System.out.println("NUMBER IS NOT PRIME");
        // }
        br.close();
    }
}
