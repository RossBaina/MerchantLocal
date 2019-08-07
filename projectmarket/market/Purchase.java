package projectmarket.market;

import projectmarket.products.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Purchase {
    public ArrayList<Double> quantities;
    public ArrayList<PurchaseItem> itemList;
    public Double total = 0d;

    public ArrayList<PurchaseItem> selectQuantities(ArrayList<Integer> products, String[] merchantData) throws Exception {
        Scanner scannerConsole;
        itemList = new ArrayList<PurchaseItem>();
        for (int i = 0; i < products.size(); i++) {
            PurchaseItem purchaseItem = new PurchaseItem();
            String[] productData = Product.getProductData(products.get(i), new Integer(merchantData[0]));
            purchaseItem.productName = productData[1];
            purchaseItem.merchantAdress = merchantData[2];
            purchaseItem.unit = productData[4];
            purchaseItem.unitPrice = Double.parseDouble(productData[2]);

            System.out.println("Enter a quantity by 'Product ID':" + products.get(i));
            purchaseItem.showPurchaseItemRequestQuantity();
            scannerConsole = new Scanner(System.in);
            purchaseItem.quantity = scannerConsole.nextDouble();
            purchaseItem.total = purchaseItem.unitPrice * purchaseItem.quantity;
            itemList.add(purchaseItem);
        }
        return itemList;
    }

    public void showItems() {
        PurchaseItem.showHeaderPurchaseItem();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).showPurchaseItem();
        }
        System.out.println("Order Total: "+getTotal()+"Bs");
    }

    public Double getTotal() {
        for (int i = 0; i < itemList.size(); i++) {
            total = total + itemList.get(i).total;
        }
        return total;
    }
}
