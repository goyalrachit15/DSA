
package alpha;

public class doublell {

    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void print(Node head) {
        if (head == null) {
            System.out.println("LINKELIST IS EMPTY");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "<->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public void addfirst(int data) {
        size++;
        if (head == null) {
            Node newnode = new Node(data);
            head = tail = newnode;
            return;
        }
        Node newnode = new Node(data);
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }

    public void addlast(int data) {
        if (head == null) {
            Node newnode = new Node(data);
            head = tail = newnode;
            return;
        }
        Node newnode = new Node(data);
        tail.next = newnode;
        newnode.prev = tail;
        tail = newnode;
        size++;
    }

    public void removefirst() {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        if (size == 1) {
            head = tail = null;
            size = 0;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void removelast() {
        size--;
        if (head == null) {
            System.out.println("empty");
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    public void reverse() {
        Node curr=head;
        Node prev=null;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head=prev;
    }
    public static void main(String[] args) {
        doublell ll = new doublell();
        ll.addfirst(11);
        ll.addfirst(10);
        ll.addfirst(9);
        ll.addlast(12);
        ll.addlast(13);
        // print(head);
        // ll.removefirst();
        // ll.removelast();
        print(head);
        ll.reverse();
        print(head);
    }

}
