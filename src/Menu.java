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

        String part1 = """
                
                
                *********************************
                Bem vindo ao Conversor de Moedas!
                *********************************
                
                """;
                
        String part2 = """
                
                
                ***********************************************
                Caso queira interroper a aplicação, pressione 0
                Caso queira continuar, pressione 1
                Escolha: 
                """;

        String part3 = """
                
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
        String part4 = """
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
        String part5 = """
                *************************
                Valor a converter: 
                """;

        System.out.print(part1);
        System.out.print(part2);
        int status = reader.nextInt();
        if (status == 0){
            return conversion;
        }
        System.out.print(part3);
        int moedaBase = reader.nextInt();
        System.out.print(part4);
        int moedaDesejada = reader.nextInt();
        System.out.print(part5);
        double valor = reader.nextInt();



        conversion = new Conversion(selectOption(moedaBase), selectOption(moedaDesejada), valor);

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
