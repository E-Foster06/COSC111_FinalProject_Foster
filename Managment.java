import java.util.Scanner;
public class Managment {

    public static void addBook() {
        Scanner kb = new Scanner(System.in);
        System.out.print("Book Title: ");
        String title = kb.next();
        System.out.print("Book Author: ");
        String author = kb.next();
        Book book = new Book(title, author);
        kb.close();
    }

    public static int readMenuChoice(Scanner kb){
        System.out.print("What: ");
        int choice = kb.nextInt();
        return choice;
    }

    public static void printMenuMain(){
            System.out.println("1.) add book");
            System.out.println("2.) checkout");
            System.out.println("3.) return");
            System.out.println("4.) update book");
            System.out.println("5.) Search");
            System.out.println("6.) see book info");
            System.out.println("7.) cataloge");
            System.out.println("8.) add library");
            System.out.println("9.) exit");
    }
    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int choice = 0;
        do {
            printMenuMain();
            choice = readMenuChoice(kb);
            switch (choice) {
                case 1: 
                    addBook();
                case 2:
                    
                case 3:

                case 4:

                case 5:

                case 6:

                case 7:

                case 8:
                
            }
        } while (choice != 9);

        kb.close();
    }
}