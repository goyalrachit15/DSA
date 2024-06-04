package alpha;
import java.util.*;

public class deque {

    static class stack{
        static Deque<Integer> q=new LinkedList<>();

        public static boolean isEmpty() {
            return q.size() == 0;
        }

        public static void push(int data) {
            q.addLast(data);
        }

        public static int pop() {
            return q.removeLast();
        }

        public static int peek() {
            return q.getLast();
        }
    }

    static class queue{
        static Deque<Integer> q=new LinkedList<>();

        public static boolean isEmpty() {
            return q.size() == 0;
        }

        public static void add(int data) {
            q.addLast(data);
        }

        public static int pop() {
            return q.removeFirst();
        }

        public static int peek() {
            return q.getFirst();
        }
    }



    public static void main(String[] args) {
        // Deque<Integer> deque = new LinkedList<Integer>();
        // deque.addFirst(1);
        // deque.addFirst(5);
        // deque.addLast(10);
        // deque.addLast(15);

        // deque.removeFirst();
        // deque.removeLast();
        // System.out.println(deque.getFirst());
        // System.out.println(deque.getLast());
        // System.out.println(deque);

        // stack s=new stack();
        // s.push(5);
        // s.push(3);
        // s.push(1);
        // s.push(7);
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.peek());
        // System.out.println(s.pop());

        // queue s=new queue();
        // s.add(5);
        // s.add(3);
        // s.add(1);
        // s.add(7);
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.peek());
        // System.out.println(s.pop());
    }
}
