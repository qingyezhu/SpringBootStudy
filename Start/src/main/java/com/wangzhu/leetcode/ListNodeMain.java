package com.wangzhu.leetcode;

/**
 * Created by wangzhu on 2024/10/18 12:16.
 **/
public class ListNodeMain {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 反转链表
    public ListNode reverse(ListNode head) {
        ListNode newHead = null;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;

            node.next = newHead;
            newHead = node;

            node = next;
        }
        return newHead;
    }

    // 查找中间节点
    public ListNode findMidNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 查找中间节点的前驱节点
    public ListNode findPrevForMidNode(ListNode head) {
        // 中间节点肯定存在
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 查找倒数第k个节点
    public ListNode findKToLastNode(ListNode head, int k) {
        // k保证有效
        ListNode firstNode = head;
        while (k-- > 0) {
            firstNode = firstNode.next;
        }
        ListNode secondNode = head;
        while (firstNode != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return secondNode;
    }

    // 删除倒数第k个节点
    public ListNode removeKToLastNode(ListNode head, int k) {
        // k保证有效
        ListNode firstNode = head;
        while (k-- > 0) {
            firstNode = firstNode.next;
        }
        ListNode newHead = new ListNode(0, head);
        ListNode secondNode = newHead;
        while (firstNode != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        ListNode node = secondNode.next;
        secondNode.next = node.next;
        node.next = null;

        return newHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2,5,2};
        ListNode head = new ListNode();
        ListNode tail = head;
        for(int num : nums){
            tail.next = new ListNode(num);
            tail = tail.next;
        }
        print(head);
        ListNode newHead = partition(head.next, 3);
        print(newHead);
    }

    static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + "-->");
            head = head.next;
        }
        System.out.println();
    }


    static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0, head);
        ListNode node = head.next, last = head;
        while (node != null) {
            ListNode next = node.next;
            if (last.val >= x && node.val < x) {
                ListNode prev = newHead;
                ListNode curr = head;
                while (curr.val <= node.val) {
                    prev = curr;
                    curr = curr.next;
                }
                ListNode newNext = prev.next;
                prev.next = node;
                node.next = newNext;

                last.next = next;
            } else {
                last = node;
            }
            node = next;
        }
        return newHead.next;
    }


}
