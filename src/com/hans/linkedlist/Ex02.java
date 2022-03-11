package com.hans.linkedlist;


import com.hans.utils.Timer;

class Solution1 {

    // Iterative java solution
    /*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1); // sentinel
        ListNode ptr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }

        while (l1 != null) {
            ptr.next = l1;
            ptr = ptr.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            ptr.next = l2;
            ptr = ptr.next;
            l2 = l2.next;
        }

        return dummy.next;
    }*/

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) l1.next = mergeTwoLists(l1.next, l2);
        else {
            ListNode n = l1;
            l1 = l2;
            l1.next = mergeTwoLists(l1.next, n);
        }
        return l1;
    }

    public void print(ListNode node) {
        System.out.print(node.val + ", ");
        if(node.next != null) {
            print(node.next);
        }
    }
}

public class Ex02 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(2);
        root1.next.next = new ListNode(4);

        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(3);
        root2.next.next = new ListNode(4);



        Solution1 solution = new Solution1();
        solution.print(root1);
        System.out.println();

        solution.print(root2);
        System.out.println();
        ListNode result = solution.mergeTwoLists(root1, root2);
        solution.print(result);
        System.out.println();

        timer.printTime();
    }
}
