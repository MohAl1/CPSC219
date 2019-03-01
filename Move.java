public class Move{
    public static final int MAX = 5;
    public static final int MIN = 0;

    private static int xcoord = 0;
    private static int ycoord = 0;

    public moveUp() {
        ycoord -= 1;
        return ycoord;
    }
    
    public moveDown() {
        ycoord += 1;
        return ycoord;
    }
    
    public moveLeft() {
        xcoord += 1;
        return xcoord;
    }
    
    public moveRight() {
        xcoord -= 1;
        return xcoord;
    }
    
    public static void main(String[] args) {
    	char movement = 'W';
    	switch (movement) {
    		case 'W':  Player.moveUp();
                 break;
    		case 'A':  Player.moveLeft();
                 break;
    		case 'S':  Player.moveDown();
                 break;
    		case 'D':  Player.moveRight();
                 break;
    }
    
    
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
}
