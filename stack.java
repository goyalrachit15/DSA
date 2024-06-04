package alpha;

import java.util.ArrayList;
import java.util.LinkedList;

public class stack {

    // class StackA is implementing stack using arraylist
    public static class StackA{
        static ArrayList<Integer> list=new ArrayList<>();

        public boolean isEmpty(){
            return list.size()==0;
        }

        public void push(int data){
            list.add(data);
        }

        public int pop() {
            if(list.size()==0){
                return -1;
            }
            int val=list.get(list.size()-1);
            list.remove(list.size()-1);
            return val;
        }

        public int peek() {
                if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }


    //implementing stack using linkedlist
    // creating node class
    static class Node {
         int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
   }

    public static Node head=null;
    public static class Stackll{
        LinkedList <Integer> ll =new LinkedList<>();

        public boolean isEmpty() {
             return head==null;
        }

        public void push(int data) {
            if(isEmpty()){
                Node newNode = new Node(data);
                head=newNode;
                return;
            }

            Node newNode = new Node(data);
            newNode.next = head;
            head=newNode;
        }

        public int pop() {
            if(head==null){
                return -1;
            }
            int val=head.data;
            head=head.next;
            return val;
        }

        public int peek() {
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }


    public static void main(String[] args) {
        StackA s=new StackA();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop(); 
        }

        Stackll sll=new Stackll();
        sll.push(1);
        sll.push(2);
        sll.push(3);
        while(!sll.isEmpty()){
            System.out.println(sll.peek());
            sll.pop();
        }
    }
}
