package by.bntu.fitr.povt.justcompileit.javalabs.lab10.model.entity;

import java.util.ArrayList;
import java.util.Arrays;


public class Human {

    private static final String OUTPUT_PRODUCTS = "Products:";
    private static final String OUTPUT_NAME = "Name";
    private static final String OUTPUT_AMOUNT = "Count";
    private static final String OUTPUT_MONEY = "Money: ";

    private long money;
    private ArrayList<String> productName;
    private ArrayList<Long> productAmount;

    {
        money = 1000L;
        productName = new ArrayList<>();
        productAmount = new ArrayList<>();
    }

    public Human(long money, String[] names, Long[] amounts) {
        this.money = money;
        this.productName.addAll(Arrays.asList(names));
        this.productAmount.addAll(Arrays.asList(amounts));
    }

    public Human(long money) {
        this.money = money;
    }

    public Human() {

    }

    public void giveMoney(long price) {
        this.money -= price;
    }

    public long showMoney() {
        return this.money;
    }

    public void addProduct(long amount, String name) {
        int index = getProductIndex(name);
        if (index >= 0) {
            this.productAmount.set(index, this.productAmount.get(index) + amount);
        } else {
            this.productName.add(name);
            this.productAmount.add(amount);
        }

    }

    public String checkState() {
        StringBuilder items = new StringBuilder(OUTPUT_PRODUCTS + "\n");

        items.append(String.format("|%-10s| %s\n", OUTPUT_NAME, OUTPUT_AMOUNT));
        items.append("-------------------\n");
        for (int i = 0; i < this.productName.size(); i++) {
            items.append(String.format("|%-10s| %s\n", productName.get(i), productAmount.get(i).toString()));
        }
        items.append("\n").append(OUTPUT_MONEY).append(this.money);
        return items.toString();
    }

    private int getProductIndex(String product) {
        int index = -1;
        if (this.productName.contains(product)) {
            index = this.productName.indexOf(product);
        }
        return index;
    }
}
