
package ComunidadUIS;

import Consumibles.Item;
import Utileria.Validacion;
import java.util.ArrayList;

public class Jugador {
    
    private int nivelPersonaje;
    private int expPersonaje;
    private int saludPersonaje;
    private int energiaPersonaje;
    private ArrayList<Item> inventario;
    private Persona rol;
   
    public Jugador(){
        
    }
    
    public Jugador(int nivelPersonaje, int expPersonaje, int saludPersonaje, int energiaPersonaje, Persona rol){
        
        this.setNivelPersonaje(nivelPersonaje);
        this.setExpPersonaje(expPersonaje);
        this.setSaludPersonaje(saludPersonaje);
        this.setEnergiaPersonaje(energiaPersonaje);
        this.rol = rol;
        this.inventario = new ArrayList<>();
        
    }
    
        protected final void setNivelPersonaje(int nivelPersonaje){
            Validacion.validateInt(nivelPersonaje);
            this.nivelPersonaje = nivelPersonaje;
        }
        
        protected final void setExpPersonaje(int expPersonaje){
            Validacion.validateInt(expPersonaje);
            this.expPersonaje = expPersonaje;
        }
        
        protected final void setSaludPersonaje(int saludPersonaje){
            Validacion.validateInt(saludPersonaje);
            this.saludPersonaje = saludPersonaje;
        }
        
        protected final void setEnergiaPersonaje(int energiaPersonaje){
            Validacion.validateInt(energiaPersonaje);
            this.energiaPersonaje = energiaPersonaje;
        }
        
        public void agregarItem(Item item){
            inventario.add(item);
        }
        
        public int getNivelPersonaje(){
            return this.nivelPersonaje;
        }
        
        public int getExpPersonaje(){
            return this.expPersonaje;
        }
        
        public int getSaludaPersonaje(){
            return this.saludPersonaje;
        }
        
        public int getEnergiaPersonaje(){
            return this.energiaPersonaje;               
        }
        public Persona getRol(){
            return this.rol;
        }
    
    
}
