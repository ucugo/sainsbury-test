package sainsburys.console.application.test.model;

import org.junit.Test;
import sainsburys.console.application.test.error.BuilderError;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemTest{

    @Test
    public void testForValidity() throws Exception {
        Item item = new Item
                .Builder()
                .withTitle("some_title")
                .withUnitPrice(2.0)
                .withSize("27.2kb")
                .withDescription("some_description")
                .build();

        assertThat("some_title", is(item.getTitle()));
        assertThat("2.00", is(item.getUnitPrice()));
        assertThat("27.2kb", is(item.getSize()));
        assertThat("some_description", is(item.getDescription()));
    }

    @Test(expected = BuilderError.class)
    public void testShouldThrowExceptionForMissingTitle() throws Exception {
        new Item
                .Builder()
                .withUnitPrice(2.0)
                .withSize("100.0kb")
                .withDescription("Some_Description")
                .build();
    }

    @Test(expected = BuilderError.class)
    public void testShouldThrowExceptionForNullUnitPrice() throws Exception {
        new Item
                .Builder()
                .withTitle("some_title")
                .withSize("100.0kb")
                .withDescription("Some_Description")
                .build();
    }

    @Test(expected = BuilderError.class)
    public void testShouldThrowExceptionForNullSize() throws Exception {
        new Item
                .Builder()
                .withTitle("some_title")
                .withUnitPrice(2.0)
                .withDescription("Some_Description")
                .build();
    }

}