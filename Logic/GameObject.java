package Logic;

/**
 * Abstract class that represents simple object in game.
 * Each object has coordinates, boolean alive value, speed for moving,
 * and range for interacting with other objects.
 */
public abstract class GameObject {
    private int currX;
    private int currY;
    private int speed;
    private boolean alive = true;
    private int range;

    public GameObject(int x, int y, int speed, int range){
        currX = x;
        currY = y;
        this.speed = speed;
        this.range = range;
    }


    public int getCurrX() {
        return currX;
    }
    public int getCurrY() {
        return currY;
    }
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public void setCurrY(int currY) {
        this.currY = currY;
    }
    public void setCurrX(int currX) {
        this.currX = currX;
    }

    /**
     * Checks if the coordinates of another foreign object are within range of this object for interaction.
     * Calculated using Pythagorean distance formula.
     *
     * @param x: x coordinate of foreign object.
     * @param y: y coordinate of foreign object.
     * @return: boolean value whether or not the foreign object is in range.
     */
    public boolean isInRange(int x, int y){
        if(Math.sqrt((currX-x)*(currX-x)+(currY-y)*(currY-y)) <= range) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * Mutates the objects coordinates by speed amount.
     *
     * E.g. object y coordinate with speed 2 will be y-2 after moveUp().
     */
    public void moveUp(){
        currY -= speed;
    }
    public void moveDown(){
        currY += speed;
    }
    public void moveLeft(){
        currX -= speed;
    }
    public void moveRight(){
        currX += speed;
    }
}
