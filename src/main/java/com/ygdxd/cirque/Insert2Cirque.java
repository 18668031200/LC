package com.ygdxd.cirque;

import com.ygdxd.linkedlist.Node;

/**
 * @author Created by ygdxd_admin at 2019-02-17 6:35 PM
 */
public class Insert2Cirque {

    public static Node insertNum(Node head, int num){
        Node node = new Node(num);
        if (head == null){
            node.next = node;
            return node;
        }

        Node pre = head;
        Node cur = head.next;

        while (cur != head){
            if (pre.val < node.val && cur.val >= num){
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.val > num ? head : node;
    }
}
