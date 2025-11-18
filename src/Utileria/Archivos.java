
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
import java.io.File;

public final class Archivos {
    
    private Archivos(){}
     
    public static ArrayList<Persona> readPersona(String filePath){
        
        ArrayList<Persona> personas = new ArrayList<>();
        
        return personas;
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
