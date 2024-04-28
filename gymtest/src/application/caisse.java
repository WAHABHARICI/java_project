package application;

import java.util.Date;

public class caisse {
    private String productId;
    private String firstName;
    private int quantity;
    private int unitPrice;
    private Date date;
    private int totalPrice;
    
    
    public caisse(String firstName, int i, int quantity, int unitPrice, Date date, int totalPrice) {
       // this.productId = productId;
        this.firstName = firstName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public caisse( String firstName, int quantity, int unitPrice, int totalPrice, Date date) {
        
        this.firstName = firstName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.date=date;
    }
    public Date getDate() {
        return date;
    }
    // Getter methods
    public String getProductId() {
        return productId;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    // Setter methods
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}


