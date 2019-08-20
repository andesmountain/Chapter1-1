package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/8/15
 * 公司：北京活力天汇<br>
 **/
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return  null;
        }
        int size =1;
        ListNode before = head;
        while(before.next!=null){
            size++;
            before = before.next;
        }
        if(size<n){
            return null;
        }
        if(size==n){
            return head.next;
        }

        int k=0;
        before = head;
        while(k<size-n-1){
            k++;
            before = before.next;
        }
        before.next = before.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        removeNthFromEnd(head,5);

    }

}
