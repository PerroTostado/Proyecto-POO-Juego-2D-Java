
package ComunidadUIS;
import Utileria.Validacion;

public class Administrativo extends Persona {
    
    private String edificioDeTrabajo;
    private String oficina;
   
    public Administrativo(){
        
    }
    public Administrativo(String name, int edad, String genero, boolean comunidadUIS, 
            int estratoSocial, String nombreRol, String edificioDeTrabajo, String oficina){
        super(name, edad, genero, comunidadUIS, estratoSocial, nombreRol);
        this.setEdificioDeTrabajo(edificioDeTrabajo);
        this.setOficina(oficina);
    }
    
    protected final void setEdificioDeTrabajo(String edificioDeTrabajo){
        Validacion.validateString(edificioDeTrabajo);
        this.edificioDeTrabajo = edificioDeTrabajo;
    }
    
    protected final void setOficina(String oficina){
        Validacion.validateName(oficina);
        this.oficina = oficina;
    }
    
    public String getEdificioDeTrabajo(){
        return this.edificioDeTrabajo;
    }
    public String getOficina(){
        return this.oficina;
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
    @Override
    public String descripcion(){
        String mess = "Posees un rol alto en la comunidad UIS";
        return mess;
    }
}
