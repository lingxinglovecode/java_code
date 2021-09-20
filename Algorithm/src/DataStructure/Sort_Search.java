package DataStructure;

import org.junit.Test;

/**
 * @author lianxing
 * @description
 * @create 2021-09-17 10:15
 */
public class Sort_Search {
    @Test
    public void sortTest1(){
        Sort_solution solution = new Sort_solution();
       int[] nums = {3,1};
       int res = solution.search2(nums,1);
        System.out.println(res);

    }
    @Test
    public void searchTest1(){
        Sort_solution solution = new Sort_solution();
        int[][] nums = {{-5}};
        boolean res = solution.searchMatrix4(nums,-10);
        System.out.println(res);

    }

}


class Sort_solution{


//----------------------------中级算法--------------------------------


//1.搜索旋转排序数组
//https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvyz1t/


    //方法1：直接搜索
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target){
                return nums[i];
            }
        }
        return -1;
    }

    //方法2：将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
    //此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
    public int search2(int[] nums, int target) {
         int left = 0;
         int right = nums.length-1;
         int n =nums.length;
         if (n==0){
             return -1;
         }
         if (n==1){
             return target==nums[0] ? 0 : -1;
         }

         while (left<=right){
             int mid = (right+left)/2;
             if (target == nums[mid]){
                 return mid;
             }
             if (nums[0]<=nums[mid]){
                 if (target>=nums[0] && target<nums[mid]){
                     right = mid-1;
                 }else {
                     left = mid+1;
                 }
             }else {
                 if (target<=nums[n-1] && target>nums[mid]){
                     left = mid+1;
                 }else {
                     right = mid -1;
                 }


             }

         }



        return -1;
    }

//2.搜素二维矩阵
//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//    每行的元素从左到右升序排列。
//    每列的元素从上到下升序排列。

    //方法1：直接按照行搜素
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;

    }


    //假设array已经排好序
    public boolean binarySearch(int[] array,int target){
        int left = 0;
        int right = array.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (array[mid]>target){
                right = mid -1;
            }else if(array[mid]<target){
                left = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }

    //方法2：每一行进行二分搜素
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length;
        for (int i = 0; i < row; i++) {
            if (binarySearch(matrix[i],target)==true) {
                return true;
            }
        }
        return false;

    }
    //方法3：先判断target是否大于行最小值并且小于最大值，然后对满足条件的行进行二分搜素
    public boolean searchMatrix3(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (target>=matrix[i][0] && target<=matrix[i][col-1]){
                if (binarySearch(matrix[i],target)==true) {
                    return true;
                }
            }
        }
        return false;


    }

    //方法4(借鉴)：从左下角看，每一个数的上面一个数都是比他要小，右面的数比他要大
    public boolean searchMatrix4(int[][] matrix,int target){
        int row = matrix.length;
        int col = matrix[0].length;
        int rowIndex = row-1;
        int colIndex = 0;
        while (rowIndex>=0  && colIndex<col ){
            if ( target > matrix[ rowIndex ][ colIndex ] ) {
                colIndex = colIndex + 1;
            } else if ( target < matrix[ rowIndex ][ colIndex ] ) {
                rowIndex = rowIndex - 1;
            } else if ( target == matrix[ rowIndex ][ colIndex ] ) {
                return true;
            }
        }

        return false;

        }


}