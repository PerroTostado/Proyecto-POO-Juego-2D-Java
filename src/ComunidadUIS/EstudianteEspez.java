
package ComunidadUIS;
import Utileria.Validacion;


public class EstudianteEspez extends Estudiante {
    
    private String campo;
    private double horas;
    
    public EstudianteEspez(){
        
    }
    
    public EstudianteEspez(String name, int edad, String genero, boolean comunidadUIS, 
            int estratoSocial, String nombreRol, int cantidadDeCreditos, int nivel, String campo, double horas){
          
         super(name, edad, genero, comunidadUIS, estratoSocial, nombreRol, cantidadDeCreditos, nivel);
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
    public String descripcion(){
        String mess = "Has logrado obtener obtener tu título y ahora vas en busca de más conocimiento";
        return mess;
    }
}
