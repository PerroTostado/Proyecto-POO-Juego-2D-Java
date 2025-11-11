package ComunidadUIS;
import Utileria.Validacion;


public class EstudiantePre extends Estudiante {
    
    private boolean comedoresD;
    private boolean comedoresA;
    private boolean comedoresC;
    
    public EstudiantePre(String name, int edad, String lugarOrigen, String colorPiel, String genero, String orientacionSexual, String sexo, boolean comunidadUIS, 
            int estratoSocial, String sisben, int cantidadDeCreditos, int nivel, boolean comedoresD, boolean comedoresA, boolean comedoresC){
            
         super(name, edad, lugarOrigen, colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, cantidadDeCreditos, nivel);
         this.setComedoresD(comedoresD);
         this.setComedoresA(comedoresA);
         this.setComedoresC(comedoresC);
    }
        
            protected final void setComedoresD(boolean comedoresD){
                this.comedoresD = comedoresD;
            }
        
            protected final void setComedoresA(boolean comedoresA){
                this.comedoresA = comedoresA;
            }
        
            protected final void setComedoresC(boolean comedoresC){
                this.comedoresC = comedoresC;
            }
        
            public boolean getComedoresD(){
                return this.comedoresD;
            }
        
            public boolean getComedoresA(){
                return this.comedoresA;
            }
        
            public boolean getComedoresC(){
                return this.comedoresC;
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
