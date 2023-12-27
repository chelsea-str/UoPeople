package Unit5;

import java.util.HashMap;
import java.util.Map;


public class Student {
    /*/
    Private instance variables for name, ID, and enrolled courses. Enrolled courses is a map
    to store a list of courses one student may be taking at a time.
    /*/
    private String name;
    private String studentId;
    private Map<String, Course> enrolledCourses;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.enrolledCourses = new HashMap<>();
    }

    //Setter and getter methods for accessing and updating student information
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public Map<String, Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Method to get course code and add it to list of enrolled courses
    public void enrollInCourse(Course course) {
        enrolledCourses.put(course.getCourseCode(), course);
        Course.addStudentToCourse(this);
        Course.incrementTotalNumberOfEnrolledStudents();
    }
}


