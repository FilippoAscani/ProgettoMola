module com.example.progettomola {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires org.slf4j;


    opens com.example.progettomola to javafx.fxml;
    exports com.example.progettomola;
    exports com.example.progettomola.enumerations;
    opens com.example.progettomola.enumerations to javafx.fxml;
    exports com.example.progettomola.model.dao;
    opens com.example.progettomola.model.dao to javafx.fxml;
    exports com.example.progettomola.model.entity;
    opens com.example.progettomola.model.entity to javafx.fxml;
    exports com.example.progettomola.controllercli;
    opens com.example.progettomola.controllercli to javafx.fxml;
    exports com.example.progettomola.model.daoimpl;
    opens com.example.progettomola.model.daoimpl to javafx.fxml;
    exports com.example.progettomola.other;
    opens com.example.progettomola.other to javafx.fxml;
    exports com.example.progettomola.controllergui;
    opens com.example.progettomola.controllergui to javafx.fxml;
}