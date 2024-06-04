package alpha.variable;

import java.util.Scanner;

public class area {
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int r=br.nextInt();
        double area=3.14*r*r;
        System.out.println(area);
        br.close();
    }
}
