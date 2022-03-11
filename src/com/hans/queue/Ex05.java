package com.hans.queue;

import java.util.LinkedList;

/**
 * 문제 : LRU
 *
 * 풀이 : array, queue
 */

public class Ex05 {

    public static int[] solution(int s, int[] work) {
        LinkedList<Integer> cache = new LinkedList<>();
        int[] answer = new int[s];
        for (int i : work) {
            if (cache.contains(i)) { //캐시에 최근 작업이 이미 있다면
                cache.remove((Integer) i);
            }
            cache.addFirst(i);
            if (cache.size() > s) {
                cache.removeLast();
            }
        }
        for (int i = 0; i < s; i++) {
            answer[i] = cache.get(i);
        }
        return answer;
    }

    // 배열을 통한 방법
    /*public int[] solution(int size, int[] arr) {
        int[] cache = new int[size];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < size; i++) if (x == cache[i]) pos = i;
            if (pos == -1) {
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }
        return cache;
    }*/

    public static void main(String[] args) {

        int[] ex1 = {1, 2, 3, 2, 6, 2, 3, 5, 7};
        int size = 5;

        Ex05 t = new Ex05();
        int[] result = t.solution(size, ex1);
        for (int i : result) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
