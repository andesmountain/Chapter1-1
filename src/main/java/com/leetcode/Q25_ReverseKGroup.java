package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 */
public class Q25_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> lists = new ArrayList<>();
        ListNode tail = head;
        boolean full = true;
        for(int i=0;i<k;i++){
            if(head==null){
                full =false;
                break;
            }
            lists.add(head);
            head=head.next;
        }
        // 此时head为下一组的ListNode
        if(full){
            ListNode revHead = new ListNode(-1);
            ListNode rev = revHead;
            for(int i=k-1;i>=0;i--){
                rev.next = lists.get(i);
                rev = rev.next;
            }
            rev.next = reverseKGroup(head,k);
            return revHead.next;
        }else{
           return tail;
        }
    }


    public static void main(String[] args) {
        Q25_ReverseKGroup q= new Q25_ReverseKGroup();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        q.reverseKGroup(l1,2);
    }
}
