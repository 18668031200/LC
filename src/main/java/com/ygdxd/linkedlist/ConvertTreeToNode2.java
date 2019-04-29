package com.ygdxd.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Created by ygdxd_admin at 2019-02-16 8:53 PM
 */
public class ConvertTreeToNode2 {

    public Node2 convert(Node2 head){
        Queue<Node2> queue = new LinkedList<>();
        inOrder2Queue(head, queue);
        if (queue.isEmpty()){
            return head;
        }
        head = queue.poll();
        Node2 pre = head;
        pre.left = null;
        Node2 cur = null;
        while (!queue.isEmpty()){
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    public void inOrder2Queue(Node2 head, Queue<Node2> queue){
        if (head == null){
            return;
        }
        inOrder2Queue(head.left, queue);
        queue.offer(head);
        inOrder2Queue(head.right, queue);
    }
}
