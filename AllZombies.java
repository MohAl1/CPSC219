import javafx.animation.AnimationTimer;

import java.util.ArrayList;

public class AllZombies {
    public static ArrayList<Zombie> zombies = new ArrayList<>();
    private int numZombies;
    static Map map;
    static Player player;
    
    public AllZombies() {}
    
    public AllZombies(int numZ, Map aMap, Player aPlayer) {
        numZombies = numZ;
        map = aMap;
        player = aPlayer;
        //update();
    }

    public void createZombies() {
        for (int i = 0; i < numZombies; i++) {
            Zombie thisZombie = new Zombie(map, player, (int) (Math.random() * 1280), (int) (Math.random() * 720), (int) (Math.random()*7)+0.1);
            zombies.add(thisZombie);
            // add zombie to scene
            map.getRoot().getChildren().add(thisZombie.getNode());

        }
    }
    
    public void addZobile() {
    	Zombie thisZombie = new Zombie(map, player, (int) (Math.random() * 1280), (int) (Math.random() * 720), (int) (Math.random()*7)+0.1);
        zombies.add(thisZombie);
        // add zombie to scene
        map.getRoot().getChildren().add(thisZombie.getNode());
    }
    
    public void ZobileDie(Zombie x) {
    	map.getRoot().getChildren().remove(x.getNode());
    	zombies.remove(x);
    }
}
/**
    public void update(){
        AnimationTimer updateTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(player.isKillZomb()){
                    for(Zombie z : zombies){
                        if(!z.getIsAlive()){
                            map.getRoot().getChildren().remove(z.getNode());
                            z = null;
                        }
                    }
                }
            }
        };
        updateTimer.start();
    }

    public void zombieCollision(){
        AnimationTimer zombCollisionTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for(Zombie z : zombies){
                    for(Zombie h : zombies){
                        if(z.getNode().getBoundsInParent().intersects(h.getNode().getBoundsInParent())){
                            System.out.println("dsds");
                            z.stopGay();
                        }
                    }
                }
            }
        };
        zombCollisionTimer.start();
    }
*/




//(int)(Math.random()*1280),(int)(Math.random()*720)