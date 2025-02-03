module com.example.ironmaiden {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ironmaiden to javafx.fxml;
    exports com.example.ironmaiden;
}