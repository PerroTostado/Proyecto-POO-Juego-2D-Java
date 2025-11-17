
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
import Consumibles.ItemOfensivo;
import Consumibles.ItemCuracion;
import Consumibles.ItemEspecial;
import Consumibles.ItemEnergia;
import Consumibles.ItemBuff;
import Consumibles.ItemUtilidad;
import Consumibles.ItemRemedio;

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
    
    public static ArrayList<ItemOfensivo> readItemOf(String filePath){
        ArrayList<ItemOfensivo>inventarioOf = new ArrayList<>();
        
        String line = "";
        String nombre = "";
        String descripcion= "";
        int precio = 0;
        int cantidad = 0;
        String rareza = "";
        int poderAtaque = 0;
        double probabilidadCritico = 0;
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
                            poderAtaque = Integer.parseInt(parts[5].trim());
                            probabilidadCritico = Double.parseDouble(parts[6].trim());
                            
                            inventarioOf.add(new ItemOfensivo(nombre, descripcion, precio, cantidad, rareza, poderAtaque, probabilidadCritico));
                            
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
        
        return inventarioOf;
    }
    public static ArrayList<ItemCuracion> readItemCu(String filePath){
        ArrayList<ItemCuracion>inventarioCu = new ArrayList<>();
        
        String line = "";
        String nombre = "";
        String descripcion= "";
        int precio = 0;
        int cantidad = 0;
        String rareza = "";
        int puntosCuracion = 0;
        boolean curaEstado = false;
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
                            puntosCuracion = Integer.parseInt(parts[5].trim());
                            curaEstado = Boolean.parseBoolean(parts[6].trim());
                            
                            inventarioCu.add(new ItemCuracion(nombre, descripcion, precio, cantidad, rareza, puntosCuracion, curaEstado));
                            
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
        
        return inventarioCu;
    }
    
    
    public static ArrayList<ItemEspecial> readItemEs(String filePath){
        ArrayList<ItemEspecial>inventarioEs = new ArrayList<>();
        
        String line = "";
        String nombre = "";
        String descripcion= "";
        int precio = 0;
        int cantidad = 0;
        String rareza = "";
        String habEspecial = "";
        int poder = 0;
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
                            habEspecial = parts[5].trim();
                            poder = Integer.parseInt(parts[6].trim());
                            
                            inventarioEs.add(new ItemEspecial(nombre, descripcion, precio, cantidad, rareza, habEspecial, poder));
                            
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
        
        return inventarioEs;
    }
    public static ArrayList<ItemOfensivo> readItemEner(String filePath){
        ArrayList<ItemOfensivo>inventarioOf = new ArrayList<>();
        
        String line = "";
        String nombre = "";
        String descripcion= "";
        int precio = 0;
        int cantidad = 0;
        String rareza = "";
        int poderAtaque = 0;
        double probabilidadCritico = 0;
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
                            poderAtaque = Integer.parseInt(parts[5].trim());
                            probabilidadCritico = Double.parseDouble(parts[6].trim());
                            
                            inventarioOf.add(new ItemOfensivo(nombre, descripcion, precio, cantidad, rareza, poderAtaque, probabilidadCritico));
                            
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
        
        return inventarioOf;
    }
    public static ArrayList<ItemOfensivo> readItemBuff(String filePath){
        ArrayList<ItemOfensivo>inventarioOf = new ArrayList<>();
        
        String line = "";
        String nombre = "";
        String descripcion= "";
        int precio = 0;
        int cantidad = 0;
        String rareza = "";
        int poderAtaque = 0;
        double probabilidadCritico = 0;
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
                            poderAtaque = Integer.parseInt(parts[5].trim());
                            probabilidadCritico = Double.parseDouble(parts[6].trim());
                            
                            inventarioOf.add(new ItemOfensivo(nombre, descripcion, precio, cantidad, rareza, poderAtaque, probabilidadCritico));
                            
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
        
        return inventarioOf;
    }
    public static ArrayList<ItemOfensivo> readItemUtil(String filePath){
        ArrayList<ItemOfensivo>inventarioOf = new ArrayList<>();
        
        String line = "";
        String nombre = "";
        String descripcion= "";
        int precio = 0;
        int cantidad = 0;
        String rareza = "";
        int poderAtaque = 0;
        double probabilidadCritico = 0;
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
                            poderAtaque = Integer.parseInt(parts[5].trim());
                            probabilidadCritico = Double.parseDouble(parts[6].trim());
                            
                            inventarioOf.add(new ItemOfensivo(nombre, descripcion, precio, cantidad, rareza, poderAtaque, probabilidadCritico));
                            
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
        
        return inventarioOf;
    }
    
    public static ArrayList<ItemOfensivo> readItemRe(String filePath){
        ArrayList<ItemOfensivo>inventarioOf = new ArrayList<>();
        
        String line = "";
        String nombre = "";
        String descripcion= "";
        int precio = 0;
        int cantidad = 0;
        String rareza = "";
        int poderAtaque = 0;
        double probabilidadCritico = 0;
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
                            poderAtaque = Integer.parseInt(parts[5].trim());
                            probabilidadCritico = Double.parseDouble(parts[6].trim());
                            
                            inventarioOf.add(new ItemOfensivo(nombre, descripcion, precio, cantidad, rareza, poderAtaque, probabilidadCritico));
                            
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
        
        return inventarioOf;
    }
}
