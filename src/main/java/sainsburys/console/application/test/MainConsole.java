package sainsburys.console.application.test;

import sainsburys.console.application.test.service.ConsoleAppService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainConsole {

    public static void main(String[] aArgs) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        new MainConsole().run(br);
    }

    public String run(BufferedReader br)throws Exception{
        ConsoleAppService consoleAppService = new ConsoleAppService();
        String response = null;
        try {
            System.out.print("Sainsbury's recruitment test");
            System.out.println("===================================\n\n\n");


            System.out.println("Enter unit price for Avocado:...");
            double avocadoUnitPrice = convertToNumber(br.readLine());

            System.out.println("\nEnter unit price for Pear:...");
            double pearUnitPrice = convertToNumber(br.readLine());

            System.out.println("\nEnter unit price for Kiwi:...");
            double kiwiUnitPrice = convertToNumber(br.readLine());

            System.out.println("\nEnter unit price for Mango:...");
            double mangoUnitPrice = convertToNumber(br.readLine());

            System.out.println("\nPress r and  Enter to view results");
            String results = br.readLine();


            if ("r".equals(results)){
                response = consoleAppService.getResponseAsJson(avocadoUnitPrice,
                        pearUnitPrice,
                        kiwiUnitPrice,
                        mangoUnitPrice);
                System.out.println(response);
            }

        } catch (IOException e) {
            throw new IOException(e.getMessage());
        } catch (NumberFormatException e){
            throw new NumberFormatException(e.getMessage());
        }

        return response;
    }

    private double convertToNumber(String unitPrice){

        try{
            return  Double.valueOf(unitPrice);
        }catch(NumberFormatException e) {
            throw new NumberFormatException("Can only accept a number. System will now exit");
        }
    }
}
