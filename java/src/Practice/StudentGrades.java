package Practice;

import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @author lianxing
 * @create 2021-09-06 15:13
 */
public class StudentGrades {

    public static void main(String[] args) {
        Student s1 = new Student("xiaoming",98,2313);
        Student s2 = new Student("xiaoli",89,4313);
        Student s3 = new Student("xiaowang",100,2413);
        Student s4 = new Student("xiaoniu",96,1243);
        Student s5 = new Student("xiaoji",96,2345);
        TreeSet students = new TreeSet();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        Iterator iterator = students.iterator();
        int num = 0;
        while (iterator.hasNext() && num<3){
            System.out.println(iterator.next());
            num++;
        }

    }
}





class Student implements Comparable{
    private String name;
    private int score;
    private int id;

    public Student(String name, int score, int id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int compareTo(Object o){
        try {
            if(o instanceof Student){
                Student stu = (Student)o;
                if (this.score > stu.getScore()){
                    return -1;
                }
                else if (this.score< stu.getScore()){return 1;}
                else{return this.id-stu.getId();}
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score && id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", id=" + id +
                '}';
    }
}