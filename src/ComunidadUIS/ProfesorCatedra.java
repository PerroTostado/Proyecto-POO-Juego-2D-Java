
package ComunidadUIS;
import Utileria.Validacion;

public class ProfesorCatedra extends Profesor {
    
    private int horasSemanales;
    private String asignaturaPrincipal;
    public String dialogo;
    
    public ProfesorCatedra(){
        
    }
    
    public ProfesorCatedra(String name, int edad, String genero, boolean comunidadUIS, 
            int estratoSocial, String nombreRol, int horasSemanales, String asignaturaPrincipal){
        
        super(name, edad, genero, comunidadUIS, estratoSocial, nombreRol);
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
        public String descripcion(){
        dialogo = "Estás a un paso de lograr un sueldo fijo, falta poco";
        return dialogo;
    }
}
