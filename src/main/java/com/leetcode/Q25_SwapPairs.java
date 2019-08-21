package com.leetcode;

public class Q25_SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode sec = head.next;
        if(sec==null){
            return head;
        }
        ListNode third = sec.next;
        head.next = swapPairs(third);
        sec.next = head;
        return sec;
    }

    public static void main(String[] args) {
        Q25_SwapPairs q = new Q25_SwapPairs();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(6);

        q.swapPairs(l1);

    }

}
