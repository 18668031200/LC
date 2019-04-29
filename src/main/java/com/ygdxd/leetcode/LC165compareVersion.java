package com.ygdxd.leetcode;

/**
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 *
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 *
 *  . 字符不代表小数点，而是用于分隔数字序列。
 *
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 *
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 *
 * @author Created by ygdxd_admin at 2019-03-31 3:17 PM
 */
public class LC165compareVersion {

    public static int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");

        int l1 = strs1.length, l2 = strs2.length;
        int i = 0;
        while (l1 > 0 && l2 > 0){
            int a = Integer.valueOf(strs1[i]);
            int b = Integer.valueOf(strs2[i]);
            if (a > b){
                return 1;
            }else if (a < b){
                return -1;
            }else {
                i ++;
                l1 --;
                l2 --;
            }
        }
        while (l1 > 0){
            if (Integer.valueOf(strs1[i]) > 0){
                return 1;
            }
            i ++;
            l1 --;
        }
        while (l2 > 0){
            if (Integer.valueOf(strs2[i]) > 0){
                return -1;
            }
            i ++;
            l2 --;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.0.1", "1"));
    }

}
