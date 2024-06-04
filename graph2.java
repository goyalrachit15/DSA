package alpha;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class graph2 {

    static class edge {
        int src;
        int dst;

        public edge(int src, int dst) {
            this.src = src;
            this.dst = dst;
        }
    }

    public static void create(ArrayList<edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new edge(2, 3));

        graph[3].add(new edge(3, 1));

        graph[4].add(new edge(4, 0));
        graph[4].add(new edge(4, 1));
        
        graph[5].add(new edge(5, 0));
        graph[5].add(new edge(5, 2));
    }

    //Valid only for directed acyclics graphs
    public static void topological_dfs(ArrayList<edge>[] graph) {
        boolean vis[]=new boolean[graph.length];
        Stack<Integer> s=new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                topological_dfs_util(graph,i,vis,s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        System.out.println();
    }

    public static void topological_dfs_util(ArrayList<edge>[] graph,int curr,boolean[] vis,Stack<Integer> s) {
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            edge e=graph[curr].get(i);
            if(!vis[e.dst]){
                topological_dfs_util(graph,e.dst,vis,s);
            }
        }
        s.push(curr);
    }


    //KAHN ALGORITHM
    //TOPOLOGICAL SORT USING BFS
    //DIRECTED ACYCLLIC GRAPH HAS AT LEAST ONE VERTEX WITH IN-DEGREE=0 AND ONE WITH OUT-DEGREE=0

    public static void calc_indeg(ArrayList<edge>[] graph,int in_deg[]) {
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                edge e=graph[i].get(j);
                in_deg[e.dst]++;
            }
        }
    }

    public static void topsort_bfs(ArrayList<edge>[] graph) {
        int in_deg[]=new int[graph.length];
        calc_indeg(graph, in_deg);
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<graph.length;i++){
            if(in_deg[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.print(curr+" ");

            for(int i=0; i <graph[curr].size();i++){
                edge e=graph[curr].get(i);
                in_deg[e.dst]--;
                if(in_deg[e.dst]==0){
                    q.add(e.dst);
                }
            }
        }
    }



    public static void main(String[] args) {

        int v = 6;
        ArrayList<edge>[] graph=new ArrayList[v];
        create(graph);

        topological_dfs(graph);

        topsort_bfs(graph);


    }

}
