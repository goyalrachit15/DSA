package alpha.method;

import java.util.Scanner;

public class fact {

    public static int factorial(int a) {
    int fact=1;
    for(int i=1;i<=a;i++){
        fact*=i;
    }
    return fact;
}
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int a=br.nextInt();
        int fac=factorial(a);
        System.out.println(fac);
        br.close();
    }
}
