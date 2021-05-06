package booksys.presentation;

import booksys.javafxui.BookingDialog;
import booksys.javafxui.ReservationDialog;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("ReservationDialog.fxml"));
        GridPane grid = new GridPane();
        Button b1 = new Button("walkIn");
        Button b2 = new Button("reservation");
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BookingDialog d
                        = new booksys.javafxui.WalkInDialog(primaryStage,
                        "Enter reservation details") ;
            }
        });
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ReservationDialog d
                        = new booksys.javafxui.ReservationDialog(primaryStage,
                        "Enter reservation details") ;
            }
        });
        grid.add(b1,0,0);
        grid.add(b2,1,0);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(grid, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}