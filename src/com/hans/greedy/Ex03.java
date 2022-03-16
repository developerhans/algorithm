package com.hans.greedy;

/**
 * 문제 : 서로소 집합
 *  - union find
 */
public class Ex03 {
    static int[] unf;

    static class Solution {
        public int Find(int v){
            if(v==unf[v]) return v;
            else return unf[v]=Find(unf[v]);
        }
        public void Union(int a, int b){
            int fa=Find(a);
            int fb=Find(b);
            if(fa!=fb) unf[fa]=fb;
        }
    }

    public static void main(String[] args) {
        String ex1 = "abaac";

        int n= 9;
        int m= 7;
        unf=new int[n+1];
        for(int i=1; i<=n; i++) unf[i]=i;

        Solution ex = new Solution();
        ex.Union(1, 2);

        ex.Union(2, 3);
        ex.Union(3, 4);
        ex.Union(1, 5);
        ex.Union(6, 7);
        ex.Union(7, 8);
        ex.Union(8, 9);

        int target1 = 3;
        int target2 = 8;

        int fa=ex.Find(target1);
        int fb=ex.Find(target2);
        if(fa==fb) System.out.println("YES");
        else System.out.println("NO");
    }
}
