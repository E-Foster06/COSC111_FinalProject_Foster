import java.util.ArrayList;

public class Library {
    String location;
    int shelfs;
    ArrayList<Book> books = new ArrayList<>();
    public Library(String location, int shelfs){
        this.location = location;
        this.shelfs = shelfs;
        
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
}
