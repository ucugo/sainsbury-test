package sainsburys.console.application.test.model;

import org.junit.Test;
import sainsburys.console.application.test.error.BuilderError;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConsoleResponseTest {

    @Test
    public void testFieldValidity() throws Exception {

        List<Item> items = new ArrayList<>();
        items.add(getItem(2.0, "87.0kb"));
        items.add(getItem(6.2, "47.0kb"));

        ConsoleResponse consoleResponse = new ConsoleResponse
                .Builder()
                .withItems(items)
                .build();

        assertThat("8.20", is(consoleResponse.getTotal()));
        assertThat(items, is(consoleResponse.getResults()));
    }

    @Test(expected = BuilderError.class)
    public void testShouldThrowExceptionForMissingItemsField(){
        new ConsoleResponse
                .Builder()
                .withTotal(2.0)
                .build();
    }

    private Item getItem(double unitPrice, String size) {
        Item item = new Item
                .Builder()
                .withTitle("some_title")
                .withUnitPrice(unitPrice)
                .withSize(size)
                .withDescription("some_description")
                .build();

        return item;
    }
}