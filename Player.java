import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class Player extends GameObject {

    private double speed = 15;
    private int health = 10000;
    private HandlePlayerMovement playerM;
    private Map map;
    private AllZombies az = new AllZombies();
    private int zombienum;
    private boolean zombHit = false;
    private static Image img = new Image("Player_Idle0000.png");


    public Player(Map aMap){
        super(200,300,new ImageView(img), true);
        playerM = new HandlePlayerMovement();
        map = aMap;
    }



    @Override
    int getCurrX() {return currX;}

    @Override
    int getCurrY() {return currY;}

    @Override
    Node getNode() {return node;}

    @Override
    boolean getIsAlive() {return isAlive;}



    public void movePlayer(){
        playerM.handlePlayer();
    }

    public void printHealth(){System.out.println(health);}

    public void getHit(int dmgAmount) {
        health -= dmgAmount;
        if(health <= 0) isAlive = false;
    }
    private void removePlayer() {
        map.getRoot().getChildren().remove(node);
    }

    public void isHitByZombie(boolean truth){
        zombHit = truth;
    }

    public void heal(int healAmount){
        health += healAmount;
    }




    public class HandlePlayerMovement implements EventHandler<KeyEvent> {
        private boolean goUP = false, goDOWN = false, goLEFT = false, goRIGHT = false, attack = false;

        public void handle(KeyEvent event) { }

        // Handle player movement is an altered version of: https://www.youtube.com/watch?v=kkZ-YNv7B0E&list=WL&index=3&t=0s
        // Also found in many online examples of handling key input.
        private void handlePlayer() {
            map.getScene().setOnKeyPressed(event -> {
                switch (event.getCode()) {
                    case UP:
                        goUP = true;
                        break;
                    case DOWN:
                        goDOWN = true;
                        break;
                    case LEFT:
                        goLEFT = true;
                        break;
                    case RIGHT:
                        goRIGHT = true;
                        break;
                    case SPACE:
                        attack = true;
                        break;
                }
            });

            map.getScene().setOnKeyReleased(event -> {
                switch (event.getCode()) {
                    case UP:
                        goUP = false;
                        break;
                    case DOWN:
                        goDOWN = false;
                        break;
                    case LEFT:
                        goLEFT = false;
                        break;
                    case RIGHT:
                        goRIGHT = false;
                        break;
                    case SPACE:
                        attack = false;
                        break;
                }
            });

            AnimationTimer playerTimer = new AnimationTimer() {
                public void handle(long arg) {
                    if (isAlive) {
                    	zombienum += 5;
                        if (goUP) currY -= speed;
                        if (goDOWN) currY += speed;
                        if (goLEFT) currX -= speed;
                        if (goRIGHT) currX += speed;
                        if (attack) performAttack();
                        if(zombienum >= 50) {
                        	az.createZombies(1);
                        	zombienum=0;
                        }
                        node.relocate(currX, currY);
                    } else {
                        removePlayer();
                    }
                }
                private void performAttack() {
                	for (int i = 0 ; i < az.zombies.size(); i++) {
                		int x = az.zombies.get(i).getCurrX();
                		int y = az.zombies.get(i).getCurrY();
                		if(Math.sqrt((currX-x)*(currX-x)+(currY-y)*(currY-y)) <= 120) {
                			az.zombies.get(i).isAlive=false;
                			az.zombieDie(az.zombies.get(i));
                			zombienum+=20;
                		}
                	}
                }
            }; 
            playerTimer.start();
        }
    }
}
