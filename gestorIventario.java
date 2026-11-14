import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gestorIventario {
      static List<Objeto> inventario= new ArrayList<>();
    public static void main(String[] args) {
        arranque();
        //login();
        //menu();
    }

    private static void arranque(){
        Objeto o1=new Objeto("Tornillos", 10);
            inventario.add(o1);
    }
    public static void consultarDatos(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Que desea consultar?\n 1.Inventario\n 2.Objeto en especifico");
        int opcion=sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Inventario: "+inventario);
                break;
            case 2:

                break;
            default:
                break;
        }

    }
}