package com.ygdxd.DP;

/**
 * @author Created by ygdxd_admin at 2019-04-04 7:54 PM
 */
public class LC97IsInterleave {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if ((s1 == null && s2 == null && s3 != null) || (s3 == null && (s1 != null || s2 != null))){
            return false;
        }
        
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        
        int a = 0, b = 0, c = 0;
        while (c < s3.length() && a < s1.length() && b < s2.length()){
            if (chars1[a] == chars3[c]){
                a ++;
                c ++;
            }else if (chars2[b] == chars3[c]){
                b ++;
                c ++;
            }else {
                return false;
            }
        }
        
        return c == s3.length() - 1;
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
