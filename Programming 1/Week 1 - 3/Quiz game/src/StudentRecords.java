import java.util.*;

class Student {
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

    public int getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

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
    private static final Map<String, Book> RECORDS = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);


    static {
        // Pre-add some books to the library
        RECORDS.put("1", new Student(1, "Renaldo Swanepoel", 17));

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

            String title;
            switch (option) {
                case 1:
                    System.out.println("\nADDING");

                    System.out.print("Enter the Student ID: ");
                    ID = scanner.nextLine();

                    System.out.print("Enter the Students name:: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter the Students age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    Student addedStudent  = RECORDS.get(ID);
                    if (addedStudent != null) {
                        addedStudent.setID(addedStudent.getID());
                        System.out.println("Quantity updated for existing book: " + title);
                    } else {
                        LIBRARY.put(title, new Book(title, author, quantity));
                        System.out.println(title + " by " + author + " added to the library.");
                    }
                    break;
                case 2:
                    System.out.println("\nBORROWING");

                    System.out.println("Here is a list of all the books: ");
                    //for loop iterates through each object in the array to display the list of books to choose from
                    for (String bookTitle :
                            BOOK_TITLE) {
                        System.out.println(bookTitle);
                    }

                    System.out.print("Enter the book title: ");
                    title = scanner.nextLine().toLowerCase();

                    System.out.print("Enter the number of books to borrow: ");
                    int borrowQuantity = scanner.nextInt();
                    scanner.nextLine();

                    Book borrowedBook = LIBRARY.get(title);
                    /*
                    The if-else statements determines if the book already exists and in the quantity that the user wants.
                    If so, the inputted value is subtracted from the existing quantity. If it does not, an error
                    specifies that no more are available. Otherwise, if it is null, the book does not exist and an error
                    notifies the user
                     */
                    if (borrowedBook != null && borrowedBook.getQuantity() >= borrowQuantity) {
                        borrowedBook.setQuantity(borrowedBook.getQuantity() - borrowQuantity);
                        System.out.println("Remaining: " + borrowedBook.getQuantity());

                    } else if (borrowedBook != null) {
                        System.out.println("No books available for borrowing.");
                    } else {
                        System.out.println("Book not found: " + title);
                    }
                    break;
                case 3:
                    System.out.println("\nRETURNING");

                    System.out.print("Enter the book title: ");
                    title = scanner.nextLine().toLowerCase();

                    System.out.print("Enter the number of books to return: ");
                    int returnQuantity = scanner.nextInt();
                    scanner.nextLine();

                    Book returnedBook = LIBRARY.get(title);
                    /*
                    The if-else statements determines if the book already exists. If so, the inputted value is added to
                    the existing quantity. If it does not, an error. Otherwise, if it is null, the book does not exist
                    and an error notifies the user
                     */
                    if (returnedBook != null) {
                        returnedBook.setQuantity(returnedBook.getQuantity() + returnQuantity);
                        System.out.println(title + " returned." + returnedBook.getQuantity() + " remaining.");
                    } else {
                        System.out.println("Book not found: " + title);
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 4.");
            }

        } while (option != 4);
    }
}