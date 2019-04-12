package GUI;

import Logic.Potion;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Class that handles potion in GUI version of game.
 */
public class PotionGUI {

    // Image and node drawn by Esther Chu that represents the potion.
    private Image potionImg = new Image("Potion_Image.png");
    private Node potionNode = new ImageView(potionImg);

    // Logic instance of potion that performs healing on player.
    private Potion potion;

    public PotionGUI(Potion potion){
        this.potion = potion;
    }

    public Node getPotionNode(){
        return potionNode;
    }

    /**
     * Animation timer that performs logic class method healPlayer().
     * Relocates the potion based on logic class coordinates.
     */
    public void updatePotion(){
        potionNode.relocate(potion.getCurrX(),potion.getCurrY());
        new AnimationTimer() {
            @Override
            public void handle(long arg) {
                potion.healPlayer();
                potionNode.relocate(potion.getCurrX(),potion.getCurrY());
            }
        }.start();
    }
}
