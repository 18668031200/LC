package com.ygdxd.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * @author Created by ygdxd_admin at 2019-04-26 6:29 PM
 */
public class LC207CanFinish {

    public static int[] canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0){

        }

        Stack<Integer> stack = new Stack<>();
        //存放各课程的入度
        int[] count = new int[numCourses];
        int len = prerequisites.length;

        int c = 0;
        for (int i = 0; i < len; i++) {
            count[prerequisites[i][1]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (count[i] == 0){
                stack.push(i);
            }
        }
        int[] result = new int[numCourses];
        int x = numCourses - 1;
        while (!stack.isEmpty()){
            c = stack.pop();
            result[x] = c;
            x --;
            for (int i = 0; i < len; i++) {
                if (prerequisites[i][0] == c){
                    count[prerequisites[i][1]] --;
                    if (count[prerequisites[i][1]] == 0){
                        stack.push(prerequisites[i][1]);
                    }
                }
            }
        }
        if (x == -1){
            return result;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                new int[]{1,0}
//                new int[]{2,0},
//                new int[]{3,1},
//                new int[]{3,2},
        };

        System.out.println(JSON.toJSONString(canFinish(2, ints)));
    }

}
