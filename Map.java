import javafx.scene.Group;
import javafx.scene.Scene;

public class Map {

    private Group root;
    private Scene scene;

    public Map(Group aRoot, Scene aScene){
        root = aRoot;
        scene = aScene;
    }

    public Scene getScene(){return scene;}
    public Group getRoot(){return root;}

}
