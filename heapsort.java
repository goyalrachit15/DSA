package alpha;

public class heapsort {

    public static void heapify(int arr[],int i,int size) {
        int left=(2*i)+1;
        int right=(2*i)+2;
        int max=i;

        if(left< size && arr[max]<arr[left] ){
            max=left;
        }
        if(right<size && arr[max]<arr[right] ){
            max=right;
        }

        if(max!=i){
            int temp=arr[i];
            arr[i]=arr[max];
            arr[max]=temp;

            heapify(arr, max, size);
        }
        
    }

    public static void hsort(int arr[]) {
        int n=arr.length;

        //Step 1: Building maxheap of given array
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }

        //Step 2: Pushing largest element at end and removing it from the heap
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr,0,i);
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,4,5,3};

        hsort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
