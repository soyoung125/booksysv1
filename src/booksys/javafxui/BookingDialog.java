package booksys.javafxui;

import booksys.application.domain.Booking;
import booksys.application.domain.BookingSystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Time;
import java.util.Enumeration;


public class BookingDialog extends TextInputDialog {
    protected Label timeLabel;
    protected Label coversLabel;
    protected Label tableNumberLabel ;
    protected TextField time;
    protected TextField covers;
    protected Button ok;
    protected Button cancel;
    protected ComboBox tableNumber;
    protected boolean   confirmed ;
    protected Stage dialog;

    public BookingDialog(Stage primaryStage, String title){
        this(primaryStage, title, null) ;
    }
    public BookingDialog(Stage primaryStage, String title, Booking booking){
        dialog = new Stage(StageStyle.UTILITY);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(primaryStage);
        dialog.setTitle(title);

        Enumeration enums = BookingSystem.getTableNumbers().elements() ;
        ObservableList<String> items = FXCollections.observableArrayList();
        while (enums.hasMoreElements()) {
            items.add((enums.nextElement()).toString());
        }

        tableNumberLabel = new Label("Table Number:");
        tableNumberLabel.setMaxWidth(Double.MAX_VALUE);
        tableNumberLabel.setTextAlignment(TextAlignment.RIGHT);
        tableNumber = new ComboBox();
        tableNumber.setMaxWidth(Double.MAX_VALUE);
        tableNumber.setItems(items);
        if (booking != null) {
            tableNumber.setValue(Integer.toString(booking.getTable().getNumber()));
        }

        coversLabel = new Label("Covers:");
        coversLabel.setMaxWidth(Double.MAX_VALUE);
        coversLabel.setTextAlignment(TextAlignment.RIGHT);
        covers = new TextField();
        if (booking != null) {
            covers.setText(Integer.toString(booking.getCovers())) ;
        }

        timeLabel = new Label("Time:");
        timeLabel.setMaxWidth(Double.MAX_VALUE);
        timeLabel.setTextAlignment(TextAlignment.RIGHT);
        time = new TextField();
        time.setText("HH:MM:SS");
        if (booking != null) {
            time.setText(booking.getTime().toString()) ;
        }

        ok = new Button("OK");
        ok.setMaxWidth(Double.MAX_VALUE);
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                confirmed = true ;
                booksys.javafxui.BookingDialog.this.hide() ;
            }
        });

        cancel = new Button("Cancel");
        cancel.setMaxWidth(Double.MAX_VALUE);
        cancel.setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                confirmed = false ;
                booksys.javafxui.BookingDialog.this.hide() ;
            }
        }));
        dialog.setResizable(false);
        dialog.show();
    }

    int getTableNumber()
    {
        return Integer.parseInt(String.valueOf(tableNumber.getValue())) ;
    }

    int getCovers()
    {
        return Integer.parseInt(covers.getText()) ;
    }

    Time getTime()
    {
        return Time.valueOf(time.getText()) ;
    }

    boolean isConfirmed()
    {
        return confirmed ;
    }
}
