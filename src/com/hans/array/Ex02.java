package com.hans.array;

/**
 * 문제 : 소수(에라토스테네스 체)
 *  1 ~ N까지 소수 수량 뽑기
 *
 * 생각할것
 *  선택된 숫자를 뽑아 미리 체크하여 많은 연산을 줄이는 알고리즘.
 */
public class Ex02 {

    public int solution(int n){
        int cnt=0;
        int[] ch = new int[n+1];
        for(int i=2; i<=n; i++){
            if(ch[i]==0){
                cnt++;
                System.out.print(i + ", ");
                for(int j=i; j<=n; j=j+i) ch[j]=1;
            }
        }
        System.out.println();
        return cnt;
    }

    public static void main(String[] args){
        int ex = 20;

        Ex02 t = new Ex02();
        int result = t.solution(ex);
        System.out.print(result);
    }
}
