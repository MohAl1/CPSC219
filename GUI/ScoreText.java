package GUI;

import Logic.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Represents the text that displays the players current
 * score in the top left corner during game-play.
 */
public class ScoreText {

    // Player instance in which the score is retrieved.
    private Player player;

    // Text that displays the score.
    private Text scoreText = new Text();

    // Coordinates of text on screen.
    private int xCoord=50,yCoord=70;

    public ScoreText(Player player) {
        this.player = player;
    }

    public Text getScoreText(){
        return scoreText;
    }

    /**
     * Set coordinates, font, and colour.
     */
    private void setUp(){
        scoreText.setX(xCoord);
        scoreText.setY(yCoord);
        scoreText.setFill(Color.WHITE);
        scoreText.setFont(Font.font("Verdana", FontWeight.BOLD,70));
    }

    /**
     * Animation timer that constantly updates the text value displayed.
     * Sets the text to the value of the players score.
     */
    public void updateScoreText(){
        setUp();
        new AnimationTimer(){
            public void handle(long arg){
                scoreText.setText(String.valueOf(player.getScore()));
            }
        }.start();
    }


}
