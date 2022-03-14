package com.hans.graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 문제 : 그래프 최단거리(인접 행렬, Graph, DFS)
 */

/*
--------------------------------------------
0
/
1 --  3 7
| /|  \ /
|/ |   5
2 -- 4 \
         6 - 8


----------------------------------
DFS(0)
0 1 3 5 7 6 8 4 2

BFS(0)
0 1 2 3 4 5 6 7 8

DFS(0) - Recursive
0 1 2 4 3 5 6 8 7

DFS(3)
3 5 7 6 8 4 2 1 0

BFS(3)
3 1 2 4 5 0 6 7 8

DFS(3) - Recursive
3 1 0 2 4 5 6 8 7
 */

class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }

    Node[] nodes;
    Graph(int size) {
        nodes = new Node[size];
        for(int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) { // 두 노드간 관계를 설정
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if(!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }

        if(!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;

        while (!stack.isEmpty()) {
            Node r = stack.pop();
            for(Node n : r.adjacent) {
                if(n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }

            visit(r);
        }
    }

    void dfsR(Node r) {
        if(r == null)
            return;

        r.marked = true;
        visit(r);

        for(Node n : r.adjacent) {
            if(n.marked == false) {
                dfsR(n);
            }
        }
    }

    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }

    void dfsR() {
        dfsR(0);
    }

    void bfs() {
        bfs(0);
    }

    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new Queue<>();
        queue.add(root);
        root.marked = true;

        while (!queue.isEmpty()) {
            Node r = queue.remove();
            for(Node n : r.adjacent) {
                if(n.marked == false) {
                    n.marked = true;
                    queue.add(n);
                }
            }

            visit(r);
        }
    }



    void visit(Node n) {
        System.out.print(n.data + " ");
    }

}

public class GraphBasic {
    public static void main(String[] args) {
        GraphBasic graphBasic = new GraphBasic();

        // DFS
        Graph g = graphBasic.getSampleGraph();
        System.out.print("dfs(0) : ");
        g.dfs();
        System.out.println();

        g = graphBasic.getSampleGraph();
        System.out.print("dfsR(0) : ");
        g.dfsR();
        System.out.println();

        g = graphBasic.getSampleGraph();
        System.out.print("dfs(3) : ");
        g.dfs(3);
        System.out.println();

        g = graphBasic.getSampleGraph();
        System.out.print("dfsR(3) : ");
        g.dfsR(3);
        System.out.println();

        // BFS
        g = graphBasic.getSampleGraph();
        System.out.print("bfs(0) : ");
        g.bfs();
        System.out.println();

        g = graphBasic.getSampleGraph();
        System.out.print("bfs(0) : ");
        g.bfs(3);
        System.out.println();

        //g.bfs(3);
        //g.bfs(3);
        //g.dfsR(3);
        //g.bfs();
    }

    Graph getSampleGraph() {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);

        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

        return g;
    }


}
