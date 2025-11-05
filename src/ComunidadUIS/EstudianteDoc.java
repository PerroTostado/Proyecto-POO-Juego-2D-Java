
package ComunidadUIS;
import Utileria.Validacion;

public class EstudianteDoc extends Estudiante{
    
    private int publicaciones;
    private String temaInvestigacion;
    
    public EstudianteDoc(){
    }
    public EstudianteDoc(String name, int edad, String lugarOrigen, String colorPiel, String genero, String orientacionSexual, String sexo, boolean comunidadUIS, 
            int estratoSocial, String sisben,int cantidadDeCreditos, int nivel, int publicaciones, String temaInvestigacion){
        
       super(name, edad, lugarOrigen, colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, cantidadDeCreditos, nivel);
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
}
