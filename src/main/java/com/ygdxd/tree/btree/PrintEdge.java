package com.ygdxd.tree.btree;

import com.ygdxd.linkedlist.Node2;

/**
 * @author Created by ygdxd_admin at 2019-02-17 7:27 PM
 */
public class PrintEdge {

    public static void printEdge1(Node2 root){
        if (root == null){
            return;
        }
        Node2[][] edgeMap = new Node2[getHeight(root, 0)][2];
        setEdgeMap(root, 0, edgeMap);

    }

    public static int getHeight(Node2 root, int l){
        if (root == null){
            return l;
        }
        return Math.max(getHeight(root.left, l + 1), getHeight(root.right, l + 1));
    }

    public static void setEdgeMap(Node2 root, int l,Node2[][] edgeMap){
        if (root == null){
            return;
        }
        edgeMap[l][0] = edgeMap[l][0] == null ? root : edgeMap[l][0];
        edgeMap[l][1] = root;
        setEdgeMap(root.left, l + 1, edgeMap);
        setEdgeMap(root.right, l + 1, edgeMap);
    }
}
