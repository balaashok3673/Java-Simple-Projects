import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    private int id;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productQuantity;
    static int counter;

    public Product(String productName , String productDescription , double productPrice , int productQuantity){
        this.id= ++counter;
        this.productName=productName;
        this.productDescription=productDescription;
        this.productPrice=productPrice;
        this.productQuantity=productQuantity;
    }

    public void addProduct(Product product){
        ArrayList<Product> products;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product name");
        String name = sc.next();sc.nextLine();
        System.out.println("Enter product product description");
        String des = sc.next();sc.nextLine();
        System.out.println("Product price : ");
        double price = sc.nextDouble();sc.nextLine();
        System.out.println("Enter product quantity : ");
        int quantity = sc.nextInt();sc.nextLine();

    }
}
