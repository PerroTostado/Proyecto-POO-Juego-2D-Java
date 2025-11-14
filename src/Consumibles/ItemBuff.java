package Consumibles;


public class ItemBuff extends Item {
    private String atributoMejorado;
    private int duracion;
    
    public ItemBuff(){
        
    }
    public ItemBuff(String nombre, String descripciones, int precio, int cantidad, String rareza, String atributoMejorado, int duracion){
        super(nombre, descripciones, precio, cantidad, rareza);
        this.atributoMejorado=atributoMejorado;
        this.duracion=duracion;
    }
    
    protected final void setAtributoMejorado(String atributoMejorado){
        this.atributoMejorado=atributoMejorado;
    }
    protected final void setDuracion(int duracion){
        this.duracion=duracion;
    }
    
    public String getAtributoMejorado(){
        return this.atributoMejorado;
    }
    public int getDuracion(){
        return this.duracion;
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
        System.out.println("ADRIANA SALTEEEE");
    }
}
