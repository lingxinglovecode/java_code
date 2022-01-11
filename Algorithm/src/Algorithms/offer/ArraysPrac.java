package Algorithms.offer;

import org.junit.Test;

public class ArraysPrac {
    public static SolutionArrays solution=new SolutionArrays();

    @Test
    public void testFindNum(){
        int[][] temp={{1,2},{3,4}};
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15},{2, 5, 8, 12, 19},{3, 6, 9, 16, 22},{10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}};
        solution.findNumberIn2DArray2(matrix,5);

    }

}


class SolutionArrays{

    //------------------剑指 Offer 04. 二维数组中的查找------------------
    //1.直接暴力遍历求解，复杂度n
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

//    public int findMiddle(){
//
//    }


    //二分查找
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix.length==0 ||matrix[0].length==0) return false;
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            if (matrix[i][0]>target) continue;
            int left= 0;
            int right = col-1;
            int mid=0;
            while (left<right){
                mid = (left+right)>>>1;
                if (matrix[i][mid]<target){
                    left = mid+1;
                }else {
                    right = mid;
                }
            }
            if (matrix[i][left]==target) return true;
        }
        return  false;
    }




    


}