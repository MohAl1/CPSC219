package GUI;

import Drivers.GUIApp;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Class that handles click from mouse to start the game.
 */
public class StartButtonHandler implements EventHandler<MouseEvent> {

    private GUIApp guiApp;
    private Button button;

    public StartButtonHandler(GUIApp guiApp,Button button){
        this.button = button;
        this.guiApp = guiApp;
    }

    /**
     * Handle mouse click on button.
     * Set the button to invisible, not managed in scene and start the game.
     * @param event
     */
    @Override
    public void handle(MouseEvent event) {
        button.setVisible(false);
        button.setManaged(false);
        guiApp.startGame();
    }
}
