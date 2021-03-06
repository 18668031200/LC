package com.ygdxd.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @author Created by ygdxd_admin at 2019-03-15 6:54 PM
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {

        if (root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
           int size = queue.size();
           for (int i = 0; i < size ; i ++){
               TreeNode node = queue.poll();
               if (node.left != null){
                   queue.add(node.left);
               }
               if (node.right != null){
                   queue.add(node.right);
               }
           }
           level ++;
        }
        return level;
    }
}
