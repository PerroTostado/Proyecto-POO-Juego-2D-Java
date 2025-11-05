
package ComunidadUIS;
import Utileria.Validacion;


public class EstudianteEspez extends Estudiante {
    
    private String campo;
    private double horas;
    
    public EstudianteEspez(){
        
    }
    
    public EstudianteEspez(String name, int edad, String lugarOrigen, String colorPiel, String genero, String orientacionSexual, String sexo, boolean comunidadUIS, 
            int estratoSocial, String sisben, int cantidadDeCreditos, int nivel, String campo, double horas){
          
        super(name, edad, lugarOrigen, colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, cantidadDeCreditos, nivel);
        this.setCampo(campo);
        this.setHoras(horas);
    }
    
        protected final void setCampo(String campo){
            Validacion.validateString(campo);
            this.campo = campo;
        }
        protected final void setHoras(double horas){
            Validacion.validateDouble(horas);
            this.horas = horas;
        }
        
        public String getCampo(){
            return this.campo;
        }
        public double getHoras(){
            return this.horas;
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
