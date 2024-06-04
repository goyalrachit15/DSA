package alpha;

import java.util.*;

public class array {


    public static void creation(int arr[]){
        Scanner br=new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            arr[i]=br.nextInt();
        }
        br.close();
    }

    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }

    public static void linearsearch(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                System.out.println("KEY IS AT INDEX NUMBER "+i);
            }
        }      
        System.out.println("NOT FOUND");
    }


    public static int largest(int arr[]){
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }


    public static int smallest(int arr[]){
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }


    public static int binarysearch(int arr[],int key){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]<key){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }


    public static void reverse(int arr[]){
        for (int i = 0; i < arr.length/2; i++) {
            int temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
        print(arr);
    }


    public static void pairs(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print("("+arr[i]+","+arr[j]+")");
            }
            System.out.println();
        }
    }


    public static void subarray(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }


    public static void maxsubarray(int arr[]){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum=0;
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]+" ");
                    sum+=arr[k];
                }
                if(sum<min)
                min=sum;
                if(sum>max)
                max=sum;
                System.out.println();
            }
        }
        System.out.println(max+" "+min);
    }

    
    public static void prefix(int arr[]) {
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i]=arr[i]+prefix[i-1];
        }

        int max=Integer.MIN_VALUE;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length;j++){
                sum=i==0?prefix[j]:(prefix[j]-prefix[i-1]);
            }
            if(sum>max)
            max=sum;
        }
        System.out.println(max);
        
    }

    public static void kadanes(int arr[]) {
        int curr=0;
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]<0){
                count++;
            }
        }
        if(count==arr.length){
            max=arr[0];
            for(int i=1;i<arr.length;i++) {
                if(arr[i]>max){
                    max=arr[i];
                }
            }
        }else{
            for(int i=0;i<arr.length;i++){
                curr=curr+arr[i];
                if(curr>max){
                    max=curr;
                }else if(curr<0){
                    curr=0;
                }
            }
        }
        System.out.println(max);
    }

    public static void rainwater(int arr[]) {
        int ac=0;
        int dc=0;
        int water=0;
        int width=1;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]){
                ac++;
            }else{
                dc++;
            }
        }
        if(ac==arr.length || dc==arr.length){
            System.out.println(water);
            return;
        }
        if(arr.length==1 || arr.length==2){
            System.out.println(water);
            return;
        }


        int lh[]=new int[arr.length];
        int rh[]=new int[arr.length];
        lh[0]=arr[0];
        rh[arr.length-1]=arr[arr.length-1];
        for(int i=1;i<arr.length;i++){
            lh[i]=Math.max(lh[i-1],arr[i]);
        }
        for(int i=arr.length-2;i>0;i--){
            rh[i]=Math.max(rh[i+1], arr[i]);
        }

        for(int i=0;i<arr.length;i++){
            if(((Math.min(lh[i],rh[i])-arr[i]))>0)
            water=water+((Math.min(lh[i],rh[i])-arr[i])*width); 
        }
        System.out.println(water);
    }

    public static int profit(int arr[]) {
        int buyprice=Integer.MAX_VALUE;
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(buyprice < arr[i]){
                int profit=arr[i]-buyprice;
                max=Math.max(max, profit);
            }else{
                buyprice=arr[i];
            }
        }
        
        return max;
        
    }


    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);
        int n=br.nextInt();


        // int marks[]=new int[n];
        // for(int i=0;i<n;i++){
        //     marks[i]=br.nextInt();
        // }

        // int sum=0;
        // for(int i=0;i<n;i++){
        //     System.out.println(marks[i]);
        //     sum=sum+marks[i];
        // }

        // int per=sum/n;
        // System.out.println("percentage="+per);
        
        int arr[]=new int[n];
        // int key=br.nextInt();
        creation(arr);
        // print(arr);
        // // linearsearch(arr,key);

        // System.out.println(largest(arr));
        // System.out.println(smallest(arr));

        // System.out.println("key is present at index number "+ binarysearch(arr, key));

        // reverse(arr);

        // pairs(arr);

        // maxsubarray(arr);
        
        // prefix(arr);

        // kadanes(arr);

        rainwater(arr);
        br.close();
    }
}
