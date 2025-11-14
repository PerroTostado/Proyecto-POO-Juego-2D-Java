
package Consumibles;


public class ItemUtilidad extends Item{
    private String tipoUso;
    private int durabilidad;
    
    public ItemUtilidad(){
        
    }
    public ItemUtilidad(String nombre, String descripciones, int precio, int cantidad, String rareza, String tipoUso, int durabilidad){
        super(nombre, descripciones, precio, cantidad, rareza);
        this.durabilidad=durabilidad;
        this.tipoUso=tipoUso;
    }
    
    protected final void setTipoUso(String tipoUso){
        this.tipoUso=tipoUso;
    }
    protected final void setDurabilidad(int durabilidad){
        this.durabilidad=durabilidad;
    }
    public String getTipoUso(){
        return this.tipoUso;
    }
    public int getDuracion(){
        return this.durabilidad;
    }
    @Override
    public String toString(){
        String XD = "";
        return XD;
    }
    @Override
    public void mostrarInfo(){
        System.out.println("XD");
    }
    @Override
    public void usar(){
        System.out.println("DAYUM DANIEL AU AU AU AU AU AU AU");
    }
}
