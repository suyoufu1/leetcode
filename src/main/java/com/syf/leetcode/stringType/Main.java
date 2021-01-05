package com.syf.leetcode.stringType;

/**
 * @auth syf
 * @date 2020/10/10 19:16
 */
public class Main {
    /**
     * 写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     *
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     *
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * @return
     */
    public static int matrixIndex(int[][] matrix, int target){
        // 边界判断
        if(matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        int rowStart = 0 ;
        int rowEnd = matrix.length - 1 ;
        int colStart = 0 ;
        int colEnd = matrix[0].length - 1 ;
        // 遍历
        while (rowStart<rowEnd && colStart < colEnd){
            if(target == matrix[rowEnd][colStart]){
                return matrix[rowStart][colStart] ;
            }else if(target > matrix[rowEnd][colStart]){
                colStart ++;
            }else {
                rowEnd -- ;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
