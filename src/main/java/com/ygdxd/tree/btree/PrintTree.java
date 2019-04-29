package com.ygdxd.tree.btree;

import com.ygdxd.linkedlist.Node2;

import java.util.Stack;

/**
 * @author Created by ygdxd_admin at 2019-02-17 6:53 PM
 */
public class PrintTree {
    public static void preOrderUnRecur(Node2 root){
        if (root != null){
            Stack<Node2> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                root = stack.pop();
                System.out.println(root.val);
                if (root.right != null){
                    stack.push(root.right);
                }
                if (root.left != null){
                    stack.push(root.left);
                }
            }
        }
    }

    public static void midOrderUnRecur(Node2 root){
        if (root != null){
            Stack<Node2> stack = new Stack<>();
            while (!stack.isEmpty() || root != null){
                if (root != null){
                    stack.push(root);
                    root = root.left;
                }else {
                    root = stack.pop();
                    System.out.println(root.val);
                    stack.push(root.right);
                }
            }
        }
    }
}
