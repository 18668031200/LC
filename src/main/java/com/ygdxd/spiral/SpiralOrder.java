package com.ygdxd.spiral;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Created by ygdxd_admin at 2018-09-14 下午7:47
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null){
            return result;
        }

        int start = 0;

        while (matrix[0].length > 2 * start && matrix.length > 2 * start){
            addNumber(matrix, matrix[0].length, matrix.length, start, result);
        }
        return result;
    }

    private void addNumber(int[][] matrix, int column, int height, int start, List<Integer> list) {
        int endX = column - 1 - start;
        int endY = height - 1 - start;

        for (int i = start; i < endX; i++){
            list.add(matrix[start][i]);
        }

        for (int i = start; i < endY; i++){
            list.add(matrix[endX][i]);
        }

        for (int i = endX; i > start; i--){
            list.add(matrix[endX][i]);
        }


    }


}
