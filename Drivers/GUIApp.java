package Drivers;

import GUI.*;
import Logic.Game;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Driver class for GUI version of game.
 * Creates instances of all classes runs their methods.
 */

public class GUIApp extends Application {


    private Scene scene;
    private Game game;
    private Group root;
    private Stage window;

    /**
     * Creates instance of PlayerKeyHandler,
     * runs its methods to move the player
     * and adds it to the game scene.
     */
    private void setUpPlayer(){
        PlayerKeyHandler playerKeyHandler = new PlayerKeyHandler(game.getPlayer(),this.scene);
        playerKeyHandler.movePlayer();
        root.getChildren().add(playerKeyHandler.getPlayerNode());
    }

    /**
     * Creates instance of zombieGUIManager and calls
     * its method to manage all zombie instances.
     */
    private void setUpZombies(){
        ZombieGUIManager zombieGUIManager = new ZombieGUIManager(game,root);
        zombieGUIManager.updateZombies();
    }

    /**
     * Creates instance of potionGUI, adds it to the scene,
     * and calls its method heal player and move around scene.
     */
    private void setUpPotion(){
        PotionGUI potionGUI = new PotionGUI(game.getPotion());
        root.getChildren().add(potionGUI.getPotionNode());
        potionGUI.updatePotion();
    }

    /**
     * Display the background png.
     */
    private void setUpBackGround(){
        Image mapImg = new Image("Map.png");
        ImageView mapImageView = new ImageView(mapImg);
        root.getChildren().add(mapImageView);
    }

    /**
     * Creates instance of scoreText, adds it to scene and
     * calls its method to show the players score.
     */
    private void setUpScoreText(){
        ScoreText scoreText = new ScoreText(game.getPlayer());
        root.getChildren().add(scoreText.getScoreText());
        scoreText.updateScoreText();
    }

    /**
     * Creates instance of HealthBar, calls its method to display
     * the players health and adds it to the scene.
     */
    private void setUpHPBar(){
        HealthBar hpBar = new HealthBar(game.getPlayer());
        hpBar.updateHP();
        root.getChildren().add(hpBar.getHPBar());
    }
    /**
     * Animation timer to check if the player is dead.
     * If the player is dead, display the game over scene.
     */
    private void checkIfPlayerDead(){
        AnimationTimer playerTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!game.getPlayer().isAlive()) {
                    GameOverScene gameOverScene = new GameOverScene(window,game.getPlayer());
                    gameOverScene.showGameOverScene();
                    this.stop();
                }
            }
        };
        playerTimer.start();
    }

    /**
     * Calls all setUp methods and checkIfPlayerDead().
     */
    public void startGame(){
        setUpBackGround();
        setUpPlayer();
        setUpZombies();
        setUpPotion();
        setUpScoreText();
        setUpHPBar();
        checkIfPlayerDead();
    }

    /**
     * Creates a button that when clicked calls startGame()
     * and hides itself.
     */
    private void setUpStartButton(){
        // Create button and set up coordinates, font, and colour.
        Button startButton = new Button("Start!");
        startButton.setFont(Font.font("Verdana", FontWeight.BOLD,70));
        startButton.setLayoutX(475);
        startButton.setLayoutY(280);

        // Set event handler to new instance of StartButtonHandler class.
        startButton.setOnMouseClicked(new StartButtonHandler(this,startButton));

        // Add the button to the scene.
        root.getChildren().add(startButton);
    }

    /**
     * Create new instances of basic javaFX components: stage, root, and scene.
     * Creates new Instance of game, which creates all logic package instances.
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage){
        window = primaryStage;

        // Create game instance and call setUp() as GUI version.
        game = new Game();
        game.setUp("GUI");

        root = new Group();
        scene = new Scene(root,1280,720);

        // Add start button as only object in scene.
        setUpStartButton();

        // Set stage title, scene and show it.
        window.setResizable(false);
        window.setTitle("Zombie Zurvival");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
