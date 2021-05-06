package booksys.javafxui;


import booksys.application.domain.WalkIn;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WalkInDialog extends BookingDialog {
    public WalkInDialog(Stage owner, String title)
    {
        this(owner, title, null) ;
    }

    // This constructor initializes fields with data from an existing booking.
    // This is useful for completing Exercise 7.6.

    WalkInDialog(Stage owner, String title, WalkIn w)
    {
        super(owner, title, w) ;

        GridPane root = new GridPane();
        GridPane.setFillWidth(tableNumberLabel,true);
        root.add(tableNumberLabel, 0, 0);
        root.add(tableNumber, 1, 0);
        root.add(coversLabel, 0, 1);
        root.add(covers, 1, 1);
        root.add(timeLabel, 0, 2);
        root.add(time, 1, 2);
        root.add(ok, 0, 3);
        root.add(cancel, 1, 3);
        dialog.setScene(new Scene(root));
    }
}
