
package ComunidadUIS;
import Utileria.Validacion;

public class EstudianteTec extends Estudiante{
    
    private String tecnologia;
    private boolean practicas;
    
        public EstudianteTec(){
            
        }
        
        public EstudianteTec(String name, int edad, String lugarOrigen, String colorPiel, String genero, String orientacionSexual, String sexo, boolean comunidadUIS, 
            int estratoSocial, String sisben, int cantidadDeCreditos, int nivel, String tecnologia, boolean practicas){
            
            super(name, edad, lugarOrigen, colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, cantidadDeCreditos, nivel);
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
}
