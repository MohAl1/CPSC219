package GUI;

import Logic.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Class that handles player input from keyboard,
 * and moves png representing player on screen.
 *
 */
public class PlayerKeyHandler {
    //Image and node that represents player, drawn by Esther Chu, that moves around scene.
    private static Image playerImage = new Image("Player_Idle0000 (3).png");
    private Node playerNode = new ImageView(playerImage);

    // Player object that is moved by handler class
    private Player player;

    // Scene in which the player node is moved around.
    private Scene scene;

    // Boolean values evaluated to true when pressed, false when released.
    private boolean goUp = false, goDown = false, goLeft = false, goRight = false, attack = false;

    public PlayerKeyHandler(Player player, Scene scene){
        this.player = player;
        this.scene = scene;
    }

    public Node getPlayerNode(){
        return playerNode;
    }

    /**
     * The event handling of keys was found online from a number of sources as a basic tutorial.
     * The following link is what was primarily used as an example: https://www.youtube.com/watch?v=kkZ-YNv7B0E&list=WL&index=3&t=0s
     *
     *  When the any of arrow keys of space bar is pressed, its command is evaluated to true.
     *  False upon release.
     */
    private void handlePlayer() {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    goUp = true;
                    goDown = false;
                    break;
                case DOWN:
                    goDown = true;
                    goUp = false;
                    break;
                case LEFT:
                    goLeft = true;
                    goRight = false;
                    break;
                case RIGHT:
                    goRight = true;
                    goLeft = false;
                    break;
                case SPACE:
                    attack = true;
                    break;
            }
        });
        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case UP:
                    goUp = false;
                    break;
                case DOWN:
                    goDown = false;
                    break;
                case LEFT:
                    goLeft = false;
                    break;
                case RIGHT:
                    goRight = false;
                    break;
                case SPACE:
                    attack = false;
                    break;
            }
        });
    }

    /**
     * Animation timer that checks which key is pressed, and performs player method.
     * Multiple if statements allow for multiple keys to be pressed at same time,
     * resulting in diagonal movement, no movement, and simultaneous moving and attacking.
     */
    public void movePlayer(){
        handlePlayer();
        new AnimationTimer(){
            public void handle(long arg){
                if(goUp) player.moveUp();
                if(goDown) player.moveDown();
                if(goLeft) player.moveLeft();
                if(goRight) player.moveRight();
                if(attack) player.performAttack();
                // Relocate the player node after the player class' methods have updated its coordinates.
                playerNode.relocate(player.getCurrX(),player.getCurrY());
            }
        }.start();
    }
}
