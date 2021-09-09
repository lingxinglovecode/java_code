package Practice;

import org.junit.Test;

import java.util.*;

/**
 * @author lianxing
 * @create 2021-09-07 12:40
 */
public class HashPrac {


    @Test
    public void hashTest(){
        HashMap<String, Integer> hashMap1 = new HashMap<String,Integer>();
        hashMap1.put("test1",1);
        hashMap1.put("test2",2);
        hashMap1.put("test3",3);

        //遍历key
        System.out.println("遍历key");
        Set<String> keys = hashMap1.keySet();
        for(String str : keys){
            System.out.println(str);
        }

        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历value
        System.out.println("遍历value");
        Collection<Integer> values = hashMap1.values();
        for (Integer i:values){
            System.out.println(i);
        }
        Iterator<Integer> iterator1 = values.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历key-value
        System.out.println("遍历所有key-value");
        Set<Map.Entry<String, Integer>> entries = hashMap1.entrySet();
        for (Map.Entry entry:entries){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        Iterator<Map.Entry<String, Integer>> iterator2 = entries.iterator();
        while (iterator2.hasNext()){
            Map.Entry entry1 = iterator2.next();
            System.out.println(entry1.getKey()+":"+entry1.getValue());
        }


    }

}
