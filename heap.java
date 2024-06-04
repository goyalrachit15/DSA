package alpha;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class heap {

    static class Heap {
        ArrayList<Integer> list = new ArrayList<Integer>();

        public void add(int data) {
            list.add(data);

            int x = list.size() - 1;
            int par = (x - 1) / 2;

            while (list.get(x) < list.get(par)) { // O(log n)
                int temp = list.get(x);
                list.set(x, list.get(par));
                list.set(par, temp);
                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return list.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int min = i;

            if (left < list.size() && list.get(min) > list.get(left)) {
                min = left;
            }

            if (right < list.size() && list.get(min) > list.get(right)) {
                min = right;
            }

            if (min != i) {
                int temp = list.get(min);
                list.set(min, list.get(i));
                list.set(i, temp);

                heapify(min);
            }
        }

        public int remove() {
            int data = list.get(0);

            int temp = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.set(list.size() - 1, temp);

            list.remove(list.size() - 1);

            heapify(0);
            return data;

        }

        public void print() {
            System.out.println(list);

        }

        public boolean isEmpty() {
            return list.size() == 0;
        }
    }

    static class Points implements Comparable<Points> {
        int x;
        int y;
        int sq;

        public Points(int x, int y, int sq) {
            this.x = x;
            this.y = y;
            this.sq = sq;
        }

        @Override
        public int compareTo(Points p2) {
            return this.sq - p2.sq;
        }
    }

    static class Weakest implements Comparable<Weakest> {
        int soldier;
        int idx;

        public Weakest(int soldier, int idx) {
            this.soldier = soldier;
            this.idx = idx;
        }

        @Override
        public int compareTo(Weakest w2) {
            if (this.soldier == w2.soldier) {
                return this.idx - w2.idx;
            }
            return this.soldier - w2.soldier;
        }
    }

    static class sw implements Comparable<sw> {
        int idx;
        int data;

        public sw(int idx, int data) {
            this.idx = idx;
            this.data = data;
        }

        @Override
        public int compareTo(sw s2) {
            return s2.data - this.data;
        }
    }

    public static void sliding_window(int arr[], int k) {
        PriorityQueue<sw> p = new PriorityQueue<sw>();
        int res[] = new int[arr.length - k + 1];
            int i = 0;
            while (p.size() < k) {
                p.add(new sw(i, arr[i]));
                i++;
            }
            res[0] = p.peek().data;

            for (i = k; i < arr.length; i++) {
                while (p.size() > 0 && p.peek().idx < i - k) {
                    p.remove();
                }
                p.add(new sw(i, arr[i]));
                res[i-k+1]= p.peek().data;
            }

        for (int j = 0; j < res.length; j++) {
            System.out.print(res[j] + " ");
        }

    }

    public static void main(String[] args) {
        // Heap h=new Heap();
        // h.add(2);
        // h.add(3);
        // h.add(4);
        // h.add(5);
        // h.add(10);
        // h.add(1);

        // while(!h.isEmpty()){
        // System.out.println(h.peek());
        // h.remove();
        // }
        // h.print();

        // //nearby cars
        // PriorityQueue<Points> cars = new PriorityQueue<>();
        // int pts[][]={{3,3},{5,-1},{-2,4}};
        // int k=2;

        // for (int i=0; i<pts.length; i++){
        // int dis=(pts[i][0]*pts[i][0])+(pts[i][1]*pts[i][1]);
        // cars.add(new Points(pts[i][0],pts[i][1],dis));
        // }

        // for(int i=0;i<k;i++){
        // System.out.println(cars.remove().sq);
        // }

        // //n ropes
        // int ropes[]={2,3,3,5,7};
        // PriorityQueue<Integer> pq=new PriorityQueue<Integer>();

        // for(int i=0;i<ropes.length;i++){
        // pq.add(ropes[i]);
        // }

        // int cost=0;

        // while(pq.size()>1){
        // int min1=pq.remove();
        // int min2=pq.remove();
        // cost+=min1+min2;

        // pq.add(min1+min2);
        // }
        // System.out.println(cost);

        // //weakest soldier
        // int army[][]={{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        // int k=2;

        // PriorityQueue<Weakest> q = new PriorityQueue<Weakest>();

        // for(int i=0; i<army.length; i++){
        // int soldier=0;
        // for(int j=0; j<army[0].length; j++){
        // if(army[i][j]==1){
        // soldier++;
        // }
        // }
        // q.add(new Weakest(soldier, i));
        // }

        // for (int i = 0; i < k; i++) {
        // System.out.println(q.remove().idx);
        // }

        // sliding window maximum
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        sliding_window(arr, 3);
    }
}
