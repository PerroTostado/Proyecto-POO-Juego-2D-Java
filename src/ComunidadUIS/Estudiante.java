
package ComunidadUIS;
import Utileria.Validacion;

public abstract class Estudiante extends Persona {
    private int cantidadDeCreditos;
    private int nivel;
    
    
    public Estudiante(){
        
    }
    public Estudiante(String name, int edad, String genero, boolean comunidadUIS, 
            int estratoSocial, String nombreRol, int cantidadDeCreditos, int nivel){
        
        super(name, edad, genero, comunidadUIS, estratoSocial, nombreRol);
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
}
