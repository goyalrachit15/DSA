package alpha.conditional;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int a=br.nextInt();
        char c=br.next().charAt(0);
        int b=br.nextInt();
        switch(c){
            case '+':
            System.out.println((a+b));
            break;

            case '-':
            System.out.println((a-b));
            break;

            case '*':
            System.out.println(a*b);
            break;

            case '/':
            System.out.println(a/b);
            break;

            case '%':
            System.out.println(a%b);
            break;
        }

        br.close();
    }
}
