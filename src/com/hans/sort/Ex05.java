package com.hans.sort;

/**
 * 문제 : merge sort
 *
 */
public class Ex05 {

    private void sort(int[] arr) {
        int[] tmp = new int[arr.length];
        sort(arr, tmp, 0, arr.length -1);
    }

    private void sort(int[] arr, int[] tmp, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            sort(arr, tmp, start, mid);
            sort(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    private void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for(int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }

        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while (part1 <= mid && part2 <= end) {
            if(tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }

        for(int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }

    }

    private void print(int[] arr) {
        for (int i:arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {3,9,4,7,5,0,1,6,8,2};

        Ex05 t = new Ex05();
        t.print(arr);
        t.sort(arr);
        t.print(arr);
    }
}
