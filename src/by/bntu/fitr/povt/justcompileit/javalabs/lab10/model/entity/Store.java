package by.bntu.fitr.povt.justcompileit.javalabs.lab10.model.entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Store {

    private static int DELTA = 2;
    private static final String ORDER_ERROR = "We can't order this product.";
    private static final String ORDER_SUCCESS = "Ordering is ended successfully...";
    private static final String NO_MANEY_ERROR = "You don't have enough money.";
    private static final String DONT_HAVE_SUCH = "There's no such product in the Store.";
    private static final String DONT_HAVE_MANY = "We don't have so many...";
    private static final String SELL_SUCCESS ="There is you product...";
    private static final String EMPTY_INVENTORY =  "None";


    private ArrayList<Integer> productPrice;
    private ArrayList<String> productName;
    private ArrayList<Long> productAmount;

    {
        productPrice = new ArrayList<>();
        productName = new ArrayList<>();
        productAmount = new ArrayList<>();
    }
    public Store(String[] names, Integer[] prices, Long[] amount) {
        this.productName.addAll(Arrays.asList(names));
        this.productAmount.addAll(Arrays.asList(amount));
        this.productPrice.addAll(Arrays.asList(prices));
    }

    public Integer[] showPrice() {
        return this.productPrice.toArray(new Integer[this.productPrice.size()]);
    }

    public Long[] showAmount() {
        return this.productAmount.toArray(new Long[this.productAmount.size()]);
    }

    public String sell(String product, long amount, Human person) {

        String msg = NO_MANEY_ERROR;

        int index = getProductIndex(product);

        if (index < 0) {
            msg = DONT_HAVE_SUCH;

        } else if (amount > this.productAmount.get(index)) {
            msg = DONT_HAVE_MANY;
        } else if (this.productPrice.get(index) * amount <= person.showMoney()) {

            this.productAmount.set(index, productAmount.get(index) - amount);

            person.giveMoney(this.productPrice.get(index));
            person.addProduct(amount, product);

            msg = SELL_SUCCESS;

            if (this.productAmount.get(index) == 0) {
                deleteProduct(index);
            }
        }
        return msg;
    }

    public String[] viewProducts() {

        String[] names = {EMPTY_INVENTORY};

        if (this.productName.size() > 0) {
            names = this.productName.toArray(new String[productName.size()]);
        }
        return names;
    }

    public String orderProduct(long amount, String name, Manufacturer... manufacturers) {

        String msg = ORDER_ERROR;

        for (int i = 0; i <= manufacturers.length; i++) {

            if (manufacturers[i].getProduct(name)) {
                int index = getProductIndex(name);

                if (index > 0) {
                    this.productAmount.set(index, this.productAmount.get(index) + amount);
                } else {
                    addProduct(amount, name, manufacturers[i].givePrice(name) + DELTA);
                }

                msg = ORDER_SUCCESS;
                break;
            }
        }
        return msg;
    }

    private int getProductIndex(String product) {

        int index = -1;

        if (this.productName.contains(product)) {
            index = this.productName.indexOf(product);
        }

        return index;
    }

    private void addProduct(long amount, String name, int price) {
        this.productName.add(name);
        this.productAmount.add(amount);
        this.productPrice.add(price);
    }

    private void deleteProduct(int index) {
        this.productAmount.remove(index);
        this.productName.remove(index);
        this.productPrice.remove(index);
    }
}