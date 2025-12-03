public class Book {
    String name;
    String author;
    int length;
    // String location;
    Library location;
    boolean available = true;
    String borower;
    String genre;
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(String name, String author, Library location){
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

    public void getAuthor(String author){
        this.author = author;
    }

    public String setAuthor(){
        return this.author;
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
        System.out.println(name);
        System.out.println(author);
        System.out.println(length);
    }
    
}
