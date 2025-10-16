import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product {
    private int id;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productQuantity;
    static int counter;

    Product(String productName, String productDescription, double productPrice, int productQuantity) {
        this.id = ++counter;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public int getId() { return id; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getProductDescription() { return productDescription; }
    public void setProductDescription(String productDescription) { this.productDescription = productDescription; }
    public double getProductPrice() { return productPrice; }
    public void setProductPrice(double productPrice) { this.productPrice = productPrice; }
    public int getProductQuantity() { return productQuantity; }
    public void setProductQuantity(int productQuantity) { this.productQuantity = productQuantity; }

    @Override
    public String toString() {
        return "[" + id + "] " + productName + " - " + productDescription + " | ₹" + productPrice + " | Qty: " + productQuantity;
    }
}

class CartService {
    ArrayList<Product> cart = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addProduct() {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter product description: ");
        String desc = sc.nextLine();
        System.out.print("Enter product price: ");
        double price = sc.nextDouble();
        System.out.print("Enter product quantity: ");
        int qty = sc.nextInt();
        sc.nextLine();
        Product pr = new Product(name, desc, price, qty);
        cart.add(pr);
        System.out.println("Product has been added successfully!");
    }

    public void viewAllProducts() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            for (Product p : cart) {
                System.out.println(p);
            }
        }
    }

    private Product findById(int id) {
        for (Product p : cart) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public void deleteProduct() {
        if (cart.isEmpty()) {
            System.out.println("There is no product in cart");
            return;
        }
        System.out.print("Enter product ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();
        Product found = findById(id);
        if (found != null) {
            cart.remove(found);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    public void updateProduct() {
        if (cart.isEmpty()) {
            System.out.println("No products to update.");
            return;
        }
        System.out.print("Enter product ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        Product found = findById(id);
        if (found == null) {
            System.out.println("Product not found!");
            return;
        }
        System.out.print("Enter new name (leave blank to keep same): ");
        String newName = sc.nextLine();
        if (!newName.isEmpty()) found.setProductName(newName);

        System.out.print("Enter new description (leave blank to keep same): ");
        String newDesc = sc.nextLine();
        if (!newDesc.isEmpty()) found.setProductDescription(newDesc);

        System.out.print("Enter new price (0 to keep same): ");
        double newPrice = sc.nextDouble();
        if (newPrice != 0) found.setProductPrice(newPrice);

        System.out.print("Enter new quantity (-1 to keep same): ");
        int newQty = sc.nextInt();
        if (newQty != -1) found.setProductQuantity(newQty);

        System.out.println("Product updated successfully!");
    }
}

class Main {
    public static void main(String[] args) {
        CartService service = new CartService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= CART MANAGEMENT =========");
            System.out.println("1  Add Product");
            System.out.println("2  View All Products");
            System.out.println("3  Update Product");
            System.out.println("4  Delete Product");
            System.out.println("5  Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> service.addProduct();
                case 2 -> service.viewAllProducts();
                case 3 -> service.updateProduct();
                case 4 -> service.deleteProduct();
                case 5 -> {
                    System.out.println("Thank you for using the Cart Management System!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
