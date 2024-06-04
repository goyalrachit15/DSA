package alpha.method;

import java.util.*;

public class pro {
    public static int product(int a,int b) {
        int pro=a*b;
        return pro;
    }
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int a=br.nextInt();
        int b=br.nextInt();
        int pro=product(a,b);
        System.out.println(pro);
        br.close();
   }
}
