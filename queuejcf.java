package alpha;

import java.util.*;

// import java.util.Queue;

public class queuejcf {

    //push in O(n) time
    static class queueb{
        static Stack<Integer> s1=new Stack<>();
        static Stack<Integer> s2=new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("emoty");
                return -1;
            }
            return s1.pop();
        }

        public static int peek() {
            if(isEmpty()){
                System.out.println("emoty");
                return -1;
            }
            int val=s1.peek();
            return val;
        }
    }

    static class queuec{
        static Stack<Integer> s1=new Stack<>();
        static Stack<Integer> s2=new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        public static void add(int data){
            s1.push(data);
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("emoty");
                return -1;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int val=s2.pop();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }

            return val;
        }

        public static int peek() {
            if(isEmpty()){
                System.out.println("emoty");
                return -1;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int val=s2.peek();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }

            return val;
        }
    }

    static class stackb{
        static Queue<Integer> s1=new LinkedList<>();
        static Queue<Integer> s2=new LinkedList<>();

        public static boolean isEmpty(){
            return s1.isEmpty() && s2.isEmpty();
        }

        public static void add(int data){
            if(!s1.isEmpty()){
                s1.add(data);
            }else{
                s2.add(data);
            }
        }

        public static int pop(){
            if(isEmpty()){
                System.out.println("emoty");
                return -1;
            }
            int top=-1;
            
            if(!s1.isEmpty()){
                while(!s1.isEmpty()){
                    top=s1.remove();
                    if(s1.isEmpty()){
                        break;
                    }
                    s2.add(top);
                }
            }else{
                while(!s2.isEmpty()){
                    top=s2.remove();
                    if(s2.isEmpty()){
                        break;
                    }
                    s1.add(top);
                }
            }
            return top;
        }

        public static int peek() {
            if(isEmpty()){
                System.out.println("emoty");
                return -1;
            }
            int top=-1;
            
            if(!s1.isEmpty()){
                while(!s1.isEmpty()){
                    top=s1.remove();
                    s2.add(top);
                }
            }else{
                while(!s2.isEmpty()){
                    top=s2.remove();
                    s1.add(top);
                }
            }
            return top;
        }
    }

    public static void firstrepaeating(String s) {
        Queue<Character> q=new LinkedList<>();
        int freq[]=new int[26];
        int i=0;
        while(i<s.length()){
            char curr=s.charAt(i);
            q.add(curr);
            freq[curr-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print("-1");
            }else{
                System.out.print(q.peek());
            }
            i++;
        }
    }

    public static void interleave(Queue<Integer> q1) {

        Queue<Integer> q2 = new LinkedList<>();
        int size=q1.size();

        int i=0;
        while(i<size/2){
            q2.add(q1.remove());
            i++;
        }
        while(!q2.isEmpty()){
            q1.add(q2.remove());
            q1.add(q1.remove());
        }

        System.out.println(q1);
    }

    public static void reversal(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<Integer>();

        while(!q.isEmpty()){
            stack.push(q.remove());
        }

        while(!stack.isEmpty()){
            q.add(stack.pop());
        }

        System.out.println(q);
    }

    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        // q.add(5);
        // q.add(3);
        // q.add(7);
        // q.add(4);

        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove(); 
        // }

        // queuec q=new queuec();
        // q.add(4);
        // q.add(5);
        // q.add(6);

        // while(!q.isEmpty()){
        //     System.out.println(q.remove());
        // }

        // stackb q=new stackb();
        // q.add(4);
        // q.add(5);
        // q.add(6);

        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.pop();
        // }

        // String s="aabccxb";
        // firstrepaeating(s);

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        // interleave(q);
        reversal(q);
    }
}

