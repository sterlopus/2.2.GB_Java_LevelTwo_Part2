package ru.geekbrains.lession9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class lession9 {


    public static void main(String[] args) {

        // data
        Course course0 = new Course("Java4Beginners");
        Course course1 = new Course("Java4Testers");
        Course course2 = new Course("JavaCore");
        Course course3 = new Course("JavaLevel2");
        Course course4 = new Course("JavaLevel3");
        Course course5 = new Course("JavaGodMode");

        List<Course> courses = Arrays.asList(course0, course1, course2, course3, course4, course5);
        //думал использовать готовый list для манипуляций с ним (например, набивать student, но оказалось,
        // что с ним намного менее удобно работать когда нужна выборка, чем с массивом
        // не пригодился =)


        Student student0 = new Student("Johnson", Arrays.asList(course1, course2, course3, course4, course5));
        Student student1 = new Student("Jackson", Arrays.asList(course1, course2, course3, course4));
        Student student2 = new Student("Billson", Arrays.asList(course1, course2, course3));
        Student student3 = new Student("Fredson", Arrays.asList(course1, course2));
        Student student4 = new Student("Tompson", Arrays.asList(course1));
        Student student5 = new Student("Duckson", Arrays.asList(course1, course2, course3, course4));
        List<Student> students = Arrays.asList(student0, student1, student2, student3, student4, student5);


        //  body
        System.out.println("All unique courses - " + uniqueCourses(students));
        System.out.println("Most curious students are: " + curiousStudents(students));
        System.out.println("Course " + course3 + " is attended by students: " + studentsByCourse(students, course3));


    }

        // methods
    public static List<Course> uniqueCourses (List<Student> students) {
            return students.stream()
                    .flatMap(student -> student.getAllCourses().stream())
                    .distinct()
                    .collect(Collectors.toList());
    }

    public static List<Student> curiousStudents (List<Student> students){
            return students.stream()
                    .sorted((stud1, stud2) -> (stud2.getAllCourses().size()) - stud1.getAllCourses().size())
                    .limit(3)
                    .collect(Collectors.toList());
    }

    public static List<Student> studentsByCourse (List<Student> students, Course course){
            return students.stream()
                    .filter(student -> student.getAllCourses().contains(course))
                    .collect(Collectors.toList());
    }

}


/**
 * Имеется следующая структура:
 *
 *    interface Student {
 *         String getName();
 *         List<Course> getAllCourses();
 *     }
 *     interface Course {}
 *
 * 1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов,
 *    на которые подписаны студенты.
 *
 * 2. Написать функцию, принимающую на вход список Student и возвращающую список
 *    из трех самых любознательных (любознательность определяется количеством курсов).
 *
 * 3. Написать функцию, принимающую на вход список Student и экземпляр Course,
 *    возвращающую список студентов, которые посещают этот курс.
 */