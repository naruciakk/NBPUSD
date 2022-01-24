package eu.naruciakk.nbpusd;

import eu.naruciakk.nbpusd.factories.ButtonFactory;
import eu.naruciakk.nbpusd.factories.TableViewFactory;
import eu.naruciakk.nbpusd.handlers.ButtonHandler;
import eu.naruciakk.nbpusd.models.Rate;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Rekrutacja - Centrum Uslug Informatycznych PG");
        stage.setWidth(640);
        stage.setHeight(480);

        DatePicker datePicker = new DatePicker();
        TableView<Rate> tableView = TableViewFactory.createNewRateTable();
        Label label = getLabel();
        Button button = getButton(datePicker, tableView);

        VBox vBox = getvBox();
        vBox.getChildren().addAll(label, new HBox(datePicker, new Separator(), button), tableView);
        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().addAll(vBox);

        stage.setScene(scene);
        stage.show();
    }

    private static VBox getvBox() {
        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10, 0, 0, 10));
        return vBox;
    }

    private static Label getLabel() {
        Label label = new Label("Kursy USDPLN");
        label.setFont(new Font("Liberation Serif", 20));
        return label;
    }

    private static Button getButton(DatePicker datePicker, TableView tableView) {
        return ButtonFactory.createButton("Wyszukaj", new ButtonHandler(datePicker, tableView));
    }

    public static void main(String[] args) {
        launch();
    }

}