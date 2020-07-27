package com.leetcode;

/**
 * @author zhuyinkui
 * @version 1.0.0
 * @Description TODO
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * 3 4  1 2
 * 1 2 3 4
 * @createTime 2020年05月22日 16:44:00
 */
public class Q86_partition {
    /**
     * 找到第一个大于等于x的节点m，然后找到后续所有比x小的节点n2，
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode b = new ListNode(0);
        b.next = head;
        ListNode rs = b;
        ListNode m = null;
        ListNode beforeM = null;
        ListNode last = b;
        ListNode curNode = last.next;
        while(curNode!=null){
            if(curNode.val>=x){
                if(m==null){
                    beforeM = last;
                    m = curNode;
                }
            }else{ // curNode.val<x
                if(m!=null){
                    last.next = curNode.next;
                    curNode.next = m;
                    beforeM.next = curNode;
                    beforeM = curNode;
                }
            }
            last = curNode;
            curNode = curNode.next;
        }
        return rs.next;
    }


    /**
     * 拆成两个链表，before都是比x小的，after都是大于等于x的，然后再拼接
     * @param head
     * @param x
     * @return
     */
    public ListNode partition2(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode b=  before;
        ListNode a = after;

        ListNode curNode = head;
        while(curNode!=null){
            if(curNode.val<x){
                b.next= curNode;
                b= b.next;
            }else{
                a.next = curNode;
                a=a.next;
            }
            curNode =  curNode.next;
        }
        a.next= null;
        b.next = after.next;
        return before.next;
    }

    public static void main(String[] args) {
        Q86_partition q = new Q86_partition();
        // 1->4->3->2->5->2
        ListNode l = new ListNode(3);
        l.next= new ListNode(1);
        l.next.next= new ListNode(2);
        q.partition2(l,3);
    }
}


