package sainsburys.console.application.test.service;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ConsoleAppServiceTest {

    @Test
    public void testResponse() throws Exception {
        ConsoleAppService consoleAppService = new ConsoleAppService();

        String json = consoleAppService.getResponseAsJson(2.00, 2.00, 2.00, 2.00);

        ObjectMapper mapper = new ObjectMapper();

        JsonNode node =  mapper.readTree(json);

        assertThat(node.get("total").asText(), is("8.00"));
        assertThat(node.get("results").size(), is(4));
    }
}