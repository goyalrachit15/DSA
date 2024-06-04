package alpha;

import java.util.LinkedList;

public class linkedlistjcf {
    public static void main(String[] args) {
        LinkedList <Integer> ll=new LinkedList<>();

        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }
}
