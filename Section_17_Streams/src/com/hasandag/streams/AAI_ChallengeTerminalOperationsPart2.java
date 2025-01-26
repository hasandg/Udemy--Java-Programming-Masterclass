package com.hasandag.streams;

import com.hasandag.streams.model.Course;
import com.hasandag.streams.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AAI_ChallengeTerminalOperationsPart2 {

    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass",50);
        Course jmc= new Course("JMC", "Java Masterclass", 100);
        Course cgj= new Course("CGJ", "Creating Games in Java");

        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(jmc, pymc, cgj))
                        .limit(5000)
                        .toList();

        Double totalPercentice =        students.stream()
                .map(student -> student.getPercentComplete("JMC"))
                .reduce((percentComplete,total) -> percentComplete+total)
                .orElse(0.0);
        System.out.println("Average percent complete for JMC = " + totalPercentice/students.size());

    }

}
