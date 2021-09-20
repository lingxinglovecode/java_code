package DataStructure;

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







}