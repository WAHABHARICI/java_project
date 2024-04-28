package application;

import java.sql.Timestamp;

public class EventRecord {
    private String cardNumber;
    private int employeeId;
    private String firstName;
    private String lastName;
    private Timestamp ariseTime;

    public EventRecord(String cardNumber, int employeeId, String firstName, String lastName, Timestamp ariseTime) {
        this.cardNumber = cardNumber;
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ariseTime = ariseTime;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public Timestamp getAriseTime() {
        return ariseTime;
    }

    public void setAriseTime(Timestamp ariseTime) {
        this.ariseTime = ariseTime;
    }
}

