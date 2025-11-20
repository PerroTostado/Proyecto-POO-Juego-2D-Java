
package noComunidadUIS;
import ComunidadUIS.Persona;
import Utileria.Validacion;

public class Visitantes extends Persona{
    private String horaDeVisita;
    private boolean presencia;
    
     public Visitantes(){
        
    }
    public Visitantes(String name, int edad, String genero, boolean comunidadUIS, 
            int estratoSocial, String nombreRol, String horaDeVisita, boolean presencia){
        super(name, edad, genero, comunidadUIS, estratoSocial, nombreRol);
        this.setHoraDeVisita(horaDeVisita);
        this.setPresencia(presencia);
    }
    
    protected final void setHoraDeVisita(String horaDeVisita){
        Validacion.validateName(horaDeVisita);
        this.horaDeVisita = horaDeVisita;
    }
    
    protected final void setPresencia(boolean presencia){
        this.presencia = presencia;
    }
    
    public String getHoraDeVisita(){
        return this.horaDeVisita;
    }
    
    public boolean getPresencia(){
        return this.presencia;
    }
    
    
    
    @Override
    public void mostrarPersonalInfo(){
        
    }
    @Override
    public void mostrarRol(){
        
    }
    @Override
    public String obtenerID(){
        String mess = "hla;";
        return mess;
    }
    public String descripcion(){
        String mess = "No eres más que una desdichada alma que vaga sin rumbo por los lares de la universidad";
        return mess;
    }
}
