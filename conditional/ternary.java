package alpha.conditional;

import java.util.Scanner;

public class ternary {
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int marks=br.nextInt();
        String result=(marks>33)?"PASS":"FAIL";
        System.out.println(result);
        br.close();
    }
}
