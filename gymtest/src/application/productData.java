package application;

public class productData {

	private String productId;
	private String firstName;
	private String lastName;
	private String gender;
	private String price;
	private String image;
	 private int quantity;

	public productData(String productId, String firstName, String lastName, String gender, String price, String image,int quantity) {
		this.productId = productId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.price = price;
		this.image = image;
		this.quantity=quantity;
	}
	
	public int getQuantity() {
        return quantity;
    }
	// Getter methods
	public String getProductId() {
		return productId;
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

	public String getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	// Setter methods
	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
