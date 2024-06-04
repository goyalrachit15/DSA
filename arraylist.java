package alpha;

import java.util.ArrayList;
// import java.util.Collections;
import java.util.Scanner;

public class arraylist {


    public static void swap(ArrayList <Integer> list,int idx1,int idx2) {
        int temp=list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
        System.out.println(list);
        
    }

    public static boolean pairsum(ArrayList<Integer> list, int target ) {
        boolean result = false;
        for( int i=0; i<list.size(); i++ ){
            for( int j=i+1; j<list.size();j++){
                if(list.get(i)+list.get(j)==target){
                    result = true;
                }
            }
        }
        return result;
    }


    //only applicable for sorted arraylists
    public static boolean pairsum1(ArrayList<Integer> list,int target) {
        boolean result = false;
        int lp=0;
        int rp=list.size()-1;
        while(lp<rp){ 
            if(list.get(lp)+list.get(rp) == target) {
                result = true;
                return result;
            }
            else if(list.get(lp)+list.get(rp) > target) {
                rp--;
            }
            else{
                lp++;
            }
        }
        return result;
    }

    //sorted and rotated arraylist

    public static boolean pairsum2(ArrayList<Integer> list,int target) {
        int i=0;
        while(list.get(i)> list.get(i+1)){
            i++;
        }
        int lp=i+1;
        int rp=i;

        while(lp!=rp){
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            else if(list.get(lp)+list.get(rp)>target){
                // if(rp==0){
                //     rp=list.size()-1;
                // }else{
                //     rp--;
                // }
                rp=(list.size()+rp-1)%list.size();
            }
            else{
                // if(lp==list.size()-1){
                //     lp=0;
                // }else{
                //     lp++;
                // }
                lp=(lp+list.size())%list.size();
            }
        }
        return false;
    }
    public static void main(String[] args) {

        Scanner br=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<Integer>();

        // //add operations
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(list);
        int target=br.nextInt();

        // //get operations
        // int element= list.get(3);
        // System.out.println(element);

        // //delete operations
        // list.remove(2);
        // System.out.println(list );

        // //set operations
        // list.set(2, 10);
        // System.out.println(list);

        // //check operation
        // System.out.println(list.contains(1));

        // int size=list.size();
        // System.out.println(size);


        //printing arraylist in reverse order
        // for (int i = size-1; i >= 0; i--) {
        //     System.out.println(list.get(i));
        // }

        // //finding maximum in arraylist
        // list.add(10000);
        // int max=Integer.MIN_VALUE;
        // for (int i = 0; i < list.size(); i++) {
        //     if(list.get(i)>max){
        //         max=list.get(i);
        //     }
        // }
        // System.out.println(max);

        // swap(list, 2, 5);

        // System.out.println(list);
        // Collections.sort(list);
        // System.out.println(list);
        // Collections.sort(list,Collections.reverseOrder());
        // System.out.println(list);


        ////multidimensional arraylist
        // ArrayList<ArrayList<Integer>> mainlist =new ArrayList<>();
        // ArrayList<Integer> arr=new ArrayList<>();
        // arr.add(1);
        // arr.add(2);
        // arr.add(3);
        // arr.add(4);
        // arr.add(5);
        // ArrayList<Integer> arr2=new ArrayList<>();
        // arr2.add(2);
        // arr2.add(4);
        // arr2.add(6);
        // arr2.add(8);
        // arr2.add(10);
        // ArrayList<Integer> arr3=new ArrayList<>();
        // arr3.add(3);
        // arr3.add(6);
        // arr3.add(9);
        // arr3.add(12);
        // arr3.add(15);
        // mainlist.add(arr);
        // mainlist.add(arr2);
        // mainlist.add(arr3);
        // System.out.println(mainlist);


        // for(int i=0;i< mainlist.size();i++){
        //     ArrayList<Integer> curr = mainlist.get(i);
        //     for (int index = 0; index < curr.size(); index++) {
        //         System.out.print(curr.get(index)+" ");
        //     }
        //     System.out.println();
        // }


        // //maximum water container
        // ArrayList<Integer> height = new ArrayList<Integer>();
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);

        // int size=height.size();
        // int water=0;
        // int maxwater=Integer.MIN_VALUE;


    //o(n^2) time complexity
        // for (int i=0; i<size; i++){
        //     for (int j=i+1; j<size;j++){
        //         water=(j-i)*Math.min(height.get(j),height.get(i));
        //         maxwater=Math.max(maxwater,water);
        //     }
        // }
        // System.out.println(maxwater);


    // //o(n) time complexity
            
    // int lp=0;
    // int rp=height.size()-1;

    // while(lp<rp) {
    //     water=Math.min(height.get(lp),height.get(rp))*(rp-lp);
    //     maxwater=Math.max(maxwater,water);
    //     if(height.get(lp)<height.get(rp)){
    //         lp++;
    //     }
    //     else{
    //     rp--;
    //     }
    // }
    // System.out.println(maxwater);

    System.out.println(pairsum(list,target));
    System.out.println(pairsum1(list,target));
    System.out.println(pairsum2(list,target));
    br.close();
}
}
