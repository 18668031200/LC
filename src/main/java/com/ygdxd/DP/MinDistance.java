package com.ygdxd.DP;

/**
 * @author Created by ygdxd_admin at 2019-03-23 3:25 PM
 */
public class MinDistance {

    public static int minDistance(String word1, String word2) {
        if ((word1 == null && word2 == null) && word1.equals(word2)){
            return 0;
        }

        if (word1 == null || word1.equals("")){
            return word2.length();
        }

        if (word2 == null || word2.equals("")){
            return word1.length();
        }

        int[][] d = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word1.length(); i++) {
            d[i][0] = i;
        }

        for (int i = 0; i < word2.length(); i++) {
            d[0][i] = i;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    d[i][j] = d[i - 1][j - 1];
                }else {
                    d[i][j] = Math.min(Math.min(d[i - 1][j] + 1,d[i][j - 1] + 1), d[i - 1][j - 1] + 1);
                }
            }
        }

        return d[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String a = "distance";
        String b = "springbok";
        System.out.println(minDistance(a, b));

    }
}
