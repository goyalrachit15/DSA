package alpha.pattern;

import java.util.Scanner;

public class character {
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int n=br.nextInt();
        char ch='a';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
        br.close();
    }
}
