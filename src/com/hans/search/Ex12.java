package com.hans.search;

import java.util.ArrayList;

/**
 * 문제 : 경로 탐색(인접 행렬, Graph, DFS)
 * 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프 로그램을 작성하세요. 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는 총 6 가지입니다.
 */

public class Ex12 {
    static int n = 5;
    static int m = 9;
    static int answer=0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int[] ch;
    public void DFS(int v){
        if(v==n) answer++;
        else{
            for(int nv : graph.get(v)){
                if(ch[nv]==0){
                    ch[nv]=1;
                    DFS(nv);
                    ch[nv]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Ex12 t = new Ex12();

        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        ch=new int[n+1];

        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(2).add(5);
        graph.get(3).add(4);
        graph.get(4).add(2);
        graph.get(4).add(5);

        ch[1]=1;
        t.DFS(1);
        System.out.println(answer);
    }
}
