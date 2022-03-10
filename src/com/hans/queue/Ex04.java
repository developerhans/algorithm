package com.hans.queue;

/**
 * 문제 : Design Circular Queue
 * https://leetcode.com/problems/design-circular-queue/
 *
 * 설명
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
 *
 * Implementation the MyCircularQueue class:
 * MyCircularQueue(k) Initializes the object with the size of the queue to be k.
 * int Front() Gets the front item from the queue. If the queue is empty, return -1.
 * int Rear() Gets the last item from the queue. If the queue is empty, return -1.
 * boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
 * boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
 * boolean isEmpty() Checks whether the circular queue is empty or not.
 * boolean isFull() Checks whether the circular queue is full or not.
 * You must solve the problem without using the built-in queue data structure in your programming language.
 */

class MyCircularQueue {

    final int[] a;
    int front, rear = -1,  len = 0;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        a = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(!isFull()) {
            rear =(rear + 1)%a.length;
            a[rear] = value;
            len++;
            return true;
        }
        else
            return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()) {
            front = (front + 1)%a.length;
            len--;
            return true;
        }
        else
            return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty()?-1:a[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty()?-1:a[rear];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(len == 0)
            return true;
        else
            return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(len == a.length)
            return true;
        else
            return false;
    }
}

public class Ex04 {

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear();     // return 4
    }
}
