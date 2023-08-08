package org.example.GradeCalculator;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;

//    private final List<Course> courses; // 이수 과목

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    public GradeCalculator(Courses courses) {
        this.courses = courses;
    }


    public double calculateGrade() {

        // 평균학점 계산 방법 = (학점 수 x 교과목 평점)의 합계 / 수강신청 총 학점 수

        // 1. (학점수 x 교과목 평점)의 합계
        // 1-1. Getter 사용
//        double multipliedCreditAndCourseGrade = 0;
//        for(Course course : courses) {
//            multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
//        }

        // 1-2. 메소드 사용
//        for (Course course : courses) {
//            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
//        }

        // 1-3. 일급 컬렉션 사용
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();


        // 2. 수강신청 총 학점 수
        // 2-1. Getter 방식 사용
//        int totalCompletedCredit = courses.stream()
//                .mapToInt(course -> course.getCredit())
//                .sum();

        // 2-2. 일급 컬렉션 사용
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();

        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
