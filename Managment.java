import java.util.Scanner;

public class Managment {
    public static void readMenuChoice(Scanner kb) {
        
    }
    public static void printMainMenu() {

    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Book book = new Book("Java", "Ev");
        book.setLength(350);
        book.getInfo();
    }
}