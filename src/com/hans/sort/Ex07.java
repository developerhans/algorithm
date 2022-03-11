package com.hans.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 문제 : quick sort
 *
 */
class Point implements Comparable<Point>{
    public int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public int compareTo(Point o){
        if(this.x==o.x) return this.y-o.y;
        else return this.x-o.x;
    }
}


public class Ex07 {

    private void print(int[] arr) {
        for (int i:arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ArrayList<Point> arr=new ArrayList<>();

        arr.add(new Point(2, 7));
        arr.add(new Point(1, 3));
        arr.add(new Point(1, 2));
        arr.add(new Point(2, 5));
        arr.add(new Point(3, 6));

        Ex07 t = new Ex07();
        Collections.sort(arr);
        for(Point o : arr) System.out.println(o.x+" "+o.y);
    }
}
