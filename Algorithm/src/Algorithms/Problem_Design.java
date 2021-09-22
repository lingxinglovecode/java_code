package Algorithms;

import org.junit.Test;

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