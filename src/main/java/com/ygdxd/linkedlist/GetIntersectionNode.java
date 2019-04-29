package com.ygdxd.linkedlist;

import com.ygdxd.list.ListNode;

/**
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 *
 *
 * 示例 1：
 * @author Created by ygdxd_admin at 2019-03-30 10:01 PM
 */
public class GetIntersectionNode {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        int l1 = 0, l2 = 0;
        ListNode a = headA, b = headB;

        while (headA != null){
            l1 ++;
            headA = headA.next;
        }

        while (headB != null){
            l2 ++;
            headB = headB.next;
        }

        int i = l1 - l2;
        if (l1 > l2){
            while (i > 0){
                a = a.next;
                i--;
            }
        }else {
            while (i < 0){
                b = b.next;
                i++;
            }
        }

        while (a != null && b != null && a.val != b.val){
            a = a.next;
            b = b.next;
        }
        return a;
    }


    public static void main(String[] args) {

    }
}
