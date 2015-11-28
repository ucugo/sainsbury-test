package sainsburys.console.application.test.repository;

import sainsburys.console.application.test.model.ConsoleResponse;
import sainsburys.console.application.test.model.Item;

import java.util.Arrays;
import java.util.List;

/**
 * A repo that generates static response object for console app
 */
public class RipeFruitRepo {
    /**
     *
     * @param avocadoUnitPrice Avocado unit price
     * @param pearUnitPrice Pear unit price
     * @param kiwiUnitPrice unit price for kiwi
     * @param mangoUnitPrice unit price for mango
     * @return A ConsoleResponse object
     */
    public ConsoleResponse getResponse(double avocadoUnitPrice,
                                       double pearUnitPrice,
                                       double kiwiUnitPrice,
                                       double mangoUnitPrice) {

       return new ConsoleResponse
                .Builder()
                .withItems(getItems(avocadoUnitPrice, pearUnitPrice, kiwiUnitPrice, mangoUnitPrice))
                .build();
    }

    /**
     *
     * @param avocadoUnitPrice Avocado unit price
     * @param pearUnitPrice Pear unit price
     * @param kiwiUnitPrice unit price for kiwi
     * @param mangoUnitPrice unit price for mangoe
     * @return A list of Items
     */
    private List<Item> getItems(double avocadoUnitPrice,
                                double pearUnitPrice,
                                double kiwiUnitPrice,
                                double mangoUnitPrice) {

        Item avocadoItem = getItem("Sainsbury's Avocado, Ripe & Ready x2", avocadoUnitPrice, "87.6kb",
                "Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...");

        Item pearItem = getItem("Sainsburys Conference pears, Ripe and Ready x4 (minimum)", pearUnitPrice, "87.6kb",
                "Great to eat now - refrigerate at home 1 of 5 a day 1 pear counts as 1 of your 5..." );

        Item kiwiItem = getItem("Sainsburys kiwi fruit, Ripe and Ready x4", kiwiUnitPrice, "87.6kb",
                "Great to eat now - refrigerate at home 1 of 5 a day 1 kiwi counts as 1 of your 5..." );

        Item mangoItem = getItem("Sainsburys mango, Ripe and Ready x2", mangoUnitPrice, "87.6kb",
                "Great to eat now - refrigerate at home 1 of 5 a day 1 mango counts as 1 of your 5..." );

        Item items [] = {avocadoItem, pearItem, kiwiItem, mangoItem };

        return Arrays.asList(items);
    }

    /**
     *
     * @param title Items title
     * @param unitPrice Items unit price
     * @param size Html size
     * @param description Item description
     * @return An item
     */
    private Item getItem(String title, double unitPrice, String size, String description ) {

        return new Item
                .Builder()
                .withTitle(title)
                .withUnitPrice(unitPrice)
                .withSize(size)
                .withDescription(description)
                .build();
    }
}
