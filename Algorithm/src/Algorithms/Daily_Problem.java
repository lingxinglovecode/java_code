package Algorithms;

import java.util.*;

/**
 * @author lianxing
 * @description
 * @create 2021-10-06 8:27
 */
public class Daily_Problem {


}

class DailySolution{

    //题目1：第三大的数
    //1.排序后统计当前数为第几大的数
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int index = 2;
        int curIdx = nums.length-1;
        int result = nums[curIdx];
       for (int i=nums.length-2;i>=0;i--){
           if ( result == nums[ i ] ){
               continue;
           }else{
               result = nums[i];
               index--;
           }
           if ( index == 0 ){
               return  result;
           }

       }
       return nums[nums.length-1];
    }

    //2.set存储所有非重复元素后重新构建数组再排序找到第三个元素即可
    public int thirdMax2(int[] nums) {
        HashSet hashSet = new HashSet<Integer>();
        for (Integer x:nums) hashSet.add(x);
        ArrayList<Integer> newNums = new ArrayList<Integer>(hashSet);
        newNums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }

        });
        return newNums.size()>2 ? newNums.get(2) : newNums.get(0);

    }

    //3.用三个数分别存储最大数，次大数以及第三大的数
    long MIN = (long)-1e18;
    public int thirdMax3(int[] nums) {
        long a = MIN,b=MIN,c=MIN;
        for(int i=0;i<nums.length;i++){
            if ( nums[i]>a ){
                c = b;
                b = a;
                a = nums[i];
            }else if(nums[i]<a && nums[i]>b){
                c = b;
                b = nums[i];
            }else if(nums[i]<b && nums[i]>c){
                c = nums[i];
            }
        }
        return (int) (c==MIN ? a : c);


    }

    //题目2：字符串中的单词数
    public int countSegments(String s) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if ( s.charAt(i)!=' ' ){
                if ( !flag ) {
                    count++;
                    flag = true;
                };
            }else if ( s.charAt(i)==' '){
                flag = false;
            }
        }
        return count;
    }


    //3.重复的DNA序列
    //超时
    public List<String> findRepeatedDnaSequences(String s) {
        String curString = "";
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if ( i+10<s.length() ){
                curString = s.substring(i,i+10);
                if ( !result.contains(curString) && s.substring(i+1).contains(curString) ){
                    result.add(curString);
                }
            }
        }
        return result;

    }
    //解法1：使用哈希表存储
    public List<String> findRepeatedDnaSequences2(String s) {

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i+10 <s.length(); i++) {
            String cur =  s.substring(i,i+10);
            Integer times = hashMap.getOrDefault(cur,0)+1;
            hashMap.put(cur,times);
        }
        ArrayList<String> result = new ArrayList<>();
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<String, Integer>entry : entries) {
            if ( entry.getValue()>1 ){
                result.add(entry.getKey());
            }

        }


        return result;

    }
    //解法2：字符串哈希

    int N = (int)1e5+10, P=13131313;
    int[] h = new int[N] , p = new int[N];
    public List<String> findRepeatedDnaSequences3(String s) {




    }




}
