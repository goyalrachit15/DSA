package alpha;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class graph_dijkstra {

    static class edge{
        int src;
        int des;
        int wt;

        public edge(int src,int des,int wt){
            this.src=src;
            this.des=des;
            this.wt=wt;
        }
    }

    public static void create(ArrayList<edge>[] graph) {
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new edge(0, 1, 2));
        graph[0].add(new edge(0, 2, 4));

        graph[1].add(new edge(1, 2, 1));
        graph[1].add(new edge(1, 3, 7));

        graph[2].add(new edge(2, 4, 3));

        graph[3].add(new edge(3, 5, 1));

        graph[4].add(new edge(4, 3, 2));
        graph[4].add(new edge(4, 5, 5));
    }

    static class pair implements Comparable<pair>{
        int n;
        int path;

        public pair(int n, int path){
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(pair p2){
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<edge>[]graph,int src) {
        int dis[]=new int[graph.length];
        for (int i = 0; i < dis.length; i++) {
            if(i!=src){
                dis[i]=Integer.MAX_VALUE;
            }
        }

        boolean vis[]=new boolean[graph.length];
        PriorityQueue<pair> q = new PriorityQueue<pair>();
        q.add(new pair(src,0));

        while(!q.isEmpty()){
            pair curr=q.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;

                for(int i=0;i<graph[curr.n].size();i++){
                    edge e=graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.des;
                    int wt=e.wt;

                    if(dis[u]+wt<dis[v]){
                        dis[v]=dis[u]+wt;
                        q.add(new pair(v, dis[v]));
                    }
                }
            }
        }

        for (int i = 0; i < dis.length; i++) {
            System.out.println(dis[i]);
        }
    }


    //NOT VALID FOR NEGATIVE WEIGHTED CYCLE
    public static void bellman(ArrayList<edge>[] graph,int src) {
         int dis[]=new int[graph.length];

         for(int i=0;i<dis.length;i++) {
            if(i!=src){
                dis[i]=Integer.MAX_VALUE;
            }
        }

        int v=graph.length;

        for(int i=0;i<v-1;i++) {
            for(int j=0;j<graph.length;j++) {
                for(int k=0;k<graph[j].size();k++) {
                    edge e=graph[j].get(k);
                    
                    int u=e.src;
                    int V=e.des;
                    int wt=e.wt;

                    if(dis[V]>dis[u]+wt && dis[u]!=Integer.MAX_VALUE) {
                        dis[V]=dis[u]+wt;
                    }
                }
            }
        }

            for (int j = 0; j < dis.length; j++) {
                System.out.print(dis[j] +" ");
            }
            System.out.println();
    }

    static class Pairs implements Comparable<Pairs>{
        int v;
        int cost;

        public Pairs(int v, int cost){
            this.v=v;
            this.cost=cost;
        }

        @Override
        public int compareTo(Pairs p2){
            return this.cost-p2.cost;
        }
    }


    public static void prim(ArrayList<edge> graph[]) {
        boolean[] vis=new boolean[graph.length];
        PriorityQueue<Pairs> pq=new PriorityQueue<>();

        pq.add(new Pairs(0, 0));
        int finals=0;

        while(!pq.isEmpty()){
           Pairs curr=pq.remove();
           if(!vis[curr.v]){
            vis[curr.v]=true;
            finals+=curr.cost;

            for(int i=0;i<graph[curr.v].size();i++){
            edge e=graph[curr.v].get(i);

            pq.add(new Pairs(e.des, i));
            }
           }
        }

        System.out.println(finals);
    }

    public static void main(String[] args) {
        int v=6;
        ArrayList<edge>[] graph=new ArrayList[v];
        create(graph);

        // dijkstra(graph, 0);
        bellman(graph, 0);

        prim(graph);
    }


}
