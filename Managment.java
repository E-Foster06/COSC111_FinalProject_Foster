import java.util.ArrayList;
import java.util.Scanner;
public class Managment {

    /** addBook(Scanner kb) - creates a book object with user defined title and author
     * @param kb - scanner for reading input
     * @return book - a book object
     */
    public static Book addBook(Scanner kb) {
        // Scanner kb = new Scanner(System.in);
        System.out.print("Book Title: ");
        String title = kb.next();
        System.out.print("Book Author: ");
        String author = kb.next();
        Book book = new Book(title, author);
        // book.getName();
        return book;
    }

    /** addLibrary(Scanner kb) - creates a library object
     * @param kb - scanner object
     * @return library - a library object
     */
    public static Library addLibrary(Scanner kb) {
        System.out.print("Library location: ");
        String location = kb.next();
        System.out.print("Number of shelfs: ");
        int shelfs = kb.nextInt();
        Library library = new Library(location, shelfs);
        return library;
    }

    /** searchBook(ArrayList<Book> bookArray, String title) - search the book array for a book with a specific title
     * @param bookArray - an arraylist with type book that is searched
     * @param title - the title to search for
     * @return index - the index of the searched book in the array
     */
    public static int searchBook(ArrayList<Book> bookArray, String title) {
        int index = -1;
        for(int i = 0; i < bookArray.size(); i ++) {
            String current = bookArray.get(i).getName();
            current = current.toLowerCase();
            title = title.toLowerCase();
            if (current.equalsIgnoreCase(title)) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public static int readMenuChoice(Scanner kb){
        
        int choice = kb.nextInt();
        return choice;
    }

    public static void printMenuMain(){
            System.out.println("===============================");
            System.out.println("1.) add book");
            System.out.println("2.) checkout");
            System.out.println("3.) return");
            System.out.println("4.) update book");
            System.out.println("5.) Search");
            System.out.println("6.) see book info");
            System.out.println("7.) cataloge");
            System.out.println("8.) add library");
            System.out.println("9.) exit");
            System.out.println("===============================");
            System.out.print("What: ");
    }
    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ArrayList<Book> bookArray = new ArrayList<>(); // book array
        ArrayList<Library> libraryArray = new ArrayList<>(); // library array
        int choice;
        int searchedIndex = -1;
        do {
            printMenuMain();
            choice = readMenuChoice(kb);
            switch (choice) {
                case 1: 
                    bookArray.add(addBook(kb));
                    // System.out.println(bookArray);
                    break;
                case 2:
                    System.out.print("Book title: ");
                    String checkoutTitle = kb.next();
                    searchedIndex = searchBook(bookArray, checkoutTitle);
                    if (searchedIndex == -1) {
                        System.out.println("Book not found");
                    } else if (bookArray.get(searchedIndex).getAvailable() == false) {
                        System.out.println("Book: " + checkoutTitle + " is not available");
                    }
                    else {
                    bookArray.get(searchedIndex).setAvailable(false);
                    System.out.println("Book: " + checkoutTitle + " Has been checked out");
                    }
                    break;                    
                case 3:
                    System.out.print("Book title: ");
                    String returnTitle = kb.next();
                    searchedIndex = searchBook(bookArray, returnTitle);
                    if (searchedIndex == -1) {
                        System.out.println("Book not found");
                    } else if (bookArray.get(searchedIndex).getAvailable() == true) {
                        System.out.println("Book: " + returnTitle + " was already returned");
                    }
                    else {
                    bookArray.get(searchedIndex).setAvailable(true);
                    System.out.println("Book: " + returnTitle + " Has been returned");
                    }
                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Search for a book");
                    System.out.print("Book title: ");
                    String searchTitle = kb.next();
                    searchedIndex = searchBook(bookArray, searchTitle);
                    if (searchedIndex == -1) {
                        System.out.println("Book not found");
                    } else {
                    bookArray.get(searchedIndex).getInfo();
                    }
                    break;
                case 6:

                    break;
                case 7:
                    break;
                case 8:
                    libraryArray.add(addLibrary(kb));
                    break;
                
            }
        } while (choice != 9);

        kb.close();
    }
}