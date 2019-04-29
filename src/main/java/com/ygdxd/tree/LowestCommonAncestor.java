package com.ygdxd.tree;

/**
 * @author Created by ygdxd_admin at 2019-03-13 9:10 PM
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if (root.val < q.val && root.val < p.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    /**
     *  不是二叉搜索🌲
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode l = lowestCommonAncestor2(root.left, p, q);
        TreeNode r = lowestCommonAncestor2(root.right, p, q);
        if (l == null){
            return r;
        }else if (r == null){
            return l;
        }else {
            return root;
        }
    }
}
