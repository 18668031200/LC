package com.ygdxd.tree;

import java.util.Stack;

/**
 * @author Created by ygdxd_admin at 2019-04-09 10:29 AM
 */
public class LC230KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        int i = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (++i == k) {
                    return cur.val;
                }
                cur = cur.right;
            }
        }
        return -1;
    }
}
