package com.ygdxd.linkedlist;

import java.math.BigInteger;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Created by ygdxd_admin at 2019-02-16 9:14 PM
 */
public class SelectionSort {

    public static Node SelectionSort(Node head){
        Node tail = null;
        Node cur = head;
        Node smallPre = null;
        Node small = null;
        while (cur != null){
            small = cur;
            smallPre = getSmallestPreNode(cur);
            if (smallPre != null){
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail == null){
                head = small;
            }else {
                tail.next = small;
            }
        }
        return head;
    }

    public static Node getSmallestPreNode(Node head){
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;

        while (cur != null){
            if (cur.val < small.val){
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
}
