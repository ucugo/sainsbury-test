package sainsburys.console.application.test.error;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class BuilderErrorTest {

    @Test
    public void testErrorMessage() throws Exception {
        BuilderError error = new BuilderError("some_message");

        assertThat("some_message", is(error.getMessage()));
    }
}