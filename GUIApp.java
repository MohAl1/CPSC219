import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

/**
 * GUIApp has one instance and creates all instances of zombies and player.
 * Group and root are inside GUIApp for easier access.
 */
public class GUIApp {

    private Player player;
    private AllZombies zombies;

    public Group root;
    public Scene scene;


    public GUIApp(){
        //amount of zombies to create
        zombies = new AllZombies(4);

        player = new Player();

        root = new Group();
        scene = new Scene(root, 1920, 1080, Color.CYAN);
    }

    public Scene getScene(){return scene;}
    public Player getPlayer(){return player;}

    public AllZombies getZombies(){return zombies;}




}
