package Algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lianxing
 * @description
 * @create 2021-10-03 9:07
 */
public class Other_Problem {
    @Test
    public void myTest(){
        int[] a = new int[10];
        System.out.println(a[0]);

    }
}


class OtherSolution{


    //问题1：两整数之和
    //https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwaiag/
    //位运算实现加法，与操作获取进位，异或操作获取数值位1的位
    public int getSum(int a, int b) {
        while(b!=0){
            int carry = (a&b)<<1;
            a = a^b;
            b = carry;
        }
        return a;

    }


    //问题2：多数元素
    //https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwnvrj/

    //方法1：哈希表存储每个元素出现的次数，大于n/2的时候就返回
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (Integer i : nums) {
            if ( !hashMap.containsKey(i) ) {
                hashMap.put(i,1);
            }else{
                hashMap.put(i,hashMap.get(i)+1);
            }

            if ( hashMap.get(i)>nums.length/2 ){
                return i;
            }
        }
        return 0;
    }

    //方法2：排序后记录元素出现的次数，当次数大于n/2的时候返回
    public int majorityElement2_1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int times = 1;
        if ( times>nums.length/2 ){
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            if ( nums[i]==nums[ i-1 ] ){
                times++;
            }else {
                times = 1;
            }
            if ( times>nums.length/2 ){
                return nums[i];
            }

        }
        return 0;
    }

    //方法3：摩尔投票法，记录一个候选人及其票数，当下一个票投向其他人的时候对该候选人票数-1反之票数+1，当票数为0的时候更换候选人
    //遍历完一遍之后最后留下来的一定是数组中的众数
    public int majorityElement3(int[] nums) {
        int times = 0;
        int result = 0;
        for ( int i = 0; i < nums.length; i++){
            if ( times==0 ){
                result = nums[i];
                times = 1;
            }else {
                if ( nums[i] == result ){
                    times++;
                }else {
                    times--;
                }
            }
        }
        return  result;
    }


    //问题3：任务调度器
    //https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwvaot/

    //构造分析
    //https://leetcode-cn.com/problems/task-scheduler/solution/ren-wu-diao-du-qi-by-leetcode-solution-ur9w/
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int max = 0;
        for (Character i : tasks){
            //返回对应key的value值如果没有就创建并初始化value为默认值
            int times = hashMap.getOrDefault(i, 0) + 1;
            hashMap.put(i,times);
            max = Math.max(max, times);
        }

        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Character, Integer> entry: entries){
            if ( entry.getValue()==max ){
                maxCount++;
            }
        }
        return Math.max((max-1) * (n + 1) + maxCount, tasks.length);


    }

}