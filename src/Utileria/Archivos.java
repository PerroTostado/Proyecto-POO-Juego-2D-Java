
package Utileria;

import ComunidadUIS.Jugador;
import ComunidadUIS.Persona;
import ComunidadUIS.EstudiantePre;
import ComunidadUIS.EstudiantePos;
import ComunidadUIS.EstudianteMas;
import ComunidadUIS.EstudianteEspez;
import ComunidadUIS.EstudianteTec;
import ComunidadUIS.EstudianteDoc;
import ComunidadUIS.ProfesorPlanta;
import ComunidadUIS.ProfesorCatedra;
import noComunidadUIS.Visitantes;
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
import Entity.Player;
import game.*;

public class Archivos{
    
    public static ArrayList<Persona> readPersona(String filePath){
        
        ArrayList<Persona> personas = new ArrayList<>();
        
        String line = "";
        String nombre = "";
        int edad = 0;
        String genero = "";
        boolean comunidadUIS = false;
        int estratoSocial = 0;
        String nombreRol = "";
        Player player = null;
        GamePanel gp = null;
        KeyHandler keyH = null;

        UI ui = new UI(gp,keyH,player); 
        
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            reader.readLine();
            while((line = reader.readLine())!=null){
                
                String[] parts = line.split(",");
                try{
                        if(parts.length>=7){
                            nombre = parts[0].trim();
                            edad = Integer.parseInt(parts[1].trim());
                            genero = parts[2].trim();
                            comunidadUIS = Boolean.parseBoolean(parts[3].trim());
                            estratoSocial = Integer.parseInt(parts[4].trim());
                            nombreRol = parts[5];
                            
                            if(ui.tempRol.equals("Estudiante Pregrado")){
                                int cantidadCreditos = 0;
                                int nivel = 0;
                                boolean comedoresD = false;
                                boolean comedoresA = false;
                                boolean comedoresC = false;
                                
                                cantidadCreditos = Integer.parseInt(parts[6].trim());
                                nivel = Integer.parseInt(parts[7].trim());
                                comedoresD = Boolean.parseBoolean(parts[8].trim());
                                comedoresA = Boolean.parseBoolean(parts[9].trim());
                                comedoresC = Boolean.parseBoolean(parts[10].trim());
                                personas.add(new EstudiantePre(nombre, edad, genero, comunidadUIS, estratoSocial, nombreRol, cantidadCreditos, nivel, comedoresD, comedoresA, comedoresC));
                            }
                            else if(ui.tempRol == "Estudiante Posgrado"){
                                int cantidadCreditos = 0;
                                int nivel = 0;
                                String tipoPos = "";
                                String area = "";
                                
                                cantidadCreditos = Integer.parseInt(parts[6].trim());
                                nivel = Integer.parseInt(parts[7].trim());
                                tipoPos = parts[8].trim();
                                area = parts[9].trim();
                                personas.add(new EstudiantePos(nombre, edad, genero, comunidadUIS, estratoSocial, nombreRol, cantidadCreditos, nivel, tipoPos, area));
                            }
                            else if(ui.tempRol == "Estudiante Tecnologo"){
                                int cantidadCreditos = 0;
                                int nivel = 0;
                                String tecnologias = "";
                                boolean practicas = false;
                                cantidadCreditos = Integer.parseInt(parts[6].trim());
                                nivel = Integer.parseInt(parts[7].trim());
                                tecnologias = parts[8].trim();
                                practicas = Boolean.parseBoolean(parts[9].trim());
                                personas.add(new EstudianteTec(nombre, edad, genero, comunidadUIS, estratoSocial, nombreRol, cantidadCreditos, nivel, tecnologias, practicas));
                            }
                            else if(ui.tempRol == "Estudiante de Maestria"){
                                int cantidadCreditos = 0;
                                int nivel = 0;
                                boolean clases = false;
                                String temaTesis = "";
                                String directorTesis = "";
                                cantidadCreditos = Integer.parseInt(parts[6].trim());
                                nivel = Integer.parseInt(parts[7].trim());
                                clases = Boolean.parseBoolean(parts[8].trim());
                                temaTesis = parts[9].trim();
                                directorTesis = parts[10].trim();
                                personas.add(new EstudianteMas(nombre, edad, genero, comunidadUIS, estratoSocial, nombreRol, cantidadCreditos, nivel, clases, temaTesis, directorTesis));
                            }
                            else if(ui.tempRol == "Estudiante de Especializacion"){
                                int cantidadCreditos = 0;
                                int nivel = 0;
                                String campo = "";
                                double horas = 0.0;
                                cantidadCreditos = Integer.parseInt(parts[6].trim());
                                nivel = Integer.parseInt(parts[7].trim());
                                campo = parts[8].trim();
                                horas = Double.parseDouble(parts[9].trim());
                                personas.add(new EstudianteEspez(nombre, edad, genero, comunidadUIS, estratoSocial, nombreRol, cantidadCreditos, nivel, campo, horas));
                            }
                            else if(ui.tempRol == "Estudiante de Doctorado"){
                                int cantidadCreditos = 0;
                                int nivel = 0;
                                int publicaciones = 0;
                                String temaInvestigacion = "";
                                cantidadCreditos = Integer.parseInt(parts[6].trim());
                                nivel = Integer.parseInt(parts[7].trim());
                                publicaciones = Integer.parseInt(parts[8].trim());
                                temaInvestigacion = parts[9].trim();
                                personas.add(new EstudianteDoc(nombre, edad, genero, comunidadUIS, estratoSocial, nombreRol, cantidadCreditos, nivel, publicaciones, temaInvestigacion));
                            }
                            else if(ui.tempRol == "Administrativo"){
                                String edificioTrabajo = "";
                                String oficina = "";
                                edificioTrabajo = parts[6].trim();
                                oficina = parts[7].trim();
                            }
                            else if(ui.tempRol == "Profesor Planta"){
                                int añosTrabajo = 0;
                                boolean direccionTesis = false;
                                añosTrabajo = Integer.parseInt(parts[6].trim());
                                direccionTesis = Boolean.parseBoolean(parts[7].trim());
                                personas.add(new ProfesorPlanta(nombre, edad, genero, comunidadUIS, estratoSocial, nombreRol, añosTrabajo, direccionTesis));
                             }
                            else if(ui.tempRol == "Profesor Catedra"){
                                int horasSemanales;
                                String AsignaturaPrincipal;
                                horasSemanales = Integer.parseInt(parts[6].trim());
                                AsignaturaPrincipal = parts[7].trim();
                                personas.add(new ProfesorCatedra(nombre, edad, genero, comunidadUIS, estratoSocial, nombreRol, horasSemanales, AsignaturaPrincipal));
                            }
                            else if(ui.tempRol == "Visitante"){
                                String horaVisita;
                                boolean presencia;
                                horaVisita = parts[6].trim();
                                presencia = Boolean.parseBoolean(parts[7].trim());
                                personas.add(new Visitantes(nombre, edad, genero, comunidadUIS, estratoSocial, nombreRol, horaVisita, presencia));
                            }
                            else{
                            System.out.println("No se pudo crear el objeto ofensivo por falta de atributos");
                            }
                        }
                }catch(Exception e){
                    System.out.println("Error al crear el rol: " + e.getMessage());
                }
            }        
        }catch(Exception e){
            System.err.println("Error al recuperar los datos" + e.getMessage());
        }
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
                        if(parts.length>=7){
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
                            System.out.println("No se pudo crear el objeto ofensivo por falta de atributos");
                        }
               }
               catch(Exception e){
                   System.out.println("Error creando el item ofensivo: " + e.getMessage());
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
                        if(parts.length>=7){
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
                            System.out.println("No se pudo crear el item curativo por falta de atributos");
                        }
               }
               catch(Exception e){
                   System.out.println("Error creando el item curativo: " + e.getMessage());
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
                        if(parts.length>=7){
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
                            System.out.println("No se pudo crear el item especial por falta de atributos");
                        }
               }
               catch(Exception e){
                   System.out.println("Error creando el item especial: " + e.getMessage());
               }
           }
           reader.close();
        }
        catch(IOException e){
            System.err.println("Error al recuperar los datos" + e.getMessage());
        }
        
        return inventarioEs;
    }
    public static ArrayList<ItemEnergia> readItemEner(String filePath){
        ArrayList<ItemEnergia>inventarioEner = new ArrayList<>();
        
        String line = "";
        String nombre = "";
        String descripcion= "";
        int precio = 0;
        int cantidad = 0;
        String rareza = "";
        int puntosEnergía = 0;
        boolean boostTemp = false;
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
           reader.readLine();
           
           while((line = reader.readLine())!=null){
               String[] parts = line.split(",");
               try{
                        if(parts.length>=7){
                            nombre = parts[0].trim();
                            descripcion = parts[1].trim();
                            precio = Integer.parseInt(parts[2].trim());
                            cantidad = Integer.parseInt(parts[3].trim());
                            rareza = parts[4].trim();
                            puntosEnergía = Integer.parseInt(parts[5].trim());
                            boostTemp =  Boolean.parseBoolean(parts[6].trim());
                            
                            inventarioEner.add(new ItemEnergia(nombre, descripcion, precio, cantidad, rareza, puntosEnergía, boostTemp));
                            
                        }
                        else{
                            System.out.println("No se pudo crear el item energético por falta de atributos");
                        }
               }
               catch(Exception e){
                   System.out.println("Error creando el item energético: " + e.getMessage());
               }
           }
           reader.close();
        }
        catch(IOException e){
            System.err.println("Error al recuperar los datos" + e.getMessage());
        }
        
        return inventarioEner;
    }
    public static ArrayList<ItemBuff> readItemBuff(String filePath){
        ArrayList<ItemBuff>inventarioBuff = new ArrayList<>();
        
        String line = "";
        String nombre = "";
        String descripcion= "";
        int precio = 0;
        int cantidad = 0;
        String rareza = "";
        String atributoMejorado = "";
        int duracion = 0;
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
           reader.readLine();
           
           while((line = reader.readLine())!=null){
               String[] parts = line.split(",");
               try{
                        if(parts.length>=7){
                            nombre = parts[0].trim();
                            descripcion = parts[1].trim();
                            precio = Integer.parseInt(parts[2].trim());
                            cantidad = Integer.parseInt(parts[3].trim());
                            rareza = parts[4].trim();
                            atributoMejorado = parts[5].trim();
                            duracion = Integer.parseInt(parts[6].trim());
                            
                            inventarioBuff.add(new ItemBuff(nombre, descripcion, precio, cantidad, rareza, atributoMejorado, duracion));
                            
                        }
                        else{
                            System.out.println("No se pudo crear el item buffer por falta de atributos");
                        }
               }
               catch(Exception e){
                   System.out.println("Error creando el item de buff: " + e.getMessage());
               }
           }
           reader.close();
        }
        catch(IOException e){
            System.err.println("Error al recuperar los datos" + e.getMessage());
        }
        
        return inventarioBuff;
    }
    public static ArrayList<ItemUtilidad> readItemUtil(String filePath){
        ArrayList<ItemUtilidad>inventarioUtil = new ArrayList<>();
        
        String line = "";
        String nombre = "";
        String descripcion= "";
        int precio = 0;
        int cantidad = 0;
        String rareza = "";
        String tipoUso = "";
        int durabilidad = 0;
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
           reader.readLine();
           
           while((line = reader.readLine())!=null){
               String[] parts = line.split(",");
               try{
                        if(parts.length>=7){
                            nombre = parts[0].trim();
                            descripcion = parts[1].trim();
                            precio = Integer.parseInt(parts[2].trim());
                            cantidad = Integer.parseInt(parts[3].trim());
                            rareza = parts[4].trim();
                            tipoUso = parts[5].trim();
                            durabilidad = Integer.parseInt(parts[6].trim());
                            
                            inventarioUtil.add(new ItemUtilidad(nombre, descripcion, precio, cantidad, rareza, tipoUso, durabilidad));
                            
                        }
                        else{
                            System.out.println("No se pudo crear el item de utilidad por falta de atributos");
                        }
               }
               catch(Exception e){
                   System.out.println("Error creando el item de utilidad: " + e.getMessage());
               }
           }
           reader.close();
        }
        catch(IOException e){
            System.err.println("Error al recuperar los datos" + e.getMessage());
        }
        
        return inventarioUtil;
    }
    
    public static ArrayList<ItemRemedio> readItemRe(String filePath){
        ArrayList<ItemRemedio>inventarioRe = new ArrayList<>();
        
        String line = "";
        String nombre = "";
        String descripcion= "";
        int precio = 0;
        int cantidad = 0;
        String rareza = "";
        String estadoCurado = "";
        int efectividad = 0;
        boolean suceso = false;
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
           reader.readLine();
           
           while((line = reader.readLine())!=null){
               String[] parts = line.split(",");
               try{
                        if(parts.length>=8){
                            nombre = parts[0].trim();
                            descripcion = parts[1].trim();
                            precio = Integer.parseInt(parts[2].trim());
                            cantidad = Integer.parseInt(parts[3].trim());
                            rareza = parts[4].trim();
                            estadoCurado = parts[5].trim();
                            efectividad = Integer.parseInt(parts[6].trim());
                            suceso = Boolean.parseBoolean(parts[7].trim());
                            inventarioRe.add(new ItemRemedio(nombre, descripcion, precio, cantidad, rareza, estadoCurado, efectividad, suceso));
                            
                        }
                        else{
                            System.out.println("No se pudo crear el objeto de remedio por falta de atributos");
                        }
               }
               catch(Exception e){
                   System.out.println("Error creando el objeto de remedio: " + e.getMessage());
               }
           }
           reader.close();
        }
        catch(IOException e){
            System.err.println("Error al recuperar los datos" + e.getMessage());
        }
        
        return inventarioRe;
    }
       
}
