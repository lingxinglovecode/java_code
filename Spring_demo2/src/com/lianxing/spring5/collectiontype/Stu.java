package com.lianxing.spring5.collectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lianxing
 * @description
 * @create 2021-10-30 16:28
 */
public class Stu {

    private String[] courses;
    private List<String> list;

    @Override
    public String toString() {
        return "Stu{" +
                "courses=" + Arrays.toString(courses) +
                ", list=" + list +
                ", maps=" + maps +
                ", sets=" + sets +
                ", courseList=" + courseList +
                '}';
    }

    private Map<String,String> maps;
    private Set<String> sets;
    private List<Course> courseList;

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }


}
