import java.util.Scanner;

/**
 * Class representing the location of the player on a 6x6 map.  @see Map.
 * The location is represented by a x-coordinate and a y-coordinate.  Both coordinates
 * are of type integer.
 * The player uses key 'w', 'a', 's' and 'd' on the keyboard
 * to move up, lefe, down and right, respectively. The player cannot move out of the map.
 */
public class Location{

    //The player cannot move out of the 6x6 map.
    public static final int MAX = 6;
    public static final int MIN = 0;
    
    //The initial location to (1,5) on the map.
    private static int xcoord = 1;
    private static int ycoord = 5;

    public Location(){
    }
    
    public int getX(int x){
        return xcoord;
    }
    public int getY(int y){
        return ycoord;
    }

    //I dont have a seperate isValidMove method, but in this method, if the move is invalid,
    //the location just remains the same.
     public static void move(char key){
        if(key == 'w' || key == 'W'){
            ycoord += 1;
            if(ycoord > MAX){
                ycoord = MAX;
            }
        }
        else if(key == 'a' || key == 'A'){
            xcoord -= 1;
            if(xcoord < MIN){
                xcoord = MIN;
            }
        }
        else if(key == 's' || key == 'S'){
            ycoord -= 1;
            if(ycoord < MIN){
                ycoord = MIN;
            }
        }
        else if(key == 'd' || key == 'D'){
            xcoord += 1;
            if(xcoord > MAX){
                xcoord = MAX;
            }
        }
        
        //or use this method if we have setters.
        /*
        public static void move(char key){
        if(key == 'w'){
            setY(ycoord + 1);
        }
        else if(key == 'a'){
            setX(xcoord - 1);
        }
        else if(key == 's'){
            setY(ycoord - 1);
        }
        else if(key == 'd'){
            setX(xcoord + 1);
        }*/
            
    }
    public static void main(String[] args){
        System.out.println("(" + xcoord + "," + ycoord + ")");
        while(xcoord >= MIN && xcoord <= MAX && ycoord >= MIN && ycoord <= MAX){
            Scanner keyboard = new Scanner(System.in);
            char key = keyboard.next().charAt(0);
            move(key);
            System.out.println("(" + xcoord + "," + ycoord + ")");
            
            //ideally, the game will end when the HP decreases to 0(or however you guys would like it to end),
            //but for now, just press 0 to terminate the game.
            if(key == '0'){
                System.exit(0);
            }
        }
    }   
}
