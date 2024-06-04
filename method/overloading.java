package alpha.method;

import java.util.*;

public class overloading {

    public static int multiply(int a , int b) {
        return a*b;
    }

    public static int multiply(int a , int b, int c) {
        return a*b*c;
    }
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);

        int a=br.nextInt();
        int b=br.nextInt();
        int c=br.nextInt();
        System.out.println(multiply(a,b));
        System.out.println(multiply(a,b,c));
        br.close();
    }
}
