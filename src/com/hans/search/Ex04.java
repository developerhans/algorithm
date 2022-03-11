package com.hans.search;

import java.util.Arrays;

/**
 * 문제 : 결정 알고리즘
 */
public class Ex04 {

    public int count(int[] arr, int capacity){
        int cnt=1, sum=0;
        for(int x : arr){
            if(sum+x>capacity){
                cnt++;
                sum=x;
            }
            else sum+=x;
        }
        return cnt;
    }

    public int solution(int m, int[] arr){
        int answer=0;
        int lt=Arrays.stream(arr).max().getAsInt();
        int rt=Arrays.stream(arr).sum();
        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(count(arr, mid)<=m){
                answer=mid;
                rt=mid-1;
            }
            else lt=mid+1;
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] ex1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 3;
        Ex04 t = new Ex04();
        int result = t.solution(target, ex1);
        System.out.print(result);

    }
}
