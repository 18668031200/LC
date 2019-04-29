package com.ygdxd.leetcode;

/**
 * @author Created by ygdxd_admin at 2019-04-10 1:37 PM
 */
public class LC678CheckValidString {

    public boolean checkValidString(String s) {
        if (s == null || s.isBlank()){
            return true;
        }

        int star = 0, starLeft = 0, left = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                left ++;
            }else if (c == '*'){
                if (left > 0){
                    left --;
                    starLeft ++;
                }else {
                    star ++;
                }
            }else if (c == ')'){
                if (left > 0){
                    left --;
                }else if (starLeft > 0){
                    starLeft --;
                    star ++;
                }else if (star > 0){
                    star --;
                }else {
                    return false;
                }
            }
        }
        return left < 1;
    }
}
