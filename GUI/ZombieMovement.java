package GUI;

import Logic.Zombie;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Class associated with one zombie that creates and moves png representing zombie on screen.
 */
public class ZombieMovement {

    // Image and node that represent zombie drawn by Esther Chu.
    private static Image zombieImage = new Image("Zombie_Left0000 (1).png");
    private Node zombieNode = new ImageView(zombieImage);

    // Zombie instance used to access and mutate coordinates.
    private Zombie zombie;

    public ZombieMovement(Zombie zombie){
        this.zombie = zombie;

        // Immediately relocate the zombie node to its random spawn coordinates.
        zombieNode.relocate(zombie.getCurrX(),zombie.getCurrY());

    }
    public Zombie getZombie(){
        return zombie;
    }

    public Node getZombieNode() {
        return zombieNode;
    }

    /**
     * Animation timer that moves the zombie then relocates the node based on zombie coordinates.
     */
    public void moveZombie(){
        new AnimationTimer(){
            @Override
            public void handle(long now) {
                zombie.moveZombie();
                zombieNode.relocate(zombie.getCurrX(),zombie.getCurrY());
            }
        }.start();
    }
}
