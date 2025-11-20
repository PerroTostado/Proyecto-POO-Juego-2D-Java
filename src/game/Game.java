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
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("UIS ADVENTURE");
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.startGameThread();
        
        
    }
    
}
