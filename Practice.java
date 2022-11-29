package Day1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice {
    List<Student> list=new ArrayList<Student>();

    @Before
    public void creatList(){
        Student stu1=new Student("张三",18);
        Student stu2=new Student("李四",19);
        Student stu3=new Student("王五",17);
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
    }

    @Test  //StringJoiner
    public void Test1(){
        StringJoiner stringJoiner=new StringJoiner(",","[","]");
        for(Student stu:list){
            stringJoiner.add(stu.getName());
        }
        System.out.println(stringJoiner); //[张三,李四,王五]
    }

    @Test   //Lambda表达式简化匿名内部类书写
    public void Test2(){
        Collections.sort(list,(o1, o2)-> o1.getAge()-o2.getAge());
        for(Student stu:list){
            System.out.println("{"+stu.getName()+stu.getAge()+"}");
        }
    }

    @Test  //利用Stream流实现...
    public  void Test3(){
        String str=list.stream()
                .map(Student::getName)
                .collect(Collectors.joining(",","[","]"));
        System.out.println(str);
    }

    @Test
    public void Test4(){
        String str= IntStream.range(0, list.size())
                .mapToObj(i->list.get(i).getName())
                .collect(Collectors.joining(",","[","]"));
        System.out.println(str);
    }
}
