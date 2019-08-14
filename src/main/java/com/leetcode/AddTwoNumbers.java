package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/8/9
 * 公司：北京活力天汇<br>
 **/
public class AddTwoNumbers {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 是否补位
        int addOne =0,sum=0;
        ListNode rs  = new ListNode(0);
        ListNode thisNode = rs;

        while (true){
            if(l1==null){
                sum = l2.val+addOne;
            }else if(l2==null){
                sum = l1.val+addOne;
            }else{
                sum = l1.val+l2.val+addOne;
            }

            if(sum>=10){
                addOne=1;
                thisNode.val = sum-10;
            }else{
                addOne= 0;
                thisNode.val = sum;
            }

            sum=0;
            if(l1!=null)    l1 = l1.next;
            if(l2!=null)    l2 = l2.next;

            if(l1==null && l2==null){
                if(addOne==0)
                break;
                if(addOne==1){
                    thisNode.next = new ListNode(1);
                    break;
                }
            }

            ListNode nextNode = new ListNode(0);
            thisNode.next  = nextNode;
            thisNode = nextNode;

        }
        return rs;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}