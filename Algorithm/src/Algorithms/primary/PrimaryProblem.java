package Algorithms.primary;

import java.util.*;

public class PrimaryProblem {
}


class PrimarySolution{


    //1.删除重复的元素
    public int removeDuplicates(int[] nums) {
        int slow=0;
        int fast=1;
        while(fast<nums.length){
            if (nums[fast]!=nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return ++slow;
    }


    //2.买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        int sum=0;
        for(int i=0;i+1<prices.length;i++){
            if(prices[i+1]>prices[i]){sum = sum+prices[i+1]-prices[i];}
        }
        return sum;
    }

    public int maxProfit2(int[] prices){
        int num = prices.length;
        int[][] dp = new int[num][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < num; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
        return dp[num-1][0];
    }

    //3.旋转数组
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int idx;
        for (int i = 0; i < nums.length; i++) {
            idx = (k+i)%nums.length;
            temp[idx] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    public void rotate2(int[] nums,int k){
        k = k%nums.length;
        int temp;
        int len = nums.length;
        for (int i = 0; i < nums.length/2; i++) {
            temp = nums[i];
            nums[i] = nums[len-i-1];
            nums[len-i-1] = temp;
        }

        for (int i = 0; i < k/2; i++) {
            temp = nums[i];
            nums[i] = nums[k-i-1];
            nums[k-i-1] = temp;
        }

        for (int i = k; i < (nums.length+k)/2; i++) {
            temp = nums[i];
            nums[i] = nums[len-(i-k)-1];
            nums[len-(i-k)-1] = temp;
        }

    }
    //4.存在重复元素
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(nums[i])){
                return true;
            }
            integers.add(nums[i]);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for(Integer i:nums){
            integers.add(i);
        }
        return integers.size()!=nums.length;
    }


    //5.只出现一次的数字
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> myHashMap = new HashMap<>();
        for(Integer num:nums){
            myHashMap.put(num,myHashMap.getOrDefault(num,0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = myHashMap.entrySet();
        for(Map.Entry<Integer, Integer> entry:entries){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int slow=0;
        int fast=1;
        while (fast<nums.length){
            if (nums[fast]!=nums[slow]){
                return nums[slow];
            }
            while (nums[fast]==nums[slow]){
                fast++;
            }
            slow = fast;
            fast++;
        }
        return nums[slow];
    }

    public int singleNumber3(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num^nums[i];
        }
        return num;
    }

    //6.数组的交集
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hashSet.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (hashSet.contains(nums2[i]) && !list.contains(nums2[i])){
                list.add(nums2[i]);
            }
        }
        Object[] objects = list.toArray();
        int[] res = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            res[i] = (Integer) objects[i];
        }

        return res;




    }

}