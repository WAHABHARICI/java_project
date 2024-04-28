package application;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.DatePicker;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Mouse;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter;
/**
 *
 * @author MarcoMan Subscribe our Channel -->
 *         https://www.youtube.com/channel/UCPgcmw0LXToDn49akUEJBkQ Thanks for
 *         the support guys! <3
 */
public class dashboardController implements Initializable {
	@FXML private TableView<Athlate> seance_libre_tableView;
	@FXML private TableColumn<Athlate, String> seance_libre_col_employeeID;
	@FXML private TableColumn<Athlate, String> seance_libre_col_firstName;
	@FXML private TableColumn<Athlate, String> seance_libre_col_lastName;
	@FXML private TableColumn<Athlate, String> seance_libre_col_phoneNum;
	@FXML private TableColumn<Athlate, Double> seance_libre_price1;
	@FXML private TableColumn<Athlate, String> seance_libre_date;

    
	@FXML private ImageView seance_libre_image;
    @FXML private Button seance_libre_importBtn;
    @FXML private TextField seance_libre_search;
    @FXML private TextField seance_libre_employeeID;
    @FXML private TextField seance_libre_firstName;
    @FXML private TextField seance_libre_lastName;
    @FXML private TextField seance_libre_phoneNum;
    @FXML private TextField seance_libre_price;
    @FXML private Button searchButton_seance_libre;
    @FXML private Button seance_libre_addBtn;
    @FXML private Button seance_libre_updateBtn;
    @FXML private Button seance_libre_deleteBtn;
    @FXML private Button seance_libre_clearBtn;
    @FXML private Button  seance_libre_btn;
	
    @FXML
    private AnchorPane seance_liber_form;
	
    @FXML
    private AnchorPane caisse_form;
    @FXML private Button  caisse;
   

    
    @FXML
    private TableView<caisse> addcaisse_tableView;

  

    @FXML
    private TableColumn<caisse, String> addproduct_col_employeeID1;

    @FXML
    private TableColumn<caisse, String> addproduct_col_firstName1;

    @FXML
    private TableColumn<caisse, Integer> addproduct_col_quantity1;

    @FXML
    private TableColumn<caisse, Double> addproduct_col_prix1;

    @FXML
    private TableColumn<caisse, Double> addproduct_col_price_total;
    @FXML
    private TableColumn<caisse, Date> addproduct_col_date_vente;
    
    
    @FXML
    private Label currentDateTimeLabel;


    @FXML
    private TextField quantityTextField;

    @FXML
    private TextField unitPriceTextField;

    @FXML
    private Label totalPriceLabel;
    
    
    
	 
	
	 @FXML
	    private StackPane add_user1;

	    @FXML
	    private AnchorPane leftForm;

	    @FXML
	    private AnchorPane rightForm;

	    @FXML
	    private Label gymLabel;

	    @FXML
	    private Label addAdminLabel;
	    @FXML
		private Button searchButton_record;
	    @FXML
		private Button all;
	    @FXML
		private Button ini2;
	    
	// update part
	@FXML
	private Button addproduct_updateBtn1;
	@FXML
	private Button ini;
	@FXML
	private DatePicker datePicker_update;
	@FXML
	private Button addproduct_updateBtn3;

	@FXML
	private TextField days_left1_update;
	@FXML
	private TextField record_search;
	@FXML
	private ComboBox<?> type_abonment_update;
	@FXML
	private ComboBox<?> addEmployee_position_update;
	@FXML
	private Button addproduct_updateBtn2;

	@FXML
	private Button searchButtonfirst;

	@FXML
	private Label labelSubscription;

	@FXML
	private Label labelRemainingDays;

	@FXML
	private Label labelEndDate;
	@FXML
	private Label type_abonment1;

	@FXML
	private DatePicker datePicker;

	@FXML
	private DatePicker date1;

	@FXML
	private DatePicker date2;
	@FXML
	private ComboBox<?> type_abonment;

	

	@FXML
	private AnchorPane main_form;
	@FXML
	private AnchorPane search_form;
	@FXML
	private AnchorPane addProduct_form;
	@FXML
	private AnchorPane record_form;

	@FXML
	private Button close;

	@FXML
	private Button minimize;

	@FXML
	private Label username;

	@FXML
	private Button home_btn;

	@FXML
	private Button addEmployee_btn;
	@FXML
	private Button searchEmployee_btn;

	@FXML
	private Button salary_btn;
	@FXML
	private Button product_btn;
	
	@FXML
	private Button record_btn;
	

	@FXML
	private Button logout;

	@FXML
	private AnchorPane home_form;
	@FXML
	private AnchorPane add_user;

	@FXML
	private Label home_totalEmployees;

	@FXML
	private Label home_totalPresents;

	@FXML
	private Label home_totalInactiveEm;

	@FXML
	private BarChart<?, ?> home_chart;

	@FXML

	private AnchorPane addEmployee_form;

//athlat clumn
	
	@FXML
	private TableView<employeeData> addEmployee_tableView;
	@FXML
	private TableColumn<employeeData, String> days_left;

	@FXML
	private TableColumn<employeeData, String> addEmployee_col_days_left_2;

	@FXML
	private TableColumn<employeeData, String> addEmployee_col_employeeID;

	@FXML
	private TableColumn<employeeData, String> addEmployee_col_firstName;

	@FXML
	private TableColumn<employeeData, String> addEmployee_col_lastName;

	@FXML
	private TableColumn<employeeData, String> addEmployee_col_gender;

	@FXML
	private TableColumn<employeeData, String> addEmployee_col_phoneNum;

	@FXML
	private TableColumn<employeeData, String> addEmployee_col_position;
	@FXML
	private TableColumn<employeeData, String> addEmployee_col_abonmet;

	@FXML
	private TableColumn<employeeData, String> addEmployee_col_date;
	@FXML
	private TableColumn<employeeData, String> addEmployee_col_date2;

	TableColumn<employeeData, Integer> days_left3;
	

	@FXML
	private TableView<productData> addproduct_tableView;

	@FXML
	private TableColumn<productData, String> addproduct_col_employeeID;

	@FXML
	private TableColumn<productData, String> addproduct_col_firstName;

	@FXML
	private TableColumn<productData, String> addproduct_col_lastName;

	@FXML
	private TableColumn<productData, String> addproduct_col_gender;

	@FXML
	private TableColumn<productData, String> addproduct_col_price;

	@FXML
	private TableColumn<productData, String> addproduct_col_position;

	@FXML
	private TableColumn<productData, String> addproduct_col_date;
	@FXML
	private TableColumn<productData, String> addproduct_col_quantity;
	@FXML
	private TextField addEmployee_employeeID2;
	@FXML
	private TextField abonmet_type;
	@FXML
	private TextField days_left_2;
	@FXML
	private TextField numberOfDaysTextField;
	@FXML
	private TextField date_fin;
	@FXML
	private TextField days_left2;
	@FXML
	private TextField days_left1;
	@FXML
	private TextField addEmployee_search1;
	@FXML
	private TextField addEmployee_search2;
	@FXML
	private TextField addEmployee_search;

	@FXML
	private TextField addEmployee_employeeID;

	@FXML
	private TextField addEmployee_firstName;

	@FXML
	private TextField addEmployee_lastName;

	@FXML
	private ComboBox<?> addEmployee_gender;

	@FXML
	private TextField addEmployee_phoneNum;

	@FXML
	private ComboBox<?> addEmployee_position;
	@FXML
	private ComboBox<?> searchByComboBox;

	@FXML
	private ImageView addEmployee_image;

	@FXML
	private TextField addEmployee_employeeID1;

	@FXML
	private TextField addEmployee_firstName1;

	@FXML
	private TextField addEmployee_lastName1;
	@FXML
	private ComboBox<?> addEmployee_gender1;

	@FXML
	private TextField addEmployee_phoneNum1;

	@FXML
	private ComboBox<?> addEmployee_position1;

	@FXML
	private ImageView addEmployee_image1;

	@FXML
	private Button addEmployee_importBtn;

	@FXML
	private Button addEmployee_addBtn;

	@FXML
	private Button addEmployee_updateBtn;

	@FXML
	private Button addEmployee_deleteBtn;

	@FXML
	private Button addEmployee_clearBtn;

	@FXML
	private TextField addproduct_search;

	@FXML
	private TextField addproduct_employeeID;

	@FXML
	private TextField addproduct_firstName;

	@FXML
	private TextField addproduct_lastName;
	@FXML
	private TextField  quantity;

	@FXML
	private ComboBox<?> addproduct_gender;

	@FXML
	private TextField addproduct_price;

	@FXML
	private ComboBox<?> addproduct_position;

	@FXML
	private ImageView addproduct_image;

	@FXML
	private Button addproduct_importBtn;

	@FXML
	private Button addproduct_addBtn;

	@FXML
	private Button addproduct_updateBtn;

	@FXML
	private Button addproduct_deleteBtn;

	@FXML
	private Button addproduct_clearBtn;
	@FXML
	private AnchorPane salary_form;

	@FXML
	private TextField salary_employeeID;

	@FXML
	private Label salary_firstName;

	@FXML
	private Label salary_lastName;

	@FXML
	private Label salary_position;

	@FXML
	private TextField salary_salary;

	@FXML
	private Button salary_updateBtn;
	@FXML
	private Button user;

	@FXML
	private Button salary_clearBtn;

	@FXML
	private TableView<employeeData> salary_tableView;

	@FXML
	private TableColumn<employeeData, String> salary_col_employeeID;

	@FXML
	private TableColumn<employeeData, String> salary_col_firstName;

	@FXML
	private TableColumn<employeeData, String> salary_col_lastName;

	@FXML
	private TableColumn<employeeData, String> salary_col_position;

	@FXML
	private TableColumn<employeeData, String> salary_col_salary;

	@FXML
	private ImageView validation;
	@FXML
	private Button searchButton;
	@FXML
	private Button searchButton1;
	
	
	@FXML
    private TableView<EventRecord> record_tableView;

    @FXML
    private TableColumn<EventRecord, String> cardNumberColumn;

    @FXML
    private TableColumn<EventRecord, Integer> employeeIdColumn;

    @FXML
    private TableColumn<EventRecord, String> firstNameColumn;

    @FXML
    private TableColumn<EventRecord, String> lastNameColumn;

    @FXML
    private TableColumn<EventRecord, Timestamp> ariseTimeColumn;
	
    @FXML
    private ComboBox<String> productComboBox;

	private Connection connect;
	private Statement statement;
	private PreparedStatement prepare;
	private ResultSet result;

	private Integer selectedDays = 0;

	private Image image;
	
	public void ProductController(ComboBox<String> productComboBox) {
        this.productComboBox = productComboBox;
    }

    // Method to add items to ComboBox from database
    public void addProductNamesToList() {
        // Connection details
        String url = "jdbc:mysql://localhost:3306/employee";
        String username = "root";
        String password = "Djamel14";

        // SQL query to fetch data from the product table
        String query = "SELECT firstName FROM product";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ObservableList<String> listData = FXCollections.observableArrayList();

            // Iterate through the result set and add names to the list
            while (rs.next()) {
                String name = rs.getString("firstName");
                listData.add(name);
            }

            // Set the items of the ComboBox
            productComboBox.setItems(listData);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public void homeTotalEmployees() {

		String sql = "SELECT COUNT(employee_id) FROM employee";

		connect = database.connectDb();
		int countData = 0;
		try {

			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			while (result.next()) {
				countData = result.getInt("COUNT(employee_id)");
			}

			home_totalEmployees.setText(String.valueOf(countData));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void homeEmployeeTotalPresent() {

		String sql = "SELECT COUNT(product_id) FROM product";

		connect = database.connectDb();
		int countData = 0;
		try {
			statement = connect.createStatement();
			result = statement.executeQuery(sql);

			while (result.next()) {
				countData = result.getInt("COUNT(product_id)");
			}
			home_totalPresents.setText(String.valueOf(countData));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void homeTotalInactive() {

		String sql = "SELECT COUNT(employee_id) FROM employee_info WHERE salary = '0.0'";

		connect = database.connectDb();
		int countData = 0;
		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			while (result.next()) {
				countData = result.getInt("COUNT(employee_id)");
			}
			home_totalInactiveEm.setText(String.valueOf(countData));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void homeChart() {

		home_chart.getData().clear();

		String sql = "SELECT date, COUNT(employee_id) FROM employee GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 7";

		connect = database.connectDb();

		try {
			@SuppressWarnings("rawtypes")
			XYChart.Series chart = new XYChart.Series();

			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			while (result.next()) {
				chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
			}

			home_chart.getData().add(chart);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//Connection connect1 = DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "Djamel14");

	public static void updateEmployeeCheck() {
	    String jdbcUrl = "jdbc:mysql://localhost:3306/employee";
	    String username = "root";
	    String password = "Djamel14";

	    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
	         Statement statement = connection.createStatement()) {

	        String sql = "UPDATE Employee " +
	                     "SET `check` = CASE " +
	                     "    WHEN date_fin IS NULL OR date_fin > CURRENT_DATE THEN 0 " +
	                     "    ELSE 1 " +
	                     "END";

	        int rowsAffected = statement.executeUpdate(sql);
	      //  System.out.println(rowsAffected + " row(s) updated.");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    synchronizeFlagColumn();
	    synchronizeFlagColumn2();
	   // synchronizeEmployee("0002954295");
	}
	
	
	public static void updateCheck2Column() {
	    String mysqlJdbcUrl = "jdbc:mysql://localhost:3306/employee";
	    String mysqlUsername = "root";
	    String mysqlPassword = "Djamel14";

	    try (Connection mysqlConnection = DriverManager.getConnection(mysqlJdbcUrl, mysqlUsername, mysqlPassword);
	         Statement statement = mysqlConnection.createStatement()) {

	        String sql = "UPDATE employee SET check2 = 1 WHERE abonment_type = 'يومي'";

	        // Execute the update statement
	        int rowsUpdated = statement.executeUpdate(sql);

	        // Print a message indicating the update
	        System.out.println(rowsUpdated + " row(s) updated in check2 column of the MySQL database.");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public static void synchronizeFlagColumn() {
        String mysqlJdbcUrl = "jdbc:mysql://localhost:3306/employee";
        String mysqlUsername = "root";
        String mysqlPassword = "Djamel14";

        String accessJdbcUrl = "jdbc:ucanaccess://C:/SafesmartBusinessEn/Database/Property2.mdb;password=AnsonSTMake811";

        try (Connection mysqlConnection = DriverManager.getConnection(mysqlJdbcUrl, mysqlUsername, mysqlPassword);
             Statement mysqlStatement = mysqlConnection.createStatement();
             Connection accessConnection = DriverManager.getConnection(accessJdbcUrl);
             PreparedStatement updateAccessStatement = accessConnection.prepareStatement(
                     "UPDATE Employee SET Flag = 0 WHERE EmployeeID = ?"))
        {

            // Querying the check column in MySQL
            String checkQuery = "SELECT employee_id, `check` FROM employee";
            ResultSet checkResultSet = mysqlStatement.executeQuery(checkQuery);

            while (checkResultSet.next()) {
                int employeeID = checkResultSet.getInt("employee_id");
                int checkValue = checkResultSet.getInt("check");

                if (checkValue == 1) {
                    // Update the corresponding record in the Access database
                    updateAccessStatement.setInt(1, employeeID);
                    int rowsUpdated = updateAccessStatement.executeUpdate();
                    System.out.println(rowsUpdated + "  0000 row(s) updated in Access database for EmployeeID:  " + employeeID);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
	public static void synchronizeFlagColumn2() {
        String mysqlJdbcUrl = "jdbc:mysql://localhost:3306/employee";
        String mysqlUsername = "root";
        String mysqlPassword = "Djamel14";

        String accessJdbcUrl = "jdbc:ucanaccess://C:/SafesmartBusinessEn/Database/Property2.mdb;password=AnsonSTMake811";

        try (Connection mysqlConnection = DriverManager.getConnection(mysqlJdbcUrl, mysqlUsername, mysqlPassword);
             Statement mysqlStatement = mysqlConnection.createStatement();
             Connection accessConnection = DriverManager.getConnection(accessJdbcUrl);
             PreparedStatement updateAccessStatement = accessConnection.prepareStatement(
                     "UPDATE Employee SET Flag = 128 WHERE EmployeeID = ?")) {

            // Querying the check column in MySQL
            String checkQuery = "SELECT employee_id, `check` FROM employee";
            ResultSet checkResultSet = mysqlStatement.executeQuery(checkQuery);

            while (checkResultSet.next()) {
                int employeeID = checkResultSet.getInt("employee_id");
                int checkValue = checkResultSet.getInt("check");

                if (checkValue == 0) {
                    // Update the corresponding record in the Access database
                    updateAccessStatement.setInt(1, employeeID);
                    int rowsUpdated = updateAccessStatement.executeUpdate();
                    System.out.println(rowsUpdated + " 11111 row(s) updated in Access database for EmployeeID: " + employeeID);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public static void synchronize() {
	    String mysqlJdbcUrl = "jdbc:mysql://localhost:3306/employee";
	    String mysqlUsername = "root";
	    String mysqlPassword = "Djamel14";

	    String accessJdbcUrl = "jdbc:ucanaccess://C:/SafesmartBusinessEn/Database/Property2.mdb;password=AnsonSTMake811";

	    try (Connection mysqlConnection = DriverManager.getConnection(mysqlJdbcUrl, mysqlUsername, mysqlPassword);
	         Connection accessConnection = DriverManager.getConnection(accessJdbcUrl);
	    		PreparedStatement selectAccessStatement = accessConnection.prepareStatement(
	    			    "SELECT CardLow, EmployeeID, COUNT(*) AS occurrences " +
	    			    "FROM EventRecord " +
	    			    "WHERE EventType = 0 " +
	    			    "GROUP BY CardLow, EmployeeID");

	    		PreparedStatement checkStatement = mysqlConnection.prepareStatement(
	    			    "SELECT employee_id, days_left_2, abonment_type, new_column, check2 FROM employee WHERE employee_id = ? AND abonment_type = 'يومي'");

	    ) {

	        System.out.println("Starting synchronization...");

	        ResultSet accessResultSet = selectAccessStatement.executeQuery();

	        while (accessResultSet.next()) {
	            String cardNumber = accessResultSet.getString("CardLow");
	            int employeeID = accessResultSet.getInt("EmployeeID");
	            int occurrences = accessResultSet.getInt("occurrences");

	            System.out.println("Inside the loop...");

	            // Querying the days_left_2, abonment_type, and new_column from MySQL database
	            checkStatement.setInt(1, employeeID);
	            ResultSet checkResultSet = checkStatement.executeQuery();

	            if (checkResultSet.next()) {
	                System.out.println("Inside the loop...");

	                String typeAbnmet = checkResultSet.getString("abonment_type");
	                int check2Value = checkResultSet.getInt("check2");

	                // Check if the type_abnmet is يومي or check2 is 1
	                if (check2Value == 1) {
	                    int daysLeft2 = checkResultSet.getInt("days_left_2");
	                    int newColumnValue = checkResultSet.getInt("new_column");
	                    String id = checkResultSet.getString("employee_id");

	                    // Update occurrences in the employee table
	                    String updateOccurrencesQuery = "UPDATE employee SET occurrences = (SELECT COUNT(*) FROM EventRecord WHERE EmployeeID = ? AND EventType = 0) WHERE employee_id = ?";
	                    try (PreparedStatement updateOccurrencesStatement =  mysqlConnection.prepareStatement(updateOccurrencesQuery)) {
	                        updateOccurrencesStatement.setInt(1, employeeID);
	                        updateOccurrencesStatement.setString(2, id);
	                        int rowsUpdatedOccurrences = updateOccurrencesStatement.executeUpdate();
	                        System.out.println(rowsUpdatedOccurrences + " Updated occurrences for Employee ID: " + id);
	                    } catch (SQLException e) {
	                        e.printStackTrace();
	                    }
	                    System.out.println("EmployeeID: " + id);
	                    System.out.println("EmployeeID: " + employeeID);
	                    System.out.println("Occurrences: " + occurrences);
	                    System.out.println("DaysLeft2 before update: " + daysLeft2);
	                    System.out.println("NewColumnValue: " + newColumnValue);

	                    // Calculate the new value for days_left_2
	                    int updatedDaysLeft2 = newColumnValue - occurrences;

	                 // Check if daysLeft2 is not zero
	                 if (daysLeft2 > 0) {
	                     // Execute the update for days_left_2 and occurrences
	                     updateEmployeeDaysLeft2(mysqlJdbcUrl, mysqlUsername, mysqlPassword, id, updatedDaysLeft2, occurrences);
	                 } else {
	                     System.out.println("Skipping update for Employee ID: " + id +
	                             " because daysLeft2 is 0.");
	                 }

	                 System.out.println("DaysLeft2 after update: " + updatedDaysLeft2);

	                    // Comparing occurrences with new_column
	                    if (occurrences >= newColumnValue) {
	                        // Execute the update for occurrences >= new_column
	                        updateEmployeeFlag(accessJdbcUrl, employeeID, 0, "ta3 days left hada");
	                    } else {
	                        // Execute the update for occurrences < new_column
	                        updateEmployeeFlag(accessJdbcUrl, employeeID, 128, "ta3 day_s left hada");
	                    }
	                } else {
	                    // Handle the case where type_abnmet is not يومي (daily) and check2 is not 1
	                    System.out.println("Skipping synchronization for Employee ID: " + employeeID +
	                            " because type_abnmet is not يومي and check2 is not 1.");
	                }
	            }
	        }

	        System.out.println("Synchronization complete.");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public static void updateEmployeeFlag(String accessJdbcUrl, int employeeID, int flagValue, String message) {
	    // Define the ModifyFlag value
	    int modifyFlagValue = 2049;

	    // Define the update query with placeholders for parameters
	    String updateQuery = "UPDATE Employee SET Flag = ?, ModifyFlag = ? WHERE EmployeeID = ?";
	    try (Connection accessConnection = DriverManager.getConnection(accessJdbcUrl);
	         PreparedStatement updateAccessStatement = accessConnection.prepareStatement(updateQuery)) {

	        // Set the parameters in the prepared statement
	        updateAccessStatement.setInt(1, flagValue);
	        updateAccessStatement.setInt(2, modifyFlagValue);
	        updateAccessStatement.setInt(3, employeeID);

	        // Execute the update statement
	        int rowsUpdated = updateAccessStatement.executeUpdate();

	        // Print a message indicating the update
	        System.out.println(rowsUpdated + " " + message + " " + employeeID);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	String mysqlJdbcUrl = "jdbc:mysql://localhost:3306/employee";
    String mysqlUsername = "root";
    String mysqlPassword = "Djamel14";

    // Example employee update
    String employeeIDToUpdate = "123"; // Replace with the actual employee ID
    int updatedDaysLeft2 = 20;         // Replace with the actual value
    int occurrences = 5;               // Replace with the actual value

    // Update employee in MySQL
   


public static void updateEmployeeDaysLeft2(String mysqlJdbcUrl, String mysqlUsername, String mysqlPassword,
                                           String employeeID, int updatedDaysLeft2, int occurrences) {
    // MySQL connection details
    String mysqlDriver = "com.mysql.cj.jdbc.Driver";

    // SQL query with placeholders
    String updateQuery = "UPDATE employee SET days_left_2 = ?, occurrences = ? WHERE employee_id = ?";

    try {
        // Load the MySQL JDBC driver
        Class.forName(mysqlDriver);

        // Create the MySQL connection
        try (Connection mysqlConnection = DriverManager.getConnection(mysqlJdbcUrl, mysqlUsername, mysqlPassword);
             PreparedStatement updateMysqlStatement = mysqlConnection.prepareStatement(updateQuery)) {

            // Set the parameters in the prepared statement
            updateMysqlStatement.setInt(1, updatedDaysLeft2);  // days_left_2
            updateMysqlStatement.setInt(2, occurrences);        // occurrences
            updateMysqlStatement.setString(3, employeeID);      // employee_id

            // Execute the update statement
            int rowsUpdated = updateMysqlStatement.executeUpdate();

            // Print a message indicating the update
            System.out.println(rowsUpdated + " Updated days_left_2 and occurrences for Employee ID: " + employeeID);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}





	
	
	
	
	


	public void addEmployeeAdd() {
		
		days_left1.setText(String.valueOf(selectedDays));

		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		LocalDate selectedDate = datePicker.getValue();
		java.sql.Date sqlDate2 = (selectedDate != null) ? java.sql.Date.valueOf(selectedDate) : null;

		String sql = "INSERT INTO employee "
				+ "(employee_id,firstName,lastName,gender,phoneNum,position,image,date,days_left,date_fin,abonment_type,days_left_2,new_column) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		connect = database.connectDb();

		try {
			Alert alert;
			if (addEmployee_employeeID.getText().isEmpty()
			// || addEmployee_firstName.getText().isEmpty()
			// || addEmployee_lastName.getText().isEmpty()
			// || addEmployee_gender.getSelectionModel().getSelectedItem() == null
			// || addEmployee_phoneNum.getText().isEmpty()
			// || addEmployee_position.getSelectionModel().getSelectedItem() == null
			// || getData.path == null || getData.path == ""
			) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("املا جميع الفراغات");
				alert.showAndWait();
			} else {

				String check = "SELECT employee_id FROM employee WHERE employee_id = '"
						+ addEmployee_employeeID.getText() + "'";

				statement = connect.createStatement();
				result = statement.executeQuery(check);

				if (result.next()) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Employee ID: " + addEmployee_employeeID.getText() + " was already exist!");
					alert.showAndWait();
				} else {

					prepare = connect.prepareStatement(sql);
					prepare.setString(1, addEmployee_employeeID.getText());
					prepare.setString(2, addEmployee_firstName.getText());
					prepare.setString(3, addEmployee_lastName.getText());
					prepare.setString(4, (String) addEmployee_gender.getSelectionModel().getSelectedItem());
					prepare.setString(5, addEmployee_phoneNum.getText());
					String selectedPosition = (String) addEmployee_position.getSelectionModel().getSelectedItem();

					if (selectedPosition != null && !selectedPosition.isEmpty()) {
						prepare.setString(6, selectedPosition);
					} else {
						// Provide a default value or handle the case where position is not selected
						// For example, providing a default value:
						prepare.setString(6, "Default Position");
					}

					prepare.setInt(9, selectedDays);
					if (sqlDate2 != null) {
						prepare.setDate(10, sqlDate2);
					} else {
						prepare.setNull(10, Types.DATE);
					}
					prepare.setString(11, (String) type_abonment.getSelectionModel().getSelectedItem());
					String numberOfDaysValue = numberOfDaysTextField.getText();
					int numberOfDays;

					if (!numberOfDaysValue.isEmpty()) {
						// Parse the value if it's not empty
						try {
							numberOfDays = Integer.parseInt(numberOfDaysValue);
						} catch (NumberFormatException e) {

							e.printStackTrace();

							numberOfDays = 0;
						}
					} else {
						// Handle the case where the text field is empty
						// Set a default value or handle it as appropriate
						numberOfDays = 0; // Default value or any appropriate default value
					}

					// Now you can use the 'numberOfDays' variable in your code
					prepare.setInt(12, numberOfDays);
					prepare.setInt(13, numberOfDays);
					String uri = getData.path;
					// uri = uri.replace("\\", "\\\\");
					if (uri == null) {
						// Assuming "defaultImage.png" is the name of your default image file in the
						// "image" package.
						uri = "/img/athlete.png";
					} else {
						// Replace backslashes with double backslashes.
						uri = uri.replace("\\", "\\\\");
					}
					prepare.setString(7, uri);
					prepare.setString(8, String.valueOf(sqlDate));
					prepare.executeUpdate();

					String insertInfo = "INSERT INTO employee_info "
							+ "(employee_id,firstName,lastName,position,salary,date) " + "VALUES(?,?,?,?,?,?)";

					prepare = connect.prepareStatement(insertInfo);
					prepare.setString(1, addEmployee_employeeID.getText());
					prepare.setString(2, addEmployee_firstName.getText());
					prepare.setString(3, addEmployee_lastName.getText());
					prepare.setString(4, (String) addEmployee_position.getSelectionModel().getSelectedItem());
					prepare.setString(5, "0.0");
					prepare.setString(6, String.valueOf(sqlDate));
					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("تم الاضافة بنجاح");
					alert.showAndWait();
					//updateEmployeeCheck();
				//	addEmployeeShowListData();
					//openApplicationAndClickOK();
					
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

        
        
		String url1 = "jdbc:ucanaccess://C:/SafesmartBusinessEn/Database/Property2.mdb;password=AnsonSTMake811";
		try (Connection connection = DriverManager.getConnection(url1)) {
		    // Insert data into the Employee table
		    String insertEmployeeQuery = "INSERT INTO Employee (EmployeeID, EmployeeName , ModifyFlag, Flag, ValidNum) VALUES (?, ?, ?, ?, ?)";
		    try (PreparedStatement insertEmployeeStatement = connection.prepareStatement(insertEmployeeQuery)) {
		        int validnum = 50;
		        int flag = 128;
		        int m = 1;
		        
		        String EmployeeIdValueText = addEmployee_employeeID.getText();
		        int employeeIDValue = Integer.parseInt(EmployeeIdValueText); 
		       
		        String employeeNameValue = addEmployee_firstName.getText();

		        insertEmployeeStatement.setInt(1, employeeIDValue);
		        insertEmployeeStatement.setString(2, employeeNameValue);
		        insertEmployeeStatement.setInt(3, m);
		        insertEmployeeStatement.setInt(4, flag);
		        insertEmployeeStatement.setInt(5, validnum);

		        // Execute the insert query
		        int rowsInsertedEmployee = insertEmployeeStatement.executeUpdate();
		        System.out.println(rowsInsertedEmployee + " row(s) inserted into Employee table.");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    // Insert data into the Card table
		    try {
		        String insertCardQuery = "INSERT INTO Card (CardLow , EmployeeID) VALUES (?, ?)";
		        try (PreparedStatement insertCardStatement = connection.prepareStatement(insertCardQuery)) {
		            
		            String cardLowValueText = addEmployee_employeeID.getText(); // Assuming you have a text field for CardLow
		            int cardLowValue = Integer.parseInt(cardLowValueText);   
		            int employeeIDValue = Integer.parseInt(addEmployee_employeeID.getText()); // Employee ID from the previous insert

		            insertCardStatement.setInt(1, cardLowValue);
		            insertCardStatement.setInt(2, employeeIDValue);

		            // Execute the insert query
		            int rowsInsertedCard = insertCardStatement.executeUpdate();
		            System.out.println(rowsInsertedCard + " row(s) inserted into Card table.");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		//();
		addEmployeeReset();
		addEmployeeShowListData();
		
		addproductShowListData();
		updateEmployeeCheck();
		synchronize();
		updateEmployeeCheck();
		updateCheck2Column();
		//gettherecord();
		//ini();
		openApplicationAndClickOK();
		
		
		

	}
	
	
	

	
	

	public void addEmployeeUpdate() {
	    String uri = getData.path;
	    uri = uri.replace("\\", "\\\\");

	    Date date = new Date();
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    LocalDate selectedDate = datePicker.getValue();
	    java.sql.Date sqlDate2 = (selectedDate != null) ? java.sql.Date.valueOf(selectedDate) : null;

	    String daysLeft2Value = numberOfDaysTextField.getText();
	    int daysLeft2Int = 0; // Default value

	    // Validate and parse the input for days_left_2
	    if (daysLeft2Value != null && !daysLeft2Value.trim().isEmpty()) {
	        try {
	            daysLeft2Int = Integer.parseInt(daysLeft2Value);
	        } catch (NumberFormatException e) {
	            // Handle parsing error
	            e.printStackTrace();
	        }
	    }

	    String sql = "UPDATE employee SET " +
	            "employee_id = ?, " +
	            "firstName = ?, " +
	            "lastName = ?, " +
	            "phoneNum = ?, " +
	            "image = ?, " +
	            "date = ?, " +
	            "date_fin = ?, " +
	            "days_left = ?, " +
	            "abonment_type = ?, " +
	            "days_left_2 = ?, " +
	            "new_column = new_column + ? " +
	            "WHERE employee_id = ?";

	    connect = database.connectDb();

	    try {
	        Alert alert;
	        if (addEmployee_employeeID.getText().isEmpty() || 
	        	    uri == null || uri.isEmpty() || 
	        	    type_abonment.getSelectionModel().isEmpty()) {
	            alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Error Message");
	            alert.setHeaderText(null);
	            alert.setContentText("املا الفراغات");
	            alert.showAndWait();
	        } else {
	            alert = new Alert(AlertType.CONFIRMATION);
	            alert.setTitle("Cofirmation Message");
	            alert.setHeaderText(null);
	            alert.setContentText("هل انت متاكد من تعديل العضو: " + addEmployee_firstName.getText() + "?");
	            Optional<ButtonType> option = alert.showAndWait();

	            if (option.isPresent() && option.get().equals(ButtonType.OK)) {
	                try (PreparedStatement statement = connect.prepareStatement(sql)) {
	                    statement.setString(1, addEmployee_employeeID2.getText());
	                    statement.setString(2, addEmployee_firstName.getText());
	                    statement.setString(3, addEmployee_lastName.getText());
	                    statement.setString(4, addEmployee_phoneNum.getText());
	                    statement.setString(5, uri);
	                    statement.setDate(6, sqlDate);
	                    if (sqlDate2 != null) {
	                        statement.setDate(7, sqlDate2);
	                    } else {
	                        statement.setNull(7, java.sql.Types.NULL);
	                    }
	                    statement.setString(8, days_left1.getText());
	                    statement.setString(9, (String) type_abonment.getSelectionModel().getSelectedItem());
	                    statement.setInt(10, daysLeft2Int);
	                    statement.setInt(11, daysLeft2Int); // Set the value of daysLeft2Int for new_column
	                    statement.setString(12, addEmployee_employeeID.getText());

	                     statement.executeUpdate();
	                    // Process the result if needed
	                }
					
					
					String url1 = "jdbc:ucanaccess://C:/SafesmartBusinessEn/Database/Property2.mdb;password=AnsonSTMake811";

					try (Connection connection = DriverManager.getConnection(url1)) {
					    // Delete records from the Card table
					    String deleteCardQuery = "DELETE FROM Card WHERE EmployeeID = ?";
					    try (PreparedStatement deleteCardStatement = connection.prepareStatement(deleteCardQuery)) {
					        int oldEmployeeID = Integer.parseInt(addEmployee_employeeID.getText());
					        
					        deleteCardStatement.setInt(1, oldEmployeeID);

					        int rowsAffectedCard = deleteCardStatement.executeUpdate();
					        System.out.println(rowsAffectedCard + " row(s) deleted from Card table where EmployeeID = " + oldEmployeeID);
					    } catch (SQLException e) {
					        e.printStackTrace();
					    }

					    // Delete records from the Employee table
					    String deleteEmployeeQuery = "DELETE FROM Employee WHERE EmployeeID = ?";
					    try (PreparedStatement deleteEmployeeStatement = connection.prepareStatement(deleteEmployeeQuery)) {
					        int oldEmployeeID = Integer.parseInt(addEmployee_employeeID.getText());

					        deleteEmployeeStatement.setInt(1, oldEmployeeID);

					        int rowsAffectedEmployee = deleteEmployeeStatement.executeUpdate();
					        System.out.println(rowsAffectedEmployee + " row(s) deleted from Employee table where EmployeeID = " + oldEmployeeID);
					    } catch (SQLException e) {
					        e.printStackTrace();
					    }
					} catch (SQLException e) {
					    e.printStackTrace();
					}

					try (Connection connection = DriverManager.getConnection(url1)) {
					    // Insert data into the Employee table
					    String insertEmployeeQuery = "INSERT INTO Employee (EmployeeID, EmployeeName , ModifyFlag, Flag, ValidNum) VALUES (?, ?, ?, ?, ?)";
					    try (PreparedStatement insertEmployeeStatement = connection.prepareStatement(insertEmployeeQuery)) {
					        int validnum = 50;
					        int flag = 128;
					        int m = 1;
					        
					        String EmployeeIdValueText = addEmployee_employeeID2.getText();
					        int employeeIDValue = Integer.parseInt(EmployeeIdValueText); 
					       
					        String employeeNameValue = addEmployee_firstName.getText();

					        insertEmployeeStatement.setInt(1, employeeIDValue);
					        insertEmployeeStatement.setString(2, employeeNameValue);
					        insertEmployeeStatement.setInt(3, m);
					        insertEmployeeStatement.setInt(4, flag);
					        insertEmployeeStatement.setInt(5, validnum);

					        // Execute the insert query
					        int rowsInsertedEmployee = insertEmployeeStatement.executeUpdate();
					        System.out.println(rowsInsertedEmployee + " row(s) inserted into Employee table.");
					    } catch (SQLException e) {
					        e.printStackTrace();
					    }

					    // Insert data into the Card table
					    try {
					        String insertCardQuery = "INSERT INTO Card (CardLow , EmployeeID) VALUES (?, ?)";
					        try (PreparedStatement insertCardStatement = connection.prepareStatement(insertCardQuery)) {
					            
					            String cardLowValueText = addEmployee_employeeID2.getText(); // Assuming you have a text field for CardLow
					            int cardLowValue = Integer.parseInt(cardLowValueText);   
					            int employeeIDValue = Integer.parseInt(addEmployee_employeeID2.getText()); // Employee ID from the previous insert

					            insertCardStatement.setInt(1, cardLowValue);
					            insertCardStatement.setInt(2, employeeIDValue);

					            // Execute the insert query
					            int rowsInsertedCard = insertCardStatement.executeUpdate();
					            System.out.println(rowsInsertedCard + " row(s) inserted into Card table.");
					        }
					    } catch (SQLException e) {
					        e.printStackTrace();
					    }
					} catch (SQLException e) {
					    e.printStackTrace();
					}
					gettherecord();
					updateEmployeeCheck();
					addEmployeeReset();
					updateEmployeeCheck();
					synchronize();
					//updateEmployeeCheck();
					updateCheck2Column();
					openApplicationAndClickOK();
					addEmployeeShowListData();
					//updateEmployeeCheck();
					//updateCheck2Column();
					//synchronize();
					addProductNamesToList();
					//ini();
					//synchronizeEmployee();
					
//					


					

					String checkData = "SELECT * FROM employee_info WHERE employee_id = '"
							+ addEmployee_employeeID.getText() + "'";

					prepare = connect.prepareStatement(checkData);
					result = prepare.executeQuery();

					while (result.next()) {
						result.getDouble("salary");
					}

					String updateInfo = "UPDATE employee_info SET firstName = '" + addEmployee_firstName.getText()
							+ "', lastName = '" + addEmployee_lastName.getText() + "', position = '"
							+ addEmployee_position.getSelectionModel().getSelectedItem() + "' WHERE employee_id = '"
							+ addEmployee_employeeID.getText() + "'";

					prepare = connect.prepareStatement(updateInfo);
					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("تم التعديل بنجاح");
					alert.showAndWait();

					addEmployeeShowListData();
					addEmployeeReset();
//					updateEmployeeCheck();
//					updateCheck2Column();
//					synchronize();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addEmployeeDelete() {

		String sql = "DELETE FROM employee WHERE employee_id = '" + addEmployee_employeeID.getText() + "'";

		connect = database.connectDb();

		try {

			Alert alert;
			if (addEmployee_employeeID.getText().isEmpty()
					// || addEmployee_firstName.getText().isEmpty()
					// || addEmployee_lastName.getText().isEmpty()
					// || addEmployee_gender.getSelectionModel().getSelectedItem() == null
					// || addEmployee_phoneNum.getText().isEmpty()
					// || addEmployee_position.getSelectionModel().getSelectedItem() == null
					|| getData.path == null || getData.path == "") {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Please fill all blank fields");
				alert.showAndWait();
			} else {
				alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Cofirmation Message");
				alert.setHeaderText(null);
				alert.setContentText("qre you sure you zqnnq delet it  : " + addEmployee_employeeID.getText() + "?");
				Optional<ButtonType> option = alert.showAndWait();

				if (option.get().equals(ButtonType.OK)) {
					statement = connect.createStatement();
					statement.executeUpdate(sql);

					String deleteInfo = "DELETE FROM employee_info WHERE employee_id = '"
							+ addEmployee_employeeID.getText() + "'";

					prepare = connect.prepareStatement(deleteInfo);
					prepare.executeUpdate();

					String url1 = "jdbc:ucanaccess://C:/SafesmartBusinessEn/Database/Property2.mdb;password=AnsonSTMake811";

					try (Connection connection = DriverManager.getConnection(url1)) {
					    // Delete records from the Card table
					    String deleteCardQuery = "DELETE FROM Card WHERE EmployeeID = ?";
					    try (PreparedStatement deleteCardStatement = connection.prepareStatement(deleteCardQuery)) {
					        int oldEmployeeID = Integer.parseInt(addEmployee_employeeID.getText());
					        
					        deleteCardStatement.setInt(1, oldEmployeeID);

					        int rowsAffectedCard = deleteCardStatement.executeUpdate();
					        System.out.println(rowsAffectedCard + " row(s) deleted from Card table where EmployeeID = " + oldEmployeeID);
					    } catch (SQLException e) {
					        e.printStackTrace();
					    }

					    // Delete records from the Employee table
					    String deleteEmployeeQuery = "DELETE FROM Employee WHERE EmployeeID = ?";
					    try (PreparedStatement deleteEmployeeStatement = connection.prepareStatement(deleteEmployeeQuery)) {
					        int oldEmployeeID = Integer.parseInt(addEmployee_employeeID.getText());

					        deleteEmployeeStatement.setInt(1, oldEmployeeID);

					        int rowsAffectedEmployee = deleteEmployeeStatement.executeUpdate();
					        System.out.println(rowsAffectedEmployee + " row(s) deleted from Employee table where EmployeeID = " + oldEmployeeID);
					    } catch (SQLException e) {
					        e.printStackTrace();
					    }
					} catch (SQLException e) {
					    e.printStackTrace();
					}
					
					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("تم الحدف بنجاح");
					alert.showAndWait();

					addEmployeeShowListData();
					addEmployeeReset();
					
					updateEmployeeCheck();
					synchronize();
					updateEmployeeCheck();
					updateCheck2Column();
					openApplicationAndClickOK();
					addEmployeeShowListData();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public void addEmployeeReset() {
		addEmployee_employeeID.setText("");
		addEmployee_firstName.setText("");
		addEmployee_lastName.setText("");
		addEmployee_gender.getSelectionModel().clearSelection();
		addEmployee_position.getSelectionModel().clearSelection();
		addEmployee_phoneNum.setText("");
		addEmployee_image.setImage(null);
		getData.path = "";
		datePicker.setValue(null);
		numberOfDaysTextField.setText("");
		addEmployee_employeeID2.setText("");

	}

//    public void addEmployeeInsertImage() {
//
//        FileChooser open = new FileChooser();
//        File file = open.showOpenDialog(main_form.getScene().getWindow());
//
//        if (file != null) {
//            getData.path = file.getAbsolutePath();
//
//            image = new Image(file.toURI().toString(), 101, 127, false, true);
//            addEmployee_image.setImage(image);
//        }
//    }

	public void addEmployeeInsertImage() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Choose Image Source");
		alert.setHeaderText("اختر من اين تريد الحصول على الصوررة ");
		alert.setContentText(" واختر ملف ادا كنت تريد احضارها من ملف او التقاط ادا كنت تريد التقاط صورة بالكاميراا.");

		ButtonType importButton = new ButtonType("ملف");
		ButtonType captureButton = new ButtonType("التقاط");

		alert.getButtonTypes().setAll(importButton, captureButton, ButtonType.CANCEL);

		alert.showAndWait().ifPresent(buttonType -> {
			if (buttonType == importButton) {
				importImageFromFile1();
			} else if (buttonType == captureButton) {
				captureImageFromCamera1();
			}
		});
	}

	private void importImageFromFile1() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

		File file = fileChooser.showOpenDialog(new Stage());

		if (file != null) {
			// Assuming 'getData.path' is a class variable
			getData.path = file.getAbsolutePath();

			image = new Image(file.toURI().toString(), 101, 127, false, true);
			addEmployee_image.setImage(image);
		}
	}

	private void captureImageFromCamera1() {
		// Launch the camera app
		launchCameraApp1();
	}

	private void launchCameraApp1() {
		try {
			// Replace with the appropriate command to open the camera app on Windows
			String command = "cmd /c start microsoft.windows.camera:";

			// Execute the command and wait for the process to finish
			Process process = Runtime.getRuntime().exec(command);
			int exitCode = process.waitFor();

			if (exitCode == 0) {
				// The process exited successfully (user closed the camera app)

				// Ask the user if they want to use the captured image
				Platform.runLater(() -> showConfirmationDialog1());
			} else {
				// The process exited with an error
				Platform.runLater(() -> showErrorMessage("Error launching the camera app. Please try again."));
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace(); // Print the stack trace for debugging
			Platform.runLater(() -> showErrorMessage("Error launching the camera app: " + e.getMessage()));
		}
	}

	private void showConfirmationDialog1() {
		Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
		confirmationAlert.setTitle("التاكيد");
		confirmationAlert.setHeaderText("هل تريد  صورة الان! ");
		confirmationAlert.setContentText("Choose 'OK' to use the image or 'Cancel' to discard it.");

		Optional<ButtonType> result = confirmationAlert.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.OK) {
			// Capture the new image
			// Image newImage = captureImage();

			// Get the path of the last image
			String lastImagePath = getLastImagePath();
			// System.out.println("Last Image Path: " + lastImagePath);

			if (lastImagePath != null) {
				File file = new File(lastImagePath);

				// Check if the file exists before trying to set the image
				if (file.exists()) {
					getData.path = file.getAbsolutePath();
					System.out.println("Setting image from file: " + lastImagePath);
					addEmployee_image.setImage(new Image(file.toURI().toString()));
				} else {
					System.out.println("Image file does not exist: " + lastImagePath);
				}
			} else {
				System.out.println("Last Image Path is null.");
			}
		} else {
			// Handle the case where the user clicked 'Cancel' in the confirmation dialog
			System.out.println("User canceled using the captured image.");
		}
	}
	
	
	public void addEmployeeInsertImage1() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Choose Image Source");
		alert.setHeaderText("اختر من اين تريد الحصول على الصوررة ");
		alert.setContentText(" واختر ملف ادا كنت تريد احضارها من ملف او التقاط ادا كنت تريد التقاط صورة بالكاميراا.");

		ButtonType importButton = new ButtonType("ملف");
		ButtonType captureButton = new ButtonType("التقاط");

		alert.getButtonTypes().setAll(importButton, captureButton, ButtonType.CANCEL);

		alert.showAndWait().ifPresent(buttonType -> {
			if (buttonType == importButton) {
				importImageFromFile2();
			} else if (buttonType == captureButton) {
				captureImageFromCamera2();
			}
		});
	}

	private void importImageFromFile2() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

		File file = fileChooser.showOpenDialog(new Stage());

		if (file != null) {
			// Assuming 'getData.path' is a class variable
			getData.path = file.getAbsolutePath();

			image = new Image(file.toURI().toString(), 101, 127, false, true);
			seance_libre_image.setImage(image);
		}
	}

	private void captureImageFromCamera2() {
		// Launch the camera app
		launchCameraApp2();
	}

	private void launchCameraApp2() {
		try {
			// Replace with the appropriate command to open the camera app on Windows
			String command = "cmd /c start microsoft.windows.camera:";

			// Execute the command and wait for the process to finish
			Process process = Runtime.getRuntime().exec(command);
			int exitCode = process.waitFor();

			if (exitCode == 0) {
				// The process exited successfully (user closed the camera app)

				// Ask the user if they want to use the captured image
				Platform.runLater(() -> showConfirmationDialog2());
			} else {
				// The process exited with an error
				Platform.runLater(() -> showErrorMessage("Error launching the camera app. Please try again."));
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace(); // Print the stack trace for debugging
			Platform.runLater(() -> showErrorMessage("Error launching the camera app: " + e.getMessage()));
		}
	}

	private void showConfirmationDialog2() {
		Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
		confirmationAlert.setTitle("التاكيد");
		confirmationAlert.setHeaderText("هل تريد  صورة الان! ");
		confirmationAlert.setContentText("Choose 'OK' to use the image or 'Cancel' to discard it.");

		Optional<ButtonType> result = confirmationAlert.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.OK) {
			// Capture the new image
			// Image newImage = captureImage();

			// Get the path of the last image
			String lastImagePath = getLastImagePath();
			// System.out.println("Last Image Path: " + lastImagePath);

			if (lastImagePath != null) {
				File file = new File(lastImagePath);

				// Check if the file exists before trying to set the image
				if (file.exists()) {
					getData.path = file.getAbsolutePath();
					System.out.println("Setting image from file: " + lastImagePath);
					seance_libre_image.setImage(new Image(file.toURI().toString()));
				} else {
					System.out.println("Image file does not exist: " + lastImagePath);
				}
			} else {
				System.out.println("Last Image Path is null.");
			}
		} else {
			// Handle the case where the user clicked 'Cancel' in the confirmation dialog
			System.out.println("User canceled using the captured image.");
		}
	}
	
	
	
	
	
	
	
	

	private String[] positionList = { "1 mois", "2 mois", "3 mois", "4 mois", "5 mois", "6 mois", "7 mois", "8 mois",
			"9 mois", "10 mois", "11 mois", "12 mois" };
	private String defaultPosition = "Default mois"; // Set your default position here

	@SuppressWarnings("unchecked")
	public void addEmployeePositionList() {
		List<String> listP = new ArrayList<>(Arrays.asList(positionList));

		// Add default position
		listP.add(defaultPosition);

		ObservableList<String> listData = FXCollections.observableArrayList(listP);

		// Explicitly specify the type parameter for ComboBox
		ComboBox<String> comboBox = (ComboBox<String>) addEmployee_position;
		comboBox.setItems(listData);

		// Set default position as selected
		int defaultPositionIndex = listData.indexOf(defaultPosition);
		comboBox.getSelectionModel().select(defaultPositionIndex);
	}

	private String[] positionList1 = { "1 mois", "2 mois", "3 mois", "4 mois", "5 mois", "6 mois", "7 mois", "8 mois",
			"9 mois", "10 mois", "11 mois", "12 mois" };
	private String defaultPosition1 = "Default mois"; // Set your default position here

	@SuppressWarnings("unchecked")
	public void addEmployeePositionList1() {
		List<String> listP = new ArrayList<>(Arrays.asList(positionList1));

		// Add default position
		listP.add(defaultPosition1);

		ObservableList<String> listData = FXCollections.observableArrayList(listP);

		// Explicitly specify the type parameter for ComboBox
		ComboBox<String> comboBox = (ComboBox<String>) addEmployee_position_update;
		comboBox.setItems(listData);

		// Set default position as selected
		int defaultPositionIndex = listData.indexOf(defaultPosition1);
		comboBox.getSelectionModel().select(defaultPositionIndex);
	}

	private String[] listGender = { "Male", "Female" };

	public void addEmployeeGendernList() {
		List<String> listG = new ArrayList<>();

		for (String data : listGender) {
			listG.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(listG);
		addEmployee_gender.setItems(listData);
	}

	private String[] listabenment = { "يومي", "شهري" };

	public void addEmployeeabenmentList() {
		List<String> listG = new ArrayList<>();

		for (String data : listabenment) {
			listG.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(listG);
		type_abonment.setItems(listData);
	}

	private String[] listabenment1 = { "يومي", "شهري" };

	public void addEmployeeabenmentList1() {
		List<String> listG = new ArrayList<>();

		for (String data : listabenment1) {
			listG.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(listG);
		type_abonment_update.setItems(listData);
	}

	public void handleSearchButton(ActionEvent event) {
		StringProperty searchKey = new SimpleStringProperty(addEmployee_search.getText().toLowerCase());

		// Apply the filter
		FilteredList<employeeData> filter = new FilteredList<>(addEmployeeList, predicateEmployeeData -> {
			if (searchKey.get() == null || searchKey.get().isEmpty()) {
				return true;
			}

			String key = searchKey.get();

			return predicateEmployeeData.getEmployeeId().toString().contains(key)
					|| predicateEmployeeData.getFirstName().toLowerCase().contains(key)
					|| predicateEmployeeData.getLastName().toLowerCase().contains(key)
					|| predicateEmployeeData.getGender().toLowerCase().contains(key)
					|| predicateEmployeeData.getPhoneNum().toLowerCase().contains(key)
					|| predicateEmployeeData.getPosition().toLowerCase().contains(key)
					|| predicateEmployeeData.getDate().toString().contains(key);
		});

		// Sort the filtered list
		SortedList<employeeData> sortedList = new SortedList<>(filter);
		sortedList.comparatorProperty().bind(addEmployee_tableView.comparatorProperty());

		addEmployee_tableView.setItems(sortedList);
	}

	public ObservableList<employeeData> addEmployeeListData() {

		ObservableList<employeeData> listData = FXCollections.observableArrayList();
		String sql = "SELECT * FROM employee";

		connect = database.connectDb();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			employeeData employeeD;

			while (result.next()) {
				employeeD = new employeeData(result.getString("employee_id"), result.getString("firstName"),
						result.getString("lastName"), result.getString("gender"), result.getString("phoneNum"),
						result.getString("position"), result.getString("image"), result.getDate("date"),
						result.getInt("days_left_2"), result.getString("abonment_type"), result.getDate("date_fin"));
				listData.add(employeeD);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listData;
	}

	private ObservableList<employeeData> addEmployeeList;

	public void addEmployeeShowListData() {
	    addEmployeeList = addEmployeeListData();

	    addEmployee_col_employeeID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
	    addEmployee_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
	    addEmployee_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
	    addEmployee_col_phoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
	    addEmployee_col_position.setCellValueFactory(new PropertyValueFactory<>("position"));
	    addEmployee_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
	    addEmployee_col_date2.setCellValueFactory(new PropertyValueFactory<>("date2"));
	    addEmployee_col_abonmet.setCellValueFactory(new PropertyValueFactory<>("abonmentType"));

	    // Set the cell value factory for days_left TableColumn
	    if (days_left != null) {
	    	days_left.setCellValueFactory(new PropertyValueFactory<>("daysLeft"));

	    } else {
	        System.out.println("days_left is null");
	    }

	    addEmployee_tableView.setItems(addEmployeeList);

	    // Set row factory to change row color based on the condition
	    addEmployee_tableView.setRowFactory(tv -> {
	        TableRow<employeeData> row = new TableRow<>();

	        // Listen for changes in the itemProperty of each row
	        row.itemProperty().addListener((obs, oldItem, newItem) -> {
	            // Check if newItem is not null and its AbonmentType is "يومي" (daily)
	            if (newItem != null && newItem.getAbonmentType().equals("يومي")) {
	                // Set the background color to light blue
	                row.setStyle("-fx-background-color: lightblue;");
	            } else {
	                // Clear the background color
	                row.setStyle("");
	            }
	        });

	        return row;
	    });
	}


	public void addEmployeeSelect() {
		employeeData employeeD = addEmployee_tableView.getSelectionModel().getSelectedItem();
		int num = addEmployee_tableView.getSelectionModel().getSelectedIndex();

		if ((num - 1) < -1) {
			return;
		}

		addEmployee_employeeID.setText(String.valueOf(employeeD.getEmployeeId()));
		addEmployee_firstName.setText(employeeD.getFirstName());
		addEmployee_lastName.setText(employeeD.getLastName());
		addEmployee_phoneNum.setText(employeeD.getPhoneNum());
		addEmployee_employeeID2.setText(String.valueOf(employeeD.getEmployeeId()));
		getData.path = employeeD.getImage();
		numberOfDaysTextField.setText(String.valueOf(employeeD.getDaysLeft()));
		String uri = "file:" + employeeD.getImage();
		java.sql.Date sqlDate = employeeD.getDate2();
		if (sqlDate != null) {
		    datePicker.setValue(sqlDate.toLocalDate());
		} else {
		    // Handle the case where the date is null
		    // For example, set the datePicker to today's date
		    datePicker.setValue(LocalDate.now());
		}

		image = new Image(uri, 101, 127, false, true);
		addEmployee_image.setImage(image);

		java.sql.Date type = employeeD.getDate2();
		// String type1=employeeD.getGender();

		if (type != null) {

			labelSubscription.setVisible(true);
			addEmployee_position.setVisible(true);
			labelRemainingDays.setVisible(true);
			days_left1.setVisible(true);
			labelEndDate.setVisible(true);
			datePicker.setVisible(true);
			numberOfDaysTextField.setVisible(false);
			type_abonment1.setVisible(false);

		} else {

			labelSubscription.setVisible(false);
			addEmployee_position.setVisible(false);
			labelRemainingDays.setVisible(false);
			days_left1.setVisible(false);
			labelEndDate.setVisible(false);
			datePicker.setVisible(false);
			numberOfDaysTextField.setVisible(true);
			type_abonment1.setVisible(true);
			// numberOfDaysTextField.setText(String.valueOf(employeeD.getdays_Left_2()));

		}
	}

	public void salaryUpdate() {

		String sql = "UPDATE employee_info SET salary = '" + salary_salary.getText() + "' WHERE employee_id = '"
				+ salary_employeeID.getText() + "'";

		connect = database.connectDb();

		try {
			Alert alert;

			if (salary_employeeID.getText().isEmpty() || salary_firstName.getText().isEmpty()
					|| salary_lastName.getText().isEmpty() || salary_position.getText().isEmpty()) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Please select item first");
				alert.showAndWait();
			} else {
				statement = connect.createStatement();
				statement.executeUpdate(sql);

				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText(null);
				alert.setContentText("تم التعديل بنجاح");
				alert.showAndWait();

				salaryShowListData();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void salaryReset() {
		salary_employeeID.setText("");
		salary_firstName.setText("");
		salary_lastName.setText("");
		salary_position.setText("");
		salary_salary.setText("");
	}

	public ObservableList<employeeData> salaryListData() {

		ObservableList<employeeData> listData = FXCollections.observableArrayList();

		String sql = "SELECT * FROM employee_info";

		connect = database.connectDb();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			employeeData employeeD;

			while (result.next()) {
				employeeD = new employeeData(result.getString("employee_id"), result.getString("firstName"),
						result.getString("lastName"), result.getString("position"), result.getDouble("salary"));

				listData.add(employeeD);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listData;
	}

	private ObservableList<employeeData> salaryList;

	public void salaryShowListData() {
		salaryList = salaryListData();

		salary_col_employeeID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
		salary_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		salary_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		salary_col_position.setCellValueFactory(new PropertyValueFactory<>("position"));
		salary_col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));

		// Set row factory to change row color based on the condition
		salary_tableView.setRowFactory(tv -> {
			TableRow<employeeData> row = new TableRow<>();
			row.itemProperty().addListener((obs, oldItem, newItem) -> {
				if (newItem != null && newItem.getSalary() == 0) {
					row.setStyle("-fx-background-color: red;");
				} else {
					row.setStyle("");
				}
			});
			return row;
		});

		salary_tableView.setItems(salaryList);
	}

	public void salarySelect() {

		employeeData employeeD = salary_tableView.getSelectionModel().getSelectedItem();
		int num = salary_tableView.getSelectionModel().getSelectedIndex();

		if ((num - 1) < -1) {
			return;
		}

		salary_employeeID.setText(String.valueOf(employeeD.getEmployeeId()));
		salary_firstName.setText(employeeD.getFirstName());
		salary_lastName.setText(employeeD.getLastName());
		salary_position.setText(employeeD.getPosition());
		salary_salary.setText(String.valueOf(employeeD.getSalary()));

	}

	public void defaultNav() {
		if (home_btn != null) {
		home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
	}}

//	public void displayUsername() {
//		username.setText(getData.username);
//	}

	public void switchForm(ActionEvent event) {

		if (event.getSource() == home_btn) {
			home_form.setVisible(true);
			addEmployee_form.setVisible(false);
			salary_form.setVisible(false);
			addProduct_form.setVisible(false);
			search_form.setVisible(false);
			record_form.setVisible(false);
			seance_liber_form.setVisible(false);
			
			caisse_form.setVisible(false);
			caisse.setStyle("-fx-background-color:transparent");
			home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
			addEmployee_btn.setStyle("-fx-background-color:transparent");
			salary_btn.setStyle("-fx-background-color:transparent");
			product_btn.setStyle("-fx-background-color:transparent");
			record_btn.setStyle("-fx-background-color:transparent");
			seance_libre_btn.setStyle("-fx-background-color:transparent");
			homeTotalEmployees();
			homeEmployeeTotalPresent();
			homeTotalInactive();
			homeChart();

		} else if (event.getSource() == addEmployee_btn) {
			home_form.setVisible(false);
			addEmployee_form.setVisible(true);
			salary_form.setVisible(false);
			addProduct_form.setVisible(false);

			search_form.setVisible(false);
			record_form.setVisible(false);
			seance_liber_form.setVisible(false);
			caisse_form.setVisible(false);
			caisse.setStyle("-fx-background-color:transparent");
			addEmployee_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
			home_btn.setStyle("-fx-background-color:transparent");
			salary_btn.setStyle("-fx-background-color:transparent");
			product_btn.setStyle("-fx-background-color:transparent");
			record_btn.setStyle("-fx-background-color:transparent");
			seance_libre_btn.setStyle("-fx-background-color:transparent");
			addEmployeeGendernList();
			addEmployeePositionList();

			// addEmployeeSearch();

		} else if (event.getSource() == salary_btn) {
			home_form.setVisible(false);
			addEmployee_form.setVisible(false);
			salary_form.setVisible(true);
			addProduct_form.setVisible(false);
			search_form.setVisible(false);
			record_form.setVisible(false);
			seance_liber_form.setVisible(false);
			caisse_form.setVisible(false);
			caisse.setStyle("-fx-background-color:transparent");
			salary_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
			addEmployee_btn.setStyle("-fx-background-color:transparent");
			home_btn.setStyle("-fx-background-color:transparent");
			product_btn.setStyle("-fx-background-color:transparent");
			record_btn.setStyle("-fx-background-color:transparent");
			seance_libre_btn.setStyle("-fx-background-color:transparent");
			salaryShowListData();

		} else if (event.getSource() == product_btn) {
			addProduct_form.setVisible(true);
			home_form.setVisible(false);
			addEmployee_form.setVisible(false);
			salary_form.setVisible(false);
			search_form.setVisible(false);
			record_form.setVisible(false);
			seance_liber_form.setVisible(false);
			caisse_form.setVisible(false);
			caisse.setStyle("-fx-background-color:transparent");
			product_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
			salary_btn.setStyle("-fx-background-color:transparent");
			addEmployee_btn.setStyle("-fx-background-color:transparent");
			home_btn.setStyle("-fx-background-color:transparent");
			record_btn.setStyle("-fx-background-color:transparent");
			seance_libre_btn.setStyle("-fx-background-color:transparent");
		}
		else if (event.getSource() == record_btn) {
			record_form.setVisible(true);
			addProduct_form.setVisible(false);
			home_form.setVisible(false);
			addEmployee_form.setVisible(false);
			salary_form.setVisible(false);
			search_form.setVisible(false);
			seance_liber_form.setVisible(false);
			caisse_form.setVisible(false);
			caisse.setStyle("-fx-background-color:transparent");
			record_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
			product_btn.setStyle("-fx-background-color:transparent");
			salary_btn.setStyle("-fx-background-color:transparent");
			addEmployee_btn.setStyle("-fx-background-color:transparent");
			home_btn.setStyle("-fx-background-color:transparent");
			seance_libre_btn.setStyle("-fx-background-color:transparent");

		}else if (event.getSource() == seance_libre_btn) {
			seance_liber_form.setVisible(true);
			record_form.setVisible(false);
			addProduct_form.setVisible(false);
			home_form.setVisible(false);
			addEmployee_form.setVisible(false);
			salary_form.setVisible(false);
			search_form.setVisible(false);
			caisse_form.setVisible(false);
			caisse.setStyle("-fx-background-color:transparent");
			seance_libre_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
			record_btn.setStyle("-fx-background-color:transparent");
			product_btn.setStyle("-fx-background-color:transparent");
			salary_btn.setStyle("-fx-background-color:transparent");
			addEmployee_btn.setStyle("-fx-background-color:transparent");
			home_btn.setStyle("-fx-background-color:transparent");
			

		}
		else if (event.getSource() == caisse) {
			seance_liber_form.setVisible(false);
			record_form.setVisible(false);
			addProduct_form.setVisible(false);
			home_form.setVisible(false);
			addEmployee_form.setVisible(false);
			salary_form.setVisible(false);
			search_form.setVisible(false);
			caisse_form.setVisible(true);
		
			caisse.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
			seance_libre_btn.setStyle("-fx-background-color:transparent");
			record_btn.setStyle("-fx-background-color:transparent");
			product_btn.setStyle("-fx-background-color:transparent");
			salary_btn.setStyle("-fx-background-color:transparent");
			addEmployee_btn.setStyle("-fx-background-color:transparent");
			home_btn.setStyle("-fx-background-color:transparent");
			

		}


	}

	private double x = 0;
	private double y = 0;

	public void logout() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("هل انت متاكد من الخروج?");
		Optional<ButtonType> option = alert.showAndWait();
		try {
			if (option.get().equals(ButtonType.OK)) {

				logout.getScene().getWindow().hide();
				Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(root);

				root.setOnMousePressed((MouseEvent event) -> {
					x = event.getSceneX();
					y = event.getSceneY();
				});

				root.setOnMouseDragged((MouseEvent event) -> {
					stage.setX(event.getScreenX() - x);
					stage.setY(event.getScreenY() - y);

					stage.setOpacity(.8);
				});

				root.setOnMouseReleased((MouseEvent event) -> {
					stage.setOpacity(1);
				});

				stage.initStyle(StageStyle.TRANSPARENT);

				stage.setScene(scene);
				stage.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void close() {
		System.exit(0);
	}

	public void minimize() {
		Stage stage = (Stage) main_form.getScene().getWindow();
		stage.setIconified(true);
	}

//    

//    product method

	public void addEproductAdd() {

		Date date = new Date();
		new java.sql.Date(date.getTime());

		String sql = "INSERT INTO product " + "(product_id,firstName,lastName,gender,price,image, quantity) "
				+ "VALUES(?,?,?,?,?,?,?)";

		connect = database.connectDb();

		try {
			Alert alert;
			if (addproduct_employeeID.getText().isEmpty()
			// || addproduct_firstName.getText().isEmpty()
			// || addproduct_lastName.getText().isEmpty()
			// || addproduct_gender.getSelectionModel().getSelectedItem() == null
			// || addproduct_price.getText().isEmpty()
			// || getData.path == null || getData.path == ""
			) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("املء جميع المعلومات");
				alert.showAndWait();
			} else {

				String check = "SELECT product_id FROM product WHERE product_id = '" + addproduct_employeeID.getText()
						+ "'";

				statement = connect.createStatement();
				result = statement.executeQuery(check);

				if (result.next()) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("product ID: " + addproduct_employeeID.getText() + " موجود من قبل!");
					alert.showAndWait();
				} else {

					prepare = connect.prepareStatement(sql);
					prepare.setString(1, addproduct_employeeID.getText());
					prepare.setString(2, addproduct_firstName.getText());
					prepare.setString(3, addproduct_lastName.getText());
					prepare.setString(4, (String) addproduct_gender.getSelectionModel().getSelectedItem());
					prepare.setString(5, addproduct_price.getText());
					prepare.setString(7, quantity.getText());
					String uri = getData.path;
					if (uri == null) {
						// Assuming "defaultImage.png" is the name of your default image file in the
						// "image" package.
						uri = "/img/icons8-user-not-found-50.png";
					} else {
						// Replace backslashes with double backslashes.
						uri = uri.replace("\\", "\\\\");
					}

					prepare.setString(6, uri);

					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("تم الاضافة بنجاح");
					alert.showAndWait();

					addproductShowListData();
					addproductReset();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		addProductNamesToList();
	}
	public void addCaisse() {
	    // Get the current date
	    LocalDate currentDate = LocalDate.now();

	    String sql = "INSERT INTO caisse (product_name, quantity, unit_price, total_price, sale_date) " +
	                 "VALUES (?, ?, ?, ?, ?)";

	    connect = database.connectDb();

	    try {
	        Alert alert;
	        if (productComboBox.getSelectionModel().isEmpty() || 
	            quantityTextField.getText().isEmpty() || 
	            unitPriceTextField.getText().isEmpty()) {
	            alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("Error Message");
	            alert.setHeaderText(null);
	            alert.setContentText("Please fill in all the information.");
	            alert.showAndWait();
	        } else {
	            prepare = connect.prepareStatement(sql);
	            prepare.setString(1, productComboBox.getSelectionModel().getSelectedItem());
	            prepare.setString(2, quantityTextField.getText());
	            prepare.setString(3, unitPriceTextField.getText());
	            
	            // Calculate total price
	            double quantity = Double.parseDouble(quantityTextField.getText());
	            double unitPrice = Double.parseDouble(unitPriceTextField.getText());
	            double totalPrice = quantity * unitPrice;
	            prepare.setDouble(4, totalPrice);
	            
	            // Set sale date
	            prepare.setDate(5, java.sql.Date.valueOf(currentDate));

	            prepare.executeUpdate();

	            alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setTitle("Information Message");
	            alert.setHeaderText(null);
	            alert.setContentText("Entry added successfully.");
	            alert.showAndWait();

	            // Clear input fields
	            productComboBox.getSelectionModel().clearSelection();
	            quantityTextField.clear();
	            unitPriceTextField.clear();

	            // Update the table view with the new data
	            //addcaisseShowListData();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    addCaisseShowListData() ;
	}
	
	public ObservableList<caisse> addCaisseListData() {
	    ObservableList<caisse> listData = FXCollections.observableArrayList();
	    String sql = "SELECT * FROM caisse";

	    connect = database.connectDb();

	    try {
	        prepare = connect.prepareStatement(sql);
	        result = prepare.executeQuery();

	        while (result.next()) {
	        	caisse caisseData = new caisse(
	        		    result.getString("product_name"),
	        		    result.getInt("quantity"),
	        		    result.getInt("unit_price"),
	        		    result.getInt("total_price"),
	        		    result.getDate("sale_date")
	        		    
	        		);
	            listData.add(caisseData);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return listData;
	}
	
	public void onProductSelected(ActionEvent event) {
        // Retrieve the selected product from the ComboBox
        String selectedProduct = productComboBox.getValue();

        // Retrieve the price of the selected product from the database
        double price = retrievePriceFromDatabase(selectedProduct);

        // Set the price as the text of the unitPriceTextField
        unitPriceTextField.setText(String.valueOf(price));
    }

    // Method to retrieve price from the database based on product name
	// Define your database connection parameters
	private final String DB_URL = "jdbc:mysql://localhost:3306/employee";
	private final String DB_USERNAME = "root";
	private final String DB_PASSWORD = "Djamel14";

	// Method to retrieve price from the database based on product name
	private double retrievePriceFromDatabase(String productName) {
	    double price = 0.0;
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        // Establish the database connection
	        conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

	        // Prepare the SQL query
	        String query = "SELECT price FROM product WHERE firstName = ?";
	        stmt = conn.prepareStatement(query);
	        stmt.setString(1, productName);

	        // Execute the query
	        rs = stmt.executeQuery();

	        // Retrieve the price from the result set
	        if (rs.next()) {
	            price = rs.getDouble("price");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close the database resources
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return price;
	}

	

	private ObservableList<caisse> addCaisseList;

	public void addCaisseShowListData() {
	    addCaisseList = addCaisseListData();

	    addproduct_col_firstName1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
	    addproduct_col_quantity1.setCellValueFactory(new PropertyValueFactory<>("quantity"));
	    addproduct_col_prix1.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
	    addproduct_col_price_total.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
	    addproduct_col_date_vente.setCellValueFactory(new PropertyValueFactory<>("date"));


	    addcaisse_tableView.setItems(addCaisseList);
	}



	public void addproductUpdate() {

		String uri = getData.path;
		uri = uri.replace("\\", "\\\\");

		Date date = new Date();
		new java.sql.Date(date.getTime());

		String sql = "UPDATE product SET firstName = '" + addproduct_firstName.getText() + "', lastName = '"
				+ addproduct_lastName.getText() + "', gender = '"
				+ addproduct_gender.getSelectionModel().getSelectedItem() + "', price = '" + addproduct_price.getText()
				+ "', image = '"
				// + uri + "', date = '" + sqlDate
				+ "' WHERE product_id ='" + addproduct_employeeID.getText() + "'";

		connect = database.connectDb();

		try {
			Alert alert;
			if (addproduct_employeeID.getText().isEmpty() || addproduct_firstName.getText().isEmpty()
					|| addproduct_lastName.getText().isEmpty()
					// || addproduct_gender.getSelectionModel().getSelectedItem() == null
					|| addproduct_price.getText().isEmpty() || getData.path == null || getData.path == "") {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("املء جميع المعلومات");
				alert.showAndWait();
			} else {
				alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Cofirmation Message");
				alert.setHeaderText(null);
				alert.setContentText("هل انت متاكد من تعديل المنتج: " + addproduct_employeeID.getText() + "?");
				Optional<ButtonType> option = alert.showAndWait();

				if (option.get().equals(ButtonType.OK)) {
					statement = connect.createStatement();
					statement.executeUpdate(sql);

//                    

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("تم التعديل بنجاح");
					alert.showAndWait();

					addproductShowListData();
					addproductReset();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addproductDelete() {

		String sql = "DELETE FROM product WHERE product_id = '" + addproduct_employeeID.getText() + "'";

		connect = database.connectDb();

		try {

			Alert alert;
			if (addproduct_employeeID.getText().isEmpty()
//                    || addEmployee_firstName.getText().isEmpty()
//                    || addEmployee_lastName.getText().isEmpty()
//                    || addEmployee_gender.getSelectionModel().getSelectedItem() == null
//                    || addEmployee_phoneNum.getText().isEmpty()
//                    || addEmployee_position.getSelectionModel().getSelectedItem() == null
//                    || getData.path == null || getData.path == ""
			) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("املاء كل المعلومات ");
				alert.showAndWait();
			} else {
				alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Cofirmation Message");
				alert.setHeaderText(null);
				alert.setContentText("هل انت متاكد من حدف المنتج " + addproduct_employeeID.getText() + "?");
				Optional<ButtonType> option = alert.showAndWait();

				if (option.get().equals(ButtonType.OK)) {
					statement = connect.createStatement();
					statement.executeUpdate(sql);

//                    String deleteInfo = "DELETE FROM employee_info WHERE employee_id = '"
//                            + addEmployee_employeeID.getText() + "'";
//
//                    prepare = connect.prepareStatement(deleteInfo);
//                    prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("تم الحدف بنجاح");
					alert.showAndWait();

					addproductShowListData();
					addproductReset();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addproductReset() {
		addproduct_employeeID.setText("");
		addproduct_firstName.setText("");
		addproduct_lastName.setText("");
		addproduct_gender.getSelectionModel().clearSelection();

		addproduct_price.setText("");
		addproduct_image.setImage(null);
		getData.path = "";
	}

//    public void addproductInsertImage() {
//
//        FileChooser open = new FileChooser();
//        File file = open.showOpenDialog(main_form.getScene().getWindow());
//       if (file != null) {
//            getData.path = file.getAbsolutePath();
//
//            image = new Image(file.toURI().toString(), 101, 127, false, true);
//            addproduct_image.setImage(image);
//        }
//    }

	public void addproductInsertImage() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Choose Image Source");
		alert.setHeaderText("اختر من اين تريد الحصول على الصوررة ");
		alert.setContentText(" واختر ملف ادا كنت تريد احضارها من ملف او التقاط ادا كنت تريد التقاط صورة بالكاميراا.");

		ButtonType importButton = new ButtonType("ملف");
		ButtonType captureButton = new ButtonType("التقاط");

		alert.getButtonTypes().setAll(importButton, captureButton, ButtonType.CANCEL);

		alert.showAndWait().ifPresent(buttonType -> {
			if (buttonType == importButton) {
				importImageFromFile();
			} else if (buttonType == captureButton) {
				captureImageFromCamera();
			}
		});
	}

	private void importImageFromFile() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

		File file = fileChooser.showOpenDialog(new Stage());

		if (file != null) {
			// Assuming 'getData.path' is a class variable
			getData.path = file.getAbsolutePath();

			image = new Image(file.toURI().toString(), 101, 127, false, true);
			addproduct_image.setImage(image);
		}
	}

	private void captureImageFromCamera() {
		// Launch the camera app
		launchCameraApp();
	}

	private void launchCameraApp() {
		try {
			// Replace with the appropriate command to open the camera app on Windows
			String command = "cmd /c start microsoft.windows.camera:";

			// Execute the command and wait for the process to finish
			Process process = Runtime.getRuntime().exec(command);
			int exitCode = process.waitFor();

			if (exitCode == 0) {
				// The process exited successfully (user closed the camera app)

				// Ask the user if they want to use the captured image
				Platform.runLater(() -> showConfirmationDialog());
			} else {
				// The process exited with an error
				Platform.runLater(() -> showErrorMessage("Error launching the camera app. Please try again."));
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace(); // Print the stack trace for debugging
			Platform.runLater(() -> showErrorMessage("Error launching the camera app: " + e.getMessage()));
		}
	}

	private void showConfirmationDialog() {
		Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
		confirmationAlert.setTitle("التاكيد");
		confirmationAlert.setHeaderText("هل تريد  صورة الان! ");
		confirmationAlert.setContentText("Choose 'OK' to use the image or 'Cancel' to discard it.");

		Optional<ButtonType> result = confirmationAlert.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.OK) {
			// Capture the new image
			// Image newImage = captureImage();

			// Get the path of the last image
			String lastImagePath = getLastImagePath();
			System.out.println("Last Image Path: " + lastImagePath);

			if (lastImagePath != null) {
				File file = new File(lastImagePath);

				// Check if the file exists before trying to set the image
				if (file.exists()) {
					getData.path = file.getAbsolutePath();
					// System.out.println("Setting image from file: " + lastImagePath);
					addproduct_image.setImage(new Image(file.toURI().toString()));
				} else {
					System.out.println("Image file does not exist: " + lastImagePath);
				}
			} else {
				System.out.println("Last Image Path is null.");
			}
		} else {
			// Handle the case where the user clicked 'Cancel' in the confirmation dialog
			System.out.println("User canceled using the captured image.");
		}
	}

	// Other methods...

	private String getLastImagePath() {
		// Specify the folder path (adjust this based on your requirements)
		String cameraRollPath = System.getProperty("user.home") + File.separator + "Pictures" + File.separator
				+ "Camera Roll";

		File folder = new File(cameraRollPath);

		if (folder.exists() && folder.isDirectory()) {
			File[] files = folder.listFiles();

			if (files != null && files.length > 0) {
				// Sort files by last modified time in descending order
				Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());

				// Return the path of the first (latest) file
				return files[0].getAbsolutePath();
			}
		}

		// Return null if the folder is empty or does not exist
		return null;
	}

	private void showErrorMessage(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	private String[] listGender1 = { "Protein", "outil de sport" };

	public void addproductGendernList() {
		List<String> listG = new ArrayList<>();

		for (String data : listGender1) {
			listG.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(listG);
		addproduct_gender.setItems(listData);
	}

	private String[] listcombox1 = { "id", "first name" };

	public void searchbycombox() {
		List<String> listc = new ArrayList<>();

		for (String data : listcombox1) {
			listc.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(listc);
		searchByComboBox.setItems(listData);

	}



	public void handleSearchButton1(ActionEvent event) {
		StringProperty searchKey = new SimpleStringProperty(addproduct_search.getText().toLowerCase());

		// Apply the filter
		FilteredList<productData> filter = new FilteredList<>(addproductList, predicateproductData -> {
			if (searchKey.get() == null || searchKey.get().isEmpty()) {
				return true;
			}

			String key = searchKey.get();

			return predicateproductData.getProductId().toString().contains(key)
					|| predicateproductData.getFirstName().toLowerCase().contains(key)
					|| predicateproductData.getLastName().toLowerCase().contains(key)
			// || predicateproductData.getGender().toLowerCase().contains(key)
					|| predicateproductData.getPrice().toLowerCase().contains(key);

		});

		// Sort the filtered list
		SortedList<productData> sortedList = new SortedList<>(filter);
		sortedList.comparatorProperty().bind(addproduct_tableView.comparatorProperty());

		addproduct_tableView.setItems(sortedList);
	}

	public ObservableList<productData> addproductListData() {

		ObservableList<productData> listData = FXCollections.observableArrayList();
		String sql = "SELECT * FROM product";

		connect = database.connectDb();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			productData productD;

			while (result.next()) {
				productD = new productData(result.getString("product_id"), result.getString("firstName"),
						result.getString("lastName"), result.getString("gender"), result.getString("price"),

						result.getString("image"), result.getInt("quantity"));

				listData.add(productD);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listData;
	}

	private ObservableList<productData> addproductList;

	public void addproductShowListData() {
		addproductList = addproductListData();

		addproduct_col_employeeID.setCellValueFactory(new PropertyValueFactory<>("productId"));
		addproduct_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		addproduct_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		addproduct_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		addproduct_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		addproduct_col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		addproduct_tableView.setItems(addproductList);

	}

	public void addproductSelect() {
		productData productD = addproduct_tableView.getSelectionModel().getSelectedItem();
		int num = addproduct_tableView.getSelectionModel().getSelectedIndex();

		if ((num - 1) < -1) {
			return;
		}

		addproduct_employeeID.setText(String.valueOf(productD.getProductId()));
		addproduct_firstName.setText(productD.getFirstName());
		addproduct_lastName.setText(productD.getLastName());
		addproduct_price.setText(productD.getPrice());

		getData.path = productD.getImage();

		String uri = "file:" + productD.getImage();

		image = new Image(uri, 101, 127, false, true);
		addproduct_image.setImage(image);
	}
	
	
	public void seanceLibreSelect() {
	    Athlate athlete = seance_libre_tableView.getSelectionModel().getSelectedItem();
	    int selectedIndex = seance_libre_tableView.getSelectionModel().getSelectedIndex();

	    if (selectedIndex < 0) {
	        return;
	    }

	    seance_libre_employeeID.setText(athlete.getAthleteId());
	    seance_libre_firstName.setText(athlete.getFirstName());
	    seance_libre_lastName.setText(athlete.getLastName());
	    seance_libre_phoneNum.setText(athlete.getPhoneNumber());
	    seance_libre_price.setText(String.valueOf(athlete.getPrice()));
	    

	    // Assuming getImage() returns the image path for the athlete
	    String imagePath = athlete.getImage();
	    // Assuming imagePath is a valid file path
	    String uri = "file:" + imagePath;
	    
	    // Load the image
	    Image image = new Image(uri);
	    seance_libre_image.setImage(image);
	}

	
	 public ObservableList<Athlate> addAthleteListData() {
	        ObservableList<Athlate> listData = FXCollections.observableArrayList();
	        String sql = "SELECT * FROM athlete";

	        connect = database.connectDb();

	        try {
	            prepare = connect.prepareStatement(sql);
	            result = prepare.executeQuery();

	            while (result.next()) {
	                Athlate athleteData = new Athlate(
	                        result.getString("athlet_id_2"),
	                        result.getString("first_name"),
	                        result.getString("last_name"),
	                        result.getString("phone_number"),
	                        result.getDouble("price"),
	                        result.getString("image"),
	                        result.getDate("date_seance") // Assuming registration_date is a DATE column
	                );

	                listData.add(athleteData);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (connect != null) {
	                    connect.close();
	                }
	                if (prepare != null) {
	                    prepare.close();
	                }
	                if (result != null) {
	                    result.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return listData;
	    }

	    private ObservableList<Athlate> addAthleteList;

	    public void addAthleteShowListData() {
	        addAthleteList = addAthleteListData();

	        seance_libre_col_employeeID.setCellValueFactory(new PropertyValueFactory<>("athleteId"));
	        seance_libre_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
	        seance_libre_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
	        seance_libre_col_phoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
	        seance_libre_price1.setCellValueFactory(new PropertyValueFactory<>("price"));
	       
	        seance_libre_date.setCellValueFactory(new PropertyValueFactory<>("date")); // Assuming this is a TableColumn in your TableView

	        seance_libre_tableView.setItems(addAthleteList);
	    }
	
	
	

	
	// record form 
	    public ObservableList<EventRecord> retrieveEventRecords() {
	        try {
	            // Initialize connection1
	            String url = "jdbc:ucanaccess://C:/SafesmartBusinessEn/Database/Property2.mdb;password=AnsonSTMake811";
	            Connection connection1 = DriverManager.getConnection(url);

	            ObservableList<EventRecord> eventRecords = FXCollections.observableArrayList();
	            String selectQuery = "SELECT er.CardLow, er.EmployeeID, e.EmployeeName, er.AriseTime " +
	                     "FROM EventRecord er " +
	                     "JOIN Employee e ON er.EmployeeID = e.EmployeeID " +
	                     "WHERE EventType = 0";


	            try (PreparedStatement selectStatement = connection1.prepareStatement(selectQuery);
	                 ResultSet resultSet = selectStatement.executeQuery()) {

	                while (resultSet.next()) {
	                    String cardNumber = resultSet.getString("CardLow");
	                    int employeeId = resultSet.getInt("EmployeeID");
	                    String employeeName = resultSet.getString("EmployeeName");
	                    Timestamp ariseTime = resultSet.getTimestamp("AriseTime");

	                    String[] names = employeeName.split(" ");
	                    String firstName = names[0];
	                    String lastName = names.length > 1 ? names[names.length - 1] : "";

	                    EventRecord eventRecord = new EventRecord(cardNumber, employeeId, firstName, lastName, ariseTime);
	                    eventRecords.add(eventRecord);
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	            return eventRecords;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }


	public void populateRecordTableView() {
	    ObservableList<EventRecord> eventRecordList = retrieveEventRecords();

	    cardNumberColumn.setCellValueFactory(new PropertyValueFactory<>("cardNumber"));
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
       
        ariseTimeColumn.setCellValueFactory(new PropertyValueFactory<>("ariseTime"));

	    record_tableView.setItems(eventRecordList);
	}

	
	
	
	public void handleSearchButton3(ActionEvent event) {
	    ObservableList<EventRecord> eventRecordList = retrieveEventRecords();
	    FilteredList<EventRecord> filteredData = new FilteredList<>(eventRecordList);

	    // Bind the search text field to the filter
	    record_search.textProperty().addListener((observable, oldValue, newValue) -> {
	        String searchKey = newValue.toLowerCase().trim();
	        filteredData.setPredicate(eventRecord -> {
	            if (searchKey.isEmpty()) {
	                return true; // Show all records if search field is empty
	            }
	            // Check if any field contains the search key
	            return eventRecord.getCardNumber().toLowerCase().contains(searchKey) ||
	                    String.valueOf(eventRecord.getEmployeeId()).contains(searchKey) ||
	                    eventRecord.getFirstName().toLowerCase().contains(searchKey) ||
	                    eventRecord.getLastName().toLowerCase().contains(searchKey) ||
	                    eventRecord.getAriseTime().toString().contains(searchKey);
	        });
	    });

	    // Bind the filtered list to the table view
	    
	    record_tableView.setItems(filteredData);
	}

	public void handleSearchButtonSeanceLibre(ActionEvent event) {
	    ObservableList<Athlate> athlateList = addAthleteListData();
	    FilteredList<Athlate> filteredData = new FilteredList<>(athlateList);

	    // Bind the search text field to the filter
	    seance_libre_search.textProperty().addListener((observable, oldValue, newValue) -> {
	        String searchKey = newValue.toLowerCase().trim();
	        filteredData.setPredicate(athlate -> {
	            if (searchKey.isEmpty()) {
	                return true; // Show all Athletes if search field is empty
	            }
	            // Check if any field contains the search key
	            return athlate.getAthleteId().toLowerCase().contains(searchKey) ||
	                    athlate.getFirstName().toLowerCase().contains(searchKey) ||
	                    athlate.getLastName().toLowerCase().contains(searchKey) ||
	                    athlate.getPhoneNumber().toLowerCase().contains(searchKey) ||
	                    String.valueOf(athlate.getPrice()).contains(searchKey) ||
	                    athlate.getDate().toString().toLowerCase().contains(searchKey); // Convert date to string for comparison
	        });
	    });

	    // Bind the filtered list to the table view
	    seance_libre_tableView.setItems(filteredData);
	}


	
	public void initialize(URL location, ResourceBundle resources) {
		gettherecord();
		addAthleteShowListData();
		populateRecordTableView();
		//displayUsername();
		//defaultNav();
		defaultNav();
		homeTotalEmployees();
		homeEmployeeTotalPresent();
		homeTotalInactive();
		homeChart();
		addEmployeeShowListData();
		addCaisseShowListData();
		addEmployeeGendernList();
		addEmployeePositionList();
		addEmployeePositionList1();
		addproductShowListData();
		addproductGendernList();
		// addEmployeePositionList();

		salaryShowListData();
		searchbycombox();
		addEmployeeabenmentList();
		addEmployeeabenmentList1();
		updateEmployeeCheck();
		updateCheck2Column();
		synchronize();
		addProductNamesToList();
		ini();
		//openApplicationAndClickOK();
		//gettherecord();
		
		
		//synchronizeEmployee("0002954295");
		//synchronizeFlagColumn();
//		synchronizeFlagColumn2();
		 LocalDateTime currentDateTime = LocalDateTime.now();

	        // Format the current date and time with the day name and month name
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm");
	        String formattedDateTime = currentDateTime.format(formatter);

	        // Set the formatted date and time to the Label
	        currentDateTimeLabel.setText(formattedDateTime);
		
		addproduct_updateBtn3.setOnAction(event -> addUpdate3(event));

		type_abonment.setOnAction(event -> {
			String selectedType = (String) type_abonment.getSelectionModel().getSelectedItem();

			if ("شهري".equals(selectedType)) {
				// Show the labels, text fields, and date picker for monthly abonment
				labelSubscription.setVisible(true);
				addEmployee_position.setVisible(true);
				labelRemainingDays.setVisible(true);
				days_left1.setVisible(true);
				labelEndDate.setVisible(true);
				datePicker.setVisible(true);
				numberOfDaysTextField.setVisible(false);
				type_abonment1.setVisible(false);
			} else {
				// Hide the labels, text fields, and date picker for other types
				labelSubscription.setVisible(false);
				addEmployee_position.setVisible(false);
				labelRemainingDays.setVisible(false);
				days_left1.setVisible(false);
				labelEndDate.setVisible(false);
				datePicker.setVisible(false);
				numberOfDaysTextField.setVisible(true);
				type_abonment1.setVisible(true);
			}
		});

		addEmployee_search1.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				String input = addEmployee_search1.getText().trim();
				if (!input.isEmpty()) {
					// Check if the input is a valid ID (10 digits)
					if (input.matches("\\d{10}")) {
						// Call the search method when the text matches the required format for ID
						search();
					} else {
						// Check if the input is a valid name (alphabetic characters and reasonable
						// length)
						if (input.matches("[a-zA-Z]+") && input.length() <= 50) {
							// Call the search method when Enter is pressed and the text is a valid name
							search();
						} else {
							// Handle the case when the input doesn't match the required format for ID or
							// name
							// You may choose to display an error message or take other actions
						}
					}
					addEmployee_search1.clear();
				}
			}
		});
		Image image3;
		Image image4;
		image3 = new Image(
				getClass().getResource("/img/240_F_677752939_HtD0gmxVQRSRBB8IbiLxBxrs9pWcYY6Z.jpg").toExternalForm());
		addproduct_image.setImage(image3);

		image4 = new Image(getClass().getResource("/img/athlete.png").toExternalForm());
		addEmployee_image.setImage(image4);

		addEmployee_position.setOnAction(event -> {
			String selectedPosition = (String) addEmployee_position.getSelectionModel().getSelectedItem();
			// System.out.println("Debug: days_left1 before switch: " +
			// days_left1.getText());
			if (selectedPosition != null) {
				switch (selectedPosition) {
				case "1 mois":
					days_left1.setText(String.valueOf(30));
					selectedDays = 30;
					break;
				case "2 mois":
					selectedDays = 60;
					break;
				case "3 mois":
					selectedDays = 90;
					break;
				case "4 mois":
					selectedDays = 120;
					break;
				case "5 mois":
					selectedDays = 150;
					break;
				case "6 mois":
					selectedDays = 180;
					break;
				case "7 mois":
					selectedDays = 210;
					break;
				case "8 mois":
					selectedDays = 240;
					break;
				case "9 mois":
					selectedDays = 270;
					break;
				case "10 mois":
					selectedDays = 300;
					break;
				case "11 mois":
					selectedDays = 330;
					break;
				case "12 mois":
					selectedDays = 365;
					break;
				default:
					selectedDays = 0; // Default value if the selected item doesn't match any case
					break;
				}
				System.out.println(selectedDays);
				days_left1.setText(String.valueOf(selectedDays));
				// System.out.println("Debug: days_left1 after switch: " +
				// days_left1.getText());
			}
		});
		
		
		
		
	}
	
	@FXML
	private void commonInitialization() throws FindFailed  {
        // Your common initialization code here
//		defaultNav();
//		defaultNav();
//		homeTotalEmployees();
//		homeEmployeeTotalPresent();
//		homeTotalInactive();
//		homeChart();

		//addEmployeeShowListData();
//		//addEmployeeGendernList();
//		//addEmployeePositionList();
//		//addEmployeePositionList1();
		//addproductShowListData();
//		addproductGendernList();
//		// addEmployeePositionList();
//		synchronize();
//		salaryShowListData();
//		updateEmployeeCheck();
//		updateCheck2Column();
//		updateEmployeeCheck();
//		searchbycombox();
//		//addEmployeeabenmentList();
//		//addEmployeeabenmentList1();
//		updateEmployeeCheck();
		//synchronizeFlagColumn();
//		synchronizeFlagColumn2();
		//synchronizeEmployee("0002954295")
//		gettherecord();
//showAlert("Processing", "Opening application and clicking OK. Please wait...");
//        
//        // Run the process in a separate thread
//        new Thread(() -> {
//            openApplicationAndClickOK();
//        }).start();
//        updateEmployeeCheck();
//		updateCheck2Column();
		//openApplicationAndClickOK();
		//ini();
		gettherecord();
		addAthleteShowListData();
		populateRecordTableView();
		//displayUsername();
		defaultNav();
		defaultNav();
		homeTotalEmployees();
		homeEmployeeTotalPresent();
		homeTotalInactive();
		homeChart();
		addEmployeeShowListData();
		addCaisseShowListData();
		addEmployeeGendernList();
		addEmployeePositionList();
		addEmployeePositionList1();
		addproductShowListData();
		addproductGendernList();
		// addEmployeePositionList();

		salaryShowListData();
		searchbycombox();
		addEmployeeabenmentList();
		addEmployeeabenmentList1();
		updateEmployeeCheck();
		updateCheck2Column();
		synchronize();
		addProductNamesToList();
		
    }

    @FXML
    private void handleIniButtonClick(ActionEvent event) throws FindFailed  {
        commonInitialization();
        openApplicationAndClickOK();
        addEmployeeShowListData();
        
      //  synchronizeEmployee("0002954295");
    }
    
    public void handleIniButtonClick1(ActionEvent event) throws FindFailed  {
    	
    	gettherecord();
    	populateRecordTableView();
     
    }
    public void handleIniButtonClick2(ActionEvent event) throws FindFailed  {
    	//gettherecord();
    	
    	//ini();
    	updateEmployeeCheck();
		updateCheck2Column();
		populateRecordTableView();
    	addCaisseShowListData();
    	synchronize();
    	addEmployeeShowListData();
    	openApplicationAndClickOK();
     
    }

	public void addEmployeeReset1() {
		addEmployee_employeeID1.setText("");
		addEmployee_firstName1.setText(""); // Resetting the first name field
		addEmployee_lastName1.setText("");
		// ... other fields reset logic ...
		addEmployee_phoneNum1.setText("");
		// Resetting image and data path (assuming these are related to image handling)
		days_left2.setText("");
		addEmployee_image1.setImage(null);
		getData.path = "";
		validation.setImage(null);
		abonmet_type.setText("");
		date_fin.setText("");
		days_left_2.setText("");
	}

//    
	public void search() {
		synchronize();
		Date date = new Date();
		new java.sql.Date(date.getTime());
		connect = database.connectDb();

		// Determine the selected search criteria from the ComboBox
		String searchCriteria = (String) searchByComboBox.getValue(); // Assuming searchByComboBox is your ComboBox

		String check;
		if ("id".equals(searchCriteria)) {
			// Search by ID
			check = "SELECT employee_id, firstName, lastName, gender, phoneNum, position, image, date, days_left, date_fin, days_left_2, abonment_type FROM employee WHERE employee_id = '"
					+ addEmployee_search1.getText() + "'";
		} else if ("first name".equals(searchCriteria)) {
			// Search by First Name
			check = "SELECT employee_id, firstName, lastName, gender, phoneNum, position, image, date, days_left, date_fin, days_left_2, abonment_type FROM employee WHERE firstName = '"
					+ addEmployee_search1.getText() + "'";
		} else {
			Platform.runLater(() -> {
				Alert alert1 = new Alert(AlertType.INFORMATION);
				alert1.setTitle("Message");
				alert1.setHeaderText(null);
				alert1.setContentText(" اختر طريقة البحث");
				alert1.show();
				search_form.setVisible(false);
			});
			return;
		}

		try {
			statement = connect.createStatement();
			result = statement.executeQuery(check);
			if (result.next()) {
				// Employee found
			} else {
				addEmployeeReset1();
				Platform.runLater(() -> {
					Alert alert1 = new Alert(AlertType.INFORMATION);
					alert1.setTitle("Message");
					alert1.setHeaderText(null);
					alert1.setContentText("عضو غير موجود ");
					alert1.show();
				});
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return; // Exit the method in case of an exception
		}

		addProduct_form.setVisible(false);
		home_form.setVisible(false);
		addEmployee_form.setVisible(false);
		salary_form.setVisible(false);
		search_form.setVisible(true);

		product_btn.setStyle("-fx-background-color:transparent");
		salary_btn.setStyle("-fx-background-color:transparent");
		addEmployee_btn.setStyle("-fx-background-color:transparent");
		home_btn.setStyle("-fx-background-color:transparent");

		try {
			prepare = connect.prepareStatement(check);
			result = prepare.executeQuery();
			employeeData employeeD;

			while (result.next()) {
				employeeD = new employeeData(result.getString("employee_id"), result.getString("firstName"),
						result.getString("lastName"), result.getString("gender"), result.getString("phoneNum"),
						result.getString("position"), result.getString("image"), result.getDate("date"),
						result.getInt("days_left"), result.getDate("date_fin"), result.getString("abonment_type"), // Check
																													// this
																													// column
																													// name
						result.getInt("days_left_2"));

				addEmployee_employeeID1.setText(String.valueOf(employeeD.getEmployeeId()));
				addEmployee_firstName1.setText(employeeD.getFirstName());
				addEmployee_lastName1.setText(employeeD.getLastName());
				addEmployee_phoneNum1.setText(employeeD.getPhoneNum());
				abonmet_type.setText(employeeD.getAbonmentType());
				days_left2.setText(String.valueOf(employeeD.getDaysLeft()));
				days_left_2.setText(String.valueOf(employeeD.getdays_Left_2()));
				getData.path = employeeD.getImage();

				Date date2Value = employeeD.getDate2();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // or any desired date format
				String formattedDate = (date2Value != null) ? dateFormat.format(date2Value) : "";
				date_fin.setText(formattedDate);

				String uri = "file:" + employeeD.getImage();

				image = new Image(uri, 101, 127, false, true);
				addEmployee_image1.setImage(image);

				Image image2;
				datePicker_update.setVisible(false);
				days_left1_update.setVisible(false);
				type_abonment_update.setVisible(false);
				addEmployee_position_update.setVisible(false);
				abonmet_type.setVisible(true);
				days_left2.setVisible(true);
				date_fin.setVisible(true);
				days_left_2.setVisible(true);

				try {

					if ("99".equals(employeeD.getAbonmentType())) {
						int daysLeft2Value = employeeD.getdays_Left_2();

						if (daysLeft2Value == 0) {
							image2 = new Image(getClass().getResource("/img/no1.png").toExternalForm());
							validation.setImage(image2);
						} else {
							Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
							alert.setTitle("Decrement Confirmation");
							alert.setHeaderText("هل تريد انقاص حصة؟");
							alert.setContentText("اضغط على OK");
							// alert.showAndWait();
							Optional<ButtonType> resultButton = alert.showAndWait();

							if (resultButton.isPresent() && resultButton.get() == ButtonType.OK) {
								String currentText = days_left_2.getText();
								int currentValue = Integer.parseInt(currentText);

								// Decrement the value
								int decrementedValue = currentValue - 1;

								// Set the decremented value back to the TextField
								days_left_2.setText(String.valueOf(decrementedValue));

								// Update the corresponding database column
								try {
									// Assuming 'connect' is your database connection
									Connection connect = database.connectDb(); // Getting the connection from your
																				// Database class

									String updateSql = "UPDATE employee SET days_left_2 = ? WHERE employee_id = ?";
									try (PreparedStatement updateStatement = connect.prepareStatement(updateSql)) {
										updateStatement.setInt(1, decrementedValue);
										updateStatement.setString(2, addEmployee_employeeID1.getText());

										int rowsUpdated = updateStatement.executeUpdate();

										if (rowsUpdated > 0) {
											// System.out.println("days_left_2 decremented in the database.");
										} else {
											// System.out.println("No rows updated. Check if employee_id exists.");
											// System.out.println("Updating employee_id: " +
											// addEmployee_employeeID1.getText());

										}
									} catch (SQLException e) {
										e.printStackTrace();
									} finally {
										// Close the connection in a finally block to ensure it's closed even if an
										// exception occurs
										if (connect != null) {
											try {
												connect.close();
											} catch (SQLException e) {
												e.printStackTrace();
											}
										}
									}
								} catch (NumberFormatException e) {
									e.printStackTrace();
								}
							}

							image2 = new Image(getClass().getResource("/img/yes.png").toExternalForm());
							validation.setImage(image2);

						}
					}

					else if ("شهري".equals(employeeD.getAbonmentType())) {
						String dateFromTextField = date_fin.getText();

						// Parse the date from the TextField
						Date textFieldDate = parseDate(dateFromTextField);

						if (textFieldDate != null) {
							// Convert Date to LocalDate to compare only the date part
							LocalDate localDateFromTextField = textFieldDate.toInstant().atZone(ZoneId.systemDefault())
									.toLocalDate();
							LocalDate localCurrentDate = LocalDate.now();

							// Compare only year, month, and day
							if (localDateFromTextField.isEqual(localCurrentDate)
									|| localDateFromTextField.isBefore(localCurrentDate)) {
								// System.out.println("Date is equal to or earlier than the current date");
								// System.out.println("Parsed TextField Date: " + textFieldDate);
								// System.out.println("Current Date: " + new Date());
								image2 = new Image(getClass().getResource("/img/no1.png").toExternalForm());
								validation.setImage(image2); // Uncomment this line to set the image
							} else {
								// System.out.println("Date is later than the current date");
								// System.out.println("Parsed TextField Date: " + textFieldDate);
								// System.out.println("Current Date: " + new Date());
								image2 = new Image(getClass().getResource("/img/yes.png").toExternalForm());
								validation.setImage(image2); // Uncomment this line to set the image
							}
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Date parseDate(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the format accordingly
		try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	@FXML
	private void addUpdate1(ActionEvent event) {
		// Your existing code for handling the button click

		// Make the desired UI elements visible
		datePicker_update.setVisible(true);
		days_left1_update.setVisible(true);
		type_abonment_update.setVisible(true);
		addEmployee_position_update.setVisible(true);
		addproduct_updateBtn2.setVisible(true);
		abonmet_type.setVisible(false);
		days_left2.setVisible(false);
		date_fin.setVisible(false);
		days_left_2.setVisible(false);
		addproduct_updateBtn1.setVisible(false);
		addproduct_updateBtn3.setVisible(true);

	}

	@FXML
	private void addUpdate2(ActionEvent event) {
		// Your logic for addUpdate2
		datePicker_update.setVisible(false);
		days_left1_update.setVisible(false);
		type_abonment_update.setVisible(false);
		addEmployee_position_update.setVisible(false);

		abonmet_type.setVisible(true);
		days_left2.setVisible(true);
		date_fin.setVisible(true);
		days_left_2.setVisible(true);
		addproduct_updateBtn1.setVisible(true);
		addproduct_updateBtn3.setVisible(false);

	}

	private void addUpdate3(ActionEvent event) {
	    // Get the values from UI elements
	    String selectedEmployeeId = addEmployee_employeeID1.getText();
	    LocalDate selectedDate = datePicker_update.getValue();
	    String formattedDate = (selectedDate != null) ? selectedDate.toString() : null; // Removed quotes for NULL

	    String selectedDaysLeft1 = days_left1_update.getText();

	    // Handle empty or null selectedDaysLeft1
	    String finalSelectedDaysLeft1;
	    if (selectedDaysLeft1 == null || selectedDaysLeft1.isEmpty()) {
	        finalSelectedDaysLeft1 = "0";
	    } else {
	        finalSelectedDaysLeft1 = selectedDaysLeft1;
	    }

	    // Ensure that selectedAbonmentType and selectedPosition are not null
	    String selectedAbonmentType = (type_abonment_update.getSelectionModel().getSelectedItem() != null)
	            ? type_abonment_update.getSelectionModel().getSelectedItem().toString()
	            : null; // Removed quotes for NULL

	    String selectedPosition = (addEmployee_position_update.getSelectionModel().getSelectedItem() != null)
	            ? addEmployee_position_update.getSelectionModel().getSelectedItem().toString()
	            : null; // Removed quotes for NULL

	    // Your database update logic
	    Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
	    confirmationAlert.setTitle("Confirmation");
	    confirmationAlert.setHeaderText("هل انت متاكد من التحديث؟");
	    confirmationAlert.setContentText("اضغط OK.");

	    // Show and wait for the user's decision
	    confirmationAlert.showAndWait().ifPresent(response -> {
	        if (response == ButtonType.OK) {
	            // User clicked OK, proceed with the update
	            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "Djamel14")) {
	                String updateSql = "UPDATE employee SET " +
	                        "date_fin = ?, " +
	                        "days_left_2 = ?, " +
	                        "abonment_type = ?, " +
	                        "position = ?, " +
	                        "new_column = new_column + ? " +
	                        "WHERE employee_id = ?";

	                try (PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
	                    preparedStatement.setString(1, formattedDate);
	                    preparedStatement.setInt(2, Integer.parseInt(finalSelectedDaysLeft1));
	                    preparedStatement.setString(3, selectedAbonmentType);
	                    preparedStatement.setString(4, selectedPosition);
	                    preparedStatement.setInt(5, Integer.parseInt(finalSelectedDaysLeft1));
	                    preparedStatement.setString(6, selectedEmployeeId);

	                    int rowsUpdated = preparedStatement.executeUpdate();
	                    System.out.println(rowsUpdated + " rows updated.");
	                    updateEmployeeCheck();
	                   // openApplicationAndClickOK();
	                  //  synchronizeEmployee("0002954295");
	                    synchronize();
	                    // Fetch and update UI after the database update
	                    String check1 = "SELECT employee_id, firstName, lastName, gender, phoneNum, position, image, date, days_left, date_fin, abonment_type, days_left_2 FROM employee WHERE employee_id = ?";

	                    try (PreparedStatement prepare = connection.prepareStatement(check1)) {
	                        prepare.setString(1, addEmployee_employeeID1.getText());

	                        try (ResultSet result = prepare.executeQuery()) {
	                            if (result.next()) {
	                                employeeData employeeD = new employeeData(
	                                        result.getString("employee_id"),
	                                        result.getString("firstName"),
	                                        result.getString("lastName"),
	                                        result.getString("gender"),
	                                        result.getString("phoneNum"),
	                                        result.getString("position"),
	                                        result.getString("image"),
	                                        result.getDate("date"),
	                                        result.getInt("days_left"),
	                                        result.getDate("date_fin"),
	                                        result.getString("abonment_type"),
	                                        result.getInt("days_left_2"));

	                                // Update UI elements with fetched data
	                                addEmployee_employeeID1.setText(String.valueOf(employeeD.getEmployeeId()));
	                                addEmployee_firstName1.setText(employeeD.getFirstName());
	                                addEmployee_lastName1.setText(employeeD.getLastName());
	                                addEmployee_phoneNum1.setText(employeeD.getPhoneNum());
	                                abonmet_type.setText(employeeD.getAbonmentType());
	                                days_left2.setText(String.valueOf(employeeD.getDaysLeft()));
	                                days_left_2.setText(String.valueOf(employeeD.getdays_Left_2()));
	                                getData.path = employeeD.getImage();

	                                Date date2Value = employeeD.getDate2();
	                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	                                String formattedDate1 = (date2Value != null) ? dateFormat.format(date2Value) : "";
	                                date_fin.setText(formattedDate1);

	                                String uri = "file:" + employeeD.getImage();
	                                Image image = new Image(uri, 101, 127, false, true);
	                                addEmployee_image1.setImage(image);
	                            }
	                        }
	                    }
	                }
	            } catch (SQLException | NumberFormatException e) {
	                e.printStackTrace();
	                // Handle or log the exception as needed
	            }

	            // Optionally, you can show a success message or perform other actions
	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setTitle("Information");
	            alert.setHeaderText(null); // Use null to hide the header text
	            alert.setContentText("تم التحديث بنجاح ");
	            alert.showAndWait();

	            // Additional method for updating the list
	            addEmployeeShowListData();
	            synchronize();
	        } else {
	            // User clicked Cancel, do nothing or show a message
	            System.out.println("Update canceled by user.");
	            addproduct_updateBtn1.setVisible(true);
				addproduct_updateBtn3.setVisible(false);
	        }

	        // Additional logic after the update (if needed)
	        addproduct_updateBtn1.setVisible(true);
	        addproduct_updateBtn3.setVisible(false);
	        
	    });
	}

	
	
	@FXML
    private TextField username1;

    @FXML
    private PasswordField password1;
    @FXML
    private Button loginBtn1;

    @FXML
    private Button close1;
    
    public void handleAddUserButtonAction(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adduser.fxml"));
            Parent addUserParent = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Add User");
            stage.setScene(new Scene(addUserParent));

            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
	
	 
   
    
    public static void openApplicationAndClickOK() {
        // Path to SmartCard.exe
        String filePath = "C:\\SafesmartBusinessEn\\SmartCard.exe";

        // Create a File object representing the application
        File file = new File(filePath);

        // Check if the file exists and is executable
        if (file.exists() && file.canExecute()) {
            try {
                // Open the application using the default system application
                Desktop.getDesktop().open(file);
                System.out.println("SmartCard application opened successfully.");

                // Wait for the application to open
                Thread.sleep(2000); // Adjust the delay as needed

                // Simulate pressing the Enter key
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                System.out.println("Pressed the Enter key.");

                // Wait for 2 seconds
                Thread.sleep(2000);

                // Calculate relative coordinates for mouse click
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                double relativeX = screenSize.width * 0.80; // 85% from the left edge
                double relativeY = screenSize.height * 0.55; // 55% from the top edge
                int x = (int) relativeX;
                int y = (int) relativeY;

                // Move mouse to the calculated coordinates
                robot.mouseMove(x, y);

                // Simulate a mouse click
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                System.out.println("Clicked on the OK button.");

                Thread.sleep(1000);

                // Calculate relative coordinates for mouse click on Sync Settings button
                double syncSettingsRelativeX = screenSize.width * 0.65; // Adjust the x-coordinate as needed
                double syncSettingsRelativeY = screenSize.height * 0.59; // Adjust the y-coordinate as needed
                int syncSettingsX = (int) syncSettingsRelativeX;
                int syncSettingsY = (int) syncSettingsRelativeY;

                // Move mouse to the calculated coordinates and click on Sync Settings button
                robot.mouseMove(syncSettingsX, syncSettingsY);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                System.out.println("Clicked on the Sync Settings button.");
                Thread.sleep(3000);
                // Close the application by simulating Alt + F4 keys
                robot.keyPress(KeyEvent.VK_ALT);
                robot.keyPress(KeyEvent.VK_F4);
                robot.keyRelease(KeyEvent.VK_F4);
                robot.keyRelease(KeyEvent.VK_ALT);
                Thread.sleep(1000);
                
                ////////////
                
                ///////////////////  
                
                
                //gettherecord();
                // Show success alert
               // Platform.runLater(() -> showAlert("Success", "Operation completed successfully."));

            } catch (IOException | InterruptedException | AWTException e) {
                // Show error alert if an exception occurs
                Platform.runLater(() -> showAlert("Error", "An error occurred: " + e.getMessage()));
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            // Show error alert if the application file does not exist or is not executable
            Platform.runLater(() -> showAlert("Error", "SmartCard application file does not exist or is not executable."));
            System.out.println("SmartCard application file does not exist or is not executable.");
        }
    }

    private static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    public static void gettherecord() {
        // Path to SmartCard.exe
        String filePath = "C:\\SafesmartBusinessEn\\SmartCard.exe";

        // Create a File object representing the application
        File file = new File(filePath);

        // Check if the file exists and is executable
        if (file.exists() && file.canExecute()) {
            try {
                // Open the application using ProcessBuilder
                ProcessBuilder processBuilder = new ProcessBuilder(filePath);
                processBuilder.start();
                System.out.println("SmartCard application opened successfully.");

                // Wait for the application to open
                Thread.sleep(1000);

                // Simulate pressing the Enter key
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                System.out.println("Pressed the Enter key.");

                // Wait for 2 seconds
                Thread.sleep(1000);

                // Calculate relative coordinates for mouse click
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                double relativeX = screenSize.width * 0.80; // 85% from the left edge
                double relativeY = screenSize.height * 0.90; // 90% from the top edge
                int x = (int) relativeX;
                int y = (int) relativeY;

                // Move mouse to the calculated coordinates
                robot.mouseMove(x, y);

                // Simulate a mouse click
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                System.out.println("Clicked on the OK button.");

                Thread.sleep(1000);

                // Calculate relative coordinates for mouse click on Sync Settings button
                double syncSettingsRelativeX = screenSize.width * 0.65; // Adjust the x-coordinate as needed
                double syncSettingsRelativeY = screenSize.height * 0.54; // Adjust the y-coordinate as needed
                int syncSettingsX = (int) syncSettingsRelativeX;
                int syncSettingsY = (int) syncSettingsRelativeY;

                // Move mouse to the calculated coordinates and click on Sync Settings button
                robot.mouseMove(syncSettingsX, syncSettingsY);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                System.out.println("Clicked on the Sync Settings button.");

                Thread.sleep(1000);
                double syncSettingsRelativeX3 = screenSize.width * 0.55; // Adjust the x-coordinate as needed
                double syncSettingsRelativeY3 = screenSize.height * 0.53; // Adjust the y-coordinate as needed
                int syncSettingsX3 = (int) syncSettingsRelativeX3;
                int syncSettingsY3 = (int) syncSettingsRelativeY3;

                // Move mouse to the calculated coordinates and click on Sync Settings button
                robot.mouseMove(syncSettingsX3, syncSettingsY3);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                System.out.println("Clicked on the Sync Settings button.");
                Thread.sleep(1000);
                // Close the application by simulating Alt + F4 keys
                robot.keyPress(KeyEvent.VK_ALT);
                robot.keyPress(KeyEvent.VK_F4);
                robot.keyRelease(KeyEvent.VK_F4);
                robot.keyRelease(KeyEvent.VK_ALT);

                // Show success message
                System.out.println("SmartCard application closed.");

            } catch (IOException | InterruptedException | AWTException e) {
                System.err.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.err.println("SmartCard application file does not exist or is not executable.");
        }
    }
    public static void ini() {
        // Path to SmartCard.exe
        String filePath = "C:\\SafesmartBusinessEn\\SmartCard.exe";

        // Create a File object representing the application
        File file = new File(filePath);

        // Check if the file exists and is executable
        if (file.exists() && file.canExecute()) {
            try {
                // Open the application using the default system application
            	Desktop.getDesktop().open(file);
                System.out.println("SmartCard application opened successfully.");

                // Wait for the application to open
                Thread.sleep(1000); // Adjust the delay as needed

                // Simulate pressing the Enter key
                Robot robot1 = new Robot();
                robot1.keyPress(KeyEvent.VK_ENTER);
                robot1.keyRelease(KeyEvent.VK_ENTER);
                System.out.println("Pressed the Enter key.");

                // Wait for 2 seconds
                Thread.sleep(1000);

                // Calculate relative coordinates for mouse click
                Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
                double relativeX1 = screenSize1.width * 0.27; // 85% from the left edge
                double relativeY1 = screenSize1.height * 0.65; // 55% from the top edge
                int x1 = (int) relativeX1;
                int y1 = (int) relativeY1;

                // Move mouse to the calculated coordinates
                robot1.mouseMove(x1, y1);

                // Simulate a mouse click
                robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                System.out.println("Clicked on the OK button.");

                Thread.sleep(1000);

                // Calculate relative coordinates for mouse click on Sync Settings button
                double syncSettingsRelativeX1 = screenSize1.width * 0.92; // Adjust the x-coordinate as needed
                double syncSettingsRelativeY1 = screenSize1.height * 0.34; // Adjust the y-coordinate as needed
                int syncSettingsX1 = (int) syncSettingsRelativeX1;
                int syncSettingsY1 = (int) syncSettingsRelativeY1;

                // Move mouse to the calculated coordinates and click on Sync Settings button
                robot1.mouseMove(syncSettingsX1, syncSettingsY1);
                robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                System.out.println("Clicked on the Sync Settings button.");
                
                Thread.sleep(1000);
                
                double syncSettingsRelativeX3 = screenSize1.width * 0.55; // Adjust the x-coordinate as needed
                double syncSettingsRelativeY3 = screenSize1.height * 0.52; // Adjust the y-coordinate as needed
                int syncSettingsX3 = (int) syncSettingsRelativeX3;
                int syncSettingsY3 = (int) syncSettingsRelativeY3;

                // Move mouse to the calculated coordinates and click on Sync Settings button
                robot1.mouseMove(syncSettingsX3, syncSettingsY3);
                robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                System.out.println("Clicked on the Sync Settings button.");
                Thread.sleep(5000);
                double syncSettingsRelativeX4 = screenSize1.width * 0.05; // Adjust the x-coordinate as needed
                double syncSettingsRelativeY4 = screenSize1.height * 0.85; // Adjust the y-coordinate as needed
                int syncSettingsX4 = (int) syncSettingsRelativeX4;
                int syncSettingsY4 = (int) syncSettingsRelativeY4;

                // Move mouse to the calculated coordinates and click on Sync Settings button
                robot1.mouseMove(syncSettingsX4, syncSettingsY4);
                robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                System.out.println("Clicked on the Sync Settings button.");
                Thread.sleep(1000);
                double syncSettingsRelativeX5 = screenSize1.width * 0.65; // Adjust the x-coordinate as needed
                double syncSettingsRelativeY5 = screenSize1.height * 0.59; // Adjust the y-coordinate as needed
                int syncSettingsX5 = (int) syncSettingsRelativeX5;
                int syncSettingsY5 = (int) syncSettingsRelativeY5;

                // Move mouse to the calculated coordinates and click on Sync Settings button
                robot1.mouseMove(syncSettingsX5, syncSettingsY5);
                robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                System.out.println("Clicked on the Sync Settings button.");
                Thread.sleep(2000);
                // Close the application by simulating Alt + F4 keys
                robot1.keyPress(KeyEvent.VK_ALT);
                robot1.keyPress(KeyEvent.VK_F4);
                robot1.keyRelease(KeyEvent.VK_F4);
                robot1.keyRelease(KeyEvent.VK_ALT);
               
            } catch (IOException | InterruptedException | AWTException e) {
                // Show error alert if an exception occurs
                Platform.runLater(() -> showAlert("Error", "An error occurred: " + e.getMessage()));
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            // Show error alert if the application file does not exist or is not executable
            Platform.runLater(() -> showAlert("Error", "SmartCard application file does not exist or is not executable."));
            System.out.println("SmartCard application file does not exist or is not executable.");
        }
    }

    
    public void addAthleteAdd() {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "INSERT INTO athlete " +
                "(athlet_id_2, first_name, last_name,phone_number , price, image, date_seance) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, seance_libre_employeeID.getText());
            prepare.setString(2, seance_libre_firstName.getText());
            prepare.setString(3, seance_libre_lastName.getText());
            prepare.setString(4, seance_libre_phoneNum.getText());
            prepare.setString(5, seance_libre_price.getText());

            String uri = getData.path;
            if (uri == null) {
                uri = "/img/icons8-user-not-found-50.png";
            } else {
                uri = uri.replace("\\", "\\\\");
            }

            prepare.setString(6, uri);
            prepare.setDate(7, sqlDate); // Registration date

            prepare.executeUpdate();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Insertion successful");
            alert.showAndWait();

            // Additional actions if needed
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources if needed
            try {
                if (connect != null) {
                    connect.close();
                }
                if (prepare != null) {
                    prepare.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        addAthleteShowListData();
    }
    public void addAthleteDelete() {
        String sql = "DELETE FROM athlete WHERE athlet_id_2 = ?";

        connect = database.connectDb();

        try {
            Alert alert;
            if (seance_libre_employeeID.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Fill in all the information");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete the athlete " + seance_libre_employeeID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.isPresent() && option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, seance_libre_employeeID.getText());
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Deletion successful");
                    alert.showAndWait();

                    // Additional actions if needed
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources if needed
            try {
                if (connect != null) {
                    connect.close();
                }
                if (prepare != null) {
                    prepare.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        addAthleteShowListData();
    }
    public void athletReset() {
    	seance_libre_employeeID.setText("");
    	seance_libre_firstName.setText("");
    	seance_libre_lastName.setText("");
    	seance_libre_phoneNum.setText("");
    	seance_libre_price.setText("");
    	seance_libre_image.setImage(null);
		getData.path = "";
	}


    
    }




//    
