package game;


abstract public class Item {
    private String nombre;
    private String descripcion;
    private int precio;
    private int cantidad;
    private String rareza;
    
public Item(){
    
}
public Item(String nombre, String descripciones, int precio, int cantidad, String rareza){
    this.nombre=nombre;
    this.descripcion=descripcion;
    this.precio=precio;
    this.cantidad=cantidad;
    this.rareza=rareza;
}
public void setNombre(String nombre){
    this.nombre=nombre;
}
public void setDescripcion(String descripcion){
    this.descripcion=descripcion;
}
public void setPrecio(int precio){
    this.precio=precio;
}
public void setCantidad(int cantidad){
    this.cantidad=cantidad;
}
public void setRareza(String rareza){
    this.rareza=rareza;
}
public String getNombre(){
    return this.nombre;
}
public String getDescripcion(){
    return this.descripcion;
}
public int getPrecio(){
    return this.precio;
}
public int getCantidad(){
    return this.cantidad;
}
public String getRareza(){
    return this.rareza;
}
@Override
public String toString(){
    String XD= "";
    return XD;
}
public abstract void usar();

public abstract void mostrarInfo();
}
