package sainsburys.console.application.test.repository;

import org.junit.Test;
import sainsburys.console.application.test.model.ConsoleResponse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RipeFruitRepoTest {

    @Test
    public void testGetConsoleResponse() throws Exception {
        RipeFruitRepo ripeFruitRepo = new RipeFruitRepo();
        ConsoleResponse consoleResponse = ripeFruitRepo.getResponse(2.0, 3.0, 4.0, 3.5);

        assertThat("12.50", is(consoleResponse.getTotal()));
        assertThat(4, is(consoleResponse.getResults().size()));
    }
}