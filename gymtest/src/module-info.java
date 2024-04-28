module gymtest {
    requires javafx.controls;
    requires javafx.fxml;

    opens application to javafx.graphics, javafx.fxml;

    exports application; // Add this line if your application package needs to be accessible outside the module
}
