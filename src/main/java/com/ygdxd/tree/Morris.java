package com.ygdxd.tree;


/**
 * @author Created by ygdxd_admin at 2019-04-11 9:48 PM
 */
public class Morris {

    public void morrisPre(TreeNode head){
        if (head == null){
            return;
        }

        TreeNode cur = head;
        TreeNode mostRight = null;

        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if (mostRight == null){
                    mostRight.right = cur;
                    System.out.println(cur.val + "|");
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.val + "|");
            }
            cur = cur.right;
        }
    }


}
