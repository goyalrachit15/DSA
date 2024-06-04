package alpha;

import java.util.Scanner;

public class array_2D {

    public static void creation(int matrix[][]) {
        Scanner br=new Scanner(System.in);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j]=br.nextInt();
            }
        }
        br.close();
    }

    public static void print(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void search(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==key){
                    System.out.println("founded at"+i+" "+j);
                }    
            }
        }
        
    }


    public static void spiral() {
        int arr[][]={{1,2,3,4},
                     {5,6,7,8},
                     {9,10,11,12},
                     {13,14,15,16}};

        int startrow=0;
        int startcol=0;
        int endrow=3;         //endrow==(n-1)
        int endcol=3;         //endcol==(n-1)
        
        while(startrow<=endrow && startcol<=endcol){

            for (int i=startcol; i < endcol; i++){
                System.out.print(arr[startrow][i]+" ");
            }   

            for (int i = startrow; i < endrow ; i++){
                System.out.print(arr[i][endcol]+" ");
            }

            for (int i= endcol; i > startcol; i--){
                System.out.print(arr[endrow][i]+" ");
            }

            for (int i = endrow; i > startrow; i--){
                System.out.print(arr[i][startcol]+" ");
            }

            startrow++;
            startcol++;
            endcol--;
            endrow--;
        }
    }

    public static int diagonalsum(int arr[][]) {
        // int pri_sum=0;
        // int sec_sum=0;
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr.length; j++){
        //         if(i==j){
        //             pri_sum+=arr[i][j];
        //         }
        //         if((i+j)==arr.length-1){
        //             sec_sum+=arr[i][j];
        //         }
        //     }
        // }




        int sum=0;
        for (int i = 0;i<arr.length;i++) {
            sum+=arr[i][i];
            if(i!=arr.length-i-1){
            sum+=arr[i][arr.length-i-1];
            }
        }





        // if(arr.length%2==0){
        // return pri_sum+sec_sum;
        // }
        // else{
        //     return pri_sum+sec_sum-arr[arr.length/2][arr.length/2];
        // }
        return sum;
    }

    public static void search_sorted(int arr[][],int key) {
        int row=0;
        int col=arr[0].length-1;
        while(row<arr.length && col>=0 ){
            if(arr[row][col]==key){
                System.out.println("index is " + row+" "+col);
                break;
            }
            else if(arr[row][col]>key){
                col--;
            }
            else if(arr[row][col]<key){
                row++;
            }
         }
     }

     public static void number_7(int arr[][]) {
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j]==7){
                    count++;
                }
            }
        }
        System.out.println(count);  
     }

     public static void sum_2row(int arr[][]) {
        int sum=0;
        for (int i = 0; i < arr[0].length; i++) {
            sum+=arr[1][i];
        }
        System.out.println(sum);
     }

     public static void transpose(int arr[][]) {
        int transpose[][] = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                transpose[j][i]=arr[i][j];
            }
        }
        print(transpose);
        
     }
    
    
    
     public static void main(String[] args) {
        int matrix[][]=new int[2][3];
                creation(matrix);
                print(matrix);
                // search(matrix, 7);
                // spiral();
                // System.out.println(diagonalsum(matrix));
                // search_sorted(matrix, 3);
                // number_7(matrix);
                // sum_2row(matrix);
                transpose(matrix);
    }
}

