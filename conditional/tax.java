package alpha.conditional;

import java.util.Scanner;

public class tax {
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int income=br.nextInt();
        double tax=0;
        if(income<500000){
            tax=0;
        }else if(income>500000 && income<1000000){
            tax=0.20*income;
        }else if(income>1000000){
            tax=0.30*income;
        }
        System.out.println(tax);
        br.close();
    }
}
