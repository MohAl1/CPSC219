package GUI;

import Logic.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Class that displays player health as a red bar.
 * Shrinks in size when taking damage, and grows when healed.
 */
public class HealthBar {

    // Instance of player to give access to health
    private Player player;

    // Rectangle that represents health
    private Rectangle HPBar;

    // Values used for size of health bar, and amount it grows and shrinks.
    // healthTracker keeps track of the players health and decides whether the bar
    // should increase or decrease.
    private int healthTracker,width=500,height=50,healAmount=30,dmgAmount=3;

    // Coordinates on screen
    private int xLocation=20,yLocation=650;

    public HealthBar(Player player){
        this.player = player;
        healthTracker = player.getHealth();
    }
    public Rectangle getHPBar() {
        return HPBar;
    }

    /**
     * Create the health bar and set its coordinates
     */
    private void setUp(){
        HPBar = new Rectangle(width,height, Color.RED);
        HPBar.setX(xLocation);
        HPBar.setY(yLocation);
    }

    /**
     * Increase the size of the health bar to represent health being gained.
     */
    private void heal() {
        // If the players health has increased since last checked by healthTracker
        if(healthTracker<player.getHealth()){
            // Increase the width of the bar.
            width+=healAmount;
            HPBar.setWidth(width);
            // Update healthTracker to the players current health.
            healthTracker = player.getHealth();
        }
    }
    /**
     * Decrease the size of the health bar to represent health being lost.
     */
    private void takeDmg() {
        // If the players health has decreased since last checked by healthTracker
        if(healthTracker>player.getHealth()){
            // Decrease the width of the bar.
            width-=dmgAmount;
            HPBar.setWidth(width);
            // Update healthTracker to the players current health.
            healthTracker = player.getHealth();
        }
    }

    /**
     * Animation timer that calls heal() and takeDmg(), checking if the players health has changed,
     * and updating the health bar to reflect the change.
     */
    public void updateHP(){
        setUp();
        new AnimationTimer(){
            public void handle(long arg){
                heal();
                takeDmg();
            }
        }.start();
    }


}
