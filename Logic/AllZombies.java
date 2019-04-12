package Logic;

import java.util.ArrayList;

/**
 * Class that handles all zombies by spawning them and calling individual attack methods.
 */
public class AllZombies {

    // Instance of player used to create new zombies
    private Player player;

    // Arraylist containing all zombies
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();

    // Individual zombie characteristics initialized based on game version (GUI or text)
    private int spawnX,spawnY,speed,range;

    public AllZombies(int x, int y, int speed, int range,Player player){
        spawnX = x;
        spawnY = y;
        this.speed = speed;
        this.range = range;
        this.player = player;
    }

    public ArrayList<Zombie> getZombies(){
        return zombies;
    }

    /**
     * Create a new zombie and add it to the list of all zombies.
     *
     * @return the newly created zombie.
     *
     */
    public Zombie createZombies(){
        Zombie thisZombie = new Zombie(spawnX, spawnY, speed, range, player);
        zombies.add(thisZombie);
        return thisZombie;

    }

    /**
     * For every zombie that is alive, call its attack method.
     */
    public void attack(){
        for(Zombie zombie:zombies){
            if(zombie.isAlive()) {
                zombie.attack();
            }
        }
    }
}
