package ua.dymohlo.moduletwo;

public class Groceries {

    String productName;
    int numberOfProduct;
    double productPrice;

    public Groceries(String productName, int numberOfProduct, double productPrice) {
        this.productName = productName;
        this.numberOfProduct = numberOfProduct;
        this.productPrice = productPrice;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public double getTotalPrice() {
        return numberOfProduct * productPrice;
    }

    @Override
    public String toString() {
        return productName + " has quantity: " + numberOfProduct + ", at the price per piece: " + productPrice;
    }
}
