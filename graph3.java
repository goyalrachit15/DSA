package alpha;

import java.util.ArrayList;

public class graph3 {

    static class edge{
        int src;
        int des;

        public edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void create(ArrayList<edge>[] graph) {
        for(int i = 0; i < graph.length; i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0, 3));

        graph[2].add(new edge(2, 3));

        graph[3].add(new edge(3, 1));

        graph[4].add(new edge(4, 0));
        graph[4].add(new edge(4, 1));

        graph[5].add(new edge(5, 0));
        graph[5].add(new edge(5, 2));
    }

    public static void allpath(ArrayList<edge>[] graph,int src,int des,String path) {
        if(src==des){
            System.out.println(path+des);
            return;
        }

        for(int i=0;i<graph[src].size();i++){
            edge e=graph[src].get(i);
            allpath(graph,e.des, des, path+src);
        }
    }

    
    public static void main(String[] args) {
        int v=6;
        ArrayList<edge>[]graph=new ArrayList[v];
        create(graph);

        int src=5;
        int des=1;
        String path=""; 
        allpath(graph, src, des,path);

         
        
    }
}
