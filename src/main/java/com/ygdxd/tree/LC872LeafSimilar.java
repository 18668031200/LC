package com.ygdxd.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by ygdxd_admin at 2019-04-10 3:05 PM
 */
public class LC872LeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        dfs(list1, root1);
        dfs(list2, root2);

        return list1.equals(list2);
    }

    private void dfs(List<Integer> list, TreeNode node){
        if (node != null){
            if (node.left == null && node.left == null){
                list.add(node.val);
            }

            if (node.left != null) {
                dfs(list, node.left);
            }
            if (node.right != null){
                dfs(list, node.right);
            }
        }
    }
}
