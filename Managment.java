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
        String title = kb.nextLine();
        System.out.print("Book Author: ");
        String author = kb.nextLine();
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

    public static int searchLibrary(ArrayList<Library> libraryArray, String location) {
        int index = -1;
        for(int i = 0; i < libraryArray.size(); i ++) {
            String current = libraryArray.get(i).getLocation();
            current = current.toLowerCase();
            location = location.toLowerCase();
            if (current.equalsIgnoreCase(location)) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public static void updateBook(ArrayList<Book> bookArray, ArrayList<Library> libraryArray, String title, Scanner kb) {
        int index = searchBook(bookArray, title);
        int choice;
        if (index == -1) {
            System.out.println("Book not found");
        } else {
        bookArray.get(index).getInfo();
        do{
            printUpdateMenu();
            choice = readMenuChoice(kb);
            switch (choice) {
                case 1:
                    System.out.println("New title: ");
                    kb.nextLine();
                    String newTitle = kb.nextLine();
                    bookArray.get(index).setName(newTitle);
                    break;
                case 2:
                    System.out.println("New Author: ");
                    kb.nextLine();
                    String newAuthor = kb.nextLine();
                    bookArray.get(index).setAuthor(newAuthor);
                    break;
                case 3:
                    System.out.println("Lenght: ");
                    int newLength = kb.nextInt();
                    bookArray.get(index).setLength(newLength);
                    break;
                case 4:
                    System.out.println("Location: ");
                    kb.nextLine();
                    String location = kb.nextLine();
                    int libraryIndex = searchLibrary(libraryArray, location);
                    if (libraryIndex == -1) {
                        System.out.println("Library not found");
                    } else {
                        libraryArray.get(libraryIndex).addBook(bookArray.get(index));
                        System.out.println("Book " + bookArray.get(index).getName() + " has been added too library at " + libraryArray.get(libraryIndex).getLocation());
                    }
                    break;
                case 5:
                    System.out.println("Update borrower: ");
                    kb.nextLine();
                    String newBorrower = kb.nextLine();
                    bookArray.get(index).setBorower(newBorrower);
                    break;
                case 6:
                    System.out.println("Set genre: ");
                    kb.nextLine();
                    String newGenre = kb.nextLine();
                    bookArray.get(index).setGenre(newGenre);
                    break;
            }
        } while(choice != 9);
        
        }
    }

    public static int readMenuChoice(Scanner kb){
        int choice = kb.nextInt();
        return choice;
    }

    public static void printUpdateMenu(){
        System.out.println("===============================");
        System.out.println("1.) title");
        System.out.println("2.) author");
        System.out.println("3.) length");
        System.out.println("4.) location");
        System.out.println("5.) borrower");
        System.out.println("6.) genre");
        System.out.println("9.) exit");
        System.out.println("===============================");
        System.out.print("what would you like to update: ");
    }

    public static void printMenuMain(){
            System.out.println("===============================");
            System.out.println("1.) add book");
            System.out.println("2.) checkout");
            System.out.println("3.) return");
            System.out.println("4.) update book");
            System.out.println("5.) Search");
            System.out.println("6.) see book info"); // maybe redundent
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
                    kb.nextLine();
                    bookArray.add(addBook(kb));
                    // System.out.println(bookArray);
                    break;
                case 2:
                    System.out.print("Book title: ");
                    kb.nextLine();
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
                    kb.nextLine();
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
                    System.out.print("Book title: ");
                    kb.nextLine();
                    String updateTitle = kb.nextLine();
                    updateBook(bookArray, libraryArray, updateTitle, kb);
                    break;
                case 5:
                    System.out.println("Search for a book");
                    System.out.print("Book title: ");
                    kb.nextLine();
                    String searchTitle = kb.nextLine();
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