package alpha.variable;

import java.util.Scanner;

public class product {
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int a,b;
        a=br.nextInt();
        b=br.nextInt();
        int pro=a*b;
        System.out.println(pro);
        br.close();
    }
    
}
