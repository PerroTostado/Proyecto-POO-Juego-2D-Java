
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
        this.setOrientacionSexual(orientacionSexual);
        this.setSexo(sexo);
        this.setComunidadUIS(comunidadUIS);
        this.setEstratoSocial(estratoSocial);
        this.setSisben(sisben);
    }
    
    protected final void setName(String name){
        this.name = name;
    }
    protected final void setEdad(int edad){
        this.edad = edad;
    }
    protected final void setLugarOrigen(String lugarOrigen){
        this.lugarOrigen = lugarOrigen;
    }
    protected final void setColorPiel(String colorPiel){
        this.colorPiel = colorPiel;
    }
    protected final void setGenero(String genero){
        this.genero = genero;
    }
    protected final void setOrientacionSexual(String orientacionSexual){
        this.orientacionSexual = orientacionSexual;
    }
    protected final void setSexo(String sexo){
        this.sexo = sexo;
    }
    protected final void setComunidadUIS(boolean comunidadUIS){
        this.comunidadUIS = comunidadUIS;
    }
    protected final void setEstratoSocial(int estratoSocial){
        this.estratoSocial = estratoSocial;
    }
    protected final void setSisben(String sisben){
        this.sisben = sisben;
    }
    
    public String getName(){
        return this.name;
    }
    public int getEdad(){
        return this.edad;
    }
    public String getLugarOrigen(){
        return this.lugarOrigen;
    }
    public String getColorPiel(){
        return this.colorPiel;
    }
    public String getGenero(){
        return this.genero;
    }
    public String getOrientacionSexual(){
        return this.orientacionSexual;
    }
    public String getSexo(){
        return this.sexo;
    }
    public boolean getComunidadUIS(){
        return this.comunidadUIS;
    }
    public int getEstratoSocial(){
        return this.estratoSocial;
    }
    public String getSisben(){
        return this.sisben;
    }
            
    
    
            
    
    
    
    
    
    public abstract void mostrarPersonalInfo();
    public abstract String obtenerID();
    public abstract void mostrarRol();
    
            
}
