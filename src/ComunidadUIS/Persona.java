
package ComunidadUIS;

public abstract class Persona {
    private String name;
    private int edad;
    private String lugarOrigen;
    private String colorPiel;
    private String genero;
    private String orientacionSexual;
    private String sexo;
    private boolean comunidadUIS;
    private int estratoSocial;
    private String sisben;
    
    public Persona(){
        
    }
    
    public Persona(String name, int edad, String lugarOrigen, String colorPiel, String genero, String orientacionSexual, String sexo, boolean comunidadUIS, 
            int estratoSocial, String sisben){
        
        this.setName(name);
        this.setEdad(edad);
        this.setLugarOrigen(lugarOrigen);
        this.setColorPiel(colorPiel);
        this.setGenero(genero);
    }
            
    
    
    
    
    
    public abstract void mostrarPersonalInfo();
    public abstract String obtenerID();
    public abstract void mostrarRol();
    
            
}
