
package ComunidadUIS;
import Utileria.Validacion;

public abstract class Persona {
    private String name;
    private int edad;
    private String genero;
    private boolean comunidadUIS;
    private int estratoSocial;
    private String nombreRol;
    
    public Persona(){
        
    }
    
    public Persona(String name, int edad, String genero, boolean comunidadUIS, 
            int estratoSocial, String nombreRol){
        
        this.setName(name);
        this.setEdad(edad);
        this.setGenero(genero);
        this.setComunidadUIS(comunidadUIS);
        this.setEstratoSocial(estratoSocial);
        this.setNombreRol(nombreRol);

    }
    
    protected final void setName(String name){
        Validacion.validateName(name);
        this.name = name;
    }
    protected final void setEdad(int edad){
        Validacion.validateInt(edad);
        this.edad = edad;
    }
   
    protected final void setGenero(String genero){
        Validacion.validateString(genero);
        this.genero = genero;
    }
    
    protected final void setComunidadUIS(boolean comunidadUIS){
        this.comunidadUIS = comunidadUIS;
    }
    protected final void setEstratoSocial(int estratoSocial){
        Validacion.validateInt(estratoSocial);
        this.estratoSocial = estratoSocial;
    }
    
    protected final void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
    
    public String getName(){
        return this.name;
    }
    public int getEdad(){
        return this.edad;
    }

    public String getGenero(){
        return this.genero;
    }
   
    public boolean getComunidadUIS(){
        return this.comunidadUIS;
    }
    public int getEstratoSocial(){
        return this.estratoSocial;
    }
    public String getNombreRol(){
        return this.nombreRol;
    }
    
            
    
    

    
    
    
    
    public abstract void mostrarPersonalInfo();
    public abstract String obtenerID();
    public abstract void mostrarRol();
    public abstract String descripcion();

    
            
}
