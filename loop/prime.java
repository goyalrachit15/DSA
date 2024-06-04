package alpha.loop;

import java.util.Scanner;

public class prime {
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int n=br.nextInt();
        int counter=0;
        for (int i = 2; i <=Math.sqrt(n); i++) {
            if(n%i==0){
                System.out.println("NOT PRIME");
                counter++;
                break;
            }
        }
        if(counter==0){
            System.out.println("PRIME");
        }
        br.close();
    }
}
