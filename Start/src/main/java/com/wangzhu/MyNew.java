package com.wangzhu;

/**
 * Created by wangzhu on 2024/12/17 17:20.
 **/
public class MyNew {

    static class ListNode{
        int val;
        ListNode next;
    }

    static ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        ListNode newHead = null;
        ListNode node = head;
        while(node != null){
            ListNode next = node.next;

            node.next = newHead;
            newHead = node;

            node = next;
        }
        return newHead;
    }
}
