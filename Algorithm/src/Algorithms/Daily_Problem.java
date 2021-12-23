package Algorithms;

import org.junit.Test;

import java.util.*;

/**
 * @author lianxing
 * @description
 * @create 2021-10-06 8:27
 */
public class Daily_Problem {
    DailySolution daySolution = new DailySolution();
    @Test
    public void test1(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        int a = daySolution.kthSmallest2(root,3);

    }

    public static void main(String[] args) {

    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
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

    int N = (int)1e5+10, P=131313;
    int[] h = new int[N] , p = new int[N];
    public List<String> findRepeatedDnaSequences3(String s) {
        ArrayList<String> result = new ArrayList<String>();
        p[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            h[i] = h[i-1]*P + s.charAt(i-1);
            p[i] = p[i-1]*P;
        }
        int code;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 1; i+10-1 <= s.length(); i++) {
            int j = i + 10 -1;
            code = h[j] - h[i-1]*p[j-i+1];
            int times = hashMap.getOrDefault(code, 0) + 1;
            hashMap.put(code, times);
            if ( times==2 ) result.add(s.substring(i-1,i-1+10));
        }
        return result;
    }


    /**
     * @Description: 二叉搜索树中第K小的元素
     * @param: null
     * @return * @return null
     * @author lianxing
     * @date 2021/10/17 10:55
    */
    public int kthSmallest(TreeNode root, int k) {
        String stringTravel = travelPreOrder(root);
        String[] stingList = stringTravel.split(",");
        List<Integer> myList = new ArrayList<Integer>();
        for(String s:stingList){
            myList.add(Integer.parseInt(s));
        }
//        myList.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
        myList.sort((Integer o1,Integer o2) -> o1-o2); //使用lambda表达式
        return myList.get(k-1);
    }

    public String travelPreOrder(TreeNode root){
        if ( root == null ){
            return "";
        }
        return travelPreOrder(root.left) + root.val +","+ travelPreOrder(root.right);


    }




    public int kthSmallest2(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        int count=0;
        stack.push(root);
        TreeNode curNode = root;
        while (!stack.isEmpty()){


            while ( curNode.left!=null ){
                curNode = curNode.left;
                stack.push(curNode);
            }
            TreeNode temp = stack.pop();
            count++;
            if ( count==k ){
                return temp.val;
            }
            if ( temp.right!=null ){
                curNode =temp.right;
                stack.push(curNode);
            }

        }
        return 0;


    }



    //范围求和II
    public int maxCount(int m, int n, int[][] ops) {
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        if ( ops.length==0 ){return m*n;}
        for (int i = 0; i < ops.length; i++) {
            if ( ops[i][0]<minRow ){
                minRow = ops[i][0];
            }
            if ( ops[i][1]<minCol ){
                minCol = ops[i][1];
            }

        }
        return minRow*minCol;
    }

    public int maxCount2(int m, int n, int[][] ops) {

        for (int[] op:ops){
            m = Math.min(op[0],m);
            n = Math.min(op[0],n);
        }
        return m*n;
    }


}
