package booksys.javafxui;

import booksys.application.domain.Reservation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class ReservationDialog extends BookingDialog {
    protected Label nameLabel;
    protected Label phoneLabel;
    protected TextField name;
    protected TextField phone;

    public ReservationDialog(Stage owner, String title)
    {
        this(owner, title, null) ;
    }

    // This constructor initializes fields with data from an existing booking.
    // This is useful for completing Exercise 7.6.

    ReservationDialog(Stage owner, String title, Reservation r)
    {
        super(owner, title, r) ;

        nameLabel = new Label("Name:");
        nameLabel.setTextAlignment(TextAlignment.RIGHT);
        name = new TextField();
        if (r != null) {
            name.setText(r.getCustomer().getName()) ;
        }

        phoneLabel = new Label("Phone Number:");
        phoneLabel.setTextAlignment(TextAlignment.RIGHT);
        phone = new TextField();
        if (r != null) {
            phone.setText(r.getCustomer().getPhoneNumber()) ;
        }

        GridPane root = new GridPane();
        root.add(timeLabel, 0, 0);
        root.add(time, 1, 0);
        root.add(nameLabel, 0, 1);
        root.add(name, 1, 1);
        root.add(phoneLabel, 0, 2);
        root.add(phone, 1, 2);
        root.add(coversLabel, 0, 3);
        root.add(covers, 1, 3);
        root.add(tableNumberLabel, 0, 4);
        root.add(tableNumber, 1, 4);
        root.add(ok, 0, 5);
        root.add(cancel, 1, 5);
        dialog.setScene(new Scene(root));
    }

    String getCustomerName()
    {
        return name.getText() ;
    }

    String getPhoneNumber()
    {
        return phone.getText() ;
    }
}
