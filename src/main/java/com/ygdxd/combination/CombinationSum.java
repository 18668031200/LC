package com.ygdxd.combination;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author Created by ygdxd_admin at 2019-02-12 8:03 PM
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAll=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        //排序
        Arrays.sort(candidates);
        find(listAll,list,candidates,target,0);
        return listAll;
    }


    public static void find(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates, int target,int num){
        //递归的终点
        if(target==0){
            listAll.add(new ArrayList<>(tmp));
            return;
        }
        if (target < 0){
            return;
        }
        if(target<candidates[0]) return;
        for(int i=num;i<candidates.length&&candidates[i]<=target;i++){
            if (i > num && candidates[i] == candidates[i-1]){
                continue;
            }
            tmp.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            find(listAll,tmp,candidates,target-candidates[i],i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(JSON.toJSONString(result));
    }


}
