package by.bntu.fitr.povt.justcompileit.javalabs.lab10.model.entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

    public static final int MIN_INDEX = -1;
    public static final String WRONG_INDEX = "Incorrect index!";
    public static final int MAX_INDEX = 5;
    public static final String EXIT = "Exit";
    public static String OUTPUT_INDEX = "Index";
    public static String OUTPUT_NAME = "Name";
    public static String OUTPUT_AMOUNT = "Amount";
    public static String OUTPUT_PRICE = "Price";
    public ArrayList<String> stringValueItems;

    {
        stringValueItems = new ArrayList<>(0);
    }

    public Menu() {
        this.stringValueItems.add(EXIT);
    }

    public Menu(String[] items) {
        this.stringValueItems.addAll(Arrays.asList(items));
        this.stringValueItems.add(EXIT);
    }


    public String viewItems() {
        StringBuilder items = new StringBuilder();
        for (int i = 0; i < this.stringValueItems.size(); i++) {
            items.append(i + 1).append(". ").append(this.stringValueItems.get(i)).append("\n");
        }
        return items.toString();
    }

    public String selectItem(int i) {
        if (i >= MIN_INDEX && i <= MAX_INDEX) {
            return this.stringValueItems.get(i - 1);
        } else {
            return WRONG_INDEX;
        }
    }

//\\\\///    //////

    public String viewItems(String[] fields, Integer[] prices, Long[] amount) {

        StringBuilder items = new StringBuilder();

        items.append(String.format("|%-10s| %-10s | %-10s| %s\n",
                OUTPUT_INDEX, OUTPUT_NAME, OUTPUT_AMOUNT, OUTPUT_PRICE));
        items.append("---------------------------------\n");

        for (int i = 0; i < fields.length; i++) {
            items.append(String.format("|%-10s| %-10s | %-10s |%s", Integer.toString(i + 1), fields[i], amount[i],
                    prices[i])).append("\n");
        }
        return items.toString();
    }

    public String viewItems(String[] fields) {
        StringBuilder items = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            items.append(i + 1).append(". ").append(fields[i]).append("\n");
        }
        return items.toString();
    }

    public String selectItem(int i, String[] items) {
        return items[i - 1];
    }


}
