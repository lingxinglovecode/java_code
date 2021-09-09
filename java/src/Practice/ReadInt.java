package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author lianxing
 * @create 2021-09-06 14:57
 */
public class ReadInt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请随机输入10个整数：");
        ArrayList list1 = new ArrayList();

        for (int i=0;i<10;i++) {
            list1.add(scanner.nextInt());
        }
        System.out.println("原来数组："+list1);
        System.out.println("倒序输出：");
        Collections.reverse(list1);
        System.out.println(list1);
        System.out.println("从大到小输出");
        Collections.sort(list1, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                return -((Integer) o1).compareTo((Integer)o2);
            }

        });

        System.out.println(list1);


    }

}
