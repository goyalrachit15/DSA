package alpha;

import java.util.LinkedList;

public class hashmap_implementation {

    static class HashMap<K, V> {  //<>generic general when data type is not known will work for all data type
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private int arr[];
        private LinkedList<Node> bucket[];

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.bucket = new LinkedList[4];
            for(int i = 0; i < 4; i++){
                this.bucket[i]=new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc=key.hashCode();
            return (Math.abs(hc)%N);
        }

        private int searchinLL(K key, int bi){
            LinkedList<Node> ll = bucket[bi];
            int di=0;
            for(int i=0; i<ll.size(); i++){
                Node node=ll.get(i);
                if(node.key==key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash(){
            LinkedList<Node> oldbucket[]=bucket;
            bucket=new LinkedList[N*2];
            N=2*N;
            for(int i=0; i<N; i++){
                bucket[i]=new LinkedList<>();
            }

            

        }


        public void put(K key,V value) {
            int bi=hashFunction(key);
            int di=searchinLL(key,bi);

            if(di!=-1){
                Node node=bucket[bi].get(di);
                node.value=value;
            }else{
                bucket[bi].add(new Node(key,value));
                n++;
            }

            double lambda=(double)n/N;
            if(lambda>2){
                rehash();
            }
        }




    }

    public static void main(String[] args) {

    }
}
