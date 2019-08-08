package projectmarket.products;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product {
    private File importFile;
    public ArrayList<Integer> selectedProduct;
    public Integer selectedMerchantId;

    protected Integer id;
    protected String name;
    protected String price;
    protected String available;
    protected String unitOfMeasure;

    // productString = "2,fideos lazaroni,4.5,true,0.5Kg"
    public Product(String productString){
        String productData[] = productString.split(",");
        id = Integer.parseInt(productData[0]);
        name = productData[1];
        price = productData[2];
        available = productData[3];
        unitOfMeasure = productData[4];
    }

    public ArrayList<Integer> selectProducts() throws Exception {
        System.out.println("Enter a number to select a Product by 'Product ID'/press a letter to skip");
        selectedProduct = new ArrayList<Integer>();
        Scanner scannerConsole = new Scanner(System.in);
        while (scannerConsole.hasNextInt()) {
            selectedProduct.add(scannerConsole.nextInt());
        }
        return selectedProduct;
    }

    public String ShowProduct(){
        return id + " " + name + " " + price;
    }
}
