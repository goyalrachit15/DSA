package alpha;

import java.util.Scanner;

public class sorting {

    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }

    public static void bubblesort(int arr[]) {
        for (int i = 0; i < arr.length-1; i++) {
            int swap=0;
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap++;
                }
                if(swap==0){
                    break;
                }
            }
        }
    }

    public static void selection(int arr[]) {
        for (int i = 0; i < arr.length-1; i++) {
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }

    public static void insertion(int arr[]) {
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int prev=i-1;
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
    }

    public static void counting_sort(int arr[]) {
        int largest=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest=Math.max(largest,arr[i]);
        }
        int count[]=new int[largest+1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int index=0;
        for (int i = count.length-1; i > 0; i--) {
            while(count[i]>0){
                arr[index]=i;
                index++;
                count[i]--;
            }   
        }
        
    }

    public static void main(String[] args) {
        Scanner  br=new Scanner(System.in); 
        int arr[]={6,11,8,23,1};
        // bubblesort(arr);
        // Arrays.sort(arr);
        // insertion(arr);
        counting_sort(arr);
        print(arr);
        br.close();
    }
}
