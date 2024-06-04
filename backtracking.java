package alpha;

import java.util.Scanner;

public class backtracking {

    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }

    public static void changearray(int arr[],int i,int val) {
        if(i==arr.length){
            print(arr);
            return;
        }
        arr[i] = val;
        changearray(arr, i+1, val+1);
        arr[i]-=2;
    }


    public static void findsubsets(String str,String ans,int i) {
        if(i==str.length()){
            System.out.println(ans);
            return;
        }

        //yes choice
        findsubsets(str, ans+str.charAt(i), i+1);

        //no choice
        findsubsets(str, ans, i+1);
        
    }

    public static void permutation(String str,String ans) {

        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        String newstr;
        for (int i = 0; i < str.length(); i++) {
            char curr=str.charAt(i);
            newstr=str.substring(0, i)+str.substring(i+1);
            permutation(newstr, ans+curr);
            
        }
        
    }
    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        // int arr[]=new int[5];
        // changearray(arr, 0, 1);
        // print(arr);
        // findsubsets("abc","", 0);

        permutation("abc", "");
        br.close();
    }
}
