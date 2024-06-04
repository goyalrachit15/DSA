package alpha.conditional;

import java.util.Scanner;

public class largest {
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int a=br.nextInt();
        int b=br.nextInt();
        if(a>b)
        System.out.println(a);  
        else
        System.out.println(b);
        br.close();
    
    }
}
