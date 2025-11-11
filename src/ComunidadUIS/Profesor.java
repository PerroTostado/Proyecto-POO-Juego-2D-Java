
package ComunidadUIS;
import java.util.ArrayList;
import Utileria.Validacion;

public abstract class Profesor extends Persona {
    
    private ArrayList<String> cursos;
    private ArrayList<String> materias;
    
    public Profesor(){
        
    }
    
    public Profesor(String name, int edad, String lugarOrigen, String colorPiel, String genero, String orientacionSexual, String sexo, boolean comunidadUIS, 
            int estratoSocial, String sisben){
        
        super(name, edad, lugarOrigen, colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben);
        this.cursos = new ArrayList<>();
        this.materias = new ArrayList<>();
    }
    
        public void agregarCurso(String curso){
            cursos.add(curso);
        }
        
        public void agregarMateria(String materia){
            materias.add(materia);
        }
      
}
