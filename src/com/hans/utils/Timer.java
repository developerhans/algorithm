package com.hans.utils;

public class Timer {
    long st = System.currentTimeMillis();
    public void printTime() {
        System.out.println();
        System.out.println("----------------------------------------------------------");
        System.out.println("run time = " + (System.currentTimeMillis() - st) + "ms");
        System.out.println("----------------------------------------------------------");
    }
}
