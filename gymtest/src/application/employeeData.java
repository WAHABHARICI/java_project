package application;

import java.sql.Date;

public class employeeData {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String gender;
	private String phoneNum;
	private String position;
	private String image;
	private Date date;
	private Double salary;
	private Integer daysLeft;
	private Date date2;
	private String abonmentType;
	private Integer days_Left_2;

	public employeeData(String employeeId, String firstName, String lastName, String gender, String phoneNum,
			String position, String image, Date date) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.position = position;
		this.image = image;
		this.date = date;
	}

	public employeeData(String employeeId, String firstName, String lastName, String position, Double salary) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.salary = salary;
	}

	public employeeData(String employeeId, String firstName, String lastName, String gender, String phoneNum,
			String position, String image, Date date, Integer daysLeft) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.position = position;
		this.image = image;
		this.date = date;
		this.daysLeft = daysLeft;
	}

	public employeeData(String employeeId, String firstName, String lastName, String gender, String phoneNum,
			String position, String image, Date date, Integer daysLeft, Date date2) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.position = position;
		this.image = image;
		this.date = date;
		this.daysLeft = daysLeft;
		this.date2 = date2;
	}

	public employeeData(String employeeId, String firstName, String lastName, String gender, String phoneNum,
			String position, String image, Date date, Integer daysLeft, Date date2, String abonmentType,
			Integer days_Left_2) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.position = position;
		this.image = image;
		this.date = date;
		this.daysLeft = daysLeft;
		this.date2 = date2;
		this.abonmentType = abonmentType;
		this.days_Left_2 = days_Left_2;
	}

	public employeeData(String employeeId, String firstName, String lastName, String gender, String phoneNum,
			String position, String image, Date date, Integer daysLeft, Date date2, Integer days_Left_2) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.position = position;
		this.image = image;
		this.date = date;
		this.daysLeft = daysLeft;
		this.date2 = date2;

		this.days_Left_2 = days_Left_2;
	}

	public employeeData(String employeeId, String firstName, String lastName, String gender, String phoneNum,
			String position, String image, Date date, Integer daysLeft, String abonmentType, Date date2) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.position = position;
		this.image = image;
		this.date = date;
		this.daysLeft = daysLeft;
		this.date2 = date2;
		this.abonmentType = abonmentType;
		/// this.days_Left_2=days_Left_2;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getPosition() {
		return position;
	}

	public String getAbonmentType() {
		return abonmentType;
	}

	public String getImage() {
		return image;
	}

	public Date getDate() {
		return date;
	}

	public Double getSalary() {
		return salary;
	}

	public Integer getDaysLeft() {
	    return daysLeft;
	}


	public Integer getdays_Left_2() {
		return days_Left_2;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate_fin(Date date_fin) {
		this.date2 = date_fin;
	}

	public Integer getDays_Left_2() {
		return days_Left_2;
	}

}
