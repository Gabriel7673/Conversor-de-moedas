import models.Conversion;

import java.util.Scanner;

public class Menu {


    public static void limpar() {
        String spaces = """
                
                --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                
                """;
        System.out.println(spaces);
    }

    public static Conversion buildMenu(){

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

        System.out.print(welcome);
        System.out.print(choise);
        int status = reader.nextInt();
        try{
            if (status == 0){
                return conversion;
            } else if (status == 1) {
                System.out.print(baseCodeChoise);
                baseCode = reader.nextInt();
                conversion = new Conversion(selectOption(baseCode));
            } else if (status == 2) {
                System.out.print(baseCodeChoise);
                baseCode = reader.nextInt();
                System.out.print(targetCodeChoise);
                targetCode = reader.nextInt();
                System.out.print(valueChoise);
                value = reader.nextDouble();
                conversion = new Conversion(selectOption(baseCode), selectOption(targetCode), value);
            }else{
                throw new Exception(); // Criar
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return conversion;
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
