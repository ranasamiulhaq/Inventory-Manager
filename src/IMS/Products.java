package IMS;

import java.io.Serializable;

public  abstract class Products implements Serializable {
    public abstract void addProduct();
    public abstract void showStock();
    public abstract void stockQuantity();
}
