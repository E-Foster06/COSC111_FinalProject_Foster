import java.util.ArrayList;

public class Library {
    String location;
    int shelfs;
    ArrayList<Book> books = new ArrayList<>();
    public Library(String location, int shelfs){
        this.location = location;
        this.shelfs = shelfs;
    }

    public Library(String location){
        this.location = location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation(){
        return this.location;
    }

    public void setShelfs(int shelfs){
        this.shelfs = shelfs;
    }

    public int getShelfs(){
        return this.shelfs;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String title) {
        int index; // = -1;
        for(int i = 0; i < books.size(); i ++) {
            String current = books.get(i).getName();
            current = current.toLowerCase();
            title = title.toLowerCase();
            if (current.equalsIgnoreCase(title)) {
                index = i;
                System.out.println("Book " + books.get(index).getName() + " has been removed");
                books.remove(index);
            } else {
                System.out.println("Book not found");
            }
        }
    }
}
