package alpha.conditional;

import java.util.Scanner;

public class even {
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int n=br.nextInt();
        if(n%2==0){
            System.out.println("number is even");
        }else{
            System.out.println("number is odd");
        }
        br.close();
    }
}
