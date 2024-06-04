package alpha.variable;

import java.util.Scanner;

public class sum_input {
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int a,b;
        a=br.nextInt();
        b=br.nextInt();
        int sum=a+b;
        System.out.println(sum);
        br.close();
    }
}
