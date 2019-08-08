package projectmarket.market;

import projectmarket.products.Product;

import java.util.Scanner;

public class PurchaseItem extends Product {
    public Double quantity;
    public Double total;

    public PurchaseItem(Product product, Double quantity ){
        id = product.id;
        quantity = quantity;

    }

   /*public void showPurchaseItemRequestQuantity(){
       System.out.println("ProductName, MerchantAddress, UnitPrice(Bs),unit");
       System.out.println(productName+", "+merchantAdress+", "+unitPrice+", "+unit);
   }
   public void showPurchaseItem(){
       System.out.println(productName+", "+merchantAdress+", "+unitPrice+", "+unit+", "+quantity+", "+total);
   }
   public static void showHeaderPurchaseItem(){
       System.out.println("ProductName, MerchantAddress, UnitPrice(Bs),unit, quantity, total");
   }*/
}
