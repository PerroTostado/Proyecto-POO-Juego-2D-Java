
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
    
    public abstract void mostrarPersonalInfo();
    public abstract String obtenerID();
    public abstract void mostrarRol();
    
            
}
