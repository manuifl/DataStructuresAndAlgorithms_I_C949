module org.manuel {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.manuel to javafx.fxml;
    exports org.manuel;
    exports org.manuel.controllers;
    opens org.manuel.controllers to javafx.fxml;
    exports org.manuel.elements;
    opens org.manuel.elements to javafx.fxml;
}