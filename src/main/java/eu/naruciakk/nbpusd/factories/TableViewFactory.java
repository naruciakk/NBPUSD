package eu.naruciakk.nbpusd.factories;

import eu.naruciakk.nbpusd.models.Rate;
import javafx.beans.property.Property;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewFactory {

    public static TableView<Rate> createNewRateTable() {
        TableView<Rate> tableView = new TableView<>();
        tableView.setPrefSize(500, 300);
        tableView.getColumns().setAll(
                getNoColumn(tableView), getEffectiveDateColumn(tableView), getMidColumn(tableView)
        );
        return tableView;
    }

    public static TableColumn getColumn(String name, Property property, TableView tableView, double width) {
        TableColumn<Rate, String> column = new TableColumn<>(name);
        column.setCellValueFactory(new PropertyValueFactory<>(property.getName()));
        column.prefWidthProperty().bind(tableView.widthProperty().multiply(width));
        return column;
    }

    private static TableColumn getNoColumn(TableView tableView) {
        return getColumn("Numer", new Rate().noProperty(), tableView, 0.3);
    }

    private static TableColumn getEffectiveDateColumn(TableView tableView) {
        return getColumn("Data obowiązywania", new Rate().effectiveDateProperty(), tableView, 0.3);
    }

    private static TableColumn getMidColumn(TableView tableView) {
        return getColumn("Kurs", new Rate().midProperty(), tableView, 0.3);
    }

}
