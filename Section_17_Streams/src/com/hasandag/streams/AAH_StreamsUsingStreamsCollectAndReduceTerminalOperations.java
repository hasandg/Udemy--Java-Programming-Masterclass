package com.hasandag.streams;

import com.hasandag.streams.model.Course;
import com.hasandag.streams.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AAH_StreamsUsingStreamsCollectAndReduceTerminalOperations {

    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass");
        Course jmc= new Course("JMC", "Java Masterclass");

        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                        .limit(1000)
                        .toList();

        Set<Student> australianStudents = students.stream()
                .filter((s) -> s.getCountryCode().equals("AU"))
                .collect(Collectors.toSet());
        System.out.println("# of Australian Students = " + australianStudents.size());

        Set<Student> underThirty = students.stream()
                .filter((s) -> s.getAgeEnrolled() < 30)
                .collect(Collectors.toSet());
        System.out.println("# of Under Thirty Students = " + underThirty.size());

        Set<Student> youngAussies1 = new TreeSet<>(Comparator.comparing(
                Student::getStudentId));
        youngAussies1.addAll(australianStudents);
        youngAussies1.retainAll(underThirty); // holds only both sets have same elements
        youngAussies1.forEach((s) -> System.out.print(s.getStudentId() + " "));
        System.out.println();

        Set<Student> youngAussies2 = students.stream()
                .filter((s) -> s.getAgeEnrolled() < 30)
                .filter((s) -> s.getCountryCode().equals("AU"))
                //.collect(Collectors.toSet()); // not sorted !!!
                .collect(() -> new TreeSet<>(Comparator.comparing(
                        Student::getStudentId)), TreeSet::add, TreeSet::addAll);  //sorted and more flexible!!!
                                                                                // more exercise for the needed

        youngAussies2.forEach((s) -> System.out.print(s.getStudentId() + " "));
        System.out.println();

        String countryList = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .reduce("", (r, v) -> r + " " + v);
        System.out.println("countryList = " + countryList);

    }

}
