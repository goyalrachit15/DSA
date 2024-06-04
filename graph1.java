package alpha;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class graph1 {

    static class edge{
        int src;
        int dest;

        public edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void create(ArrayList<edge>[] graph) {
        for(int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<>();
        }

        // graph[0].add(new edge(0, 1));
        graph[0].add(new edge(0, 2));
        graph[0].add(new edge(0, 3));

        // graph[1].add(new edge(1,0));
        graph[1].add(new edge(1,2));

        graph[2].add(new edge(2,0));
        graph[2].add(new edge(2,1));

        graph[3].add(new edge(3,0));
        graph[3].add(new edge(3,4));

        graph[4].add(new edge(4, 3));
    }


    public static boolean detectcycle(ArrayList<edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!visited[i]){
                if(detectcycle_util(graph,i,-1,visited))
                return true;
            }
        }
        return false;
    }

    public static boolean detectcycle_util(ArrayList<edge>[] graph,int src,int par,boolean[] vis) {
        vis[src]=true;

        for(int i=0; i<graph[src].size(); i++) {
            edge e=graph[src].get(i);
            if(!vis[e.dest]) {
                if (detectcycle_util(graph, e.dest, src, vis)){
                    return true;
                }
            }else if(vis[e.dest] && e.dest!= par){
                return true;
            }
        }
        return false;
    }

    public static boolean bipartite(ArrayList<edge>[] graph) {
        int []color=new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] =-1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++) {
            if(color[i] == -1){
                q.add(i);
                color[i] =0;
                while(!q.isEmpty()) {
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].size();j++) {
                        edge e=graph[curr].get(j);
                        if(color[e.dest]==-1){
                            int nextcol=color[curr]==0?1:0; 
                            color[e.dest]=nextcol;
                            q.add(e.dest);
                        }else if(color[e.dest]==color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int v=5;
        ArrayList<edge>[] graph=new ArrayList[v];

        create(graph);

        System.out.println(detectcycle(graph));
        System.out.println(bipartite(graph));

    }
}