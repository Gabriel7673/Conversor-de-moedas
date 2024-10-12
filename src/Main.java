import models.Conversion;
import models.ExchangeRatesConversion;

public class Main {
    public static void main(String[] args) {

        Conversion conversion;
        ExchangeRatesConversion erc;
        do{
            conversion = Menu.buildMenu();
            if (conversion == null) break;
            String address = ExchangeRatesAPIConnection.getAddress(
                    conversion.getBaseCoin(),
                    conversion.getTargetCoin()
            );

            String json = ExchangeRatesAPIConnection.getRate(address);
            erc = ExchangeRatesAPIConnection.toCoinRate(json);
            conversion.setTax(erc.conversionRate());
            conversion.makeConversion();
            System.out.println(conversion.toString());
        }while (true);



    }
}