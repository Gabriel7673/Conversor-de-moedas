import models.Conversion;
import models.ExchangeRatesConversion;

public class Main {
    public static void main(String[] args) {

        Conversion conversion;
        ExchangeRatesConversion erc;
        String address, json;

        do{
            conversion = Menu.buildMenu();
            if (conversion == null) break;
            if (conversion.getTargetCode() == null){
                address = ExchangeRatesAPIConnection.getAddress(
                        conversion.getBaseCode()
                );
                json = ExchangeRatesAPIConnection.getRate(address);
                erc = ExchangeRatesAPIConnection.toConversion(json);
                conversion.setConversionRates(erc.conversionRates());
                conversion.listConversionRates();
                continue;
            }
            address = ExchangeRatesAPIConnection.getAddress(
                    conversion.getBaseCode(),
                    conversion.getTargetCode()
            );

            json = ExchangeRatesAPIConnection.getRate(address);
            erc = ExchangeRatesAPIConnection.toConversion(json);
            conversion.setTax(erc.conversionRate());
            conversion.makeConversion();
            System.out.println(conversion.toString());
        }while (true);



    }
}