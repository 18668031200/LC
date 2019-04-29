package com.ygdxd.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author Created by ygdxd_admin at 2019-04-02 1:16 PM
 */
public class LC49GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>(strs.length);
        Map<String, List<String>> resultMap = new HashMap<>(strs.length);
        for (String s : strs){
            int[] map = new int[26];
            for (char c : s.toCharArray()){
                map[c - 'a'] ++;
            }
            StringBuilder builder = new StringBuilder(s.length() * 2);
            for (int i = 0; i < map.length; i++) {
                if (map[i] != 0){
                    builder.append("|").append(i).append("|").append(map[i]);
                }
            }
            String s1 = builder.toString();

            if (resultMap.containsKey(s1)){
                resultMap.get(s1).add(s);
            }else {
                List<String> list = new ArrayList<>(strs.length);
                list.add(s);
                resultMap.put(s1, list);
            }
        }

        for (List<String> c : resultMap.values()){
            result.add(c);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(JSON.toJSONString(groupAnagrams(strings)));
    }
}
