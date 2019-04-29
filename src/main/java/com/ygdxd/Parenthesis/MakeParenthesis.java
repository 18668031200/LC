package com.ygdxd.Parenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by ygdxd_admin at 2019-01-28 10:12 PM
 */
public class MakeParenthesis {

    private static final String LEFT = "(";
    private static final String RIGHT = ")";


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>(2 * n);
        build(result, 0, 0, "", n);
        return result;
    }

    public void build(List<String> result, int left, int right , String s, int n){
        if (left > n || right > n || right > left){
            return;
        }
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        build(result, left + 1, right, s + LEFT, n);
        build(result, left, right + 1, s + RIGHT, n);
    }
}
