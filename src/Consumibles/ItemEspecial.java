
package Consumibles;


public class ItemEspecial extends Item {
    private String habEspecial;
    private int poder;
    
    public ItemEspecial(){
        
    }
    public ItemEspecial(String nombre, String descripciones, int precio, int cantidad, String rareza, String habEspecial, int poder){
        super(nombre, descripciones, precio, cantidad, rareza);
        this.habEspecial=habEspecial;
        this.poder=poder;
    }
    protected final void setHabEspecial(String habEspecial){
        this.habEspecial=habEspecial;
    }
    protected final void setPoder(int poder){
        this.poder=poder;
    }
    public String getHabEspecial(){
        return this.habEspecial;
    }
    public int getPoder(){
        return this.poder;
    }
    @Override
    public String toString(){
        String XD = "XD";
        return XD;
    }
    @Override
    public void mostrarInfo(){
        System.out.println("XD");
    }
    @Override
    public void usar(){
        System.out.println("TLABAJAL");
    }
}
