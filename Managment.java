/**
 * COSC 111 - Fall 2025
 * @author: Evelynn Foster
 * @version: 12/13/25 
 * Library mangment sofware
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Managment {

    /** addBook(Scanner kb) - creates a book object with user defined title and author
     * @param kb - scanner for reading input
     * @return book - a book object
     */
    public static Book addBook(Scanner kb) {
        System.out.print("Book Title: ");
        String title = kb.nextLine();
        System.out.print("Book Author: ");
        String author = kb.nextLine();
        Book book = new Book(title, author);
        return book;
    }

    /** addLibrary(Scanner kb) - creates a library object
     * @param kb - scanner object
     * @return library - a library object
     */
    public static Library addLibrary(Scanner kb) {
        System.out.print("Library location: ");
        kb.nextLine();
        String location = kb.nextLine();
        Library library = new Library(location);
        return library;
    }

    /** searchBook(ArrayList<Book> bookArray, String title) - search the book array for a book with a specific title
     * @param bookArray - an arraylist with type book that is searched
     * @param title - the title to search for
     * @return index - the index of the searched book in the array
     */
    public static int searchBook(ArrayList<Book> bookArray, String title) {
        int index = -1; // default for errors
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

    /** searchLibrary(ArrayList<Library> libraryArray, String location) - search an array list of library objects by their location
     * @param libraryArray - a libaray array list
     * @paramm location - the searched for item
     * @return index - the index of the library object with the location string
     */
    public static int searchLibrary(ArrayList<Library> libraryArray, String location) {
        int index = -1; // default for errors
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

    /** updateBook(ArrayList<Book> bookArray, ArrayList<Library> libraryArray, String title, Scanner kb) - update the param of book objects using a menu
     * @param bookArray - an array list of book objects
     * @param libraryArray - an array list of library objects
     * @param title - the name of the book object
     * @param kb - a scanner object reading keyboard input
     */
    public static void updateBook(ArrayList<Book> bookArray, ArrayList<Library> libraryArray, String title, Scanner kb) {
        int index = searchBook(bookArray, title); // find index of book to update
        int choice;
        if (index == -1) { // error handling
            System.out.println("Book not found");
        } else {
        bookArray.get(index).getInfo(); // show known info for user
        do{ // do while not 9
            printUpdateMenu(); // print menu methods
            choice = readMenuChoice(kb);
            switch (choice) {
                case 1: // update title
                    System.out.print("New Title: ");
                    kb.nextLine();
                    String newTitle = kb.nextLine();
                    bookArray.get(index).setName(newTitle);
                    break;
                case 2: // update author
                    System.out.print("New Author: ");
                    kb.nextLine();
                    String newAuthor = kb.nextLine();
                    bookArray.get(index).setAuthor(newAuthor);
                    break;
                case 3: // set length
                    System.out.print("Length: ");
                    int newLength = kb.nextInt();
                    bookArray.get(index).setLength(newLength);
                    break;
                case 4: // set library object location
                    System.out.print("Location: ");
                    kb.nextLine();
                    String location = kb.nextLine();
                    int libraryIndex = searchLibrary(libraryArray, location); // find library index
                    if (libraryIndex == -1) { // error handling
                        System.out.println("Library not found");
                    } else { // add book to library and tell the user that and update the param
                        libraryArray.get(libraryIndex).addBook(bookArray.get(index));
                        System.out.println("Book " + bookArray.get(index).getName() + " has been added too library at " + libraryArray.get(libraryIndex).getLocation());
                    }
                    break;
                case 5: // set borrower
                    System.out.print("Update Borrower: ");
                    kb.nextLine();
                    String newBorrower = kb.nextLine();
                    bookArray.get(index).setBorower(newBorrower);
                    break;
                case 6: // set genre
                    System.out.print("Set Genre: ");
                    kb.nextLine();
                    String newGenre = kb.nextLine();
                    bookArray.get(index).setGenre(newGenre);
                    break;
            }
        } while(choice != 9); // kept at 9 for menu consistancy
        
        }
    }

    /** printBookArray(ArrayList<Book> bookArray) - prints an arrayList of book objects with params
     * @param bookArray - an array list of book objects
     */
    public static void printBookArray(ArrayList<Book> bookArray){
        for(int i = 0; i < bookArray.size(); i++) {
            System.out.println("===============================");
            bookArray.get(i).getInfo();
            System.out.println("===============================");
        }
    }

    /** saveLoad(ArrayList<Book> bookArray, ArrayList<Library> libraryArray, Scanner kb) - save and load books and libraries from a save file
     * @param bookArray - an array list of book objects
     * @param libraryArray - an array list of library objects
     * @param kb - a scanner object
     */
    public static void saveLoad(ArrayList<Book> bookArray, ArrayList<Library> libraryArray, Scanner kb) {
        int choice;
        do {
            printSaveLoadMenu(); 
            choice = readMenuChoice(kb);
            switch (choice) {
                case 1: // save
                    try {
                        PrintWriter writer = new PrintWriter("LibrarySaveFile.txt"); 
                        writer.println("Librarys"); // header check for file reading
                        for(int i = 0; i < libraryArray.size(); i ++) {
                            writer.println(libraryArray.get(i).getLocation()); // saving the libraries
                            
                        }
                        
                        writer.println("Books"); // header for loading
                        for (int i = 0; i < bookArray.size(); i ++) {
                            writer.println(bookArray.get(i).getName()); // print all parms of book objects
                            writer.println(bookArray.get(i).getAuthor());
                            writer.println(bookArray.get(i).getLength());
                            String libLocation = "NONE"; // default value is null 
                            if (bookArray.get(i).getLocation() != null) {
                                libLocation = bookArray.get(i).getLocation().getLocation();
                            }
                            writer.println(libLocation);
                            writer.println(bookArray.get(i).getAvailable());
                            writer.println(bookArray.get(i).getBorower());
                            writer.println(bookArray.get(i).getGenre());
                            writer.println("Stop"); // load stop / marks end of object
                        }
                        
                        writer.close();

                    } catch (IOException e) {
                        System.out.println("Error when saving");
                    }
                    break;
                case 2: // load
                    try {
                        File file = new File("LibrarySaveFile.txt");
                        Scanner reader = new Scanner(file);
                        if (!reader.hasNextLine() || !reader.nextLine().equals("Librarys")) { // error catch
                            System.out.println("failed loading file");
                        }
                        while (reader.hasNextLine()) { // load library objects
                            String line = reader.nextLine().trim(); // remove leftover newline/ whitespace
                            if (line.equals("Books")){ // switch to book loading
                                break;
                            }
                            
                            Library library = new Library(line);
                            libraryArray.add(library); // add to array
                        }

                        while (reader.hasNextLine()) { // book loading
                            String name = reader.nextLine().trim(); //trim to remove whitespace
                            if (name.equals("Stop") || name.isEmpty()) continue; // marks end of object
                            String author = reader.nextLine().trim();
                            int length = Integer.parseInt(reader.nextLine().trim());
                            String libLocation = reader.nextLine().trim();
                            boolean available = Boolean.parseBoolean(reader.nextLine().trim());
                            String borrower = reader.nextLine().trim();
                            String genre = reader.nextLine().trim();

                            reader.nextLine(); // move past stop marks

                            Library location = null; 
                            if (!libLocation.equals("NONE")) { // if we have a library for this book
                                int libIndex = searchLibrary(libraryArray, libLocation); // find library
                                if (libIndex != -1) {
                                    location = libraryArray.get(libIndex); // add library to book
                                }
                            }

                            Book book = new Book(name, author, length, location, available, borrower, genre); // add book to array
                            bookArray.add(book);
                            if (location != null) {
                                location.addBook(book); // add location to book
                            }

                        }
                        System.out.println("Loaded");
                        reader.close();

                    } catch (IOException e) {
                        System.out.println("Error loading file");
                    }
                    break;
            }
        } while (choice != 9); // menu consitancy
    }

    public static int readMenuChoice(Scanner kb){
        int choice = kb.nextInt();
        return choice;
    }

    public static void printSaveLoadMenu() {
        System.out.println("===============================");
        System.out.println("1.) Save");
        System.out.println("2.) Load");
        System.out.println("9.) Exit");
        System.out.println("===============================");
        System.out.print("Option: ");
    }

    public static void printUpdateMenu(){
        System.out.println("===============================");
        System.out.println("1.) Title");
        System.out.println("2.) Author");
        System.out.println("3.) Length");
        System.out.println("4.) Location");
        System.out.println("5.) Borrower");
        System.out.println("6.) Genre");
        System.out.println("9.) Exit");
        System.out.print("Option: ");
    }

    public static void printMenuMain(){
            System.out.println("===============================");
            System.out.println("1.) Add Book");
            System.out.println("2.) Checkout");
            System.out.println("3.) Return");
            System.out.println("4.) Update Book");
            System.out.println("5.) Search");
            System.out.println("6.) Save - Load"); 
            System.out.println("7.) Cataloge");
            System.out.println("8.) Add Library");
            System.out.println("9.) Exit");
            System.out.println("===============================");
            System.out.print("Option: ");
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
                case 1: // adding a book with the addbook method
                    kb.nextLine();
                    bookArray.add(addBook(kb));
                    // System.out.println(bookArray);
                    break;
                case 2: // checkout a book
                    System.out.print("Book Title: ");
                    kb.nextLine();
                    String checkoutTitle = kb.nextLine();
                    System.out.print("Borrower: ");
                    String borrower = kb.nextLine();
                    searchedIndex = searchBook(bookArray, checkoutTitle); // find index of book to update
                    if (searchedIndex == -1) { // error handling
                        System.out.println("Book not found");
                    } else if (bookArray.get(searchedIndex).getAvailable() == false) {
                        System.out.println("Book: " + checkoutTitle + " is not available"); // error handling
                    }
                    else { // update params and give user feedback
                    bookArray.get(searchedIndex).setAvailable(false);
                    bookArray.get(searchedIndex).setBorower(borrower);
                    System.out.println("Book: " + checkoutTitle + " has been checked out");
                    }
                    break;                
                case 3: // return a book
                    System.out.print("Book Title: ");
                    kb.nextLine();
                    String returnTitle = kb.nextLine();
                    searchedIndex = searchBook(bookArray, returnTitle); // find index of book to update
                    if (searchedIndex == -1) { // error handling
                        System.out.println("Book not found");
                    } else if (bookArray.get(searchedIndex).getAvailable() == true) {
                        System.out.println("Book: " + returnTitle + " was already returned"); // error handling
                    }
                    else { // update params and give user feedback
                    bookArray.get(searchedIndex).setAvailable(true); 
                    bookArray.get(searchedIndex).setBorower(null);
                    System.out.println("Book: " + returnTitle + " has been returned");
                    }
                    break;
                case 4: // upadate book information
                    System.out.print("Book Title: ");
                    kb.nextLine();
                    String updateTitle = kb.nextLine();
                    updateBook(bookArray, libraryArray, updateTitle, kb); // update book method
                    break;
                case 5: // search the book array for a title
                    System.out.println(" -- Search for a book -- ");
                    System.out.print("Book Title: ");
                    kb.nextLine();
                    String searchTitle = kb.nextLine();
                    searchedIndex = searchBook(bookArray, searchTitle); // find index of book
                    if (searchedIndex == -1) {
                        System.out.println("Book not found"); // error catch
                    } else {
                    bookArray.get(searchedIndex).getInfo(); // print information
                    }
                    break;
                case 6: // save / load
                    saveLoad(bookArray, libraryArray, kb);
                    break;
                case 7: // prints all books as as if they were searched
                    printBookArray(bookArray);
                    break;
                case 8: // create a library object 
                    libraryArray.add(addLibrary(kb));
                    break;
                
            }
        } while (choice != 9);

        kb.close();
    }
}