package com.ygdxd.tree;


/**
 * @author Created by ygdxd_admin at 2019-04-11 10:45 PM
 */
public class BstTopSize {

    public int bstTopSize1(TreeNode head){
        if (head == null){
            return 0;
        }
        int max = maxTopo(head, head);
        max = Math.max(bstTopSize1(head.left), max);
        max = Math.max(bstTopSize1(head.right), max);
        return max;

    }

    public static int maxTopo(TreeNode h, TreeNode n){
        if (h != null && n != null && isBSTNode(h, n, n.val)){
            return maxTopo(h, n.left) + maxTopo(h, n.right) + 1;
        }
        return 0;
    }

    public static boolean isBSTNode(TreeNode h, TreeNode n , int value){
        if (h == null){
            return false;
        }
        if (h == n){
            return true;
        }
        return isBSTNode(h.val > value ? h.left : h.right, n, value);
    }
}
