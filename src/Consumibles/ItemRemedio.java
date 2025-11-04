package Consumibles;


public class ItemRemedio extends Item implements ItemMedicos {
    private String estadoCurado;
    private int efectividad;
    private boolean suceso;
    
    public ItemRemedio(){
        
    }
    public ItemRemedio(String nombre, String descripciones, int precio, int cantidad, String rareza, String estadoCurado, int efectividad, boolean suceso){
        this.efectividad=efectividad;
        this.estadoCurado=estadoCurado;
        this.suceso=suceso;
    }
    
    protected final void setEstadoCurado(String estadoCurado){
        this.estadoCurado=estadoCurado;
    }
    protected final void setEfectividad(int efectividad){
        this.efectividad=efectividad;
    }
    protected final void setSuceso(boolean suceso){
        this.suceso=suceso;
    }
    public String getEstadoCurado(){
        return this.estadoCurado;
    }
    public int getEfectividad(){
        return this.efectividad;
    }
    public boolean getSuceso(){
        return this.suceso;
    }
    @Override
    public String toString(){
        String XD = "";
        return XD;
    }
    @Override
    public void mostrarInfo(){
        System.out.println("TLABAJA");
    }
    @Override
    public void usar(){
        System.out.println("TIENES QUE TLABAJAL");
    }
    @Override
    public void usarItemMedico(){
        System.out.println("El items se está usando");
    }
}
