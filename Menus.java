import java.util.Scanner;
public class Menus {
    int choice = 0;
    Scanner kb = new Scanner(System.in);
    public Menus(){
    }

    public int readMenuChoice(Scanner kb){
        System.out.print("What: ");
        int choice = kb.nextInt();
        return choice;
    }

    public int printMenuMain(){
        do {
            System.out.println("1.) add book");
            System.out.println("2.) checkout");
            System.out.println("3.) return");
            System.out.println("4.) update book");
            System.out.println("5.) Search");
            System.out.println("6.) see book info");
            System.out.println("7.) cataloge");
            System.out.println("8.) add library");
            System.out.println("9.) exit");
            choice = readMenuChoice(kb);
            return choice;
        }

        while(choice != 9);
    }



}
