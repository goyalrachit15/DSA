package alpha;

import java.util.Comparator;
// import java.util.Comparator;
import java.util.PriorityQueue;

public class pq {

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name,int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank; 
        }
    }


    public static void main(String[] args) {
        // PriorityQueue<Integer> pq=new PriorityQueue<Integer>();//ascending priority queue

        
        // PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Comparator.reverseOrder());
        //descending priority queue

        PriorityQueue<Student> pq=new PriorityQueue<Student>(Comparator.reverseOrder());
        pq.add(new Student("A",10));
        pq.add(new Student("B",13));
        pq.add(new Student("C",1));
        pq.add(new Student("D",100));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().rank);
            pq.remove();
        }

    }
}
