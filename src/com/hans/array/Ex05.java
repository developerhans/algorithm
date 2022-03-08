package com.hans.array;

import java.util.ArrayList;

/**
 * 문제 : 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 */
public class Ex05 {

    public ArrayList<Integer> solution(int[] a, int[] b){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;
        while(p1<a.length && p2<b.length){
            if(a[p1]<b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while(p1<a.length) answer.add(a[p1++]);
        while(p2<b.length) answer.add(b[p2++]);
        return answer;
    }

    public static void main(String[] args){
        int[] ex1 = {1, 3, 5};
        int[] ex2 = {2, 3, 6, 7, 9};
        Ex05 t = new Ex05();
        ArrayList<Integer> result = t.solution(ex1, ex2);
        System.out.print(result);
    }
}
