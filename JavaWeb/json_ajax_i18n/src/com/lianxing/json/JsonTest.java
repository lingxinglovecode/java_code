package com.lianxing.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lianxing.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lianxing
 * @description
 * @create 2021-10-26 8:53
 */
public class JsonTest {


    @Test
    public void test1(){
        //1.javaBean与json相互转换
        Person person = new Person(1,"泥");
        //创建Gson实例
        Gson gson = new Gson();
        //tojson对象可以将java对象转换为json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);
        //fromJson将json字符串转换为java对象 【json字符串，对象类型】
        gson.fromJson(personJsonString,Person.class);

    }
    @Test
    public void test2(){
        //2.List与json之间的互转
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1,"康师傅"));
        personList.add(new Person(2,"泥"));
        //List转换为json字符串
        Gson gson = new Gson();
        String peronListJsonString = gson.toJson(personList);
        System.out.println(peronListJsonString);

        //json字符串转换为List 需要创建对象继承type类
//        List<Person> personList2 = gson.fromJson(peronListJsonString, new PersonListType().getType());
        List<Person> personList2 = gson.fromJson(peronListJsonString, new TypeToken<ArrayList <Person>>(){}.getType());
        Person person = personList2.get(1);
        System.out.println(person);

    }

    @Test
    public void test3(){
        //3.Json与map之间的相互转换
        Map<Integer,Person> personMap = new HashMap<>();
        personMap.put(1, new Person(1,"Ni"));
        personMap.put(2, new Person(2,"Wo"));

        Gson gson = new Gson();
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);

//        Map<Integer,Person> personMap2 = gson.fromJson(personMapJsonString, new PersonMapType().getType());
        //使用匿名内部类
        Map<Integer,Person> personMap2 = gson.fromJson(personMapJsonString, new TypeToken<HashMap<Integer,Person>>(){}.getType());
        System.out.println(personMap2);
        Person person = personMap2.get(2);
        System.out.println(person);

    }


}
