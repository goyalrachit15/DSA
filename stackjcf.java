package alpha;

import java.util.Stack;

public class stackjcf {

    public static void pushbottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int val = s.pop();
        pushbottom(s, data);
        s.push(val);
    }

    public static String reverse(String str) {
        Stack<Character> s2 = new Stack<>();
        int i = 0;
        int len = str.length();
        while (i < len) {
            s2.push(str.charAt(i));
            i++;
        }
        StringBuilder s1 = new StringBuilder("");
        while (!s2.isEmpty()) {
            s1.append(s2.pop());
        }

        return s1.toString();
    }

    public static Stack<Integer> reverse_stack(Stack<Integer> s) {
        Stack<Integer> res = new Stack<>();
        while (!s.empty()) {
            int val = s.peek();
            s.pop();
            res.push(val);
        }

        return res;
    }

    public static void reverse_stack_recursion(Stack<Integer> s1) {
        if (s1.isEmpty()) {
            return;
        }
        int data = s1.pop();
        reverse_stack_recursion(s1);
        pushbottom(s1, data);
    }

    public static void stockspan(int[] stock, int[] span) {
        Stack<Integer> s = new Stack<Integer>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stock.length; i++) {
            int current = stock[i];
            while (!s.isEmpty() && current > stock[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevhigh = s.peek();
                span[i] = i - prevhigh;
            }
            s.push(i);
        }
    }

    public static void nextgreater(int nums[], int greater[]) {
        Stack<Integer> stack = new Stack<>();
        for (int i = greater.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                greater[i] = -1;
            } else {
                greater[i] = nums[stack.peek()];
            }
            stack.push(i);
        }
    }

    public static boolean validparanthesis(String s) {
        Stack<Character> s1 = new Stack<>();
        int i = 0;
        boolean result = true;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s1.push(ch);
            } else {
                if (s1.isEmpty()) {
                    result = false;
                    return result;
                }
                if (ch == '}' || ch == ')' || ch == ']') {
                    char open = s1.peek();
                    if (open == '(' && ch == ')') {
                        s1.pop();
                    } else if (open == '{' && ch == '}') {
                        s1.pop();
                    } else if (open == '[' && ch == ']') {
                        s1.pop();
                    } else {
                        result = false;
                    }
                }
            }
            i++;
        }
        if (!s1.isEmpty()) {
            result = false;
        }
        return result;
    }


    public static boolean duplicate(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            if(ch==')'){
                int count=0;
                while(!stack.isEmpty() && stack.peek()!='('){
                    stack.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(ch);
            }
        }
        return false;
    }

    public static void max_histogram(int height[]) {
        int max=0;
        int nsr[]=new int[height.length];
        int nsl[]=new int[height.length];

        Stack<Integer> s = new Stack<Integer>();
        //next smaller right
        for(int i=height.length-1; i>=0; i--){
            while(!s.isEmpty() && height[s.peek()]>=height[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i]=height.length-1;
            }else{
                nsr[i]=s.peek();
            }    
            s.push(i);                
        }

        s=new Stack<>();

        for(int i=0; i<=height.length-1; i++){
            while(!s.isEmpty() && height[s.peek()]>=height[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }    
            s.push(i);                
        }

        for(int i=0; i<nsl.length; i++) {
            int heights = height[i];
            int width = nsr[i] - nsl[i] -1;
            int curr= heights * width;
            max= Math.max(max,curr);
        }
        System.out.println(max);
    }

    public static void main(String arg[]) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        // pushbottom(s,5);
        // while(!s.isEmpty()){
        // System.out.println(s.peek());
        // s.pop();
        // }

        // String str="abc";
        // str=reverse(str);
        // System.out.println(str);

        // System.out.println(s);
        // reverse_stack_recursion(s);
        // System.out.println(s);
        // int stock[]={100,80,60,70,60,85,100};
        // int span[]=new int[stock.length];
        // stockspan(stock,span);

        // for (int i = 0; i < span.length; i++) {
        // System.out.println(span[i]);
        // }

        int nums[]={2,1,5,6,2,3};
        // int greater[]=new int[nums.length];

        // nextgreater(nums, greater);
        // for (int i = 0; i < greater.length; i++) {
        // System.out.print(greater[i]+" ");
        // }

        // System.out.println(duplicate("(a+b)"));

        max_histogram(nums);

    }
}
