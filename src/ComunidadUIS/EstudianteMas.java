
package ComunidadUIS;
import Utileria.Validacion;

public class EstudianteMas extends Estudiante {
    
    private boolean clases;
    private String temaTesis;
    private String directorTesis;
    
    public EstudianteMas(){
        
    }
    
    public EstudianteMas(String name, int edad, String lugarOrigen, String colorPiel, String genero, String orientacionSexual, String sexo, boolean comunidadUIS, 
            int estratoSocial, String sisben, int cantidadDeCreditos, int nivel, boolean clases, String temaTesis, String directorTesis){
        
        super(name, edad, lugarOrigen, colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, cantidadDeCreditos, nivel);
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
}
