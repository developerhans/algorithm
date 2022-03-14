package com.hans.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 문제 : 송아지 찾기(BFS)
 * 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다. 현수의 위치와 송아 지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음 과 같은 방법으로 이동한다. 송아지는 움직이지 않고 제자리에 있다.
 * 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다. 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성 하세요.
 */

public class Ex10 {

    /*int answer=0;
    int[] dis={1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e){
        ch=new int[10001];
        ch[s]=1;
        Q.offer(s);
        int L=0;
        while(!Q.isEmpty()){
            int len=Q.size();
            for(int  i=0; i<len; i++){
                int x = Q.poll();
                for(int j=0; j<3; j++){
                    int nx=x+dis[j];
                    if(nx==e){
                        return L+1;
                    }
                    if(nx>=1 && nx<=10000 && ch[nx]==0){
                        ch[nx]=1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }*/

    int answer=0;
    int[] dis={1, -1, 5};
    //int[] ch;
    Set<Integer> ch = new HashSet<>();
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e){
        ch.add(s);
        Q.offer(s);
        int L=0;
        while(!Q.isEmpty()){
            int len=Q.size();
            for(int  i=0; i<len; i++){
                int x = Q.poll();
                for(int j=0; j<3; j++){
                    int nx=x+dis[j];
                    if(nx==e){
                        return L+1;
                    }
                    if(nx>=1 && nx<=10000 && ch.contains(s)){
                        ch.add(nx);
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }



    /*int answer=0;
    int[] dis={1, -1, 5};
    Set<Integer> set = new HashSet();
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e){
        set.add(s);
        Q.offer(s);
        int L=0;
        while(!Q.isEmpty()){
            int len=Q.size();
            for(int  i=0; i<len; i++){
                int x = Q.poll();
                for(int j=0; j<3; j++){
                    int nx=x+dis[j];
                    if(nx==e){
                        return L+1;
                    }
                    if(nx>=1 && nx<=10000 && !set.contains(s)){
                        set.add(s);
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }*/


    public static void main(String[] args) {
        Ex10 t = new Ex10();
        int start = 5;
        int target = 14;
        int result = t.BFS(start, target);
        System.out.println(result);
    }
}
