package Logic;

/**
 * Represents a singular zombie.
 */
public class Zombie extends GameObject{

    // Instance of player that affects movement and deals damage.
    private Player player;

    // Damage dealt by zombie
    private int zombieDamage = 10;

    // Boolean values evaluated to true based on players coordinates.
    private boolean goUp = false, goDown = false, goLeft = false, goRight = false;


    public Zombie(int x, int y, int speed, int range,Player player) {
        super((int)(Math.random() * x),(int)(Math.random() * y),(int) (Math.random()*speed)+1,range);
        this.player = player;
    }

    /**
     * If the player is alive and in range, deal damage to the players health.
     */
    public void attack(){
        int playerX = player.getCurrX();
        int playerY = player.getCurrY();
        if(player.isAlive()) {
            if (isInRange(playerX, playerY)) {
                player.takeDamage(zombieDamage);
            }
        }
    }

    /**
     * Search for the player, then depending on where the player is,
     * move the zombie toward the player.
     */
    public void moveZombie(){
        searchForPlayer();
        if(goUp) moveUp();
        if(goDown) moveDown();
        if(goLeft) moveLeft();
        if(goRight) moveRight();
    }

    /**
     * Check whether the players coordinates are below, above, left or right of the zombie,
     * including diagonal positions.
     *
     * E.g. if the player is to the left of the zombie, the players x coordinate will be smaller,
     * thus, goLeft will be true.
     */
    private void searchForPlayer(){
        //north west
        if (player.getCurrX() < getCurrX()
                && player.getCurrY() < getCurrY()) {
            goLeft = true;
            goUp = true;
            goRight = false;
            goDown = false;
        }
        //north east
        if (player.getCurrX() > getCurrX()
                && player.getCurrY() < getCurrY()) {
            goRight = true;
            goUp = true;
            goDown = false;
            goLeft = false;
        }
        //north
        if (player.getCurrY() < getCurrY()
                && player.getCurrX() == getCurrX()) {
            goUp = true;
            goDown = false;
            goLeft = false;
            goRight = false;
        }
        //south
        if (player.getCurrY() > getCurrY()
                && player.getCurrX() == getCurrX()) {
            goDown = true;
            goRight = false;
            goLeft = false;
            goUp = false;
        }
        //south west
        if (player.getCurrX() < getCurrX()
                && player.getCurrY() > getCurrY()) {
            goDown = true;
            goLeft = true;
            goUp = false;
            goRight = false;
        }
        //south east
        if (player.getCurrX() > getCurrX()
                && player.getCurrY() > getCurrY()) {
            goRight = true;
            goDown = true;
            goUp = false;
            goLeft = false;
        }
        //west
        if (player.getCurrX() < getCurrX()
                && player.getCurrY() == getCurrY()) {
            goLeft = true;
            goRight = false;
            goDown = false;
            goUp = false;
        }
        //east
        if (player.getCurrX() > getCurrX()
                && player.getCurrY() == getCurrY()) {
            goRight = true;
            goLeft = false;
            goUp = false;
            goDown = false;
        }
    }
}
