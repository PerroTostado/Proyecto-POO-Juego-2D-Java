
package ComunidadUIS;
import Utileria.Validacion;

public class ProfesorCatedra extends Profesor {
    
    private int horasSemanales;
    private String asignaturaPrincipal;
    
    public ProfesorCatedra(){
        
    }
    
    public ProfesorCatedra(String name, int edad, String lugarOrigen, String colorPiel, String genero, String orientacionSexual, String sexo, boolean comunidadUIS, 
            int estratoSocial, String sisben, int horasSemanales, String asignaturaPrincipal){
        
        super(name, edad, lugarOrigen, colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben);
        this.setHorasSemanales(horasSemanales);
        this.setAsignaturaPrincipal(asignaturaPrincipal);
        
    }
    
        protected final void setHorasSemanales(int horasSemanales){
            Validacion.validateInt(horasSemanales);
            this.horasSemanales = horasSemanales;
        }
        
        protected final void setAsignaturaPrincipal(String asignaturaPrincipal){
            Validacion.validateString(asignaturaPrincipal);
            this.asignaturaPrincipal = asignaturaPrincipal;
        }
        
        public int getHorasSemanales(){
            return this.horasSemanales;
        }
        
        public String asignaturaPrincipal(){
            return this.asignaturaPrincipal;
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
