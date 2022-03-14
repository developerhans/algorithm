package com.hans.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제 : 그래프 최단거리(인접 행렬, Graph, DFS)
 * 다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.
 */

public class Ex13 {
    static int n = 6, m = 9, answer=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;
    public void BFS(int v){
        ch[v]=1;
        dis[v]=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(v);
        while(!queue.isEmpty()){
            int cv=queue.poll();
            for(int nv : graph.get(cv)){
                if(ch[nv]==0){
                    ch[nv]=1;
                    queue.offer(nv);
                    dis[nv]=dis[cv]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Ex13 t = new Ex13();

        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        ch=new int[n+1];
        dis = new int[n+1];

        graph.get(1).add(3);
        graph.get(1).add(4);
        graph.get(2).add(1);
        graph.get(2).add(5);
        graph.get(3).add(4);
        graph.get(4).add(5);
        graph.get(4).add(6);
        graph.get(6).add(2);
        graph.get(6).add(5);

        ch[1]=1;
        t.BFS(1);
        for(int i=2; i<=n; i++){
            System.out.println(i+" : "+dis[i]);
        }
    }
}
