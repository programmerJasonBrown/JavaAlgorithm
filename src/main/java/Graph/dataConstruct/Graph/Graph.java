package Graph.dataConstruct.Graph;

import Graph.dataConstruct.Bag;
import Graph.dataConstruct.DFS.DepthFirstSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {
    private final int vertex;//顶点数目
    private int edge; //边的数目
    private Bag<Integer>[] adj; //邻接表 adjoin

    public Graph(int vertex) {
        this.vertex = vertex;
        this.edge = 0;
        adj = (Bag<Integer>[]) new Bag[vertex]; //需要cast一下
        for (int i = 0; i < vertex ; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public int getVertex() {
        return vertex;
    }

    public int getEdge() {
        return edge;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        edge++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public static void main(String[] args) {
        File file = new File("D:\\javaProject\\maven\\algorithm\\src\\main\\resources\\tinyCG");
        Scanner scanner = null;
        Graph myGraph = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        myGraph = new Graph(scanner.nextInt());
        int edgeNum = scanner.nextInt();
        for (int i = 0; i < edgeNum; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            myGraph.addEdge(v, w);
        }
        scanner.close();

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(myGraph,0);
        System.out.println(depthFirstSearch.getCount());


    }
}
