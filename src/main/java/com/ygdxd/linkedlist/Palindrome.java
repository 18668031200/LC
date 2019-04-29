package com.ygdxd.linkedlist;

/**
 * @author Created by ygdxd_admin at 2019-02-15 9:32 PM
 */
public class Palindrome {
    
    public static boolean isPalindrome(Node head){
        boolean result = true;
        if (head == null || head.next == null){
            return result;
        }
        
        Node n1 = head;
        Node n2 = head;
        
        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        //中间右边节点 即要翻转的头结点
        n2 = n1.next;
        n1.next = null;
        
        Node n3 = null;
        while (n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        
        n3 = n1; // last
        n2 = head;// first
        
        while (n1 != null && n2 != null){
            if (n1.val != n2.val){
                result = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        
        n1 = n3.next;
        n3.next = null;
        while (n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return result;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        n1.next = n2;
        Node n3 = new Node(4);
        n2.next = n3;
        Node n4 = new Node(4);
        n3.next = n4;
        Node n5 = new Node(3);
        n4.next = n5;
        Node n6 = new Node(1);
        n5.next = n6;
        System.out.println(isPalindrome(n1));
    }
}
