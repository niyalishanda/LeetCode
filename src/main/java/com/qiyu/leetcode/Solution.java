package com.qiyu.leetcode;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public void exec() {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(-2);
        b.next = new ListNode(-1);
        b.next.next = new ListNode(-1);

        //mergeTwoLists(a, b);

        //mergeKLists();

        //[[1,4,5],[1,3,4],[2,6]]

        ListNode node = mergeKLists2(new ListNode[]{
                generate(new int[]{1, 4, 5}),
                generate(new int[]{1, 3, 4}),
                generate(new int[]{2, 6})
        });
        mergeKLists2(new ListNode[]{});
        mergeKLists2(new ListNode[]{null});
        System.out.println(node);
//        mergeKLists2(new ListNode[]{});
    }

    private ListNode generate(int[] source) {
        ListNode head = new ListNode();
        ListNode tail = head;
        for (int i = 0; i < source.length; i++) {
            ListNode node = new ListNode(source[i]);
            tail.next = node;
            tail = tail.next;
        }
        return head.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(listNode -> listNode.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode head = new ListNode();
        ListNode tail = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(one -> one.val));
        for(int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while(node != null) {
                queue.add(node);
                node = node.next;
            }
        }

        ListNode head = new ListNode();
        ListNode tail = head;
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;
        }
        return head.next;
    }
    
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }


    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}
