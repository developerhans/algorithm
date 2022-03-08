package com.hans.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 문제 : A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 */
public class Ex06 {

    public ArrayList<Integer> solution(int[] a, int[] b){
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1=0, p2=0;
        while(p1<a.length && p2<b.length){
            if(a[p1]==b[p2]){
                answer.add(a[p1++]);
                p2++;
            }
            else if(a[p1]<b[p2]) p1++;
            else p2++;
        }
        return answer;
    }

    public static void main(String[] args){
        int[] ex1 = {1, 3, 9, 5, 2};
        int[] ex2 = {3, 2, 5, 7, 8};
        Ex06 t = new Ex06();
        ArrayList<Integer> result = t.solution(ex1, ex2);
        System.out.print(result);
    }
}
