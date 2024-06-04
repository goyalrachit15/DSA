package alpha.pattern;

import java.util.Scanner;

public class half_pyramid {
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int n=br.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=i; j++) {
            System.out.print(j);
            }
            System.out.println();
        }
        br.close();
    }
}