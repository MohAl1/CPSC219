import javafx.animation.AnimationTimer;

import java.util.ArrayList;

public class AllZombies {

    public static ArrayList<Zombie> zombies = new ArrayList<>();

    //static
    private static Map map;
    private static Player player;
    
    public AllZombies() {}
    
    public AllZombies(Map aMap, Player aPlayer) {
        map = aMap;
        player = aPlayer;
    }

    public void createZombies(int numZ) {
        for (int i = 0; i < numZ; i++) {
            Zombie thisZombie = new Zombie(map, player, (int) (Math.random() * 1280), (int) (Math.random() * 720), (int) (Math.random()*7)+0.1);
            zombies.add(thisZombie);
            // add zombie to scene
            map.getRoot().getChildren().add(thisZombie.getNode());

        }
    }

    public void zombieDie(Zombie z) {
    	map.getRoot().getChildren().remove(z.getNode());
    	zombies.remove(z);
        z.node.relocate(-1000,-1000);
    }
}
