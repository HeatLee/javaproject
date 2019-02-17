package by.bntu.fitr.povt.justcompileit.javalabs.lab10.model.entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Manufacturer {

    private ArrayList<String> productName;
    private ArrayList<Integer> productPrice;

    {
        productName = new ArrayList<>(0);
        productPrice = new ArrayList<>(0);
        // amount of ich product is infinite
    }
    public Manufacturer(String[] productName, Integer[] productPrice) {
        this.productName.addAll(Arrays.asList(productName));
        this.productPrice.addAll(Arrays.asList(productPrice));
    }

    public String[] viewProducts() {
        return this.productName.toArray(new String[0]);
    }


    public int givePrice(String product) {
        return this.productPrice.get(getProductIndex(product));
    }

    public boolean getProduct(String product) {
        boolean answer = false;
        if (this.productName.contains(product)) {
            answer = true;
        }
        return answer;
    }

    private int getProductIndex(String product) {
        int index = -1;
        if (this.productName.contains(product)) {
            index = this.productName.indexOf(product);
        }
        return index;
    }

}
