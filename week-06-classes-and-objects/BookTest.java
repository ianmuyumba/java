// Task 2: test driver for Book.
public class BookTest {
    public static void main(String[] args) {
        Book myBook = new Book("Java Programming", "John Doe", 1500.00);
        myBook.displayBookInfo();

        System.out.println("Attempting to change price to -500...");
        myBook.setPrice(-500);             // rejected, price stays 1500

        System.out.println("\nBorrowing the book...");
        myBook.borrowBook();
        myBook.borrowBook();               // second borrow is refused
        myBook.displayBookInfo();

        System.out.println("Returning the book...");
        myBook.returnBook();
        myBook.displayBookInfo();
    }
}
