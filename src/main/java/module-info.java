module com.example.zadania {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.zadania to javafx.fxml;
    exports com.example.zadania;
}