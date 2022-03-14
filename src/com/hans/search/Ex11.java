package com.hans.search;

/**
 * 문제 : 경로 탐색(인접 행렬, Graph, DFS)
 * 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프 로그램을 작성하세요. 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는 총 6 가지입니다.
 */

public class Ex11 {
    static int n = 5;
    static int answer=0;
    static int[][] graph;
    static int[] ch;
    public void DFS(int v){
        if(v==n) answer++;
        else{
            for(int i=1; i<=n; i++){
                if(graph[v][i]==1 && ch[i]==0){
                    ch[i]=1;
                    DFS(i);
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Ex11 t = new Ex11();

        graph=new int[n+1][n+1];
        ch=new int[n+1];
        graph[1][2]=1;
        graph[1][3]=1;
        graph[1][4]=1;
        graph[2][1]=1;
        graph[2][3]=1;
        graph[2][5]=1;
        graph[3][4]=1;
        graph[4][2]=1;
        graph[4][5]=1;
        ch[1]=1;
        t.DFS(1);
        System.out.println(answer);
    }
}
