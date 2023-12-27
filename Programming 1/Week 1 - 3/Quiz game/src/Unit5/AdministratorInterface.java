package Unit5;

import java.util.Scanner;

// Administrator Interface
public class AdministratorInterface {
    public static void displayMenu() {
        System.out.println("Administrator Interface:");
        System.out.println("1. Add a new course");
        System.out.println("2. Enroll students");
        System.out.println("3. Assign grades");
        System.out.println("4. Calculate overall course grades");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice (1-5): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter maximum capacity: ");
                    int maxCapacity = Integer.parseInt(scanner.nextLine());
                    CourseManagement.addCourse(courseCode, courseName, maxCapacity);
                    System.out.println("Course: " + courseName + " added successfully.");
                    System.out.println();
                    break;

                case "2":
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    Student student = new Student(studentName, studentId);

                    System.out.print("Enter course code to enroll student: ");
                    String courseToEnroll = scanner.nextLine();
                    Course course = CourseManagement.courses.get(courseToEnroll);

                    if (course != null) {
                        boolean success = CourseManagement.enrollStudent(student, course);
                        if (success) {
                            System.out.println("Student enrolled successfully.");
                            System.out.println();
                        } else {
                            System.out.println("Course has reached its maximum capacity. Enrollment failed.");
                            System.out.println();
                        }
                    } else {
                        System.out.println("Invalid course code. Enrollment failed.");
                        System.out.println();
                    }
                    System.out.println();
                    break;

                case "3":
                    System.out.print("Enter student ID: ");
                    String studentIdForGrade = scanner.nextLine();
                    Student studentToGrade = Course.getEnrolledStudents().get(studentIdForGrade);
                    System.out.print("Enter course code: ");
                    String courseCodeToGrade = scanner.nextLine();
                    Course courseToGrade = studentToGrade.getEnrolledCourses().get(courseCodeToGrade);
                    System.out.print("Enter course grade: ");
                    double gradeToAssign = scanner.nextDouble();
                    CourseManagement.assignGrade(courseToGrade, gradeToAssign);
                    System.out.println("Grade assigned successfully.");
                    System.out.println();
                    break;

                case "4":
                    System.out.print("Enter student ID to calculate overall course grade: ");
                    String studentIdForOverallGrade = scanner.nextLine();
                    Student studentForOverallGrade = Course.getEnrolledStudents().get(studentIdForOverallGrade);
                    double overallGrade = CourseManagement.calculateOverallGrade(studentForOverallGrade);
                    System.out.printf("Overall course grade for student %s: %.2f\n", studentIdForOverallGrade, overallGrade);
                    System.out.println();
                    break;

                case "5":
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    System.out.println();
                    break;
            }
        }
    }
}
