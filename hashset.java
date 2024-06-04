package alpha;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class hashset {

    public static void distinct(int arr[]) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        System.out.println(set.size());

    }

    public static void union(int arr[], int arr1[]) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int j = 0; j < arr1.length; j++) {
            set.add(arr1[j]);
        }
        System.out.println(set);
    }

    public static void intersection(int arr[], int arr1[]) {
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> res = new HashSet<Integer>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < arr1.length; i++) {
            if (set.contains(arr1[i])) {
                res.add(arr1[i]);
            }
        }

        System.out.println(res);
    }

    public static void itineary() {
        HashMap<String, String> map = new HashMap<>();

        map.put("Chennai", "Bengaluru");
        map.put("Mumbai", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");

        HashMap<String, String> rev = new HashMap<>();
        for (String i : map.keySet()) {
            rev.put(map.get(i), i);
        }

        String st="";
        for (String i : map.keySet()) {
            if (!rev.containsKey(i)) {
                st = i;
            }
        }

        System.out.println(st);
        for (String key : map.keySet()) {
            System.out.println(map.get(st));
            st=map.get(st);
        }
    }

    public static void largest(int arr[]) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int len=0;

        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
            if(map.containsKey(sum)){
                len=Math.max(len,i-map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
    
        System.out.println(len);
    }

    public static void subarray_sum(int arr[],int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int ans=0;

        map.put(0,1);
        for (int i = 0; i < arr.length; i++) {
            sum=sum+arr[i];
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        // set.add("delhi");
        // set.add("mumbai");
        // set.add("noida");
        // set.add("bengaluru");

        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (String i : set) {
            System.out.println(i);
        }

        // int arr[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        // int arr1[] = { 7, 3, 9 };
        // int arr2[] = { 6, 3, 9, 2, 9, 4 };
        // distinct(arr);
        // union(arr2, arr1);
        // intersection(arr2, arr1);
        // itineary();

        int arr[]={15,-2,2,-8,1,7,10};
        largest(arr);
    }
}
