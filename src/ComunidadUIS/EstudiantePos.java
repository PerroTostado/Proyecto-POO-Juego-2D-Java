
package ComunidadUIS;
import Utileria.Validacion;

public class EstudiantePos extends Estudiante {
    
    private String tipoPos;
    private String area;
    
        public EstudiantePos(){
            
        }
        public EstudiantePos(String name, int edad, String lugarOrigen, String colorPiel, String genero, String orientacionSexual, String sexo, boolean comunidadUIS, 
            int estratoSocial, String sisben, int cantidadDeCreditos, int nivel, String tipoPos, String area){
            
            super(name, edad, lugarOrigen, colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, cantidadDeCreditos, nivel);
            this.setTipoPos(tipoPos);
            this.setArea(area);
        }
        
        protected final void setTipoPos(String tipoPos){
            Validacion.validateString(tipoPos);
            this.tipoPos = tipoPos;
        }
        
        protected final void setArea(String area){
            Validacion.validateString(area);
            this.area = area;
        }
        
        public String getTipoPos(){
            return this.tipoPos;
        }
        
        public String getArea(){
            return this.area;
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
