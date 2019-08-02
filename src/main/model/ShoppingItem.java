package model;

public class ShoppingItem extends ListItem {
    private String shoppingItem;
    private int quantity;
    private int price;

    public ShoppingItem(String shoppingItem, int quantity, int price) {
        super(shoppingItem);
        this.shoppingItem = shoppingItem;
        this.quantity = quantity;
        this.price = price;
    }

    public String getShoppingItem() {
        return shoppingItem;
    }

    public void setShoppingItem(String shoppingItem) {
        this.shoppingItem = shoppingItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
