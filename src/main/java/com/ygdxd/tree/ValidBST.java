package com.ygdxd.tree;

/**
 * @author Created by ygdxd_admin at 2019-03-13 1:27 PM
 */
public class ValidBST {

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public static boolean validate(TreeNode root, Integer min, Integer max){
        if (root == null){
            return true;
        }
        if (min != null && root.val < min) return false;
        if (max != null && root.val > max) return false;
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}
