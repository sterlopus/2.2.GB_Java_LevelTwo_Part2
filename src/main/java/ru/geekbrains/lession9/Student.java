package ru.geekbrains.lession9;

import java.util.List;
import java.util.Objects;

public class Student {

//        @lombok.Getter
        private String name;
        private List<Course> allCourses;


    public Student(String name, List<Course> allCourses) {
        this.name = name;
        this.allCourses = allCourses;
    }

    public String getName() {
        return name;
    }

    public List<Course> getAllCourses() {
        return this.allCourses;
    }

    @Override
    public String toString() {
        return name + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(allCourses, student.allCourses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, allCourses);
    }
}
