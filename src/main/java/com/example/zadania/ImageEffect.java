package com.example.zadania;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImageEffect extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Wczytanie obrazka
        Image image = new Image("E:\\dell\\Documents\\AGH\\IV semestr\\WWW\\projekt\\resources\\brysia_szalik.jpeg");
        ImageView Brysia = new ImageView(image);
        Brysia.setFitHeight(400);
        Brysia.setPreserveRatio(true);

        // Utworzenie guzików
        Button button1 = createButton("Efekt rozmycia", new BoxBlur(10, 10, 3), Brysia);
        Button button2 = createButton("Efekt sepii", new SepiaTone(), Brysia);
        Blend blend = new Blend();
        blend.setMode(BlendMode.MULTIPLY);
        blend.setTopInput(new BoxBlur(5, 5,3));
        blend.setBottomInput(new SepiaTone(0.8));
        //Brysia.setEffect(blend);
        Button button3 = createButton("Blend", blend, Brysia);
        Button button4 = createButton("Brak efektu", null, Brysia);

        // Umieszczenie guzików w kontenerze HBox
        VBox buttonBox = new VBox(button1, button2, button3, button4);
        SplitPane splitPane = new SplitPane(Brysia, buttonBox);
        splitPane.setDividerPosition((int) 0.75f, 0.25f);

        // Utworzenie sceny
        Scene scene = new Scene(splitPane, 500,500);

        // Wyświetlenie sceny
        primaryStage.setTitle("Image Effects App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButton(String text, Effect effect, ImageView imageView) {
        Button button = new Button(text);

        button.setOnAction(event -> {
            // Ustawienie efektu na obrazku
            imageView.setEffect(effect);
        });

        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
