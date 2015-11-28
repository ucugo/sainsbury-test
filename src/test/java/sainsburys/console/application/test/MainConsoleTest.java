package sainsburys.console.application.test;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import java.io.*;


public class MainConsoleTest {

    @Test
    public void testRunHappyPath() throws Exception {

        String val = "12\n3.0\n4.2\n5.1\nr";

        InputStream is = new ByteArrayInputStream(val.getBytes());

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        MainConsole mainConsole = new MainConsole();

        String results = mainConsole.run(br);

        assertNotNull(results);
    }

    @Test(expected = NumberFormatException.class)
    public void testForNumberFormatException() throws Exception {

        String val = "12e\n3.0\n4.2\n5.1\nr";

        InputStream is = new ByteArrayInputStream(val.getBytes());

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        MainConsole mainConsole = new MainConsole();

        mainConsole.run(br);

    }


    @Test(expected = IOException.class)
    public void testForIOException() throws Exception {
        String val = "12e\n3.0\n4.2\n5.1\nr";

        InputStream is = new ByteArrayInputStream(val.getBytes());

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        br.close();

        MainConsole mainConsole = new MainConsole();

        mainConsole.run(br);
    }
}