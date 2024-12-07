import models.Conversion;
import models.ExchangeRatesConversion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private ExchangeRatesConversion erc;
    private String address;
    private String json;

    public static void limpar() {
        String spaces = """
                
                --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                
                """;
        System.out.println(spaces);
    }

    public void buildMenu(){

        Scanner reader = new Scanner(System.in);
        Conversion conversion = null;

        limpar();

        String welcome = """
                
                
                *********************************
                Bem vindo ao Conversor de Moedas!
                *********************************
                
                """;
                
        String choise = """
                
                
                ***********************************************
                Caso queira interroper a aplicação, pressione 0
                Caso queira ver as taxas de conversão para um código, pressione 1
                Caso queira converter um valor entre dois códigos, pressione 2
                Escolha: 
                """;

        String baseCodeChoise = """
                
                ************************
                Escolha a moeda de base:
                1) USD
                2) BRL
                3) BOB
                4) CLP
                5) COP
                6) ARS
                7) EUR
                Opção: 
                """;
        String targetCodeChoise = """
                *************************
                Escolha a moeda desejada:
                1) USD
                2) BRL
                3) BOB
                4) CLP
                5) COP
                6) ARS
                7) EUR
                Opção: 
                """;
        String valueChoise = """
                *************************
                Valor a converter: 
                """;
        int baseCode, targetCode;
        double value;
        int status = 0;

        do {
            try {
                System.out.print(welcome);
                System.out.print(choise);
                status = reader.nextInt();
                if (status == 0) {
                    System.out.println("Encerrando...");
                    break;
                } else if (status == 1) {
                    System.out.print(baseCodeChoise);
                    baseCode = reader.nextInt();
                    conversion = new Conversion(selectOption(baseCode));
                    listConvertions(conversion);
                } else if (status == 2) {
                    System.out.print(baseCodeChoise);
                    baseCode = reader.nextInt();
                    System.out.print(targetCodeChoise);
                    targetCode = reader.nextInt();
                    System.out.print(valueChoise);
                    value = reader.nextDouble();
                    conversion = new Conversion(selectOption(baseCode), selectOption(targetCode), value);
                    makeConvertion(conversion);
                }else {
                    System.out.println("Opção inválida.");
                }
            }catch (InputMismatchException e){
                System.out.println("Apenas números inteiros são aceitos.");
                reader.nextLine();
            }
        } while (status != 0);
    }

    private void listConvertions(Conversion conversion){
        address = ExchangeRatesAPIConnection.getAddress(conversion.getBaseCode());
        json = ExchangeRatesAPIConnection.getRate(address);
        erc = ExchangeRatesAPIConnection.toConversion(json);
        conversion.setConversionRates(erc.conversionRates());
        conversion.listConversionRates();
    }

    private void makeConvertion(Conversion conversion){
        address = ExchangeRatesAPIConnection.getAddress(conversion.getBaseCode(), conversion.getTargetCode());
        json = ExchangeRatesAPIConnection.getRate(address);
        erc = ExchangeRatesAPIConnection.toConversion(json);
        conversion.setTax(erc.conversionRate());
        conversion.makeConversion();
        System.out.println(conversion.toString());
    }

    private static String selectOption(int option){
        return switch (option) {
            case 1 -> "USD";
            case 2 -> "BRL";
            case 3 -> "BOB";
            case 4 -> "CLP";
            case 5 -> "COP";
            case 6 -> "ARS";
            case 7 -> "EUR";
            default -> throw new IllegalStateException("Unexpected value: " + option);
        };
    }
}
