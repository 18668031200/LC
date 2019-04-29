package com.ygdxd.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Created by ygdxd_admin at 2019-04-11 11:10 PM
 */
public class PrintByLevel {

    public void printByLevel(TreeNode head){
        if (head == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        TreeNode last = head;
        TreeNode nlast = null;
        queue.offer(head);
        System.out.println("level " + level ++);
        while (!queue.isEmpty()){
            head = queue.poll();
            System.out.print(" "+ head.val);
            if (head.left != null){
                queue.offer(head.left);
                nlast = head;
            }

        }
    }
}
