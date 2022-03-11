package com.hans.linkedlist;


import com.hans.utils.Timer;

/**
 * 문제 : Remove Linked List Elements
 */

class Solution {

    // iterative solution
    /*public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null)
            if (curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
        return head;
    }*/

    // recursive solution
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public void print(ListNode node) {
        System.out.print(node.val + ", ");
        if(node.next != null) {
            print(node.next);
        }
    }
}

public class Ex01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        ListNode root = new ListNode(6);
        root.next = new ListNode(6);
        root.next.next = new ListNode(6);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next.next = new ListNode(6);

        Solution solution = new Solution();
        solution.print(root);
        System.out.println();
        root = solution.removeElements(root, 6);
        solution.print(root);
        timer.printTime();
    }
}
