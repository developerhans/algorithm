package com.hans.linkedlist;


import com.hans.utils.Timer;

class Solution2 {

    // Iterative java solution
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public void print(ListNode node) {
        System.out.print(node.val + ", ");
        if(node.next != null) {
            print(node.next);
        }
    }
}

public class Ex03 {
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
