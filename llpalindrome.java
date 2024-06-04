package alpha;

public class llpalindrome {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size = 0;


    public static Node reverse(Node mid) {
        Node prev=null;
        Node curr=tail=mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right=prev;
        return right;
    }

    public static boolean check(Node head,Node right) {
        Node left = head;
        while(right != null) {
            if(left.data!=right.data){
                return false;
            }
            right = right.next;
            left=left.next;
        }
        return true;
    }


    public static void palindrome(int size) {
        Node slow = head;
        Node fast = head;
        Node mid;
        if (size % 2 == 0) {
            while (fast != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            mid = slow;
        } else {
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            mid = slow;
        }
        Node right=reverse(mid);
        boolean res=check(head,right);

        if(res==true){
            System.out.println("palindrome");
        }
        if(res==false){
            System.out.println("not palindrome");
        }
    }

    public void addlast(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = tail = newnode;
        }
        tail.next = newnode;
        tail = newnode;
        size++;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        llpalindrome ll = new llpalindrome();
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(2);
        ll.addlast(1);
        print(head);
        palindrome(size);

    }
}
