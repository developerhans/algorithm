package com.hans.greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 문제 : 프림
 * - 그래프에서 트리 찾기
 * - union find와 다른점은 A->B가 없음.
 */

class Edge implements Comparable<Edge> {
    public int vex;
    public int cost;

    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

public class Ex04 {
    static int[] unf;

    public static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void main(String[] args) {
        int n=9;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        int[] ch = new int[n + 1];
        /*1 2 12
        1 9 25
        2 3 10
        2 8 17
        2 9 8
        3 4 18
        3 7 55
        4 5 44
        5 6 60
        5 7 38
        7 8 35
        8 9 15*/
        graph.get(1).add(new Edge(2, 12));
        graph.get(1).add(new Edge(9, 25));
        graph.get(2).add(new Edge(3, 10));
        graph.get(2).add(new Edge(8, 17));
        graph.get(2).add(new Edge(9, 8));
        graph.get(3).add(new Edge(4, 18));
        graph.get(3).add(new Edge(7, 55));
        graph.get(4).add(new Edge(5, 44));
        graph.get(5).add(new Edge(6, 60));
        graph.get(5).add(new Edge(7, 38));
        graph.get(7).add(new Edge(8, 35));
        graph.get(8).add(new Edge(9, 15));

        graph.get(2).add(new Edge(1, 12));
        graph.get(9).add(new Edge(1, 25));
        graph.get(3).add(new Edge(2, 10));
        graph.get(8).add(new Edge(2, 17));
        graph.get(9).add(new Edge(2, 8));
        graph.get(4).add(new Edge(3, 18));
        graph.get(7).add(new Edge(3, 55));
        graph.get(5).add(new Edge(4, 44));
        graph.get(6).add(new Edge(5, 60));
        graph.get(7).add(new Edge(5, 38));
        graph.get(8).add(new Edge(7, 35));
        graph.get(9).add(new Edge(8, 15));

        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int ev = tmp.vex;
            if (ch[ev] == 0) {
                ch[ev] = 1;
                answer += tmp.cost;
                for (Edge ob : graph.get(ev)) {
                    if (ch[ob.vex] == 0) pQ.offer(new Edge(ob.vex, ob.cost));
                }
            }
        }
        System.out.println(answer);
    }

    /*public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }
        int[] ch=new int[n+1];
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            int c=kb.nextInt();
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        int answer=0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));
        while(!pQ.isEmpty()){
            Edge tmp=pQ.poll();
            int ev=tmp.vex;
            if(ch[ev]==0){
                ch[ev]=1;
                answer+=tmp.cost;
                for(Edge ob : graph.get(ev)){
                    if(ch[ob.vex]==0) pQ.offer(new Edge(ob.vex, ob.cost));
                }
            }
        }
        System.out.println(answer);
    }*/
}
