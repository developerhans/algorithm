package com.hans.utils;

public class Timer {
    private long st;

    public Timer() {
        this.st = System.currentTimeMillis();
    }

    public void printTime() {
        System.out.println();
        System.out.println("----------------------------------------------------------");
        System.out.println("run time = " + (System.currentTimeMillis() - st) + "ms");
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(usedMemory + " bytes");
        System.out.println("----------------------------------------------------------");
    }
}
