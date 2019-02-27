import java.util.ArrayList;

public class Player{
    
    private static int health = 100;
    private static ArrayList<String> items = new ArrayList<String>();
    //private static Location x;
    //private static Location y;

    /*public Player(Location xcoord, Location ycoord){
        x = xcoord;
        y = ycoord;
    }*/

    public void addHP(){
        health += 25;
    }
    public void print(){
        System.out.println("HP: " + health + "  Inventory: " + items);
    }
}