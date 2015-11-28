package sainsburys.console.application.test.service;

import org.codehaus.jackson.map.ObjectMapper;
import sainsburys.console.application.test.model.ConsoleResponse;
import sainsburys.console.application.test.repository.RipeFruitRepo;

import java.io.IOException;

public class ConsoleAppService {

    public String getResponseAsJson(double avocadoUnitPrice,
                              double pearUnitPrice,
                              double kiwiUnitPrice,
                              double mangoUnitPrice) throws IOException{
        RipeFruitRepo repo = new RipeFruitRepo();
        ConsoleResponse response = repo.getResponse(avocadoUnitPrice, pearUnitPrice, kiwiUnitPrice, mangoUnitPrice);

        ObjectMapper mapper = new ObjectMapper();

        return  mapper.writeValueAsString(response);
    }


}
