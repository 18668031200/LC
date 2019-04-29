package com.ygdxd.linkedlist;

/**
 * @author Created by ygdxd_admin at 2019-02-16 8:05 PM
 */
public class ReverseKNode {

    public static Node reverseKNode(Node head, int k){
        if (k < 2){
            return head;
        }

        Node cur = head;
        Node start = null;
        Node pre = null;
        Node next = null;
        int count = 0;

        while (cur != null){
            next = cur.next;
            if (count == k){
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign(pre, start, cur, next);
                pre = start;
                count = 0;
            }
            count ++;
            cur = next;
        }
        return head;
    }

    public static void resign(Node left, Node start, Node end, Node right){
        Node pre = start;
        Node cur = start.next;
        Node next = null;
        while (cur != right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null){
            left.next = end;
        }
        start.next = right;
    }
}
