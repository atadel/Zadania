package com.example.zadania;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToDoListApp extends Application {
    TextField newTask = new TextField();
    private void removeSelectedTasks(VBox tasks) {
        tasks.getChildren().removeIf(node -> {
                    if (node instanceof CheckBox) {
                        CheckBox checkBox = (CheckBox) node;
                        return checkBox.isSelected();
                    }
                    return false;
                }
        );
    }

    private void addTask(VBox tasks, TextField text) {
        CheckBox task = new CheckBox(text.getText().toString());
        tasks.getChildren().add(task);
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lista zadań do zrobienia");

        // Inicjalizacja listy zadań
        VBox tasks = new VBox();

        // Tworzenie komponentów interfejsu użytkownika
        CheckBox task1 = new CheckBox("Zadanie 1");
        CheckBox task2 = new CheckBox("Zadanie 2");
        CheckBox task3 = new CheckBox("Zadanie 3");
        tasks.getChildren().addAll(task1, task2, task3);

        Button removeButton = new Button("Usuń");
        removeButton.setOnAction(event -> removeSelectedTasks(tasks));

        Button addButton = new Button("Dodaj");
        addButton.setOnAction(event->addTask(tasks, newTask));

        // Tworzenie układu interfejsu
        VBox taskList = new VBox(10.0, (Node) tasks);
        taskList.setPadding(new Insets(10));
        VBox elements = new VBox(10, newTask, removeButton, addButton);
        elements.setPadding(new Insets(10));

        // Ustawienie głównego kontenera aplikacji
        ScrollPane scrollPane = new ScrollPane(taskList);
        SplitPane splitPane = new SplitPane(scrollPane, elements);

        // Tworzenie sceny i wyświetlanie aplikacji
        Scene scene = new Scene(splitPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
