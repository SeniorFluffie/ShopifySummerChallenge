public class TestCart {
  //@Test
  public static void testInitialize() {
    Cart test = new Cart();
    System.out.println(test);
  }

  //@Test
  public static void testGetMethods() {
    Cart test = new Cart();
    System.out.println(test.getNumberItems() + ", " + test.getTotal() + ", " + test.getProducts());
  }

  //@Test
  public static void testPurchaseEmpty() {
    Cart test_1 = new Cart();
    System.out.println("Before purchase: " + test_1);
    System.out.println("Successful: " + test_1.checkout());
    System.out.println("After purchase: " + test_1);
  }

  //@Test
  public static void testPurchase() {
    Cart test = new Cart();
    test.addProduct(new Product("Test_Product_1", 12.34, 3));
    test.addProduct(new Product("Test_Product_2", 0.00, 5));
    test.addProduct(new Product("Test_Product_3", 42.00, 0));
    test.addProduct(new Product("", 0.00, 0));
    System.out.println("Before purchase: " + test);
    System.out.println("Successful: " + test.checkout());
    System.out.println("After purchase: " + test);
  }

  //@Test
  public static void testRemoval() {
    Cart test = new Cart();
    Product test_product = new Product("Test_Product_1", 12.34, 3);
    test.addProduct(test_product);
    System.out.println("Before removal: " + test);
    test.removeProduct(test_product);
    System.out.println("After removal: " + test);

    test.addProduct(new Product("Test_Product_2", 6.66, 5));
    test.addProduct(new Product("Test_Product_3", 42.00, 0));
    test.addProduct(new Product("", 0.00, 0));
    System.out.println("Before removal: " + test);
    test.removeProduct("Test_Product_2");
    System.out.println("After removal: " + test);
    test.removeProduct("Test_Product_4");
    System.out.println("Null removal: " + test);
  }

  public static void main(String[] args) {
    testInitialize();
    System.out.println("---------------------------------------------");
    testGetMethods();
    System.out.println("---------------------------------------------");
    testPurchaseEmpty();
    System.out.println("---------------------------------------------");
    testPurchase();
    System.out.println("---------------------------------------------");
    testRemoval();
    System.out.println("---------------------------------------------");
  }
}
