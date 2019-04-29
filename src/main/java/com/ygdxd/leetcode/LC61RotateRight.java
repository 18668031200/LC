package com.ygdxd.leetcode;

import com.ygdxd.list.ListNode;

/**
 * @author Created by ygdxd_admin at 2019-04-03 6:12 PM
 */
public class LC61RotateRight {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0){
            return head;
        }
        int l = 1;
        ListNode p = head;
        ListNode last = null;
        while (p.next != null){
            p = p.next;
            l++;
        }
        last = p;
        int m = k % l;
        if (m == 0){
            return head;
        }
        last.next = head;
        ListNode pre = p;
        while (l - m > 0){
            pre = pre.next;
            l--;
        }
        p = pre.next;
        pre.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        rotateRight(a, 6);
    }

}
