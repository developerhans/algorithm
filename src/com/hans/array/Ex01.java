package com.hans.array;

/**
 * 문제 : 피보나치수열
 *
 */
public class Ex01 {

    public int[] solution(int n){
        int[] answer=new int[n];
        answer[0]=1;
        answer[1]=1;
        for(int i=2; i<n; i++){
            answer[i]=answer[i-2]+answer[i-1];
        }
        return answer;
    }

    public static void main(String[] args){
        int ex = 10;

        Ex01 t = new Ex01();
        int[] result = t.solution(ex);

        for (int i:result) {
            System.out.print(i + ", ");
        }
    }
}
