package com.ygdxd.leetcode;

import com.alibaba.fastjson.JSON;
import com.ygdxd.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Created by ygdxd_admin at 2019-04-02 2:41 PM
 */
public class LC56IntervalMerge {

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size()==0) return res;
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        res.add(intervals.get(0));
        for(int i=1; i<intervals.size(); i++){
            Interval a = intervals.get(i);
            Interval b = res.get(res.size()-1);
            if(a.start <= b.end){
                b.end = (a.end > b.end)? a.end:b.end;
                res.set(res.size()-1, b);
            }
            else{
                res.add(a);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Interval a = new Interval(1,4);
        Interval b = new Interval(1,5);
        intervals.add(a);
        intervals.add(b);
        System.out.println(JSON.toJSONString(merge(intervals)));
    }
}
