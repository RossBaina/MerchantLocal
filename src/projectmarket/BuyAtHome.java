package projectmarket;

import projectmarket.market.Merchant;
import projectmarket.market.Order;
import projectmarket.products.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class BuyAtHome {

    public static void main(String[] args){
        System.out.println("Welcome to 'BUY AT HOME'");
        Scanner programScanner = new Scanner(System.in);
        System.out.println("Press enter numbers only in the options letters as product ID and Merchant Id");
        System.out.println("Do you want to place an Order (Y/N)?");
        String option = programScanner.nextLine();

        while(option.equalsIgnoreCase("Y")) {
            Merchant merchant = new Merchant();
            Product product = new Product();
            Order order = new Order();

            try {
                String merchantOption = GetOptions("Merchant.txt");
                System.out.println(merchantOption);
                Integer merchantId = merchant.selectMerchant();
                merchant.loadProductsByMerchantId(merchantId);

                System.out.println("Press 0 to stop purchasing");


                ArrayList<Integer> productsSelected = product.selectProducts();
                String[] partialMerchant = Merchant.getMerchantData(merchantId);
                order.selectQuantities(productsSelected, partialMerchant);
                order.showItems();
                System.out.println("ORDER COMPLETED!");
            } catch (Exception e) {
                System.out.println("Error in application " + e.getStackTrace());
            }
            System.out.println("Do you want to continue ordering (Y/N)?");
            option = programScanner.nextLine();
        }

        System.out.println("BYE!!!");
    }

    private  static String GetOptions(String fileName) throws Exception {

        File importFile = new File (fileName );
        Scanner scanner = new Scanner (importFile);
        String options  = "Merchant ID, MerchantName, address, available, type, main office\n";

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            options = options + line + "\n";
        }

        return options;
    }
}
