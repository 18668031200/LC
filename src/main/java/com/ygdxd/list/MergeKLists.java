package com.ygdxd.list;

/**
 * @author Created by ygdxd_admin at 2019-01-30 9:47 PM
 */
public class MergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        if (lists == null || lists.length < 1){
            return head.next;
        }
        return null;
    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode node = root;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 == null)
            node.next = l2;
        if (l2 == null)
            node.next = l1;
        return root.next;
    }
}
