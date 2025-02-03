module com.example.ironmaiden {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.progettomola to javafx.fxml;
    exports com.example.progettomola;
}