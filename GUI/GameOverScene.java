package GUI;

import Logic.Player;
import Logic.ScoreSaver;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Class for scene displayed when player is dead.
 * Displays a game over message, players score and past high score.
 */
public class GameOverScene {

    private Stage window;
    private Player player;
    private Group root;

    public GameOverScene(Stage window,Player player){
        this.window = window;
        this.player = player;
    }

    /**
     * Creates a new instance scoreSaver and saves the score.
     * Creates a new Text that displays scoreSavers recent score and past high score.
     */
    private void setUpScoreText(){
        ScoreSaver scoreSaver = new ScoreSaver(player);
        scoreSaver.saveScore();
        Text text = new Text("Game Over!\nYour Score:"+ scoreSaver.getScore() +"\nBest: " + scoreSaver.getHighest());

        // Set up the text coordinates, font, colour and add it to the scene.
        text.setX(350);
        text.setY(250);
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Verdana", FontWeight.BOLD,70));
        root.getChildren().add(text);
    }

    /**
     * Create a new scene and root that displays the game over info.
     * Set the scene of the stage.
     */
    public void showGameOverScene(){
        root = new Group();
        setUpScoreText();
        Scene gameOverScene = new Scene(root,1280,720, Color.RED);
        window.setScene(gameOverScene);
    }
}
