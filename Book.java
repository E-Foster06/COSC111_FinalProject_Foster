public class Book {
    String name;
    String author;
    int length;
    String location;
    boolean available = true;
    String borower;
    String genre;
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public void setLength(int lenght) {
        this.length = lenght;
    }

    public void getInfo() {
        System.out.println(name);
        System.out.println(author);
        System.out.println(length);
    }
}
