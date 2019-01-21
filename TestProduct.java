public class TestProduct {
  //@Test
  public static void testInitialize() {
    Product test = new Product("Test 1", 19.74, 10);
    System.out.println(test);
  }

  //@Test
  public static void testGetMethods() {
    Product test_1 = new Product("Test 1", 13.37, 10);
    Product test_2 = new Product("", 0.00, 0);

    System.out.println(test_1.getTitle() + ", " + test_1.getPrice() + ", " + test_1.getInventory());
    System.out.println(test_2.getTitle() + ", " + test_2.getPrice() + ", " + test_2.getInventory());
  }

  //@Test
  public static void testSetMethods() {
    Product test = new Product("", 19.74, 10);
    System.out.println("Before set: " + test);
    test.setTitle("Test 1");
    test.setPrice(99.99);
    test.setInventory(1);
    System.out.println("After set: " + test);
  }

  //@Test
  public static void testPurchase() {
    Product test_1 = new Product("Test_Purchase_1", 24.30, 10);
    System.out.println("Before purchase: " + test_1);
    System.out.println("Successful: " + test_1.purchase());
    System.out.println("After purchase: " + test_1);
    Product test_2 = new Product("Test_Purchase_2", 24.30, 0);
    System.out.println("Before purchase: " + test_2);
    System.out.println("Successful: " + test_2.purchase());
    System.out.println("After purchase: " + test_2);
  }

  public static void main(String[] args) {
    testInitialize();
    System.out.println("---------------------------");
    testGetMethods();
    System.out.println("---------------------------");
    testSetMethods();
    System.out.println("---------------------------");
    testPurchase();
    System.out.println("---------------------------");
  }
}
