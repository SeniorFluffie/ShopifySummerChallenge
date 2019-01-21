public class Product {
  // intialize null parameters
  private String title;
  private double price = 0.00;
  private int inventory_count = 0;

  // default constructor
  public Product() {}

  // standard constructor
  public Product(String title, double price, int inventory_count) {
    this.title = title;
    this.price = price;
    this.inventory_count = inventory_count;
  }

  // getters
  public int getInventory() { return inventory_count; }
  public double getPrice() { return price; }
  public String getTitle() { return title; }

  // setters
  public void setInventory(int inventory_count) { this.inventory_count = inventory_count; }
  public void setPrice(double price) { this.price = price; }
  public void setTitle(String title) { this.title = title; }

  public boolean purchase() {
    boolean success = false;
    // null product check
    if(isValid()) {
      // pre-increment (preventing excess memory usage)
      --this.inventory_count;
      success = true;
    }
    return success;
  }

  private boolean isValid() {
    return ((this.title != "")
    && (this.inventory_count != 0));
  }

  public String toString() {
    return "Title: '" + this.title +
    "', Price: '" + this.price +
    "', Inventory: '" + this.inventory_count + "'";
  }
}
