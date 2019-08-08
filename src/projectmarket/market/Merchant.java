package projectmarket.market;
import projectmarket.products.Product;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Merchant {
    private ArrayList<Product> productItems;
    Order order; //it should belong to client class

    public Integer selectedMerchant;
    public String merchant;

    public Merchant(){
        productItems = new ArrayList<Product>();
        order =
    }

    public void loadProductsByMerchantId(Integer merchantId) throws Exception {
        File importFile = new File(merchantId + "_product.txt");
        Scanner scanner = new Scanner(importFile);
        System.out.println("Product ID, productName, unit Price, available, unit, office");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Product myProduct = new Product(line);
            productItems.add(myProduct);

            System.out.println(line);
        }
    }

    public void ShowOption(){

    }

    public void ShowProducts(){
        for (int i = 0; i < productItems.size(); i++){
            Product p = productItems.get(i);
            System.out.println(p.ShowProduct());
        }
    }

    public void addProductToOrder(int productId, Double quantity){
        if(order == null){
            order = new Order();
        }

        Product selectedProduct = productItems.get(productId - 1);
        order.selectedItems.add(new PurchaseItem(selectedProduct, quantity));
    }

    public Integer selectMerchant()throws Exception{
        System.out.println("Enter a number to select a Merchant by 'Merchant ID':");
        Scanner scannerConsole = new Scanner(System.in);
        selectedMerchant = scannerConsole.nextInt();
        return selectedMerchant;
    }

    public static String[] getMerchantData(Integer merchantId) throws Exception {
        String[] merchantData;
        File importFile = new File ("Merchant.txt" );
        Scanner scanner = new Scanner (importFile);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            merchantData = line.split(",");
            if (new Integer(merchantData[0]).compareTo(merchantId) == 0){
                return merchantData;
            }
        }
        return null;
    }

}
