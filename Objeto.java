public class Objeto {
    //Atributos
    private String nombre;
    private int cantidad;

    //Constructores
    public Objeto(String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    //Getter y setters

    //Para recibir el nombre
    public String getNombre(){
        return nombre;
    }
    //Para recibir la cantidad
    public Integer getCantidad(){
        return cantidad;
    }
    //Para modificar el nombre
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    //Para modificar la cantidad
    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad;    }
    //ToString
    @Override
    public String toString(){
        return String.format("[%s ,%d]", nombre, cantidad);
    }
}
