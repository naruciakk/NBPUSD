package eu.naruciakk.nbpusd.factories;
import eu.naruciakk.nbpusd.handlers.ButtonHandler;

import javafx.scene.control.Button;

public class ButtonFactory {

    public static Button createButton(String text, ButtonHandler buttonHandler) {
        Button button = new Button(text);
        button.setOnAction(buttonHandler);
        return button;
    }

}
