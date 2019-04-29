package com.ygdxd.str;

/**
 * @author Created by ygdxd_admin at 2019-03-12 12:03 AM
 */
public class Anagram {

    public static boolean isAnagram(String s, String t) {
        if (s != null && t != null){
            if (s.length() == t.length()){
                int[] ints = new int[26];
                char[] chars = s.toCharArray();
                for (char c : chars){
                    ints[c - 'a'] += 1;
                }
                for (char c : t.toCharArray()){
                    ints[c - 'a'] -= 1;
                    if (ints[c - 'a'] < 0){
                        return false;
                    }
                }
                return true;
            }
        }
        return s == null && t == null;
    }
}
