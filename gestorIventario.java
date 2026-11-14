import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gestorIventario {

    static List<Objeto> inventario = new ArrayList<>();
    public static void main(String[] args) {
        arranque();
        login();
        // menu();
    }

    private static void arranque() {
        Objeto o1 = new Objeto("Tornillos", 10);
        inventario.add(o1);
    }

    private static void login() {
        Scanner sc = new Scanner(System.in);
        boolean acceso=false;

        System.out.println("Bienvenidos a Leroy Merlin, ");

        do {
            System.out.print("Para iniciar el programa pulse `enter´: ");
            String inicio = sc.nextLine();
            
            if (inicio.equals("")) {
                System.out.println("-> Acceso Permitido");
                acceso = true;
            } else {
                System.out.println("-> Acceso Denegado");
                

            }
        } while (acceso == false);
    }
}