package com.lianxing.spring5.factorybean;

import com.lianxing.spring5.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author lianxing
 * @description
 * @create 2021-10-30 20:18
 */
public class MyBean implements FactoryBean<Course> {


    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("test");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
