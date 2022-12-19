import labs.List;

public class Disk implements Comparable {
    private static int size;
    static  int first_id = 0 ;
    private int disk_id;
    List<Integer> folder;

    public Disk() {
        this.disk_id=first_id;
        first_id++;
        this.size = 1000000;
        List<Integer> folder = new List<>();
    }
public void setid(int id){
        this.disk_id = id;
}
    public int getid() {
        return this.disk_id;


    }
    public int getfreeSpace(){
        return 1000000-size;
    }
}
