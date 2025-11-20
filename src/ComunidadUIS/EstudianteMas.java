
package ComunidadUIS;
import Utileria.Validacion;

public class EstudianteMas extends Estudiante {
    
    private boolean clases;
    private String temaTesis;
    private String directorTesis;
    public String dialogo;
    
    public EstudianteMas(){
        
    }
    
    public EstudianteMas(String name, int edad, String genero, boolean comunidadUIS, 
            int estratoSocial, String nombreRol, int cantidadDeCreditos, int nivel, boolean clases, String temaTesis, String directorTesis){
        
          super(name, edad, genero, comunidadUIS, estratoSocial, nombreRol, cantidadDeCreditos, nivel);
        this.setClases(clases);
        this.setTemaTesis(temaTesis);
        this.setDirectorTesis(directorTesis);
    }
    
        protected final void setClases(boolean clases){
            this.clases = clases;
        }
        
        protected final void setTemaTesis(String temaTesis){
            Validacion.validateString(temaTesis);
            this.temaTesis = temaTesis;
        }
        
        protected final void setDirectorTesis(String directorTesis){
            Validacion.validateString(directorTesis);
            this.directorTesis = directorTesis;
        }
        
        public boolean getClases(){
            return this.clases;
        }
        
        public String getTemaTesis(){
            return this.temaTesis;
        }
        
        public String getDirectorTesis(String directorTesis){
            return this.directorTesis;
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
        dialogo = "Estarás a una elección de unirte a la gran sociedad docente";
        return dialogo;
    }
}
