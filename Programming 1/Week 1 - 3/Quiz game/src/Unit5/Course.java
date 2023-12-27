package Unit5;

import java.util.HashMap;
import java.util.Map;

class Course {
    /*/
   Private instance variables for course code, name, and maximum capacity. Static variable for total enrolled students
   to keep track across all instances of the Course class.
   /*/
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private double grade;

    // Static variable to keep track of the total number of enrolled students across all instances of the Course class
    public static int numberOfEnrolledStudents;

    // Static map to store enrolled students with their IDs as keys
    public static Map<String, Student> enrolledStudents = new HashMap<>();

    // Constructor to initialize a Course with the given code, name, and maximum capacity.
    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.numberOfEnrolledStudents = 0;
    }

    // Adds a student to the enrolled students map if the student is not already enrolled in the course.
    public static void addStudentToCourse(Student student) {
        if (!getEnrolledStudents().containsKey(student.getStudentId())) {
            getEnrolledStudents().put(student.getStudentId(), student);
        }
    }

    public static void setEnrolledStudents(Map<String, Student> enrolledStudents) {
        Course.enrolledStudents = enrolledStudents;
    }

    // Getter and setter methods for course information
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getNumberOfEnrolledStudents() {
        return numberOfEnrolledStudents;
    }

    public static Map<String, Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    // Method to enroll students in the course if less than maximum capacity
    public boolean enrollStudent() {
        return getNumberOfEnrolledStudents() < getMaxCapacity();
    }

    // Method to increment students once enrolled
    public static void incrementTotalNumberOfEnrolledStudents() {
        numberOfEnrolledStudents++;
    }
}
