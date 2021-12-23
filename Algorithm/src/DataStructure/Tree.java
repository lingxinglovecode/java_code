package DataStructure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-10-17 15:27
 */
public class Tree {
    TreeSolution solution =  new TreeSolution();
    @Test
    public void testPreOrder(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        ArrayList<Integer> list = new ArrayList<>();
        List res = solution.preorderTraversal(root);
        System.out.println(res);


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

class TreeSolution {

    //------------------------------------二叉树的遍历-------------------------------//

    //1.前序遍历
    //方法1：递归
    public List<Integer> help(TreeNode root,List<Integer> res){
        if ( root==null ){
            return null;
        }
        res.add(root.val);
        help(root.left,res);
        help(root.right,res);
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        return help(root,new ArrayList<>());
    }

    //方法2：迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node!=null ){

            while( node != null ){
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            node = node.right;

        }

        return res;

    }


    //方法3：Morris遍历
    public List<Integer> preorderTraversal3(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();
        TreeNode cur1 = root;
        TreeNode cur2;
        while(cur1!=null){
            cur2 = cur1.left;
            if ( cur2!=null ){
                while (cur2.right!=null && cur2.right!=cur1){
                    cur2 = cur2.right;
                }
                if ( cur2.right == null ){
                    cur2.right = cur1;
                    res.add(cur1.val);
                    cur1 = cur1.left;
                    continue;
                }else{
                    cur2.right = null;
                }
            }else {
                res.add(cur1.val);
            }
            cur1 = cur1.right;

        }
        return res;

    }




}
