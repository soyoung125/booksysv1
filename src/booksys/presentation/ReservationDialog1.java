package booksys.presentation;

import booksys.application.domain.BookingSystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class ReservationDialog1 implements Initializable {
    @FXML
    ComboBox combo_box;
    Enumeration enums = BookingSystem.getTableNumbers().elements() ;
    ObservableList<String> items = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        while (enums.hasMoreElements()) {
            items.add((enums.nextElement()).toString());
        }
        combo_box.setItems(items);

    }
}