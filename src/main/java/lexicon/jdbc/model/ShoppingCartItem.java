package lexicon.jdbc.model;

public class ShoppingCartItem {
    Product product;
    ShoppingCart cart;
    private int id;
    private int amount;
    private double totalPrice;
    private int productId;
    private int shoppingCartId;

    public ShoppingCartItem(int id, int amount, double totalPrice,int productId, int shippingCartId) {
        this.id = id;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.productId=productId;
        this.shoppingCartId=shippingCartId;
    }

    public ShoppingCartItem(){}

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    @Override
    public String toString(){
        return id+" "+amount+" "+totalPrice;
    }
}
