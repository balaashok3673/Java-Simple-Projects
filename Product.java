import java.lang.reflect.Array;
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

     Product(String productName , String productDescription , double productPrice , int productQuantity){
        this.id= ++counter;
        this.productName=productName;
        this.productDescription=productDescription;
        this.productPrice=productPrice;
        this.productQuantity=productQuantity;
    }


    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                '}';
    }

}

 class Cart{
    ArrayList<Product> cart = new ArrayList<>();

     public String addProduct(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product name");
        String name = sc.next();sc.nextLine();
        System.out.println("Enter product product description");
        String des = sc.next();sc.nextLine();
        System.out.println("Product price : ");
        double price = sc.nextDouble();sc.nextLine();
        System.out.println("Enter product quantity : ");
        int quantity = sc.nextInt();sc.nextLine();
        Product pr = new Product(name,des,price, quantity );
        cart.add(pr);
        System.out.println("Product has been added successfulY");
        return "Product has been added successfully";
     }

     public void viewCart(){
         if (cart.isEmpty()){
             System.out.println("Cart is empty");
         }else {
             for (Product p : cart){
                 System.out.println(p);
             }
         }
     }

    public void deleteProduct(Product product){
         if (cart.isEmpty()){
             System.out.println("There is no product in cart");
         }else {
             cart.remove(product);
         }
    }

}





