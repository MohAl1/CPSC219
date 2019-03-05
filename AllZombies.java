import java.util.ArrayList;

public class AllZombies {

    /**
     * the arraylist currently does nothing.
     */
    private ArrayList<Zombie> zombies = new ArrayList<>();
    private int numZombies;

    public AllZombies(int numZ){
        numZombies = numZ;

    }

    public void addZombiesToScene() {
        for(int i=0; i<numZombies;i++){
            Zombie thisZombie = new Zombie((int)(Math.random()*1920),(int)(Math.random()*1080));
            zombies.add(thisZombie);
            AppDriver.gApp.root.getChildren().add(thisZombie.getZombieNode());
        }
    }
}
