
public class Main {
    public static void main(String[] args) {

        String address;
        do{
            address = Menu.buildMenu();
            System.out.println(address);
            if (address.equals("exit")) break;
        }while (true);



    }
}