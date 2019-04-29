package com.ygdxd.tree;

/**
 * @author Created by ygdxd_admin at 2019-04-23 10:45 PM
 */
public class LC100IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
