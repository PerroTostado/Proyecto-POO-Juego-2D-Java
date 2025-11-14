
package Utileria;

import ComunidadUIS.Jugador;
import ComunidadUIS.Persona;
import ComunidadUIS.EstudiantePre;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import game.Game;
import Consumibles.Item;

public final class Archivos {
    
    private Archivos(){}
     
    public static void menuInicio(){
    
        System.out.println("|||PokeUIS|||");
        System.out.println("Crear");
        System.out.println("Cargar partida");
        System.out.println("Cerrar");
        
    }
    
    public static void escogerRol(){
        System.out.println("Bienvenido, que rol deseas tomas?");
        System.out.println("1.Estudiante");
        System.out.println("2.Profesor");
        System.out.println("3.Administrativo");
        System.out.println("4.Visitante");
    }
    
    public static void escogeEstu(){
        System.out.println("Podras tener cualquiera de los siguientes estudiantes:");
        System.out.println("1.Estudiante Pregrado");
        System.out.println("2.Estudiante Tecnico");
        System.out.println("3.Estudiante Especializacion");
        System.out.println("4.Estudiante Maestria");
        System.out.println("5.Estudiante Doctorado");
        System.out.println("6.Estudiante Posgrado");
    }
    
    public static void escogeProfe(){
        System.out.println("Podras tener cualquiera de los siguientes profesores:");
        System.out.println("1.Profesor planta");
        System.out.println("2.Profesor catedra");
    }
    
    public static void escogeGen(){
        System.out.println("Que genero tienes: ");
        System.out.println("1.Masculino");
        System.out.println("2.Femenino");
    }
   
    
    public static ArrayList<Jugador> readJugador(String filePath){
        
        ArrayList<Jugador> jugadores = new ArrayList<>();
        
        String line = "";
        int nivel = 0;
        int exp = 0;
        int salud = 0;
        int energia = 0;
        Persona rol;
        
        
      
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
           reader.readLine();
           
           while((line = reader.readLine())!=null){
               String[] parts = line.split(",");
               try{
                        if(parts.length>=5){
                            nivel = Integer.parseInt(parts[0].trim());
                            exp = Integer.parseInt(parts[1].trim());
                            salud = Integer.parseInt(parts[2].trim());
                            energia = Integer.parseInt(parts[3].trim());
                            
                            
                            jugadores.add(new Jugador());
                            
                        }
                        else{
                            System.out.println("No se pudo crear el personaje por falta de atributos");
                        }
               }
               catch(Exception e){
                   System.out.println("Error creando el personaje: " + e.getMessage());
               }
           }
           reader.close();
        }
        catch(IOException e){
            System.err.println("Error al recuperar los datos" + e.getMessage());
        }
        return jugadores;
    }
    
    public static ArrayList<Item> readInventario(String filePath){
        ArrayList<Item>inventario = new ArrayList<>();
        
        String line = "";
        String nombre;
        String descripcion;
        int precio;
        int cantidad;
        String rareza;
        
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
           reader.readLine();
           
           while((line = reader.readLine())!=null){
               String[] parts = line.split(",");
               try{
                        if(parts.length>=5){
                            nombre = parts[0].trim();
                            descripcion = parts[1].trim();
                            precio = Integer.parseInt(parts[2].trim());
                            cantidad = Integer.parseInt(parts[3].trim());
                            rareza = parts[4].trim();
                            
                            
                            
                            
                        }
                        else{
                            System.out.println("No se pudo crear el personaje por falta de atributos");
                        }
               }
               catch(Exception e){
                   System.out.println("Error creando el personaje: " + e.getMessage());
               }
           }
           reader.close();
        }
        catch(IOException e){
            System.err.println("Error al recuperar los datos" + e.getMessage());
        }
        
        return inventario;
    }
}
