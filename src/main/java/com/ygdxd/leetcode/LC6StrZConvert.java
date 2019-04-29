package com.ygdxd.leetcode;

/**
 * @author Created by ygdxd_admin at 2019-04-12 2:31 PM
 */
public class LC6StrZConvert {

    public static String convert(String s, int numRows) {
        if(s == null || s.length() < 2 || numRows == 1 || numRows > s.length()){
            return s;
        }

        int len = s.length();

        int range = 2 * numRows - 2;
        int count = 0;
        String result = "";

        while (count < range / 2 + 1){
            for (int i = count; i < len; i+= range) {
                if (count == 0){
                    result += s.charAt(i);
                }else {
                    int st = i;
                    int ed = i + range - 2 * count;
                    result += s.charAt(st);
                    if(st<ed&&ed<len){
                        result+=s.charAt(ed);
                    }
                }
            }
            count ++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        System.out.println(convert(s, 3));
    }
}
