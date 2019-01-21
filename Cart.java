import java.util.*;

public class Cart {
  // intialize max value
  final static int MAX_CART_ITEMS = Integer.MAX_VALUE;

  // null properties (un-intialized cart)
  private int num_items = 0;
  private double total_cost = 0.00;

  // list of cart contents
  private List<Product> products = new ArrayList<Product>();

  // default constructor
  public Cart() {}

  // getters (no setters as cart depends on contents)
  public Integer getNumberItems() { return num_items; }
  public Double getTotal() { return total_cost; }
  public List<Product> getProducts() { return products; }

  // return items currently in stock
  public List<Product> getProducts(boolean isAvailable) {
    List<Product> available_products = new ArrayList<Product>();
    for(Product product : products)
      if(isAvailable ? product.getInventory() >= 1 : true)
        available_products.add(product);
    return available_products;
  }

  // return products with a matching title
  public List<Product> getProducts(String title, boolean isAvailable) {
    List<Product> matching_products = new ArrayList<Product>();
    for(Product product : products)
      if(product.getTitle() == title && (isAvailable ? product.getInventory() >= 1 : true))
        matching_products.add(product);
    return matching_products;
  }

  public boolean addProduct(Product product) {
    // if cart is not full
    if(num_items <= MAX_CART_ITEMS) {
      // attempt adding
      if(products.add(product))
        return updateCart(product, true);
    }
    return false;
  }

  public boolean removeProduct(Product product) {
    // if cart has items
    if(num_items >= 1) {
      // attempt removing
      if(products.remove(product))
        return updateCart(product, false);
    }
    return false;
  }

  public boolean removeProduct(String title) {
    // if cart has items
    if(num_items >= 1) {
      // attempt removing
      for(Product product : products) {
        if(product.getTitle() == title)
          return updateCart(product, false);
      }
    }
    return false;
  }

  public boolean checkout() {
    boolean success = false;
    // null product check
    if(isValid()) {
      // payment here (if successful)
      boolean payment = true;
      // let's assume it went through
      if(payment) {
        success = true;
        updateInventory();
        clearCart();
      }
    }
    return success;
  }

  private boolean updateCart(Product product, boolean adding) {
    // get price
    double price = product.getPrice();
    // invert if removing
    if(!adding)
      price *= -1;
    // update properties
    total_cost += price;
    num_items += (adding ? 1 : -1);
    //
    return true;
  }

  private void clearCart() {
    // reset cart state
    num_items = 0;
    total_cost = 0.00;
    products = new ArrayList<Product>();
  }

  private void updateInventory() {
    // iterate through products
    for(Product product : products)
      // purchase each one
      product.purchase();
  }

  private boolean isValid() {
    return (this.num_items != 0 && this.total_cost != 0);
  }

  public String toString() {
    // initial properties
    String cart = "Number of Items: '" + this.num_items +
    "', Total: '" + this.total_cost + "', Contents: '";
    // add contents
    for(Product product : this.products)
      cart += "\n" + product.toString();
    cart += "'";
    return cart;
  }
}
