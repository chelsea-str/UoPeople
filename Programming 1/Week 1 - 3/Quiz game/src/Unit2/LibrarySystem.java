package Unit2;

import java.util.*;

/*
I used a HashMap as this apparently is the most appropriate method to use. Initially I thought I could use a
dictionary (because I am used to Python), but then found out a HashMap is a similar data structure that implements
key-value pairs
 */
public class LibrarySystem {
    private static final Map<String, Book> LIBRARY = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> BOOK_TITLE = new ArrayList<>();

    static {
        // Pre-add some books to the library
        LIBRARY.put("Flowers for Algernon", new Book("Flowers for Algernon", "Daniel Keyes", 5));
        LIBRARY.put("The Elephant Whisperer", new Book("The Elephant Whisperer", "Anthony Lawrence", 7));
        LIBRARY.put("No Place Like Home", new Book("No Place Like Home", "Anthony Lawrence", 4));
        LIBRARY.put("Listening to the Animals: Becoming The Supervet", new Book("Listening to the Animals: Becoming " +
                "The Supervet", "Noel Fitzpatrick", 5));

        BOOK_TITLE.addAll(LIBRARY.keySet());
    }

    public static void main(String[] args) {
        int option;

        /*
        the do...while loop is used so that the menu option reappears after each completion of the input choice selection
         */
        do {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            option = scanner.nextInt();
            scanner.nextLine();

            String title;
            //switch case for each option to choose from the menu
            switch (option) {
                case 1:
                    System.out.println("\nADDING");

                    System.out.print("Enter the book title: ");
                    title = scanner.nextLine().toLowerCase();

                    System.out.print("Enter the author: ");
                    String author = scanner.nextLine().toLowerCase();

                    System.out.print("Enter the quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    Book addedBook = LIBRARY.get(title);
                    /*
                    The if-else statements determines if the book already exists, and if so, add the inputted value to
                    the existing quantity. If it does not, a new Unit4.Book object is created with all the specified
                    parameters
                     */
                    if (addedBook != null) {
                        addedBook.setQuantity(addedBook.getQuantity() + quantity);
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
                        System.out.println("Unit4.Book not found: " + title);
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
                        System.out.println("Unit4.Book not found: " + title);
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

