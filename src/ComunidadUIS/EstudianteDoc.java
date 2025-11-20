
package ComunidadUIS;
import Utileria.Validacion;

public class EstudianteDoc extends Estudiante{
    
    private int publicaciones;
    private String temaInvestigacion;
    
    public EstudianteDoc(){
    }
    public EstudianteDoc(String name, int edad, String genero, boolean comunidadUIS, 
            int estratoSocial, String nombreRol, int cantidadDeCreditos, int nivel, int publicaciones, String temaInvestigacion){
        
       super(name, edad, genero, comunidadUIS, estratoSocial, nombreRol, cantidadDeCreditos, nivel);
        this.setPublicaciones(publicaciones);
        this.setTemaInvestigacion(temaInvestigacion);
        
    }
    
    protected final void setPublicaciones(int publicaciones){
        Validacion.validateInt(publicaciones);
        this.publicaciones = publicaciones;
    }
    protected final void setTemaInvestigacion(String temaInvestigacion){
        Validacion.validateString(temaInvestigacion);
        this.temaInvestigacion = temaInvestigacion;
    }
    
    public int getPublicaciones(){
        return this.publicaciones;
    }
    
    public String getTemaInvestigacion(){
        return this.temaInvestigacion;
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
        String mess = "Has sobrevivido a arduas y batallas y has llegado hasta aquí";
        return mess;
    }
}
