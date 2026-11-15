import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gestorIventario {

    static List<Objeto> inventario = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ProductoNoEncontrado {
        arranque();
        login();
        // menu();
    }

    private static void arranque() {
        Objeto o1 = new Objeto("Tornillos", 10);
        inventario.add(o1);
        o1 = new Objeto("Juntas", 15);
        inventario.add(o1);
        o1 = new Objeto("Martillos", 5);
        inventario.add(o1);
    }

    private static void login() {
        boolean acceso = false;

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

    public static void consultarDatos() {
        System.out.println("Que desea consultar?\n 1.Inventario\n 2.Objeto en especifico");
        int opcion = sc.nextInt();
        try {
            switch (opcion) {

                case 1:
                    System.out.println("Inventario: " + inventario); // muestra todo lo guardado en el inventario
                    break;
                case 2:
                    System.out.println("Introduzca el nombre del objeto:");
                    String nombre = sc.next();
                    boolean existe = false; // ponemos por defecto que el objeto no existe
                    for (Objeto objeto : inventario) { // bucle for que busca dentro del inventario que tenemos guardado
                        if (nombre.equalsIgnoreCase(objeto.getNombre())) {// condicional si el objeto existe cambiamos a
                                                                          // // true
                            existe = true;
                            // si existe devolvemos los datos
                            System.out.println(objeto.getNombre() + " cantidad: " + objeto.getCantidad());
                            break;
                        }
                    }
                    if (!existe) { // si no existe no devolvemos los datos
                        throw new ProductoNoEncontrado("Este producto no existe");
                    }

                    break;
                default:
                    throw new IllegalArgumentException("Introduzca una opción válida");

            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ProductoNoEncontrado e) {
            System.out.println(e.getMessage());
        }

    }

    public static void modificarExistencias() {
        try {
            System.out.println("Que desea modificar");
            String nombre = sc.next();
            boolean existe = false; // ponemos por defecto que el objeto no existe
            for (Objeto objeto : inventario) { // bucle for que busca dentro del inventario que tenemos guardado
                if (nombre.equalsIgnoreCase(objeto.getNombre())) {// condicional si el objeto existe cambiamos a
                                                                  // // true
                    existe = true;
                    // si existe devolvemos los datos
                    System.out.println("Introduzca nueva cantidad");
                    Integer cantidad = sc.nextInt();
                    objeto.setCantidad(cantidad); // seteamos la nueva cantidad
                    System.out.println(objeto.getNombre() + " cantidad: " + objeto.getCantidad()); // le muestra al
                                                                                                   // usuario la nueva
                                                                                                   // cantidad
                                                                                                   // introducidad
                    break;
                }
            }
            if (!existe) { // si no existe no devolvemos los datos
                throw new ProductoNoEncontrado("Este producto no existe");
            }

        } catch (ProductoNoEncontrado e) {
            System.out.println(e.getMessage());
        }
    }

    public static void registroProductos() {
        Scanner sc = new Scanner(System.in);
        
        boolean salir;
        
        do {
           try {
            System.out.print("Indique el nombre del producto que desea registrar: ");
            String nombreProducto = sc.next();
            System.out.print("Ingrese la cantidad del producto que va a ingresar: ");
            int cantidadProducto = sc.nextInt();

            if (nombreProducto.equals("") || cantidadProducto == 0) {
                throw new InformacionNoValida("Datos introducidos no válidos");
            } else {
                Objeto o1 = new Objeto(nombreProducto, cantidadProducto);
                inventario.add(o1);
                
            }
            System.out.println("¿Desea registar otro producto?");
            System.out.println("Introduzca `1´ para continuar");
            System.out.println("Introduzca `2´ para salir");
            int continua=sc.nextInt();
            
            if(continua==1){
                salir=false;
            }else{
                salir=true;
            }

        } catch (InformacionNoValida e) {
            System.out.println(e.getMessage());
        }
             
        } while (salir=false);        
        

    }
}

class ProductoNoEncontrado extends Exception {
    public ProductoNoEncontrado(String mensaje) {
        super(mensaje);
    }

}

class InformacionNoValida extends Exception {
    public InformacionNoValida(String mensaje) {
        super(mensaje);
    }

}