package DataStructure;

import org.junit.Test;

import java.util.*;

/**
 * @author lianxing
 * @create 2021-09-09 22:22
 */
public class Array {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//
//    }


    @Test
    public void arrayTest1(){
        Solution solution = new Solution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int num;
        num = solution.removeDuplicates3(nums);
        System.out.println(num);
        for (int i = 0; i < num; i++) {
            System.out.println(nums[i]);
        }

//        for(int i : nums){
//            System.out.println(i);
//        }
        System.out.println(nums);
    }

    @Test
    public void arrayTest2(){
        int[] prices = {7,1,5,3,6,4};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit2(prices));


    }

    @Test
    public void arrayTest3(){
        int[] nums = {1,2,3,4,5,6,7};
        int k =3;
        Solution solution = new Solution();
        solution.rotate3(nums,k);
        solution.printArray(nums);

    }


    @Test
    public void middleArrayTest1(){
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        Solution solution = new Solution();
        List<List<Integer>> lists = new ArrayList<>();
        lists = solution.threeSum(nums);
        System.out.println(lists);
    }
    @Test
    public void middleArrayTest2(){
        int[][] nums = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        Solution solution = new Solution();
        solution.setZeroes2(nums);

    }


    @Test
    public void spiralOrderTest(){
        int[][] matrix = {{2, 5, 8},{4, 0, -1}};
        Solution solution = new Solution();
        solution.spiralOrder(matrix);

    }


}



class Solution{
    public void printArray(int[] nums){
        for(int i:nums){
            System.out.println(i);
        }

    }
//----------------------------------------------初级算法-----------------------------------------------------------
//   1.删除排序数组中的重复项
    //方法1：直接两重循环遍历，遇到相同的元素直接后面元素向前覆盖，要注意的
    // 是这个时候第二个指针需要减一从第一个指针的初始后面开始重新遍历
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length-count ; j++) {
                if (nums[i] == nums[j]){
                    count = count+1;
                    int t = j;
                    while (t+1 < nums.length){
                        nums[t] = nums[t+1];
                        t = t+1;
                    }
                    j = j-1;
                }
            }
        }

        return nums.length - count;

    }


    //方法2：双指针 两个指针开始遍历，当第二个指针与第一个指针指的值相同的时候同时移动二个指针
    //不同的时候将第二个指针指向的值赋给第一个指针
    public int removeDuplicates2(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = 1;
        while (right< nums.length){
            if (nums[right] == nums[right-1]){
                right = right+1;
            }
            else{
                left = left+1;
                nums[left] = nums[right];
                right = right+1;
            }
        }
        return left+1;
    }

    // 方法3：使用hashset，其中hashset中存储的所有不重复的元素
    public int removeDuplicates3(int[] nums){
        HashSet hashSet = new HashSet<Integer>();
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer i : nums){
            list.add(i);
        }

        hashSet.addAll(list);
//        for(Object i : hashSet){
//            System.out.println((Integer)i);
//        }



        return hashSet.size();

    }
//    2.买卖股票的最佳时机
     //方法1：贪心算法，双指针，如果后面的股票比前面的大就将差值相加，否则移动两个指针
    public int maxProfit(int[] prices){
        int left = 0;
        int right = 1;
        int sum = 0;
        while (right<prices.length){
            if (prices[right]>prices[left]){
                sum = sum + (prices[right]-prices[left]);
                right += 1;
                left += 1;
            }
            else {
                left += 1;
                right += 1;
            }
        }
        return sum;

    }


    //方法2动态规划，通过递推公式计算每天持有股票和没有持有股票的最大收益
    public int maxProfit2(int[] prices){
        int[][] maxProfit= new int[prices.length][2];
        maxProfit[0][0] = 0;
        maxProfit[0][1] = -prices[0];
        for (int i = 1; i < prices.length ; i++) {
            maxProfit[i][0] = Math.max(maxProfit[i-1][0],maxProfit[i-1][1]+prices[i]);
            maxProfit[i][1] = Math.max(maxProfit[i-1][0]-prices[i],maxProfit[i-1][1]);
        }
        return Math.max(maxProfit[prices.length-1][0],maxProfit[prices.length-1][1]);

    }
//    3.旋转数组
    //方法1：直接将每一个位置的元素向后面移动
    public void rotate(int[] nums,int k){
        int len = nums.length;
        HashSet set = new HashSet();
        int nextIndex=0;
        int temp1 = nums[0];
        int temp2;
        for (int i = 0; i < len; i++) {
            nextIndex = (nextIndex+k)%len;
            if (set.contains(nextIndex)){
                nextIndex = nextIndex+1;
                temp1 = nums[nextIndex];
                nextIndex = (nextIndex+k)%len;
            }
            temp2 = nums[nextIndex];
            nums[nextIndex] = temp1;
            set.add(nextIndex);
            temp1 = temp2;
        }

        }


    //方法2：建立一个临时数组，然后将移动后的结果存储在临时数组，最后再复制回来
    public void rotate2(int[] nums,int k){
         int[] tempArray = new int[nums.length];
         int nextIndex;
        for (int i = 0; i < nums.length; i++) {
            nextIndex = (i+k)%nums.length;
            tempArray[nextIndex] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tempArray[i];
        }


    }

    //方法3：首先对整个数组进行反转。然后分别反转前面k个数字和后面的数字
    public void rotate3(int[] nums,int k){
        int temp;
        for (int i = 0; i < nums.length / 2; i++) {
           temp = nums[i];
           nums[i] = nums[nums.length-1-i];
           nums[nums.length-1-i] = temp;
        }

        int reverseK = k% nums.length;
        for (int i = 0; i < (reverseK) / 2; i++) {
            temp = nums[i];
            nums[i] = nums[reverseK-1-i];
            nums[reverseK-1-i] = temp;
        }

        for (int i = reverseK; i < (nums.length-reverseK) / 2 + reverseK; i++) {
            temp = nums[i];
            nums[i] = nums[nums.length+reverseK-1-i];
            nums[nums.length+reverseK-1-i] = temp;
        }





    }
//   4.存在重复元素
     //方法1：将元素存储在集合中，然后判断集合中的个数与原来数组中的个数是否相等
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (Integer i:nums){
            set.add(i);
        }
        return nums.length==set.size();
    }

    //方法2：直接两重循环遍历
    public boolean containsDuplicate2(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (nums[i]  == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    // 方法3：先对数组排序，之后进行一遍遍历
    public boolean containsDuplicate3(int[] nums){
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i-1]){
            return false;}
        }
        return true;
        }
//5.只出现一次的数字

    //方法1：首先排序，然后将下一个元素与上一个元素比较，如果不等的话那么返回上一个元素
    public int singleNumber(int[] nums){
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i += 2) {
               if (nums[i] != nums[i-1]){
                   return nums[i-1];
               }
        }
        return nums[nums.length-1];
    }


    //方法2：将所有数字作为key，出现次数作为value放入一个HashMap中，然后遍历所有map，找到key为1的返回其value
    public int singleNumber2(int[] nums){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer num:nums){
            if (!hashMap.containsKey(num)){
                hashMap.put(num,1);
            }
            else {
                hashMap.put(num,hashMap.get(num)+1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue() == 1){
                return next.getKey();
            }
        }
        return -1;
    }

    //方法3：利用抑或运算的性质，所有元素与自身的抑或运算都是0，且抑或运算允许交换次序，所以将所有元素进行抑或之后最终
    //结果就是出现一次的数字
    public int singleNumber3(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;


    }
//6.两个数组的交集




//------------------------------------------中级算法---------------------------------------------
//1.三数之和
//    给你一个包合n个整数的数组nms,判断mums中是否存在三个元素a,b,c,使得a+b+c=0 请你找出所有和为0且不重复的三元组
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length<3){
            List<List<Integer>> result = new ArrayList<>();
            return result;
        }
        int left = 0;
        int right = nums.length-1;

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i< nums.length && nums[i] <= 0; i++) {
            right = nums.length-1;
            if (i==0 || nums[i]!=nums[i-1]) {
                left = i + 1;
                while (left < right) {
                    if (left>i+1 && nums[left]==nums[left-1]){
                        left = left+1;
                        continue;
                    }
                    if (right<nums.length-1 && nums[right]==nums[right+1]){
                        right = right-1;
                        continue;
                    }

                    if (nums[left] + nums[right]+nums[i] > 0) {
                        right -= 1;
                    } else if (nums[left] + nums[right]+nums[i] < 0) {
                        left += 1;
                    } else {

                        ArrayList<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[left]);
                        subList.add(nums[right]);
                        result.add(subList);
                        right -= 1;
                        left += 1;
                    }
                }
            }

        }
        return result;
    }


//2. 矩阵置零

    public void setColumnZero(int[][] matrix,int column){
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }

    }
    public void setRowZero(int[][] matrix,int row){
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }

    }

    //方法1：一个矩阵遍历所有零的位置，另外一个矩阵对相应位置进行置零
    public void setZeroes(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (result[i][j]==0){
                    setColumnZero(matrix,j);
                    setRowZero(matrix,i);
                }

            }
        }
    }

    //方法2：在第一行和第一列记录当前行和列中是否有为0的元素，之后根据第一行和列的值进行置零操作
    public void setZeroes2(int[][] matrix) {
        int firstRow = 0;
        int firstCol = 0;
        //遍历第一行，如果有0的话flag置1
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i]==0){
                firstRow = 1;
                break;
            }
        }
        //遍历第一列，如果有0的话flag置1
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]==0){
                firstCol = 1;
                break;
            }
        }
        //遍历除了第一行和第一列的其他元素，如果存在零就将对应的第一列或者第一行的对应元素置为0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //遍历第一行，对相应列置零
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i]==0){
                setColumnZero(matrix,i);
            }
        }
        //遍历第一列，对相应行置零
        for (int j  = 1; j < matrix.length; j++) {
            if (matrix[j][0]==0){
                setRowZero(matrix,j);
            }
        }
        //对第一行和第一列进行置零
        if (firstCol == 1){
            for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
        }
        if (firstRow == 1){
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }



    }

    //思路3：设置一个长度为一行的数组用来存储对应行是否有0，另外一个长度为一列的数组存储对应列是否为0，
    //根据这两个数组最终置相应位置为0，其实是方法1和方法2的折中


    //------------------------------------------高级算法---------------------------------------------

    //1.螺旋矩阵
    //https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xw3ng2/

    //方法1：直接遍历，控制上下左右四个方向
    public List<Integer> spiralOrder(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        List result = new ArrayList<Integer>();

        int right_row = 0, right_col_start =0 ,right_col_end = col-1;
        int down_col = col-1, down_row_start = right_row+1, down_row_end = row-1 ;
        int left_row = row-1,left_col_start = down_col-1,left_col_end = 0;
        int up_col = left_col_end, up_row_start = left_row+1,up_row_end = right_row-1;

        while(true) {

            if ( right_col_end >= right_col_start ) {
                //right
                for (int j = right_col_start; j <= right_col_end; j++) {
                    result.add(matrix[ right_row ][ j ]);
                }
            }else break;

            down_col = right_row == 0 ? col - 1 : down_col - 1;
            down_row_start = right_row + 1;
            down_row_end = right_row == 0 ? row - 1 : down_row_end - 1;
            if ( down_row_end >= down_row_start ) {
                for (int i = down_row_start; i <= down_row_end; i++) {
                    result.add(matrix[ i ][ down_col ]);
                }
            }else break;

            left_row = right_row == 0 ?row-1:left_row-1;
            left_col_start = down_col-1;
            left_col_end = right_row == 0?0:left_col_end+1;
            if ( left_col_start >= left_col_end ) {
                for (int j = left_col_start; j >= left_col_end; j--) {
                    result.add(matrix[ left_row ][ j ]);
                }
            }else break;

            up_col = left_col_end;
            up_row_start = left_row-1;
            up_row_end = right_row+1;
            if ( up_row_end <= up_row_start ) {
                for (int i = up_row_start; i >= up_row_end; i--) {
                    result.add(matrix[ i ][ up_col ]);
                }
            }else break;

            right_row = right_row+1;
            right_col_start = up_col+1;
            right_col_end = down_col-1;
        }


        return result;

    }
    //同方法一，优化之后
    public List<Integer> spiralOrder2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[ 0 ].length;
        int left = 0, right = col - 1, up = 0, down = row - 1;

        List<Integer> list = new ArrayList<Integer>();
        while (true) {
            //right
            if ( left > right ) break;
            for (int j = left; j <= right; j++) {
                list.add(matrix[ up ][ j ]);
            }

            up++;
            //down
            if ( up > down ) break;
            for (int i = up; i <= down; i++) {
                list.add(matrix[ i ][ right ]);
            }
            //left
            right--;
            if ( left > right ) break;
            for (int j = right; j >= left; j--) {
                list.add(matrix[ down ][ j ]);

            }

            //up
            down--;
            if ( down < up ) break;
            for (int i = down; i >= up; i--) {
                list.add(matrix[ i ][ left ]);
            }
            left++;
        }
        return list;


    }


}

