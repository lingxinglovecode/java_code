package java_test;

import java.util.Arrays;

public class java_test1 {
    public static void main(String[] args) {
        int a = 1;
        System.out.println("a = " + a);
        System.out.println();
        System.out.println();

        Circle.show();

        int[] b = {1,2};
        Arrays.sort(b);
        System.out.println(b);


    }
}


class Shape{
    static {
        System.out.println("shape类静态代码块");
    }
    static int a = 1;
    int c = 2;

    {
        System.out.println("shape类代码块");
    }
    public Shape() {
        System.out.println("shape类构造器");
    }

}

class Circle extends Shape{

    int s = 0;
    static {
        System.out.println("circle类静态代码块");
    }
    {
        System.out.println("circle类代码块");
    }
    public Circle(){
        System.out.println("circle类构造器");
    }
    public static void show(){
        System.out.println("show");
    }

}
