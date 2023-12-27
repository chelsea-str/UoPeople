package Unit5;

import java.util.HashMap;
import java.util.Map;

/*/
The CourseManagement class provides static methods for managing courses, student enrollment,
grade assignments, and overall course grades for students.
 /*/
class CourseManagement {
    // Static map to store courses with their codes as keys
    static Map<String, Course> courses = new HashMap<>();

    // Static map to store overall grades for students with their IDs as keys
    static Map<String, Double> overallGrades = new HashMap<>();

    // Static method to add new courses
    public static void addCourse(String courseCode, String courseName, int maxCapacity) {
        Course newCourse = new Course(courseCode, courseName, maxCapacity);
        courses.put(courseCode, newCourse);
    }

    // Static method to enroll students
    public static boolean enrollStudent(Student student, Course course) {
        if (course.enrollStudent()) {
            student.enrollInCourse(course);
            return true;
        } else {
            return false;
        }
    }

    // Static method to assign grades
    public static void assignGrade(Course course, double grade) {
        course.setGrade(grade);
    }

    // Static method to calculate overall course grades for each student
    public static double calculateOverallGrade(Student student) {
        double overallGrade = 0;
        int totalCourses = student.getEnrolledCourses().size();

        for (Course course : student.getEnrolledCourses().values()) {
            overallGrade += course.getGrade();
        }

        overallGrades.put(student.getStudentId(), overallGrade / totalCourses);
        return overallGrades.get(student.getStudentId());
    }
}
