package Consumibles;


public class ItemEnergia extends Item {
    private int puntosEnergia;
    private boolean temporalBoost;
    
    public ItemEnergia(){
        
    }
    public ItemEnergia(String nombre, String descripciones, int precio, int cantidad, String rareza, int puntosEnergia, boolean temporalBoost){
        super(nombre, descripciones, precio, cantidad, rareza);
        this.puntosEnergia=puntosEnergia;
        this.temporalBoost=temporalBoost;
    }
    protected final void setPuntosEnergia(int puntosEnergia){
        this.puntosEnergia=puntosEnergia;
    }
    protected final void setTemporalBoost(boolean temporalBoost){
        this.temporalBoost=temporalBoost;
    }
    public int getPuntosEnergia(){
        return this.puntosEnergia;
    }
    public boolean getTemporalBoost(){
        return this.temporalBoost;
    }
    @Override
    public String toString(){
        String XD = "";
        return XD;
    }
    @Override
    public void mostrarInfo(){
        System.out.println("ENRIQUEEE");
    }
    @Override
    public void usar(){
        System.out.println("lol q mal");
    }
}   
