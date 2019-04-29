package com.ygdxd.tree;

import com.ygdxd.list.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by ygdxd_admin at 2019-04-11 10:10 PM
 */
public class GetMaxLength {
    
    public static int getMaxLength(TreeNode head, int sum){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        return preOrder(head, sum, 0, 1, 0, map);
    }
    
    public static int preOrder(TreeNode head, int sum, int preSum, int level, int maxLen, Map<Integer, Integer> map){
        if (head == null){
            return maxLen;
        }
        int curSum = preSum + head.val;
        if (!map.containsKey(curSum)){
            map.put(curSum, level);
        }
        if (map.containsKey(curSum - sum)){
            maxLen = Math.max(level - map.get(curSum - sum), maxLen);
        }
        
        maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, map);
        maxLen = preOrder(head.right, sum, curSum, level + 1, maxLen, map);
        if (level == map.get(curSum)){
            map.remove(curSum);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(7);
        
        a.left = b;
        b.left = d;
        d.left = e;

        a.right = c;

        System.out.println(getMaxLength(a, 14));
        
    }
}
