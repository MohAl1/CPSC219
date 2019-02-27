import java.util.Random;
import java.util.Scanner;

public class Location{

    public static final int MAX = 5;
    public static final int MIN = 0;

    private static int xcoord = 0;
    private static int ycoord = 0;

    public static void move(char key){
        if(key == 'w' || key == 'W'){
            ycoord -= 1;
            if(ycoord < MIN){
                ycoord = MIN;
            }
        }
        else if(key == 'a' || key == 'A'){
            xcoord -= 1;
            if(xcoord < MIN){
                xcoord = MIN;
            }
        }
        else if(key == 's' || key == 'S'){
            ycoord += 1;
            if(ycoord > MAX){
                ycoord = MAX;
            }
        }
        else if(key == 'd' || key == 'D'){
            xcoord += 1;
            if(xcoord > MAX){
                xcoord = MAX;
            }
        }
    }
	public static void main(String[] args) {
        Random randy = new Random();
        int ry = randy.nextInt(6);
        Random randx = new Random(); 
        int rx = randy.nextInt(6);
        Player play = new Player();
        play.print();
        
        Map map = new Map(); 
        System.out.println("Your Location: (" + xcoord + "," + ycoord + ")");
        map.placePlayer('P', ycoord, xcoord);
        
        Potion potion = new Potion();
        map.placePotion('H', ry, rx);
        map.print();

        while(xcoord >= MIN && xcoord <= MAX && ycoord >= MIN && ycoord <= MAX){
            map.placeEmpty('.', ycoord, xcoord);
            Scanner keyboard = new Scanner(System.in);
            char key = keyboard.next().charAt(0);
            move(key);
            if (ycoord == ry && xcoord == rx){
                play.addHP();
                randy = new Random();
                randx = new Random();
                ry = randy.nextInt(6);
                rx = randy.nextInt(6);
                map.placePotion('H', ry, rx);
            }
            play.print();
            System.out.println("Your Location: (" + xcoord + "," + ycoord + ")");
            map.placePlayer('P', ycoord, xcoord);
            map.print();

            if(key == '0'){
                System.exit(0);
            }
        } 
    }
}
