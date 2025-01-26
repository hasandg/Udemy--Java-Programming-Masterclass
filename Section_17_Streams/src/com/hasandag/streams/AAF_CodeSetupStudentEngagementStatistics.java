package com.hasandag.streams;

import com.hasandag.streams.model.Course;
import com.hasandag.streams.model.Student;

import java.time.LocalDate;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

public class AAF_CodeSetupStudentEngagementStatistics {
    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");
        Student tim = new Student("AU", 2024, 30, "M",
                true, jmc, pymc);

//        System.out.println(tim);
//
//        tim.watchLecture("JMC", 10, 5, 2024);
//        tim.watchLecture("PYMC", 7, 7, 2024);
//        System.out.println(tim);

        List<Student> students =  Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(10)
                .toList();

        //How many male and female students are in the group.
        long male = students
                .stream()
                .filter(s -> "M".equals(s.getGender()))
                .count();

        long female = students
                .stream()
                .filter(s -> "F".equals(s.getGender()))
                .count();

        System.out.println(male);
        System.out.println(female);

        // How many students fall into the three age ranges, less than age 30, between 30 and 60, over 60 years old.
        long less30 = students
                .stream()
                .filter(s -> s.getAgeEnrolled() < 30)
                .count();
        long between30and60 = students
                .stream()
                .filter(s -> s.getAgeEnrolled() >= 30 && s.getAgeEnrolled() <= 60)
                .count();

        long more60 = students
                .stream()
                .filter(s -> s.getAgeEnrolled() > 60)
                .count();

        // Use summaryStatistics on the student's age, to get a better idea of how old the student population is.
        IntSummaryStatistics intSummaryStatistics = students
                .stream()
                .mapToInt(Student::getAge)
                .summaryStatistics();

        System.out.println("intSummaryStatistics = " + intSummaryStatistics);

        // What countries are the students from?  Print a distinct list of the country codes.
        students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .forEach(System.out::println);

        //Are there students that are still active and have been enrolled for more than 7 years?
        // Use one of the match terminal operations to answer this question.
        List<Student> loyalStudents = students.stream()
                .filter(student -> !student.getEngagementMap().isEmpty())
                .filter(student -> student.getYearEnrolled() < LocalDate.now().getYear() - 7)
                .toList();

        System.out.println(loyalStudents.size());

        System.out.println("------------------------------------");

         loyalStudents.forEach(System.out::println);

        System.out.println("------------------------------------");

        // Next, select 5 of the students above and print their information out.
        loyalStudents.stream()
                .limit(5)
                .forEach(System.out::println);



    }
}
