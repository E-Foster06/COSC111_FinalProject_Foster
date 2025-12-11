public class Book {
    String name;
    String author;
    int length;
    // String location;
    Library location; // library object
    boolean available = true;
    String borower;
    String genre;
    public Book(String name, String author) { // constructor
        this.name = name;
        this.author = author;
    }

    public Book(String name, String author, Library location){ // constructor
        this.name = name;
        this.author = author;
        this.location = location;
    }

    public void setLength(int lenght) {
        this.length = lenght;
    }

    public int getLength(){
        return this.length;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public String getAuthor(){
        return author;
    }
 
    public void setAuthor(String author){
        this.author = author;
    }

    public void setLocation(Library location){
        this.location = location;
    }

    public Library getLocation(){
        return this.location;
    }

    public boolean getAvailable(){
        return this.available;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }

    public void setBorower(String borower){
        this.borower = borower;
    }

    public String getBorower(){
        return this.borower;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getGenre(){
        return this.genre;
    }

    public void getInfo() {
        System.out.println("title: " + name);
        System.out.println("author: " + author);
        System.out.println("length: " + length);
        System.out.println("is available: " + available);
        System.out.println("located at: " + location);
        System.out.println("Borrower: " + borower);
        System.out.println("genre: " + genre);
    }
    
}
