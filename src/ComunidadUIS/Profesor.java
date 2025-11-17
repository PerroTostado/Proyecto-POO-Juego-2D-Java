
package ComunidadUIS;
import java.util.ArrayList;
import Utileria.Validacion;

public abstract class Profesor extends Persona {
    
    private ArrayList<String> cursos;
    private ArrayList<String> materias;
    
    public Profesor(){
        
    }
    
    public Profesor(String name, int edad, String genero, boolean comunidadUIS, 
            int estratoSocial, String nombreRol){
        
        super(name, edad, genero, comunidadUIS, estratoSocial, nombreRol);
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
