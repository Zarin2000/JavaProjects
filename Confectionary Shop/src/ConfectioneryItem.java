public class ConfectioneryItem {
    private final String name;
    private double price;
    private int quantity;
    public ConfectioneryItem(String name, double price,int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }
    public String toString() {
        return  "Food Name: " + name + "; Per piece Price: " + price + "; Remaining Food Quantity: " + quantity;

    }
    public void subsQuantity(int quant){
        this.quantity-=quant;
    }

}
class baverage extends ConfectioneryItem {
    public baverage(String name, double price, int quantity) {
        super(name, price, quantity);
    }
}
class bakery extends ConfectioneryItem {
    public bakery(String name, double price, int quantity) {
        super(name, price, quantity);
    }
}