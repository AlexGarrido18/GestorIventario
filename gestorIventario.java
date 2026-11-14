import java.util.ArrayList;
import java.util.List;

public class gestorIventario {

    public static void main(String[] args) {
        arranque();
        //login();
        //menu();
    }

    private static void arranque(){
        List<Objeto> inventario= new ArrayList<>();
        Objeto o1=new Objeto("Tornillos", 10);
            inventario.add(o1);

        System.out.println("Inventario "+inventario);
        System.out.println("Cantidad del objeto "+o1.getCantidad());
        System.out.println("Nombre del o1 "+o1.getNombre());
    }   
}