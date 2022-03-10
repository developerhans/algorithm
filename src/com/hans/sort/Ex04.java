package com.hans.sort;

/**
 * 문제 : marge sort
 * <p>
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * <p>
 * Example 1:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * <p>
 * Example 2:
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Ex04 {

    public ListNode merge(ListNode left, ListNode right) {
        ListNode result = new ListNode(0);
        ListNode fin = result;
        //while both are available
        while (left != null && right != null) {
            if (left.val > right.val) {
                result.next = right;
                right = right.next;
            } else {
                result.next = left;
                left = left.next;
            }
            result = result.next;
        }
        while (left != null) {
            result.next = left;
            left = left.next;
            result = result.next;
        }
        while (right != null) {
            result.next = right;
            right = right.next;
            result = result.next;
        }
        return fin.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        mid.next = null;
        ListNode left_side = sortList(head);
        ListNode right_side = sortList(slow);
        return merge(left_side, right_side);
    }

    public static void main(String[] args) {

        int[] ex1 = {-1,5,3,4,0};

        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(0);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Ex04 t = new Ex04();
        ListNode result = t.sortList(n1);
        System.out.println(result);
    }
}
