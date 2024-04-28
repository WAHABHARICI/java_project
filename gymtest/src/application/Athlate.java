package application;

import java.sql.Date;
import java.time.LocalDate;

public class Athlate {
    private String employeeID;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private double price;
    private Date date; 
    private String image;

    // Constructor
    public Athlate(String employeeID, String firstName, String lastName, String phoneNum, double price, String image,Date date) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.price = price;
        this.date=date;
        this.image=image;
    }
//    public Athlate(String employeeID, String firstName, String lastName, String phoneNum,
//            double price, String image, Date date) {
// this.employeeID = employeeID;
// this.firstName = firstName;
// this.lastName = lastName;
// this.phoneNum = phoneNum;
// this.price = price;
// this.image = image;
// this.date = date;
//}

	public String getImage() {
		
		return image;
	}

	public Date getDate() {
		return date;
	}
    // Getters and setters
    public String getAthleteId() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
