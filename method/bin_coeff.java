package alpha.method;

import java.util.Scanner;


public class bin_coeff {

    public static int factorial(int a) {
        int fact=1;
        for(int i=1;i<=a;i++){
            fact*=i;
        }
        return fact;
    }

    public static int binomial(int n,int r) {
        int coeff=factorial(n)/(factorial(n-r)*factorial(r));
        return coeff;
    
    }

    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int n=br.nextInt();
        int r=br.nextInt();
        int coeff=binomial(n,r);
        System.out.println(coeff);
        br.close();
        
    }
}
