package com.ygdxd.leetcode;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例 1:
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 * @author Created by ygdxd_admin at 2019-03-31 2:45 PM
 */
public class LC164MaximumGap {

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }

        int min = nums[0], max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min){
                min = nums[i];
            }
            if (nums[i] > max){
                max = nums[i];
            }
        }
        if(min==max){
            return 0;
        }
        Bucket[] buckets=new Bucket[nums.length];
        int gap=(max-min)/(nums.length-1) + 1;

        for(int i=0;i<nums.length;i++){
            //遍历每个元素，计算该元素应该放置的桶的位置，将元素放入桶中，更新桶的最大值和最小值
            int index=getBucketIndex(min,nums[i],gap);
            putInBucket(buckets,nums[i],index);
        }
        int maxGap=buckets[0].max-buckets[0].min;
        int pre=buckets[0].max;
        for(int i=1;i<buckets.length;i++){
            //遍历所有桶，计算最大间距（桶间间距）
            if(buckets[i]!=null){
                if((buckets[i].min-pre)>maxGap){
                    maxGap=buckets[i].min-pre;
                }
                pre=buckets[i].max;
            }
        }
        return maxGap;

    }

    public static void main(String[] args) {
        int[] ints = new int[]{3,6,9,1};
        LC164MaximumGap gap = new LC164MaximumGap();
        System.out.println(gap.maximumGap(ints));
    }

    //内部类 桶
    class Bucket{
        int max=0;
        int min=0;
        boolean hasNum=false;
    }
    //根据元素的数值计算该元素应该在哪个桶中
    public int getBucketIndex(int min,int num,int gap){
        return (num-min)/gap;
    }
    //将元素放入桶种，更新桶的最大值和最小值
    public void putInBucket(Bucket[] buckets,int num,int index){
        if(buckets[index]==null){
            buckets[index]=new Bucket();
            buckets[index].hasNum=true;
            buckets[index].max=num;
            buckets[index].min=num;
        }
        if(num>buckets[index].max)
            buckets[index].max=num;
        if(num<buckets[index].min)
            buckets[index].min=num;
    }
}
