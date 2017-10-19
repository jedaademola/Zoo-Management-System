package edu.mum.mpp.util;

import edu.mum.mpp.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;


public class TestLamdba {

    public static void main(String args[]) {
        //
        TriFunction<Integer, Integer, Integer, Integer> ff = (x, y, z) -> x + y + z;

        System.out.println(ff.apply(1, 2, 3));
        //

        Student s1 = new Student("stanley", 24, "MPP");
        Student s2 = new Student("lukman", 25, "MPP");

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

        students.forEach(s -> System.out.println(s.getName().toUpperCase()));

        // student -> new Comparator<>().compare(Student student1,Student student2)

        Collections.sort(
                students,
                Comparator.comparing(Student::getName)
        );

        System.out.println("Using Lambda method1");
        students.forEach(s -> System.out.println(s.getName().toUpperCase()));

        Collections.sort(
                students,
                (o1, o2) -> o1.getName().compareTo(o2.getName())

        );

        System.out.println("Using Lambda method2");
        students.forEach(s -> System.out.println(s.getName().toUpperCase()));


        Collections.sort(
                students,
                Comparator.comparing(Student::getAge)
        );

        System.out.println("Using Lambda method3");
        students.forEach(s -> System.out.println(s.getName().toUpperCase()));

        System.out.println("Using Function");
        //function interface
        for (Student s : students) {
            Function<Student, String> f = (ss) -> s.getName().toUpperCase();
            System.out.println(f.apply(s));
        }


    }
}
