package Unit4;

/*
I created a class called "Book" as I would need subroutines to get the title, author, and quantity of each book object
in order to determine availability and calculate quantity
 */
class Book {
    private int quantity;
    private String author;
    private String title;

    public Book(String title, String author, int quantity) {
        this.author = author;
        this.title = title;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
