package alpha;

import java.util.Scanner;

public class linkedlist {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addfirst(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
    }

    public void addlast(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
    }

    public void addmiddle(int data, int index) {
        if (index == 0) {
            addfirst(data);
            return;
        }
        Node temp = head;
        size++;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        Node newnode = new Node(data);
        newnode.next = temp.next;
        temp.next = newnode;
    }

    public void removefirst() {
        if (head == null) {
            System.out.println("LINKELIST IS EMPTY");
            return;
        } else if (head == tail) {
            head = tail = null;
            size = 0;
        } else {
            head = head.next;
            size--;
        }
    }

    public void removelast() {
        if (head == null) {
            System.out.println("LINKELIST IS EMPTY");
            return;
        } else if (head == tail) {
            head = tail = null;
            size = 0;
        } else {
            Node temp = head.next;
            Node prev = head;
            while (temp.next != null) {
                temp = temp.next;
                prev = prev.next;
            }
            prev.next = null;
            tail = prev;
            size--;
        }
    }

    public static int search(int target) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == target) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public static int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }
    public static int search_recursion(int key) {
        return helper(head, key);
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void print(Node head) {
        if (head == null) {
            System.out.println("LINKELIST IS EMPTY");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static void delete(int idx) {
        int i = 0;
        Node prev = head;
        Node temp = head.next;
        while (i < idx - 2) {
            prev = prev.next;
            temp = temp.next;
            i++;
        }
        prev.next = temp.next;
    }

    public void addcycle(int idx) {
        Node temp = head;
        int i = 0;
        while (i < idx) {
            temp = temp.next;
            i++;
        }
        tail.next = temp;
    }

    public static boolean detect_cycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void remove_cycle() {
        Node fast=head;
        Node slow = head;
        if(detect_cycle()==true){
            while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        slow=head;
        while(slow.next!=fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next=null;
        }
    }

    public Node findmid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null){
            slow=slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private Node merge(Node head1,Node head2) {
        Node mergell=new Node(-1);
        Node temp=mergell;

        while(head1 != null && head2 != null){
            if(head1.data<head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }

        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }

        return mergell.next;
    }
    public Node mergesort(Node head) {
        if(head==null || head.next==null) {
            return head;
        }

        Node mid=findmid(head);

        Node right=mid.next;
        mid.next =null;
        Node newleft=mergesort(head);
        Node newright=mergesort(right);
        return merge(newleft, newright);
        
    }


    public void zigzag(Node head) {
        //find mid node
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;

        //reverse second half

        Node prev=null;
        Node curr=mid.next;
        mid.next=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node left=head;
        Node right=prev;
        Node nextl,nextr;

        //alternate merging

        while(left!=null && right!=null){
            nextl=left.next;
            left.next=right;
            nextr=right.next;
            right.next=nextl;

            left=nextl;
            right=nextr;
        }
    }

    public static void main(String[] args) {
        Scanner br = new Scanner(System.in);
        linkedlist ll = new linkedlist();
        ll.addfirst(1);
        ll.addfirst(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addmiddle(10, 0);

        print(head);

        // print(head);;
        // ll.removefirst();
        // print(head);
        // ll.removelast();
        // print(head);
        // System.out.println(search(1));
        // System.out.println(search_recursion(1));
        // print(head);
        // reverse();
        // print(head);
        // int n=br.nextInt();
        // int idx=size-n+1;
        // delete(idx);
        // print(head);

        // br.close();
        // }
        // ll.addcycle(2);

        // // print(head);
        // System.out.println(detect_cycle());
        // remove_cycle();
        // print(head);
        // System.out.println(detect_cycle());

        // ll.head=ll.mergesort(head);
        // print(head);

        ll.zigzag(head);
        print(head);
        br.close();
    }
}
