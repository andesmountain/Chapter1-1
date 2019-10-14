package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 *
 * @author dell
 * @date 2019/9/18
 * 公司：北京活力天汇<br>
 **/
public class Q61_rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        int right=0;
        if(head==null) return null;
        if(k==0) return head;



        ListNode origin = new ListNode(-1);
        ListNode originNode = origin;
        ListNode rightNode = head;
        ListNode leftNode = head;

        boolean find = false;
        while(rightNode.next!=null){
            right++;
            rightNode = rightNode.next;
            if(right>=k){
                originNode.next = new ListNode(leftNode.val);
                originNode = originNode.next;
                leftNode = leftNode.next;
                find = true;
            }
        }

        int count = right+1;
        // k>count
        if(!find){
            int remain = k % count;
            return rotateRight(head,remain);
        }


        // leftNode 即为倒数第k个node
        rightNode.next = origin.next;
        return leftNode;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next =  new ListNode(2);
        head.next.next =  new ListNode(3);
        head.next.next.next =  new ListNode(4);
        head.next.next.next.next =  new ListNode(5);
        Q61_rotateRight q = new Q61_rotateRight();

        q.rotateRight(head,6);

    }

}
