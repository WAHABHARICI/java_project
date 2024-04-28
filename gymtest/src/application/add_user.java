package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class add_user implements Initializable {
	@FXML
    private TextField username1;

    @FXML
    private PasswordField password1;

    // Add more fields as needed

    @FXML
    private Button loginBtn1;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    public void loginAdmin1() {
        String sql = "INSERT INTO admin (username, password) VALUES (?, ?)";
        String username = username1.getText();
        String password = password1.getText();

        connect = database.connectDb();

        try {
            // Use PreparedStatement to avoid SQL injection
            try (PreparedStatement prepare = connect.prepareStatement(sql)) {
                prepare.setString(1, username);
                prepare.setString(2, password);

                // Execute the insert query
                int rowsInserted = prepare.executeUpdate();

                if (rowsInserted > 0) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("User inserted successfully.");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Failed to insert user.");
                    alert.showAndWait();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection (you may want to handle this more elegantly)
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

 public void close1(){
        System.exit(0);
    }
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
}
 

}
