package com.ygdxd.tree;

/**
 * @author Created by ygdxd_admin at 2019-04-23 9:56 PM
 */
public class LC99RecoverTree {


    public void recoverTree(TreeNode root) {

        //前一节点
        TreeNode x = null;
        TreeNode a = null;
        TreeNode b = null;

        //左子树的最右节点
        TreeNode mostRight = null;

        while (root != null){
            mostRight = root.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != root){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){
                    mostRight.right = root;
                    root = root.left;
                    continue;
                }else if (mostRight.right == root){
                    mostRight.right = null;
                }
            }

            if (a == null && x != null && x.val > root.val){
                a = x;
            }
            if (a != null && x != null && x.val > root.val){
                b = root;
            }
            x = root;

            root = root.right;
        }
        if (a != b){
            swap(a , b);
        }

    }
    
    private void swap(TreeNode a, TreeNode b){
        if (a != null && b != null){
            int x = a.val ^ b.val;
            a.val = x ^ a.val;
            b.val = x ^ b.val;
        }

    }

    public static void main(String[] args) {
        int x = 0, y = 0;
        
        if (x == 0){
            x = 1;
            System.out.println("1");
        }else if (x == 1){
            System.out.println("");
        }
    }

}
