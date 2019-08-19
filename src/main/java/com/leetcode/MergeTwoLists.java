package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 1—2-4  3-4-5
 * 合并成1-2-3-4-4-5
 * @author dell
 * @date 2019/8/16
 * 公司：北京活力天汇<br>
 **/
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rs = new ListNode(0);
        rs.next=l1;
        ListNode before = rs;
        ListNode after = l2;
        while( before.next!=null){
            int n = before.next.val;
            if(after!=null){
                int k = after.val;
                if(n<=k){
                    before=before.next;
                }else{
                    ListNode old = before.next;
                    before.next=new ListNode(k);
                    before.next.next=old;
                    before = before.next;
                    after = after.next;
                }
            }else{
                break;
            }
        }
        if(after!=null){
            before.next=after;
        }

        return rs.next;
    }


    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        if(l1.val<l2.val){
            l1.next =  mergeTwoLists2(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        mergeTwoLists2(l1,l2);



    }

}
