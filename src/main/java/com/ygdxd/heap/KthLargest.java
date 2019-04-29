package com.ygdxd.heap;

import java.util.PriorityQueue;

/**
 * @author Created by ygdxd_admin at 2019-03-10 9:10 PM
 */
public class KthLargest {

    final PriorityQueue<Integer> queue;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int i : nums){
            add(i);
        }
    }

    public int add(int val) {
        if (queue.size() < val){
            queue.offer(val);
        }else if (queue.peek() < val){
            queue.poll();
            queue.offer(val);
        }

        return queue.peek();
    }
}
