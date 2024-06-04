package alpha;

import java.util.Scanner;

public class recursion {

    public static void decreasing(int n) {
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        decreasing(n-1);
    }

    public static void increasing(int n) {
        if(n==1){
            System.out.println(n);
            return;
        }
        increasing(n-1);
        System.out.println(n);
    }

    public static int factorial(int n) {
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static int sum(int n ) {
        if(n==1){
            return 1;
        }
        return n+sum(n-1);
    }


    public static int fibbonaci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibbonaci(n-1)+fibbonaci(n-2);
    }

    public static boolean sorted(int arr[],int i) {
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return sorted(arr,i+1);
    }

    public static int first(int arr[],int key,int i) {
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
        return i;
        }
        return first(arr, key, i+1);
    }

    public static int lastoccurence(int arr[],int key,int i) {
        if(i==0){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return lastoccurence(arr, key, i-1);
    }

    public static int powern(int x,int n) {
        if(n==0){
            return 1;
        }
        return x*powern(x,n-1);
    }

    public static int poweroptimized(int x,int n) {
        if(n==0){
        return 1;
        }

        int power= poweroptimized(x, n/2);
        int halfpower=(int)Math.pow(power, 2);
        if(n%2==0){
            return halfpower;
        }
        else{
            return x*halfpower;
        }
    }


    //amazon problem
    public static int tiling(int n) {
        if(n==0 || n==1){
            return 1;
        }
        return tiling(n-1)+ tiling(n-2);
    }


    //google and microsoft
    public static void duplicate(String str) {
        StringBuilder sb=new StringBuilder("");
        boolean map[]=new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if(map[ch-'a']==false){
            sb.append(ch);
            map[ch-'a']=true;            
            }
        }
        System.out.println(sb);
    }

    public static void duplicaterecursion(String s,int index, StringBuilder sb,boolean map[]){
        if(index==s.length()-1){
            System.out.println(sb);
            return;
        }
        char ch = s.charAt(index);
        if(map[ch-'a']==true){
            duplicaterecursion(s, index+1, sb, map);
        }
        else{
            map[ch-'a'] = true;
            duplicaterecursion(s, index+1, sb.append(ch), map);
        }
    }

    public static int friends(int n) {
        if(n==1||n==2){
            return n;
        }
        return friends(n-1)+(n-1)*friends(n-2);
        
    }

    //paytm
    public static void binarystring(int n,int prev,String sb) {
        if(n==0){
            System.out.println(sb);
            return;
        }
        binarystring(n-1, 0,sb+"0");
        if(prev==0){
            binarystring(n-1,1,sb+"1");
        } 
    }

    //practice

    public static void occurence(int i,int arr[],int key) {
        if(i==arr.length-1){
            return;
        }
        if(arr[i]==key){
            System.out.print(i+" ");
        }
        occurence(i+1,arr, key);
         
    }

    public static void numbertostring(int n,String arr[]) {
        if(n==0){
            return;
        }
        int last=n%10;
        numbertostring(n/10,arr);
        System.out.print(arr[last]+" ");
        
    }

    public static int length(String str) {
        if(str.length()==0){
            return 0;
        }

        return length(str.substring(1)) +1;
    }


    public static int contigous(String str,int i,int j,int n) {
        if(n==1){
            return 1;
        }
        if(n<=0){
            return 0;
        }

        int res;
        res=contigous(str, i+1, j, n-1)+ contigous(str, i, j-1, n-1) - contigous(str,i+1, j-1, n-2);

        if(str.charAt(i)==str.charAt(j)){
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        // boolean map[]=new boolean[26];
        // StringBuilder sb=new StringBuilder("");
        // int n=br.nextInt();
        // int arr[]={1,3,4,6,7,8,9,3,11,12};

        // // decreasing(n);
        // // increasing(n);
        // // System.out.println(factorial(n));
        // // System.out.println(sum(n));
        // // System.out.println(fibbonaci(n));
        // // System.out.println(sorted(arr, 0));

        // // System.out.println("key is found at index "+first(arr, 3, 0));
        // // System.out.println("key is found at index "+lastoccurence(arr, 3, arr.length-1));
        // System.out.println(powern(4, 5));
        // System.out.println(poweroptimized(4, 5));
        // System.out.println(tiling(4));
        // duplicate("appnnacollege");
        // duplicaterecursion("appnnacollege", 0,sb, map);
        // System.out.println(friends(3));
        // binarystring(6, 0, "");
        // occurence(0, arr, 3);

        // String arr[]={"zero", "one", "two", "three", "four", "five", "six", "seven","eight", "nine"};
        // numbertostring(1947, arr);

    //    System.out.println( length("rachit goyal"));

    String str="abcab";
    int n=str.length();
    System.out.println(contigous(str,0,n-1,n));


    br.close();
    }
}
