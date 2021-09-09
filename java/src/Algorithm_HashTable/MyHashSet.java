package Algorithm_HashTable;

import org.junit.Test;

/**
 * @author lianxing
 * @create 2021-09-04 22:26
 */
public class MyHashSet {
    public static void main(String[] args) {
        myHashSet3 myhash = new myHashSet3();
        myhash.add(1);
        myhash.add(2);

        myhash.remove(2);
    }

    @Test
    public void TestArray(){

        class testCls{
            private int whatever = 0;
            private testCls next;
        }
        testCls[] a1 = new testCls[10];

        a1[0] = new testCls();
        a1[0].next = new testCls();
        testCls a2 = a1[0];
        testCls a3 = a1[0].next;
        a3 = null;
        a2.next = null;

        System.out.println(a1[0]);

    }


    @Test
    public void TestObjectArray(){

        class testCls{
            private int whatever = 0;
        }
        testCls[] a1 = new testCls[10];

        a1[0] = new testCls();
        testCls a2 = a1[0];

        a2 = null;
        System.out.println(a1[0]);

    }

}

class myHashSet1{

    boolean hashSet[] = new boolean[1000000];

    public myHashSet1() {
    }
    public void add(int key){
        hashSet[key] = true;

    }

    public void remove(int key) {
        hashSet[key] = false;

    }
    public boolean contains(int key){
        return hashSet[key]==true ? true : false;
    }

}

class myHashSet2{

    private Node[] nodes = new Node[10009];

    public static class Node{
        private int key;
        private Node next;

        public Node() {
        }

        private Node(int key){
            this.key = key;
        }

    }

    private int getIndex(int key){
        int hash = Integer.hashCode(key);
        hash ^= (hash>>>16);
        return hash % nodes.length;

    }


    public myHashSet2() {


    }
    public void add(int key){
        int index = getIndex(key);
        if(nodes[index]==null){
            nodes[index] = new Node(key);
            return;
        }
        Node prev = null;
        Node start = nodes[index];
        while (start !=null && start.key!=key){
            prev = start;
            start = start.next;
        }
        if(start!=null && start.key == key){return;}
        //尾部插入新的节点
        prev.next = new Node(key);

    }

    public void remove(int key) {
        int index = getIndex(key);
        Node start = nodes[index];
        Node prev = null;
        if(start == null){return;}
        if(start.key == key ){
//            nodes[index] = start.next == null ? null : start.next;
            start = start.next == null ? null : start.next;
            return;
        }


        while (start!=null){

            if (start.key == key){
                if (start.next == null){prev.next = new Node();}
                else {prev.next = start.next;}
                return;
            }
            prev = start;
            start = start.next;
        }
        return;
    }
    public boolean contains(int key){
        int index = getIndex(key);
        Node start = nodes[index];
        while (start!=null){
            if(start.key == key){
                return true;
            }
            start = start.next;
        }
        return false;
    }



}

class myHashSet2_simp{
    class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node[] nodes = new Node[10009];

    public void add(int key){
       int idx = getHash(key);
       Node loc = nodes[idx], tmp = loc;
       if (loc != null){
           Node prev = null;
           while (tmp != null){
               if (tmp.val == key){
                   return;
               }
               prev = tmp;
               tmp = tmp.next;
           }
           tmp = prev;
       }

       Node node = new Node(key);
       //头部插入
//        nodes[idx] = node;
//        node.next = loc;

        if(tmp == null){
            nodes[idx] = node;
        }
        else {
            tmp.next = node;
        }


    }

    public void remove(int key) {
        int idx = getHash(key);
        Node loc = nodes[idx];
        if (loc != null ){
            Node prev = null;
            while (loc!=null){
                if (loc.val == key){
                    if (prev != null){
                        prev.next = loc.next;

                    }
                    else {
                        nodes[idx] = loc.next;
                    }
                    return;
                }
                prev = loc;
                loc= loc.next;
            }
        }


    }
    public boolean contains(int key){
        int idx = getHash(key);
        Node loc = nodes[idx];
        if (loc != null ){
            while (loc!=null){
                if (loc.val == key){
                        return true;
                    }
                loc= loc.next;
            }
        }
        return false;
    }


    private int getHash(int key){
        int hash = key ^ key>>16;
        hash = hash % nodes.length;
        return hash;
    }




}


class myHashSet3{

    private int[] bucket =new int[40000];

    public void add(int key){
        int bucketId = key/32;
        int loc = key % 32;
        setVal(bucketId,loc,true);

    }

    public void remove(int key) {
        int bucketId = key/32;
        int loc = key % 32;
        setVal(bucketId,loc,false);

    }
    public boolean contains(int key){
        int bucketId = key/32;
        int loc = key % 32;
        return (bucket[bucketId] & (1<<loc)) != 0 ;
    }


    private void setVal(int bucketId,int loc,boolean add){
        if(add){
            bucket[bucketId] = bucket[bucketId] | (1<<loc);
        }
        else{
            bucket[bucketId] = bucket[bucketId] & ~(1<<loc);
        }



    }






}




