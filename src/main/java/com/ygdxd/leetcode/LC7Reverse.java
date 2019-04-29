package com.ygdxd.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by ygdxd_admin at 2019-04-12 4:53 PM
 */
public class LC7Reverse {

    public static int reverse(int x) {

        boolean b = x < 0;

        if (b){
            x = -x;
        }

        long r = 0;
        List<Integer> list = new ArrayList<>();

        while (x > 0){
            list.add(x % 10);
            x = x / 10;
        }

        for (int i = 0; i < list.size(); i++) {
            r += list.get(i);
            if (i < list.size() - 1){
                r = r * 10;
            }
            if (r > Integer.MAX_VALUE){
                return 0;
            }
        }

        return b ? (int)-r : (int) r;

    }

    public static void main(String[] args) {
        System.out.println(reverse(-12121222));
    }

}
