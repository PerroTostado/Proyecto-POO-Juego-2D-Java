package Consumibles;


public class ItemOfensivo extends Item{
    private int poderAtaque;
    private double probabilidadCritico;
    
public ItemOfensivo(){
    
}   
public ItemOfensivo(String nombre, String descripciones, int precio, int cantidad, String rareza, int poderAtaque, double probabilidadCritico){
    this.poderAtaque=poderAtaque;
    this.probabilidadCritico=probabilidadCritico;
}

public void setPoderAtaque(int poderAtaque){
    this.poderAtaque=poderAtaque;
}

public void setProbabilidadCritico(double probabilidadCritico){
    this.probabilidadCritico=probabilidadCritico;
}

public int getPoderAtaque(){
    return this.poderAtaque;
}

public double getProbabilidadCritico(){
    return this.probabilidadCritico;
}

@Override
public String toString(){
    String XD = "";
    return XD;
}
@Override
public void usar(){
    System.out.println("XD");
}
@Override
public void mostrarInfo(){
    System.out.println("XD");
}
}
