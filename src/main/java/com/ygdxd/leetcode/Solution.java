package com.ygdxd.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by ygdxd_admin at 2019-04-12 1:16 PM
 */
public class Solution {

    public static int mySolution(int n, int[] nums){
        if(n < 0 || nums == null || nums.length < 1){
            return -1;
        }

        Arrays.sort(nums);

        int sum = 0;
        for(int i : nums){
            if(n > i){
                sum += i;
            }
            n = n - i;
        }
        return sum;

    }


    public static int[] mySolution(int m , int d, String msg){
        if(m > 0 && m <= 12 && msg != null){
            msg = msg.toUpperCase().replaceAll(" ", "*");
            String[] strs = new String[]{"ABCDEFGHI", "JKLMNOPQR","STUVWXYZ*"};

            Map<Integer, String> map = new HashMap<>(4);
            String s0 = strs[(m - 1) % 3].substring((d - 1) % 9) + strs[(m-1) % 3].substring(0, (d - 1) % 9);
            String s1 = strs[(m) % 3].substring((d - 1) % 9) + strs[(m) % 3].substring(0, (d - 1) % 9);
            String s2 = strs[(m + 1) % 3].substring((d - 1) % 9) + strs[(m + 1) % 3].substring(0, (d - 1) % 9);


            map.put(0, s0);
            map.put(1, s1);
            map.put(2, s2);
            
            int[] res = new int[msg.length()];
            for (int i = 0; i < msg.length(); i++) {
                char c = msg.charAt(i);

                int x = -1, y = -1;
                for (int j = 0; j < strs.length; j++) {
                    int index = map.get(j).indexOf(c);
                    if (index != -1){
                        x = j;
                        y = index;
                    }
                }

                int r= (x + 1) * 10 + y + 1;

                res[i] = r;
            }
            return res;
        }

        return new int[0];




    }



    public static void main(String[] args) {
        String s = "@@@";
        System.out.println(JSON.toJSONString(mySolution(1,1,s)));
    }
}
