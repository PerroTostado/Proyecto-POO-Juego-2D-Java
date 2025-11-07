
package Utileria;

import ComunidadUIS.Jugador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class Archivos {
    
    private Archivos(){}
     
    public static void menuInicio(){
    
        System.out.println("|||PokeUIS|||");
        System.out.println("Crear");
        System.out.println("Cargar partida");
        System.out.println("Cerrar");
        
    }
    
    public static ArrayList<Jugador> readJugador(String filepath){
        
        ArrayList<Jugador> jugadores = new ArrayList<>();
        
        String line = "";
        int nivel = 0;
        int exp = 0;
        int salud = 0;
        int energia = 0;
      
        

        
        return jugadores;
    }
}
