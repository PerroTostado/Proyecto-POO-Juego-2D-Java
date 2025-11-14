package game;

import java.util.Scanner;
import Utileria.Archivos;
import javax.swing.JFrame;
import ComunidadUIS.Persona;
import ComunidadUIS.EstudiantePre;
import ComunidadUIS.EstudianteTec;
import ComunidadUIS.EstudianteEspez;
import ComunidadUIS.EstudianteMas;
import ComunidadUIS.EstudianteDoc;
import ComunidadUIS.EstudiantePos;
import ComunidadUIS.ProfesorPlanta;
import ComunidadUIS.ProfesorCatedra;
import ComunidadUIS.Administrativo;
import noComunidadUIS.Visitantes;

public class Game {
    
     
     
    public static void main(String[] args) {
        
        String name, lugarOrigen, colorPiel, genero, orientacionSexual, sexo, sisben;
        int edad, estratoSocial;
        boolean comunidadUIS;
        
        Persona rol = null;
        /*JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("JUEGO");
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.startGameThread();*/
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digita tu edad: ");
        edad = scanner.nextInt();
                
        scanner.nextLine();
        System.out.println("Digita tu nombre: ");
        name = scanner.nextLine();
        
        System.out.println("Digita tu lugar de origen: ");
        lugarOrigen = scanner.nextLine();
        System.out.println("Digita tu color de piel: ");
        colorPiel = scanner.nextLine();
        System.out.println("Escoge tu genero: ");
        Archivos.escogeGen();
        int opcionX = scanner.nextInt();
        while(true){
            switch(opcionX){
                case 1: {genero = "Masculino";
                }
                case 2: {genero = "Femenino";
                }
                default:{
                    System.out.println("No existe esa opcion");
                }
            }
            
        break;}
        
        System.out.println("digita tu orientacion sexual: ");
        orientacionSexual = scanner.nextLine();
        System.out.println("Digita tu sexo: ");
        sexo = scanner.nextLine();
        System.out.println("Digita tu sisben: ");
        sisben = scanner.nextLine();
        System.out.println("digita tu estrato social: ");
        estratoSocial = scanner.nextInt();
        System.out.println("Eres de la comunidad UIS?");
        comunidadUIS = scanner.nextBoolean();
        
        Archivos.escogerRol();
        int opcion = scanner.nextInt();
        
        /*while(true){
        switch(opcion){
            case 1:{
                Archivos.escogeEstu();
                int opcionEstu = scanner.nextInt();
                switch(opcionEstu){
                    case 1:{
                        rol = new EstudiantePre(name, edad, lugarOrigen,colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, 20, 1, false, false, false); 
                    }
                    
                    case 2:{
                        rol = new EstudianteTec(name, edad, lugarOrigen,colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, 20, 1, "hola", false);
                    }
                    case 3:{
                        rol = new EstudianteEspez(name, edad, lugarOrigen,colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, 20, 1, "", 0.0);
                    }
                    case 4:{
                        rol = new EstudianteMas(name, edad, lugarOrigen,colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, 20, 1, false, "", "");
                    }
                    case 5:{
                        rol = new EstudianteDoc(name, edad, lugarOrigen,colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, 20, 1, 0, "");
                    }
                    case 6:{
                        rol = new EstudiantePos(name, edad, lugarOrigen,colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, 20, 1, "", "");
                    }
                    default:{
                        System.out.println("Opcion incorrecta");
                    }
                }
            }
            case 2:{
                Archivos.escogeProfe();
                int opcionProfe = scanner.nextInt();
                switch(opcionProfe){
                    case 1:{
                        rol = new ProfesorPlanta(name, edad, lugarOrigen,colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, 0, false);
                    }
                    case 2:{
                        rol = new ProfesorCatedra(name, edad, lugarOrigen,colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, 0, "");
                    }
                    default:{
                        System.out.println("Opcion no existe");
                    }
                }
            }
            case 3:{
                rol = new Administrativo(name, edad, lugarOrigen,colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, "", "");
            }
            case 4:{
                rol = new Visitantes(name, edad, lugarOrigen,colorPiel, genero, orientacionSexual, sexo, comunidadUIS, estratoSocial, sisben, "", false);
            }
        }
      }   
        */
    }
    
}
