package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 合并k个有序队列
 */
public class Q23_MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {

        return revoke(resize(lists));
    }

    public ListNode[] resize(ListNode[] lists){
        List<ListNode> arr = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                arr.add(lists[i]);
            }
        }
        if(arr.size()==lists.length){
            return lists;
        }
        ListNode[] temp = new ListNode[arr.size()];
        for(int i=0;i<arr.size();i++){
            temp[i]=(arr.get(i));
        }
        return temp;
    }


    public ListNode revoke(ListNode[]  temp  ){
        if(temp.length==0){
            return null;
        }

        int k=0,min=Integer.MAX_VALUE;
        // temp里没有null的元素
        for (int i = 0; i < temp.length; i++) {
           if ( min > temp[i].val) {
                min = temp[i].val;
                k = i;
            }
        }

        // 找到了最小的那个listnode,从lists中替换它
        ListNode left = temp[k];
        if(temp[k].next==null){
            temp[k] = left.next;
            left.next = revoke(resize(temp));
        }else{
            temp[k] = left.next;
            left.next= revoke(temp);
        }
        return left;
    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2=  new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        Q23_MergeKLists q = new Q23_MergeKLists();

        q.mergeKLists(new ListNode[]{l1,l2,l3});


    }
}
