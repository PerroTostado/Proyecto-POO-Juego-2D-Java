
package ComunidadUIS;
import Utileria.Validacion;

public class ProfesorPlanta extends Profesor{
    
    private int añosTrabajo;
    private boolean direccionTesis;
    public String dialogo;
    
        public ProfesorPlanta(){
            
        }
        
        public ProfesorPlanta(String name, int edad, String genero, boolean comunidadUIS, 
            int estratoSocial, String nombreRol, int añosTrabajo, boolean direccionTesis){
            
            super(name, edad, genero, comunidadUIS, estratoSocial, nombreRol);
            this.setAñosTrabajo(añosTrabajo);
            this.setDireccionTesis(direccionTesis);
        }
        
        protected final void setAñosTrabajo(int añosTrabajo){
            Validacion.validateInt(añosTrabajo);
            this.añosTrabajo = añosTrabajo;
        }
        
        protected final void setDireccionTesis(boolean direccionTesis){
            this.direccionTesis = direccionTesis;
        }
        
        public int getAñosTrabajo(){
            return this.añosTrabajo;
        }
        
        public boolean getDireccionTesis(){
            return this.direccionTesis;
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
        dialogo = "Te regocijas en tus bienes y no temes hacerle la vida imposible a los estudiantes, es tú elección.";
        return dialogo;
    }
}
