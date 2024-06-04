package alpha;

import java.util.*;

public class graph {

    static class edge{
        int src;
        int dst;
        int wt;

        public edge(int src, int dst, int wt){
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }
    }

    public static void create(ArrayList<edge>[] graph) {
        for(int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new edge(0, 1, 1));
        graph[0].add(new edge(0, 2, 1));

        graph[1].add(new edge(1,0,1));
        graph[1].add(new edge(1,3,1));

        graph[2].add(new edge(2,0,1));
        graph[2].add(new edge(2,4,1));

        graph[3].add(new edge(3,1,1));
        graph[3].add(new edge(3,4,1));
        graph[3].add(new edge(3,5, 1));

        graph[4].add(new edge(4, 2,1));
        graph[4].add(new edge(4, 3, 1));
        graph[4].add(new edge(4, 5, 1));

        graph[5].add(new edge(5,3, 1));
        graph[5].add(new edge(5,4, 1));
        graph[5].add(new edge(5,6, 1));

        graph[6].add(new edge(6, 5, 1));
    }


    public static void bfs(ArrayList<edge>[] graph) {
        boolean[] vis=new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                bfs_util(graph,vis);
            }
        }
        
    }
    public static void bfs_util(ArrayList<edge>[] graph,boolean[] vis) {
        Queue<Integer> q=new LinkedList<Integer>();

        //adding start point to the queue
        q.add(4);

        while(!q.isEmpty()){
            int curr=q.remove();

            //if node not visited
            if(!vis[curr]){
                //print the node and mark it as visited
                System.out.print(curr+" ");
                vis[curr]=true;

                //adding all the neighbors of curr node to queue
                for (int i = 0; i < graph[curr].size(); i++) {
                    edge e=graph[curr].get(i);
                    q.add(e.dst);
                }
            }
        }
    }


    public static void dfs(ArrayList<edge>[] graph) {
        boolean vis[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                dfs_util(graph, i, vis);
            }
        }
    }
    public static void dfs_util(ArrayList<edge>[] graph,int curr,boolean vis[]) {
        System.out.print(curr+" ");
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++) {
            edge e=graph[curr].get(i);
            if(!vis[e.dst]){
                dfs_util(graph,e.dst, vis);
            }
        }
    }

    public static boolean haspath(ArrayList<edge>[] graph,int src,int des,boolean vis[] ) {
        if(src==des){
            return true;
        }

        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            edge e=graph[src].get(i);
            if(!vis[e.dst] && haspath(graph, e.dst, des, vis)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
    //CREATING A GRAPH
        int v=7;//v is number of vertices
        ArrayList<edge>[] graph=new ArrayList[v];
        
        create(graph);
        bfs(graph);
        System.out.println();
        dfs(graph);

        boolean res=haspath(graph, 0, 3, new boolean[v]);
        System.out.println();
        System.out.println(res);
    }
}
