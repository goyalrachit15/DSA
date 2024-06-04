package alpha;

import java.util.HashMap;
import java.util.Set;

public class hashing {

    public static void majority(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            // if(map.containsKey(arr[i])){
            // int value=map.get(arr[i]);
            // map.put(arr[i],value+1);
            // }else{
            // map.put(arr[i], 1);
            // }

            // OR

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> set = map.keySet();
        for (int i : set) {
            int value = map.get(i);
            if (value > arr.length / 3) {
                System.out.print(i + " ");
            }
        }
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        } else {
            HashMap<Character, Integer> m = new HashMap<>();
            boolean ans = true;
            for (int i = 0; i < s.length(); i++) {
                m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
            }

            for (int i = 0; i < t.length(); i++) {
                if (!m.containsKey(t.charAt(i))) {
                    ans = false;
                } else {
                    m.put(t.charAt(i), m.get(t.charAt(i)) - 1);
                    if (m.get(t.charAt(i)) == 0) {
                        m.remove(t.charAt(i));
                    }
                }
            }

            if (m.isEmpty()) {
                ans = true;
            } else {
                ans = false;
            }
            return ans;
        }
    }

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // //INSERT 0(1)
        // map.put("INDIA", 100);
        // map.put("CHINA", 150);
        // map.put("US", 50);

        // System.out.println(map);

        // //GET 0(1)
        // System.out.println(map.get("india"));

        // //containskey 0(1)
        // System.out.println(map.containsKey("INDIA"));
        // System.out.println(map.containsKey("indonesia"));

        // //remove 0(1)
        // System.out.println(map.remove("US"));
        // System.out.println(map);

        // //size 0(1)
        // System.out.println(map.size());

        // //clear function to empty map
        // map.clear();
        // System.out.println(map);

        // map.put("India", 100);
        // map.put("China", 150);
        // map.put("US", 50);
        // map.put("Indonesia", 6);
        // map.put("Nepal", 5);

        // Set<String> set = map.keySet();
        // System.out.println(set);

        // for (String k : set) {
        // System.out.println(" "+map.get(k));
        // }

        int arr[] = { 1, 2 };
        majority(arr);

    }
}
