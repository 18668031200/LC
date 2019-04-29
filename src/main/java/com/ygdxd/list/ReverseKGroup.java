package com.ygdxd.list;

import java.util.List;

/**
 * @author Created by ygdxd_admin at 2019-02-08 12:20 PM
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return null;
        }
        int count = 0;
        ListNode current = head;
        while (count < k && current != null){
            count ++;
            current = current.next;
        }
        if (count == k){
            ListNode l1 = head;
            ListNode l2 = null;
            ListNode pre = null;

            count = 0;
            while (count < k){
                count ++;
                l2 = l1.next;
                l1.next = pre;
                pre = l1;
                l1 = l2;
            }
            if (l2 != null){
                head.next = reverseKGroup(head, k);
            }
            return pre;
        }else {
            return head;
        }
    }
}
