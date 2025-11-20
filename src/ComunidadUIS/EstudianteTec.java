
package ComunidadUIS;
import Utileria.Validacion;

public class EstudianteTec extends Estudiante{
    
    private String tecnologia;
    private boolean practicas;
    
        public EstudianteTec(){
            
        }
        
        public EstudianteTec(String name, int edad, String genero, boolean comunidadUIS, 
            int estratoSocial, String nombreRol, int cantidadDeCreditos, int nivel, String tecnologia, boolean practicas){
            
              super(name, edad, genero, comunidadUIS, estratoSocial, nombreRol, cantidadDeCreditos, nivel);
            this.setTecnologia(tecnologia);
            this.setPracticas(practicas);
        }
        
            protected final void setTecnologia(String tecnologia){
                Validacion.validateString(tecnologia);
                this.tecnologia = tecnologia;
            }
            
            protected final void setPracticas(boolean practicas){
                this.practicas = practicas;
            }
            
            public String getTecnologia(){
                return this.tecnologia;
            }
            
            public boolean getPracticas(){
                return this.practicas;
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
            String mess = "Eres lo suficientemente valiente para estudiar pero también lo suficientemente perezoso para no ser profesional";
            return mess;
    }
}
