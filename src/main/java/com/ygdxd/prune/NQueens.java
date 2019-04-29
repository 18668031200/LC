package com.ygdxd.prune;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by ygdxd_admin at 2019-03-15 7:51 PM
 */
public class NQueens {

//    public int totalNQueens(int n) {
//        List<String[]> res = new ArrayList<>();
//        putQueen(0, );
//    }
//
//    private void putQueen(int r, boolean[] cos, boolean[] dia1, boolean[] dia2, String[] board, List<String[]> res){
//        if (r == board.length){
//            res.add(board);
//        }else {
//            for (int i = 0; i < board.length; i ++){
//                int id = r - i + board.length, id2 = 2 * board.length - r - c - 1;
//
//            }
//        }
//    }

    public static int totalNQueens(int n) {
        Integer count = 0;
        if (n < 1) return count;
        DFS(count, n, 0, 0, 0, 0);
        return count;

    }

    public static void DFS(Integer count, int n, int row, int col, int pie, int na){
        if (row > n){
            count ++;
            return;
        }

        int bits = (~(col | pie | na)) & ((1 << n) - 1);
        while (bits > 0){
            //获得最低位1
            int p = bits & -bits;
            DFS(count, n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            //去掉最低位1
            bits = bits & (bits - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }


}
