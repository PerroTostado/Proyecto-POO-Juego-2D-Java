
package ComunidadUIS;
import Utileria.Validacion;

public class Estudiante extends Persona {
    private int cantidadDeCreditos;
    private int nivel;
    
    
    public Estudiante(){
        
    }
    public Estudiante(String name, int edad, String lugarOrigen, String colorPiel, String genero, String orientacionSexual, String sexo, boolean comunidadUIS, 
            int estratoSocial, String sisben, int cantidadDeCreditos, int nivel){
        
        super(name, edad, lugarOrigen, colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben);
        this.setCantidadDeCreditos(cantidadDeCreditos);
        this.setNivel(nivel);
    }
    
    protected final void setCantidadDeCreditos(int cantidadDeCreditos){
        Validacion.validateInt(cantidadDeCreditos);
        this.cantidadDeCreditos = cantidadDeCreditos;
    }
    protected final void setNivel(int nivel){
        Validacion.validateInt(nivel);
        this.nivel = nivel;
    }
    public int getCantidadDeCredios(){
        return this.cantidadDeCreditos;
    }
    public int getNivel(){
        return this.nivel;
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
