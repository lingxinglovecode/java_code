package DataStructure;

import java.util.Stack;

/**
 * @author lianxing
 * @description
 * @create 2021-12-24 14:41
 */
public class LinkedList {




}

class LinkedListSolution{
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
//1.删除链表中的节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

//2.删除链表的倒数第N个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node=head;
        int num=0;
        while (node != null){
            num++;
            node = node.next;
        }
        int targetNum = num-n;
        if (targetNum==0){
            return head.next;
        }

        node = head;
        num = 0;
        while (num<targetNum-1){
            node = node.next;
            num++;
        }
        node.next = node.next.next;
        return head;
    }


    //3.翻转链表
    //递归
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode next = head.next;
        ListNode listNode = reverseList(next);
        next.next = head;
        head.next = null;

        return listNode;
    }

    //堆栈
    public ListNode reverseList2(ListNode head) {
        if(head==null) return null;
        Stack<ListNode> stack = new Stack<ListNode>();
         ListNode node = head;
         while (node!=null){
             stack.push(node);
             node = node.next;
         }
         ListNode newHead = stack.pop();
         ListNode newNode = newHead;
         while(stack.isEmpty()==false){
             newNode.next = stack.pop();
             newNode = newNode.next;
         }
         newNode.next = null;
         return newHead;
    }

    //两个链表
    public ListNode reverseList3(ListNode head) {
        ListNode newHead = null;
        while (head!=null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;


    }

}