
package noComunidadUIS;
import ComunidadUIS.Persona;
import Utileria.Validacion;

public class Visitantes extends Persona{
    private String horaDeVisita;
    private boolean presencia;
    
     public Visitantes(){
        
    }
    public Visitantes(String name, int edad, String lugarOrigen, String colorPiel, String genero, String orientacionSexual, String sexo, boolean comunidadUIS, 
            int estratoSocial, String sisben, String horaDeVisita, boolean presencia){
        super(name, edad, lugarOrigen, colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben);
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
}
