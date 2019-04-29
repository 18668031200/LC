package com.ygdxd.leetcode;

import com.alibaba.fastjson.JSON;
import com.ygdxd.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by ygdxd_admin at 2019-04-03 4:07 PM
 */
public class LC57InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>(intervals.size() + 1);
        if (intervals.size()==0) {
            res.add(newInterval);
            return res;
        }

        int start = newInterval.start;
        int end = newInterval.end;
        int x = 0;
        for (int i = 0; i < intervals.size(); i++) {
            if (newInterval.start > intervals.get(i).end){
                res.add(intervals.get(i));
            }else {
                start = newInterval.start > intervals.get(i).start ? intervals.get(i).start : newInterval.start;
                break;
            }
            x ++;
        }

        for (int i = x; i < intervals.size(); i++) {
            if (newInterval.end <= intervals.get(i).end && newInterval.end >= intervals.get(i).start){
                end = intervals.get(i).end;
                x ++;
                break;
            }
            if (newInterval.end < intervals.get(i).start){
                end = newInterval.end;
                break;
            }
            x ++;
        }

        res.add(new Interval(start, end));

        for (int i = x; i < intervals.size(); i++) {
            res.add(intervals.get(i));
        }

        return res;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Interval i1 = new Interval(1,2);
        Interval i2 = new Interval(3,5);
        Interval i3 = new Interval(6,7);
        Interval i4 = new Interval(8,10);
        Interval i5 = new Interval(12,16);
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);


        Interval i = new Interval(4,8);

        System.out.println(JSON.toJSONString(insert(intervals, i)));
    }
}
