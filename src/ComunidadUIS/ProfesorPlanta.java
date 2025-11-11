
package ComunidadUIS;
import Utileria.Validacion;

public class ProfesorPlanta extends Profesor{
    
    private int añosTrabajo;
    private boolean direccionTesis;
    
    
        public ProfesorPlanta(){
            
        }
        
        public ProfesorPlanta(String name, int edad, String lugarOrigen, String colorPiel, String genero, String orientacionSexual, String sexo, boolean comunidadUIS, 
            int estratoSocial, String sisben, int añosTrabajo, boolean direccionTesis){
            
            super(name, edad, lugarOrigen, colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben);
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
}
