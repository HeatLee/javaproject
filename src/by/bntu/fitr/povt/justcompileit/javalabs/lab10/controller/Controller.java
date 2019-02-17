package by.bntu.fitr.povt.justcompileit.javalabs.lab10.controller;

import by.bntu.fitr.povt.justcompileit.javalabs.lab10.model.entity.Human;
import by.bntu.fitr.povt.justcompileit.javalabs.lab10.model.entity.Manufacturer;
import by.bntu.fitr.povt.justcompileit.javalabs.lab10.model.entity.Menu;
import by.bntu.fitr.povt.justcompileit.javalabs.lab10.model.entity.Store;
import by.bntu.fitr.povt.justcompileit.javalabs.lab10.printer.Printer;
import by.bntu.fitr.povt.justcompileit.javalabs.lab10.userinput.UserInput;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    public static final String SELECT_ITEM = "Select menu item: ";
    public static final String SELECT_PRODUCT = "Select product from list: ";
    public static final String SELECT_AMOUNT = "Input amount of product: ";
    public static final String BUY_ITEM = "Buy product";
    public static final String VIEW_ITEM = "View product";
    public static final String ORDER_ITEM = "Oder product";
    public static final String CHECK_ITEM = "Check inventory";
    public static String[] DEFAULT_FARM_PRODUCTS = {"apple", "potato"};
    public static Integer[] DEFAULT_FARM_PRICE = {10, 5};
    public static String[] DEFAULT_FACTORY_PRODUCT = {"T-shirt", "boots"};
    public static Integer[] DEFAULT_FACTORY_PRICE = {30, 50};
    public static String[] DEFAULT_STORE_PRODUCT = {"apple", "boots"};
    public static Integer[] DEFAULT_STORE_PRICE = {11, 55};
    public static Long[] DEFAULT_STORE_AMOUNT = {20L, 1L};
    public static long DEFAULT_HUMAN_MONEY = 500L;


    public static void main(String[] args) {

        Menu menu = new Menu(new String[]{BUY_ITEM, VIEW_ITEM, ORDER_ITEM, CHECK_ITEM});

        Manufacturer[] manufacturers = new Manufacturer[]{
                new Manufacturer(DEFAULT_FARM_PRODUCTS, DEFAULT_FARM_PRICE),
                new Manufacturer(DEFAULT_FACTORY_PRODUCT, DEFAULT_FACTORY_PRICE)};

        Store store = new Store(DEFAULT_STORE_PRODUCT, DEFAULT_STORE_PRICE, DEFAULT_STORE_AMOUNT);

        Human person = new Human(DEFAULT_HUMAN_MONEY);

        boolean run = true;

        while (run) {

            Printer.view(menu.viewItems());

            String item = menu.selectItem(UserInput.inputInt(SELECT_ITEM));

            switch (item) {

                case BUY_ITEM:

                    Printer.view(menu.viewItems(store.viewProducts(), store.showPrice(), store.showAmount()));

                    String product = menu.selectItem(UserInput.inputInt(SELECT_PRODUCT),
                            store.viewProducts());

                    if (!product.equals(Menu.WRONG_INDEX)) {
                        long amount = UserInput.inputLong(SELECT_AMOUNT);
                        String rez = store.sell(product, amount, person);
                        Printer.view(rez);
                    }
                    break;

                case VIEW_ITEM:

                    Printer.view(menu.viewItems(store.viewProducts(), store.showPrice(), store.showAmount()));
                    break;
                case ORDER_ITEM:

                    ArrayList<String> items = new ArrayList<>(0);
                    for (Manufacturer obj : manufacturers) {
                        items.addAll(Arrays.asList(obj.viewProducts()));
                    }
                    String[] aItems = items.toArray(new String[items.size()]);
                    Printer.view(menu.viewItems(aItems));

                    String orderProduct = menu.selectItem(UserInput.inputInt(SELECT_PRODUCT), aItems);

                    long orderAmount = UserInput.inputLong(SELECT_AMOUNT);
                    String rez = store.orderProduct(orderAmount, orderProduct, manufacturers);
                    Printer.view(rez);
                    break;
                case CHECK_ITEM:
                    Printer.view(person.checkState());
                    break;
                case Menu.EXIT:
                    run = false;
                    break;

                default:
                    Printer.view(Menu.WRONG_INDEX + "\n");
                    break;
            }
        }
    }

}
