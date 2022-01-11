package Algorithms;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author lianxing
 * @description
 * @create 2021-09-19 8:33
 */
public class Dynamic_Programming {
    public static Solution_Dynamic solution = new Solution_Dynamic();

    @Test
    public void test1(){

        int[] nums = {2,3,1,1,4};
        System.out.println(solution.canJump3(nums));
    }

    @Test
    public void test2(){
        int[] coins = {1};
        int amount = 1;
        System.out.println(solution.coinChange2(coins,amount));

    }


    @Test
    public void test3(){
        int[] nums = {4, 10, 4, 3, 8, 9};
        solution.lengthOfLIS2(nums);

        int [] friends = {49,110,13,39,45,104,9,114,86,72,13,24,10,77,103,85,9,21,66,25};
        solution.numFriendRequests5(friends);

    }
}





class Solution_Dynamic{

//----------------------------中级算法----------------------------------
    //1.跳跃游戏
    //https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvb8zs/


    //方法1：直接递归求解，超时
    public boolean canJump(int[] nums) {
        if ( nums[0]>=nums.length-1 ){
            return true;
        }

        int i = 1;
        while (i<=nums[0]){
            int[] subArray = Arrays.copyOfRange(nums,i,nums.length);
            if ( canJump(subArray) ){
                return true;
            }
            i += 1;
        }
        return false;

    }

    //方法2：维护一个记录能够跳跃到最大下标的表
    public boolean canJump2(int[] nums) {
        int[] maxJump = new int[nums.length];
        maxJump[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ( i<=maxJump[i-1] ){
             maxJump[i] = Math.max(i+nums[i],maxJump[i-1]);}
            else {
                //可以直接return false！因为没有办法到这个位置
            maxJump[i] = maxJump[i-1];}
        }

        //可以将这个判断移动到上面去
        if ( maxJump[maxJump.length-1]>=nums.length-1){
            return true;
        }
        return false;

    }

    //方法3：方法2的改进，只用一个变量分别存储上一位置能够到达最大
    // 下标以及当前位置能够到达的最大下标
    public boolean canJump3(int[] nums) {
        int thisMaxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if ( i<=thisMaxJump ){
                thisMaxJump = Math.max(thisMaxJump,i+nums[i]);
                if ( thisMaxJump>=nums.length-1 ){return true;}
            }else {
                return false;
            }
        }
        return false;

    }

    //方法4：方法2的改进，不需要额外的数组存储能够到达的最大下标
    //直接在原来的数组上记录即可
    public boolean canJump4(int[] nums) {
        if(nums[0]>=0 && nums.length==1){return true;}
        for (int i = 1; i < nums.length; i++) {
            if ( i<=nums[i-1] ){
                nums[i] = Math.max(i+nums[i],nums[i-1]);
                if ( nums[i]>=nums.length-1 ) return true;
            }
            else {
                return false;}
        }
        return false;

    }

    //2.不同路径
    //https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvjigd/


    //方法1：动态规划，从开始位置计算每一个位置的路径数量
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ( i==0 && j==0 ){continue;}
                else {
                    int leftPath = j - 1 >= 0 ? dp[ i ][ j - 1 ] : 0;
                    int upPath = i - 1 >= 0 ? dp[ i - 1 ][ j ] : 0;
                    dp[ i ][ j ] = leftPath + upPath;
                }

            }
        }
        return dp[m-1][n-1];

    }

    //方法2：计算组合数

    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }


    //3.零钱兑换
    //https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvf0kh/


    //方法1：记忆化递归
    public int help(int[] coins, int amount,int[] numsCoin){
        if ( amount==0 )return 0;
        if ( amount<0 )return -1;
        if ( numsCoin[amount]!=0 ){
            return numsCoin[amount];
        }
        int minNumber = Integer.MAX_VALUE ;
        for (int i = 0; i < coins.length; i++) {
            int num = help(coins,amount-coins[i],numsCoin);
            if ( num>=0 ){
                minNumber = Math.min(minNumber,num+1);
            }
        }
        numsCoin[amount] = minNumber==Integer.MAX_VALUE ? -1 : minNumber;

        return numsCoin[amount];
    }

    public int coinChange(int[] coins, int amount) {
        return help(coins,amount,new int[amount+1]);
    }



    //方法2：动态规划填表，利用递推公式找出从1-amount所有金额所需要的最小钱币数量
    public int coinChange2(int[] coins, int amount) {
        if ( amount==0 ){return 0;}
        int[] minCoinsNum = new int[amount+1];
        Arrays.fill(minCoinsNum,amount+1);
        minCoinsNum[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if ( i-coins[j]>=0 ){
                    minCoinsNum[i] = Math.min(minCoinsNum[i-coins[j]]+1,minCoinsNum[ i ]);
                }
            }
        }
        return minCoinsNum[ amount ]>amount ? -1 : minCoinsNum[ amount ];
    }


    //4.最长递增子序列
    //https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwhvq3/

    //方法1：求出每一个元素作为子序列的最后一个值的时候对应的最长子序列的长度
    public int lengthOfLIS(int[] nums) {
        int[] results = new int[nums.length];
        Arrays.fill(results,1);
        int maxResult = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if ( nums[i]>nums[j] ){
                    results[i] = Math.max(results[j]+1,results[i]);
                    maxResult = Math.max(maxResult,results[i]);
                }

            }
        }
        return maxResult;
    }

    //方法2：贪心+二分查找
    //借鉴答案题解
    // https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/

    public int binarySearch(int left,int right,int[] nums,int target){
        int pos = 0;
        while(left<=right){
            int mid = (left+right)/2;
            if ( target>nums[mid] ){
                left = mid+1;
                pos = mid;
            }else{
                right = mid-1;
            }
        }
        return pos+1;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] lengthAndNum = new int[nums.length+1];
        int maxLength = 1;
        lengthAndNum[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ( nums[i]>lengthAndNum[maxLength] ){
                maxLength += 1;
                lengthAndNum[maxLength] = nums[i];
            }else {

                int idx = binarySearch(1,maxLength,lengthAndNum,nums[i]);
                lengthAndNum[idx] = nums[i];

            }

        }
        return maxLength;

    }


    //适龄的朋友

    //暴力查找 超时
    public int numFriendRequests(int[] ages) {
        int request = 0;
        for (int i = 0; i < ages.length; i++) {
            for (int j = 0; j < ages.length; j++) {
                if(i==j) continue;
                if ((ages[i]<=0.5*ages[j]+7) || (ages[i]>ages[j]) || (ages[i]>100)&&(ages[j]<100)){
                    continue;
                }
                request++;
            }
        }
        return request;
    }

    //先排序然后在一定范围内查找
    public int numFriendRequests2(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        for (int i = 0; i < ages.length; i++) {
            for (int j = i-1; (j>=0) && (ages[j]>0.5*ages[i]+7); j--) {
                if (ages[j]==ages[i]){
                    res = res+2;
                }else{
                    res++;
                }

            }
        }
        return res;
    }

    //找到符合范围的左边界和右边界，然后统计个数
    public int numFriendRequests3(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        for (int l=0,r=0,i=0; i < ages.length; i++) {
            l = i;
            r = i;
            while((l-1>=0) && (ages[l-1]>0.5 * ages[i]+7)){l--;}
            if((r+1<ages.length)&&(ages[r+1]>0.5 * ages[i]+7)){
                while ((r+1<ages.length) && (ages[r+1]==ages[i])){r++;}
            }
            res = res + r-l;
        }
        return res;
    }

    //统计边界 但是从开始0的位置向上统计
    public int numFriendRequests4(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        for (int i = 0,l=0,r=0; i < ages.length; i++) {
            while (l<i && !check(ages[i],ages[l])) l++;
            r = i;
            while (r<ages.length && check(ages[i],ages[r])) r++;
            if(r>l) res = res+r-l-1;
        }
        return res;
    }

    boolean check(int x,int y){
        if(y<=0.5*x+7) return false;
        if(y>x) return false;
        return true;
    }

    //采用桶排序的思想
    public int numFriendRequests5(int[] ages) {
        int N = 120;
        int[] bucket = new int[N+1];
        for(int age:ages){bucket[age]++;}
        for (int i = 1; i < N+1; i++) {
            bucket[i] = bucket[i]+bucket[i-1];
        }
        int res=0;
        for (int i = 0; i < ages.length; i++) {
            int max = ages[i];
            int min = (int) (0.5*ages[i])+7;
            if (max>min){
                res += bucket[max]-bucket[min]-1;
            }
        }
        return res;
    }




}