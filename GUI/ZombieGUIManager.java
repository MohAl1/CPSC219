package GUI;

import Logic.Game;
import Logic.Zombie;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import java.util.ArrayList;

/**
 * Class that manages GUI aspects of zombies.
 * Spawns, removes, and calls attack method for each zombie.
 */
public class ZombieGUIManager {

    // Game instance to access logic components of zombies
    private Game game;

    // Root to remove and add zombie nodes.
    private Group root;

    // Arraylist of ZombieMovements to manage zombieNodes on screen.
    private ArrayList<ZombieMovement> zombieNodes = new ArrayList<>();

    public ZombieGUIManager(Game game,Group root){
        this.game = game;
        this.root = root;
    }

    /**
     * Remove every dead zombie from the game screen.
     */
    private void removeDeadZombies(){
        // For every zombieMovement
        for (ZombieMovement zm : zombieNodes) {
            // If the zombie associated with that zombie node is dead:
            if (!zm.getZombie().isAlive()) {
                // Remove the zombie node from the screen.
                root.getChildren().remove(zm.getZombieNode());
            }
        }
    }

    /**
     * Spawns new zombies based on game's zombieTracker mechanic.
     *
     * Info on zombieTracker mechanic can be found in Game class.
     */
    private void spawnNewZombies(){
        // If zombieTracker evaluates to true
        if(game.zombieTracker()){
            // Create one new zombie, a zombieMovement associated with the zombie,
            // add it to the list of zombieNodes, and call its move function.
            Zombie newZombie = game.getAllZombies().createZombies();
            ZombieMovement newZombieMovement = new ZombieMovement(newZombie);
            root.getChildren().add(newZombieMovement.getZombieNode());
            zombieNodes.add(newZombieMovement);
            newZombieMovement.moveZombie();

            // Reset the game's zombieTracker mechanic
            game.resetZombieTracker();
        }
    }

    /**
     * Animation timer that spawns new zombies, removes dead ones,
     * and calls attack method of allZombies.
     */
    public void updateZombies(){
        AnimationTimer zombieTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                spawnNewZombies();
                game.getAllZombies().attack();
                removeDeadZombies();
            }
        };
        zombieTimer.start();
    }
}
