package alpha.conditional;

import java.util.Scanner;

public class largest_3 {
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int a=br.nextInt();
        int b=br.nextInt();
        int c=br.nextInt();
        if(a>b && a>c){
            System.out.println(a);
        }else if(b>c){
            System.out.println(b);
        }else{
        System.out.println(c);
        }
        br.close();
    }
}
