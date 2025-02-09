module com.example.ironmaiden {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.progettomola to javafx.fxml;
    exports com.example.progettomola;
    exports com.example.progettomola.Enum;
    opens com.example.progettomola.Enum to javafx.fxml;
    exports com.example.progettomola.Model.DAO;
    opens com.example.progettomola.Model.DAO to javafx.fxml;
    exports com.example.progettomola.Model.Entity;
    opens com.example.progettomola.Model.Entity to javafx.fxml;
    exports com.example.progettomola.ControllerCLI;
    opens com.example.progettomola.ControllerCLI to javafx.fxml;
    exports com.example.progettomola.Model.DAOImpl;
    opens com.example.progettomola.Model.DAOImpl to javafx.fxml;
    exports com.example.progettomola.Other;
    opens com.example.progettomola.Other to javafx.fxml;
    exports com.example.progettomola.ControllerGUI;
    opens com.example.progettomola.ControllerGUI to javafx.fxml;
}