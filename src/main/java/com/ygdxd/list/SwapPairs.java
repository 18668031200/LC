package com.ygdxd.list;

import java.util.List;

/**
 * @author Created by ygdxd_admin at 2019-02-08 11:59 AM
 */
public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {

        if (head == null){
            return null;
        }

        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode pre = preHead;
        while (l1 != null && l2 != null){
            l1.next = l2.next;
            l2.next = l1;
            pre.next = l2;

            pre = l1;
            l1 = l1.next;
            if (l1 != null){
                l2 = l1.next;
            }
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        swapPairs(l1);
        System.out.println(l1.val);
    }
}
