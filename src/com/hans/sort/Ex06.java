package com.hans.sort;

/**
 * 문제 : quick sort
 *
 */
public class Ex06 {

    private void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end);
        if(start < part2 - 1) {
            sort(arr, start, part2 - 1);
        }
        if(part2 < end) {
            sort(arr, part2, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2 ];
        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if(start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }


    private void print(int[] arr) {
        for (int i:arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {3,9,4,7,5,0,1,6,8,2};

        Ex06 t = new Ex06();
        t.print(arr);
        t.sort(arr);
        t.print(arr);
    }
}
