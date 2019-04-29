package com.ygdxd.leetcode;

/**
 * @author Created by ygdxd_admin at 2019-04-03 5:23 PM
 */
public class LC60GetPermutation {

    public String getPermutation(int n, int k) {
        int[] fac={1, 1, 2, 6, 24, 120, 720, 5040, 40320};
        StringBuilder sb=new StringBuilder();
        boolean[] mark=new boolean[10];
        k--;
        for(int i=n-1;i>=0;i--){
            int t=k/fac[i];
            for(int j=1;j<=n;j++){
                if(mark[j]){ continue;}
                if(t==0){
                    sb.append(j);
                    mark[j]=true;
                    break;
                }
                t--;
            }
            k=k%fac[i];
        }
        return sb.toString();
    }
}
