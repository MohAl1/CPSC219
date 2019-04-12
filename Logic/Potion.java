package Logic;

/**
 * Represents potion used by player to heal.
 * Only one potion exists. When used, same instance is relocated
 * to mimic effect of new potion spawning.
 */
public class Potion extends GameObject {

    private int healAmount = 100;
    // Player to heal
    private Player player;
    // Limits of area to spawn into
    private int xMax, yMax;

    public Potion(int x, int y, int speed, int range,Player player) {
        super((int)(Math.random() * x), (int)(Math.random() * y), speed, range);
        xMax = x;
        yMax = y;
        this.player = player;
    }

    /**
     * Heals the player when it goes within range, then relocates to new position.
     */
    public void healPlayer(){
        if(isInRange(player.getCurrX(),player.getCurrY())){
            player.heal(healAmount);
            setCurrX((int)(Math.random() * xMax));
            setCurrY((int)(Math.random() * yMax));
        }
    }
}
