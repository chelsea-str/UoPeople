import java.util.*;

class Student {
    /*
    private instance variables for storing student information such as name, ID, age, and grade. These variables cannot
    be accessed outside the Student class
     */
    private int ID;
    private String name;
    private int age;
    private int grade;

    Student(int ID, String name, int age, int grade) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    // Public getter and setter methods to access the private name, age, and grade variables
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

public class StudentManagement {
    // Private static constant Map to store student records with Student ID as the key
    private static final Map<String, Student> RECORDS = new HashMap<>();
    // Private static Scanner object to handle user input
    private static final Scanner scanner = new Scanner(System.in);

    // Static block to initialize some default student records when the class is loaded
    static {
        RECORDS.put("1", new Student(1, "Renaldo Swanepoel", 27, 95));
        RECORDS.put("2", new Student(2, "Chelsea Strooh", 25, 90));
        RECORDS.put("3", new Student(3, "John Smith", 17, 60));

    }

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Information");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            option = scanner.nextInt();
            scanner.nextLine();

            String entry;
            switch (option) {
                case 1:
                    System.out.println("\nADDING");

                    System.out.print("Enter the Student ID: ");
                    entry = scanner.nextLine();
                    int ID = Integer.parseInt(entry);

                    Student addedStudent = RECORDS.get(entry);

                    if (addedStudent != null) {
                        System.out.println("Student already exists!");

                    } else {
                        System.out.print("Enter the Students name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter the Students age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter the Students grade: ");
                        int grade = scanner.nextInt();
                        scanner.nextLine();

                        RECORDS.put(entry, new Student(ID, name, age, grade));
                        System.out.println(name + " added to the records.");
                    }
                    break;
                case 2:
                    int update;
                    System.out.println("\nUPDATING");

                    System.out.print("Enter the student ID: ");
                    entry = scanner.nextLine();

                    Student updatedStudent = RECORDS.get(entry);

                    System.out.println("\nChanging information for " + updatedStudent.getName() + ". Which entry is to be update?");
                    System.out.println("1. Name");
                    System.out.println("2. Age");
                    System.out.println("3. Grade");
                    System.out.print("Enter your choice (1-3): ");

                    update = scanner.nextInt();
                    scanner.nextLine();

                    switch (update) {
                        case 1:
                            System.out.println("\nEnter new name:");
                            String newName = scanner.nextLine();
                            String oldName = updatedStudent.getName();
                            updatedStudent.setName(newName);
                            System.out.println("Student name changed from " + oldName + " to " + newName);
                            break;
                        case 2:
                            System.out.println("\nEnter new age:");
                            int newAge = scanner.nextInt();
                            int oldAge = updatedStudent.getAge();
                            updatedStudent.setAge(newAge);
                            System.out.println("Student age changed from " + oldAge + " to " + newAge);
                            break;
                        case 3:
                            System.out.println("\nEnter new grade:");
                            int newGrade = scanner.nextInt();
                            int oldGrade = updatedStudent.getGrade();
                            updatedStudent.setGrade(newGrade);
                            System.out.println("Student grade changed from" + oldGrade + " to " + newGrade);
                            break;
                        default:
                            System.out.println("Invalid option. Please enter a number between 1 and 3.");
                    }
                    break;
                case 3:
                    System.out.println("\nVIEWING");

                    System.out.print("Enter the student ID: ");
                    entry = scanner.nextLine();

                    Student viewingStudent = RECORDS.get(entry);

                    if (entry != null) {
                        System.out.println("Name: " + viewingStudent.getName() + "\nAge: " + viewingStudent.getAge() + "\nGrade: " + viewingStudent.getGrade());
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 4.");
            }

        } while (option != 4);
    }
}