package alpha;

import java.util.*;

public class pattern_adv {


    public static void hollow_rectangle(int n) {
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                if(i==1||j==1||i==n||j==n) {
                System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }



    public static void inv_rot_pyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }



    public static void inv_pyramid_number(int n) {
        for(int i = 1; i <= n; i++) {  
            for(int j = 1; j <=n-i+1; j++) {
                System.out.print(j);
            }
            System.out.println(" ");
        }
    }


    public static void floyd_triangle(int n) {
        int k=1;
        for(int i = 1; i <= n; i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(k+" ");
                k++;
            }
            System.out.println();
        }
    }


    public static void triangle0_1(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j=1;j<=i;j++) {
                if((i+j)%2==0) {
                    System.out.print("1");
                }
                else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }


    public static void butterfly(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print("*");
            }
            for(int k=1;k<=2*(n-i);k++) {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++) {
                System.out.print("*");
            }
        System.out.println();
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=(n-i+1);j++) {
                System.out.print("*");
            }
            for(int k=1;k<=2*(i-1);k++) {
                System.out.print(" ");
            }
            for(int j=1;j<=(n-i+1);j++) {
                System.out.print("*");
            }
        System.out.println();
        }
    }


    public static void rhombus(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void hollow_rhombus(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                if(i==1||i==n||j==1||j==n) {
                System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
         System.out.println();
        }
    }

    public static void diamond(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<n-i+1;j++) {  
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++) {  
                System.out.print(" ");
            }
            for(int j=1;j<=2*(n-i)+1;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        int n=br.nextInt();
        hollow_rectangle(n);

        inv_rot_pyramid(n);

        inv_pyramid_number(n);

        floyd_triangle(n);

        triangle0_1(n);

        butterfly(n);

        rhombus(n);

        hollow_rhombus(n);

        diamond(n);
        
        br.close();
    }
}
