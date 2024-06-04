package alpha;

public class queue {

    static class QueueA {
        static int arr[];
        static int size;
        static int rear;

        QueueA(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            if (rear == -1) {
                return true;
            } else {
                return false;
            }
        }

        public static void enqueue(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        public static int dequeue() {
            if (rear == -1) {
                System.out.println("queue is empty");
                return -1;
            }
            int front = arr[0];

            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        public static int peek() {
            if (rear == -1) {
                System.out.println("queue is empty");
                return -1;
            }

            return arr[0];
        }
    }

    static class circularQueue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        circularQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            if (rear == -1 && front == -1) {
                return true;
            } else {
                return false;
            }
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int dequeue() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int val = arr[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return val;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }

            return arr[front];
        }
    }

    static class Queuell{

        static class Node{
            int data;
            Node next;
            Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        static Node head=null;
        static Node tail=null;

        public static boolean isEmpty(){
            return head==null && tail==null;
        }

        public static void enqueue(int data){
            Node newnode=new Node(data);
            if(head==null){
                head=tail=newnode;
                return;
            }else{
                tail.next=newnode;
                tail=newnode;
            }
        }

        public static int dequeue(){
            if(head==null){
                System.out.println("empty");
                return -1;
            }
            int val=head.data;
            if(head==tail){
                head=tail=null;
            }else{
                head=head.next;
            }
            return val;
        }

        public static int peek(){
            if(head==null){
                System.out.println("empty");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        // QueueA q = new QueueA(5);
        // q.enqueue(5);
        // q.enqueue(4);
        // q.enqueue(2);

        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.dequeue();
        // }

        // Queuell q = new Queuell();
        // q.enqueue(5);
        // q.enqueue(4);
        // q.enqueue(2);

        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.dequeue();
        // }

    }
}
