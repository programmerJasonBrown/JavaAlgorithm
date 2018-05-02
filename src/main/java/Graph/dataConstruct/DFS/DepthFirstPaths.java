package Graph.dataConstruct.DFS;

import Graph.dataConstruct.Graph.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph graph, int v) {
        marked = new boolean[graph.getVertex()];
        edgeTo = new int[graph.getVertex()];
        s = v;
        dFS(graph, v);
    }

    private void dFS(Graph graph, int v) {
        marked[v] = true;
        for (int x : graph.adj(v)) {
            if (!marked[x]) {
                edgeTo[x] = v;
                dFS(graph, x);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = v; i != s; i = edgeTo[i]) {
            stack.push(i);
        }
        stack.push(s);
        return stack;
    }

    public static void main(String[] args) {
        File file = new File("E:\\javaProject\\maven\\algorithm\\src\\main\\resources\\tinyCG");
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
        int s = 0;  //起点
        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(myGraph, s);

        for (int i = 0; i < myGraph.getVertex(); i++) {
            System.out.print(s + " to " + i + ": ");
            if (depthFirstPaths.hasPathTo(i)) { //i到起点s存在路径
                /*for (int x : depthFirstPaths.pathTo(i)) {    //不是先入后出了
                    if (x==s)
                        System.out.print(x);
                    else
                        System.out.print("-"+x);
                }
                System.out.println();*/
                Stack<Integer> stack = depthFirstPaths.pathTo(i);
                while (!stack.isEmpty()){
                    int x = stack.pop();
                    if (x==s)
                        System.out.print(x);
                    else
                        System.out.print("-"+x);
                }
                System.out.println();
            }

        }
    }
}

/*
* console
*
0 to 0: 0
0 to 1: 0-2-1
0 to 2: 0-2
0 to 3: 0-2-3
0 to 4: 0-2-3-4
0 to 5: 0-2-3-5
*
* */