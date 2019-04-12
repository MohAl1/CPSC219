package Logic;

/**
 * Object controlled by player.
 */
public class Player extends GameObject {

    private int health = 5000;
    private int score = 0;

    // Instance of AllZombies used to kill zombies.
    private AllZombies allZombies;

    public Player(int x, int y, int speed, int range) {
        super(x,y,speed,range);
    }

    public void setHealth(int health){
        this.health = health;
    }
    public int getScore() {
        return score;
    }
    public int getHealth(){
        return health;
    }
    public void setAllZombies(AllZombies allZombies) {
        this.allZombies = allZombies;
    }

    /**
     * Checks if every alive zombie is in range, and if so, kills it.
     */
    public void performAttack(){
        // For every zombie
        for (int i = 0 ; i < allZombies.getZombies().size(); i++) {
            // Variables used to prevent long getter lines
            int zombieX = allZombies.getZombies().get(i).getCurrX();
            int zombieY = allZombies.getZombies().get(i).getCurrY();
            Zombie zombie = allZombies.getZombies().get(i);
            // If the zombie is in range and alive:
            if(isInRange(zombieX,zombieY) && zombie.isAlive()) {
                // kill the zombie and increase score by 1.
                allZombies.getZombies().get(i).setAlive(false);
                increaseScore();
            }
        }
    }
    private void increaseScore() {
        score++;
    }

    /**
     * Increase the players health.
     * @param healAmount: amount to increase health by.
     */
    public void heal(int healAmount){
        health+= healAmount;
    }

    /**
     * Decrease the players health.
     * @param damage: amount to decrease health by.
     */
    public void takeDamage(int damage) {
        health -= damage;
        if(health<=0)setAlive(false);
    }





}
