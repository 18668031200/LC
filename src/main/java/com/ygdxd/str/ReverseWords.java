package com.ygdxd.str;

import java.util.Stack;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * @author Created by ygdxd_admin at 2019-03-30 4:50 PM
 */
public class ReverseWords {

    public static String reverseWords(String s) {
        String[] strs = s.split(" ");
        Stack<String> stack = new Stack<>();
        String blank = " ";
        for (String a : strs){
            if (!a.equals("")){
                stack.push(blank + a.trim());
            }
        }
        StringBuilder builder = new StringBuilder(s.length());
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.substring(1).toString();
    }

    public static void main(String[] args) {
        String s = "    the sky  is  blue  ";
        System.out.println(s.trim());
        System.out.println(reverseWords(s));
    }
}
