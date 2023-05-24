package com.example.zadania;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class LadyBug extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Tworzenie kształtów dla biedronki
        Circle body = new Circle(150, 150, 100);
        body.setFill(Color.RED);

        Circle head = new Circle(100, 100, 50);
        head.setFill(Color.BLACK);

        Circle leftEye = new Circle(85, 90, 10);
        leftEye.setFill(Color.WHITE);

        Circle rightEye = new Circle(115, 90, 10);
        rightEye.setFill(Color.WHITE);

        Circle leftPupil = new Circle(85, 90, 5);
        leftPupil.setFill(Color.BLACK);

        Circle rightPupil = new Circle(115, 90, 5);
        rightPupil.setFill(Color.BLACK);
        // Tworzenie łuku uśmiechu
        Arc smile = new Arc(100, 120, 25, 20, 180, 180);
        smile.setType(ArcType.OPEN);
        smile.setStroke(Color.WHITE);
        smile.setFill(null);

        // Dodawanie mniejszych czarnych kropek
        Circle dot1 = new Circle(110, 180, 10);
        dot1.setFill(Color.BLACK);

        Circle dot2 = new Circle(170, 160, 10);
        dot2.setFill(Color.BLACK);

        Circle dot3 = new Circle(220, 190, 10);
        dot3.setFill(Color.BLACK);

        Circle dot4 = new Circle(140, 230, 10);
        dot4.setFill(Color.BLACK);

        Circle dot5 = new Circle(180, 120, 10);
        dot5.setFill(Color.BLACK);


        // Grupowanie kształtów węwnątrz kontenera Group
        Group ladybugGroup = new Group(body, head, leftEye, rightEye, leftPupil, rightPupil, smile, dot1, dot2, dot3, dot4, dot5);

        // Tworzenie sceny i wyświetlanie aplikacji
        Scene scene = new Scene(ladybugGroup, 300, 300);
        primaryStage.setTitle("Biedronka");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
