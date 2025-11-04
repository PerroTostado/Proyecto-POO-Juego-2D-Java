
package Consumibles;


public class ItemCuracion extends Item implements ItemMedicos {
    private int puntosCuracion;
    private boolean curarEstados;
    public ItemCuracion(){
    
}
    public ItemCuracion(String nombre, String descripciones, int precio, int cantidad, String rareza, int puntosCuracion, boolean curarEstados){
        this.curarEstados=curarEstados;
        this.puntosCuracion=puntosCuracion;
    }
    protected final void setPuntosCuracion(int puntosCuracion){
        this.puntosCuracion=puntosCuracion;
    }
    protected final void setCurarEstados(boolean curarEstados){
        this.curarEstados=curarEstados;
    }
    public int getPuntosCuracion(){
        return this.puntosCuracion;
    }
    public boolean curarEstados(){
        return this.curarEstados;
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
        System.out.println("XD");
    }
    @Override
    public void usarItemMedico(){
        System.out.println("El item se está usando");
    }
}
    

