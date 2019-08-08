package projectmarket.market;

import java.util.Scanner;

public class PurchaseItem {
    public String productName;
    public String merchantAdress;
    public Double unitPrice;
    public String unit;
    public Double quantity;
    public Double total;
   public void showPurchaseItemRequestQuantity(){
       System.out.println("ProductName, MerchantAddress, UnitPrice(Bs),unit");
       System.out.println(productName+", "+merchantAdress+", "+unitPrice+", "+unit);
   }
   public void showPurchaseItem(){
       System.out.println(productName+", "+merchantAdress+", "+unitPrice+", "+unit+", "+quantity+", "+total);
   }
   public static void showHeaderPurchaseItem(){
       System.out.println("ProductName, MerchantAddress, UnitPrice(Bs),unit, quantity, total");
   }
}
