package Algorithms;

import org.junit.Test;
import java.lang.Math;
import java.util.*;

/**
 * @author lianxing
 * @description
 * @create 2021-09-22 10:50
 */
public class Problem_Design {
    @Test
    public void test1(){
        MyTreeNode root = new MyTreeNode(10);
        root.left = new MyTreeNode(5);
        root.right = new MyTreeNode(20);
         Codec ser = new Codec();
         Codec deser = new Codec();
        System.out.println(ser.serialize(root));
        String code = "1,2,3,null,null,4,5";
        System.out.println(deser.deserialize(ser.serialize(root)));
        System.out.println(deser.deserialize(code));

        Codec2 ser2 = new Codec2();
        Codec2 deser2 = new Codec2();

        System.out.println(deser2.deserialize(code));
    }


    @Test
    public void test2(){
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.remove(0);
        randomizedSet.remove(0);
        randomizedSet.insert(0);
//        randomizedSet.insert(2);
//        randomizedSet.insert(1);
//        randomizedSet.remove(2);
        randomizedSet.getRandom();

    }

    @Test
    public void test3(){
        SummaryRanges2 summaryRanges = new SummaryRanges2();
        summaryRanges.addNum(1);


    }
}



//1.二叉树的序列化与反序列化
//https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/

class MyTreeNode {
      int val;
    MyTreeNode left;
    MyTreeNode right;

    MyTreeNode(int x) { val = x; }
}

//方法1：序列化过程使用递归前序遍历+反序列过程栈
class Codec {

    // Encodes a tree to a single string.
    public String serialize(MyTreeNode root) {
        String nodeString  = "";
        String sign = ",";
        if ( root== null ){
            return "null";
        }

        return nodeString + root.val+sign+serialize(root.left) + sign+serialize(root.right);

    }

    // Decodes your encoded data to tree.
    public MyTreeNode deserialize(String data) {
        String[] strings = data.split(",");

        if ( strings[0]=="null" ){
            return null;
        }
        MyTreeNode root = new MyTreeNode(Integer.parseInt(strings[0]));
        Deque<MyTreeNode> stack = new LinkedList<>();
        stack.push(root);

        MyTreeNode node = root;
        int i = 1;
        while (i<strings.length){
            if ("null".equals(strings[i])){
                while (i<strings.length && "null".equals(strings[i])){
                    node= stack.poll();
                    i += 1;
                }
                if ( i<strings.length ){
                    MyTreeNode newNode =  new MyTreeNode(Integer.parseInt(strings[i]));
                    node.right = newNode;
                    node = newNode;
                    stack.push(node);
                }
            }
            else {
                MyTreeNode newNode =  new MyTreeNode(Integer.parseInt(strings[i]));
                node.left = newNode;
                node = newNode;
                stack.push(node);
            }
            i += 1;
        }
        return root;
    }
}


//方法2：序列化过程和反序列化过程都使用递归
class Codec2 {

    // Encodes a tree to a single string.
    public String serialize(MyTreeNode root) {
        String nodeString  = "";
        String sign = ",";
        if ( root== null ){
            return "null";
        }

        return nodeString + root.val+sign+serialize(root.left) + sign+serialize(root.right);

    }

    // Decodes your encoded data to tree.
    public MyTreeNode deserializeHelp(List<String> stringList){
        if ( stringList.isEmpty() ){return null;}
        if ( "null".equals(stringList.get(0))   ){
            stringList.remove(0);
            return null;
        }

        int val = Integer.parseInt(stringList.remove(0));
        MyTreeNode root = new MyTreeNode(val);

        root.left = deserializeHelp(stringList);
        root.right = deserializeHelp(stringList);

        return root;
    }

    public MyTreeNode deserialize(String data) {
       String[] strings = data.split(",");
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(strings));


       return deserializeHelp(stringList);

    }
}



//题目2：O(1) 时间插入、删除和获取随机元素
//https://leetcode-cn.com/problems/insert-delete-getrandom-o1/

//方法1：使用自建哈希表进行插入和删除操作，使用动态数组实现获取随机数
class RandomizedSet {

    class LinkNode{
        private Integer val;
        LinkNode next;

        public LinkNode() {
        }

        public LinkNode(int val, LinkNode next) {
            this.val = val;
            this.next = next;
        }

        public LinkNode(int val) {
            this.val = val;
        }
    }

    private  LinkNode[] dataBuffer = new LinkNode[2000];
    private  ArrayList index = new ArrayList();
    /** Initialize your data structure here. */
    public RandomizedSet() {
//        Arrays.fill(dataBuffer,new LinkNode());
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if ( !index.contains(val)){
            index.add((Integer)val);
        }

        int location = hashCode(val);
        LinkNode node = new LinkNode(val);
        LinkNode cur = dataBuffer[location];
        if ( cur == null ){
            dataBuffer[location] = new LinkNode(node.val);
            return true;
        }

        LinkNode lastNode = cur;
        while(cur != null){
            if ( cur.val == node.val ){
                return false;
            }
            lastNode = cur;
            cur = cur.next;
        }
        lastNode.next = node;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if ( index.contains(val) ){index.remove((Integer)val);};

        int location = hashCode(val);
        LinkNode cur = dataBuffer[ location ];
        if ( cur==null ){return false;}
        if ( cur.val!=null && cur.val==val ){
            dataBuffer[location] = cur.next==null ? new LinkNode() : cur.next;
            return true;
        }

        LinkNode lastNode = cur;
        cur = cur.next==null ? null :cur.next;
        while(cur!=null){
            if ( cur.val == val ){
                lastNode.next = cur.next;
                return true;
            }
            lastNode = cur;
            cur = cur.next;
        }
        return false;



    }

    /** Get a random element from the set. */
    public int getRandom() {
        int num = index.size();
        int randomNum = (int)(Math.random()*num);
        return (int) index.get(randomNum);
    }

    public int hashCode(int value){
        int high = value>>>16;
        return Math.abs( Integer.hashCode(value) ^ high)%2000;
    }
}


//方法2：使用动态数组实现插入和获取随机数，使用哈希表存储值到索引的映射便于进行数组的删除
class RandomizedSet2{
    Map<Integer,Integer> map;
    List<Integer> list;


    /** Initialize your data structure here. */
    public RandomizedSet2() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if ( map.containsKey(val) ){return false;}
        list.add(val);
        map.put(val,list.size()-1);
        return true;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if ( !map.containsKey(val) ){return false;}
        int index = map.get(val);
        int lastVal = list.get(list.size()-1);
        list.set(index,lastVal);
        list.remove(list.size()-1);
        map.replace(lastVal,index);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = (int) (Math.random() * list.size());
        return list.get(index);
    }

}

class SummaryRanges {

    ArrayList<Integer> data = new ArrayList<Integer>();
    public SummaryRanges() {

    }

    public void addNum(int val) {
        data.add(val);
    }

    public int[][] getIntervals() {
        this.data.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        while (start<this.data.size()){
            int[] interval = {this.data.get(start),this.data.get(end)};
            while ( end+1 < this.data.size() && this.data.get(end+1) <= this.data.get(end)+1 ){
                end = end + 1;
                interval[1] = this.data.get(end);
            }
            list.add(interval);
            start = end+1;
            end = start;
        }
        return list.toArray(new int[list.size()][]);

    }
}


class SummaryRanges2 {
    List<int[]> list = new ArrayList<int[]>();
    int[] head = {-10,-10}, tail = {10010,10010};

    public SummaryRanges2() {
        list.add(head);
        list.add(tail);
    }

    public void addNum(int val) {

        int l = 0;
        int r = list.size()-1;
        while (l < r) {
            int mid = l+r+1 >> 1;
            if ( list.get(mid)[0]>val ){
                r = mid - 1;
            }else {
                l = mid;
            }
        }
        int[] prev = list.get(l);
        int[] next = list.get(l+1);
        if ( val>=prev[0] && val<=prev[1]){ // || val>=next[0] && val<=next[1]
            return ;
        }else if (prev[1]+1 == val && next[0] == val+1){
            prev[1] = next[1];
            list.remove(next);
        }else if(prev[1]+1 == val){
            prev[1] = val;
        }else if(next[0]-1 == val){
            next[0] = val;
        }else {
            list.add(l+1,new int[]{val,val});
        }

    }

    public int[][] getIntervals() {
        int n = list.size();
        int[][] result = new int[n-2][2];
        for (int i = 1; i < n-1; i++) {
            result[i-1] = list.get(i);
        }
        return result;
    }

}

class SummaryRanges3{
    TreeSet<int[]> treeSet = new TreeSet<>((a,b) -> a[0]-b[0]);
    int[] head = new int[]{-10, -10}, tail = new int[]{10010, 10010};
    public SummaryRanges3() {
        treeSet.add(head);
        treeSet.add(tail);
    }

    public void addNum(int val) {
        int[] cur = new int[]{val, val};
        int[] prev = treeSet.floor(cur);
        int[] next = treeSet.ceiling(cur);
        if ( val>=prev[0] && val<=prev[1]){ //|| (next[0] <= val && val <= next[1]
            return ;
        }else if (prev[1]+1 == val && next[0] == val+1){
            prev[1] = next[1];
            treeSet.remove(next);
        }else if(prev[1]+1 == val){
            prev[1] = val;
        }else if(next[0]-1 == val){
            next[0] = val;
        }else {
            treeSet.add(cur);
        }
    }
    public int[][] getIntervals() {

        int n = treeSet.size();
        int[][] result = new int[n-2][2];
        Iterator<int[]> iterator = treeSet.iterator();
        iterator.next();
        for (int i = 0; i < n-2; i++) {
            result[i] = iterator.next();
        }
        return result;


    }




}