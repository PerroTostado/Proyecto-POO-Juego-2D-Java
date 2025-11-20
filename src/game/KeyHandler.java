
package game;

import Entity.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Utileria.Archivos;

public class KeyHandler implements KeyListener{
    
    UI ui;
    Player player;
    GamePanel gp;
    Archivos ar;
    public boolean upPress, downPress, leftPress, rigthPress;
    public boolean enterPress = false; 
    
    public KeyHandler(GamePanel gp,UI ui){
        this.gp = gp;
        this.ui = ui;
    }
    
    public void setUI(UI ui) {
        this.ui = ui;
    }

    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();

        //Pause State
        if(gp.gameState == gp.pauseState){
            
            if(code == KeyEvent.VK_W){
                ui.commandNumPause--;
            }
            if(ui.commandNumPause < 0 ){
                ui.commandNumPause = 2;
            }
            
            if(code == KeyEvent.VK_S){
                ui.commandNumPause++;
                if(ui.commandNumPause > 2 ){
                    ui.commandNumPause = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(ui.commandNumPause == 0){
                    gp.gameState = 1;
                }
                if(ui.commandNumPause == 1){
                    gp.gameState = 1;
                    gp.savePlayerPosition(gp.player);
                    gp.savePlayerInfo(gp.player);
                }
                if(ui.commandNumPause == 2){
                    gp.gameState = gp.titleState;
                    ui.titleScreenState = 0;
                    ui.commandNum = 3;
                }
                
            }      
        }
            
        if(gp.gameState == gp.titleState){
            
            if(ui.titleScreenState == 0){
                
                if(code == KeyEvent.VK_W){
                    ui.commandNum--;
                    if(ui.commandNum < 0 ){
                        ui.commandNum = 2;
                    }
                }
                if(code == KeyEvent.VK_S){
                    ui.commandNum++;
                    if(ui.commandNum > 2 ){
                        ui.commandNum = 0;
                    }
                }
                if(code == KeyEvent.VK_ENTER){
                    if(ui.commandNum == 0){
                       ui.titleScreenState = 1;
                       gp.i = 1;
                        //gp.gameState = gp.playState;
                    }
                    if(ui.commandNum == 1){
                        gp.loadPlayerPosition();
                        gp.gameState = gp.playState;
                        
                    }
                    if(ui.commandNum == 2){
                        System.exit(0);
                    }
                    
                }
                
            }
            
            else if(ui.titleScreenState == 1){
                
                if(code == KeyEvent.VK_W){
                ui.commandNum--;
                if(ui.commandNum < 0 ){
                    ui.commandNum = 2;
                }
            }
                if(code == KeyEvent.VK_S){
                    ui.commandNum++;
                    if(ui.commandNum > 2 ){
                        ui.commandNum = 0;
                    }
                }
                if(code == KeyEvent.VK_ENTER){
                    if(ui.commandNum == 0){
                       ui.titleScreenState = 2;
                       ui.tempGenero = "Masculino";
                        
                    }
                    if(ui.commandNum == 1){
                        ui.titleScreenState = 2;
                        ui.tempGenero = "Femenino";
                    }
                    if(ui.commandNum == 2){
                        ui.titleScreenState = 0;
                    }
                }
                
            }
             
            else if(ui.titleScreenState == 3){
                
                if(code == KeyEvent.VK_W){
                ui.commandNum--;
                if(ui.commandNum < 0 ){
                    ui.commandNum = 2;
                }
            }
                if(code == KeyEvent.VK_S){
                    ui.commandNum++;
                    if(ui.commandNum > 2 ){
                        ui.commandNum = 0;
                    }
                }
                if(code == KeyEvent.VK_ENTER){
                    if(ui.commandNum == 0){
                       ui.titleScreenState = 4;
                       ui.tempComunidadUIS = true;
                        
                    }
                    if(ui.commandNum == 1){
                        //ui.titleScreenState = 3;
                        gp.gameState = gp.playState;
                        ui.tempComunidadUIS = false;
                    }
                    if(ui.commandNum == 2){
                        ui.titleScreenState = 2;
                    }
                }
                
            } 
            else if(ui.titleScreenState == 2){
                
                if(code == KeyEvent.VK_W){
                ui.commandNum--;
                if(ui.commandNum < 0 ){
                    ui.commandNum = 6;
                }
            }
                if(code == KeyEvent.VK_S){
                    ui.commandNum++;
                    if(ui.commandNum > 6 ){
                        ui.commandNum = 0;
                        
                    }
                }
                if(code == KeyEvent.VK_ENTER){
                    if(ui.commandNum == 0){
                       ui.titleScreenState = 3;
                       ui.tempEstratoSocial = 1;
                    }
                    if(ui.commandNum == 1){
                        ui.titleScreenState = 3;
                        ui.tempEstratoSocial = 2;
                    }
                    if(ui.commandNum == 2){
                        ui.titleScreenState = 3;
                        ui.tempEstratoSocial = 3;
                    }
                    
                    if(ui.commandNum == 3){
                       ui.titleScreenState = 3;
                        ui.tempEstratoSocial = 4;
                    }
                    if(ui.commandNum == 4){
                        ui.titleScreenState = 3;
                        ui.tempEstratoSocial = 5;
                    }
                    if(ui.commandNum == 5){
                        ui.titleScreenState = 3;
                        ui.tempEstratoSocial = 6;
                    }
                    if(ui.commandNum == 6){
                        ui.titleScreenState = 1;
                        
                    }
                }
                
            }
            else if (ui.titleScreenState == 4){
                
                if(code == KeyEvent.VK_W){
                ui.commandNum--;
                if(ui.commandNum < 0 ){
                    ui.commandNum = 3;
                    }
                }
                if(code == KeyEvent.VK_S){
                    ui.commandNum++;
                    if(ui.commandNum > 3 ){
                        ui.commandNum = 0;
                    }
                }
                
                if(code == KeyEvent.VK_ENTER){
                    if(ui.commandNum == 0){
                       ui.titleScreenState = 5;
                       
                    }
                    if(ui.commandNum == 1){
                        ui.titleScreenState = 6;
                        
                    }
                    if(ui.commandNum == 2){
                   
                        gp.gameState = gp.playState;
                        gp.player.tempRol = "Administrativo";
                    }
                    
                    if(ui.commandNum == 3){
                       ui.titleScreenState = 3;
                        
                    }
            }

            
        }
                else if (ui.titleScreenState == 5){
                
                if(code == KeyEvent.VK_W){
                ui.commandNum--;
                if(ui.commandNum < 0 ){
                    ui.commandNum = 5;
                    }
                }
                if(code == KeyEvent.VK_S){
                    ui.commandNum++;
                    if(ui.commandNum > 5 ){
                        ui.commandNum = 0;
                    }
                }
                
                if(code == KeyEvent.VK_ENTER){
                    if(ui.commandNum == 0){
                       gp.gameState = gp.playState;
                       gp.loadPlayerPosition();
                       ui.tempRol = "Estudiante Pregrado";
                    }
                    if(ui.commandNum == 1){
                        gp.gameState = gp.playState;
                        gp.loadPlayerPosition();
                        ui.tempRol = "Estudiante Posgrado";
                    }
                    if(ui.commandNum == 2){
                        gp.loadPlayerPosition();
                        gp.gameState = gp.playState;
                        ui.tempRol = "Estudiante Tecnologo";
                    }
                    
                    if(ui.commandNum == 3){
                       gp.gameState = gp.playState;
                       gp.loadPlayerPosition(); 
                       ui.tempRol = "Estudiante de Maestria";
                    }
                    if(ui.commandNum == 4){
                        gp.loadPlayerPosition();
                        gp.gameState = gp.playState;
                        ui.tempRol = "Estudiante de Espeliacizacion";
                    }
                    
                    if(ui.commandNum == 5){
                       gp.gameState = gp.playState;
                       gp.loadPlayerPosition(); 
                       ui.tempRol = "Estudiante de Doctorado";
                    }
            }
        }
            else if (ui.titleScreenState == 6){
                
                if(code == KeyEvent.VK_W){
                ui.commandNum--;
                if(ui.commandNum < 0 ){
                    ui.commandNum = 1;
                    }
                }
                if(code == KeyEvent.VK_S){
                    ui.commandNum++;
                    if(ui.commandNum > 1 ){
                        ui.commandNum = 0;
                    }
                }
                
                if(code == KeyEvent.VK_ENTER){
                    if(ui.commandNum == 0){
                       gp.gameState = gp.playState;
                       ui.tempRol = "Profesor Planta";
                       
                    }
                    if(ui.commandNum == 1){
                       gp.gameState = gp.playState;
                       ui.tempRol = "Profesor Catedra";
                        
                    }
                }
            }
    }
       
        //Play state
        if(code == KeyEvent.VK_W){
            upPress = true;
        }
        if(code == KeyEvent.VK_S){
            downPress = true;
        }
        if(code == KeyEvent.VK_A){
            leftPress = true;
        }
        if(code == KeyEvent.VK_D){
            rigthPress = true;
        }
        
        if(code == KeyEvent.VK_ENTER){
            enterPress = true; 
        }
        
        if(code == KeyEvent.VK_I){
            if(gp.gameState == 1){
                gp.gameState = 5;
                gp.loadPlayerInfo();
            }
            else if(gp.gameState == 5){
                gp.gameState = 1;
            }
        }
        //Pause State
        if(code == KeyEvent.VK_P){
            if(gp.gameState == gp.playState){
                gp.gameState = gp.pauseState;
            }
            else if(gp.gameState == gp.pauseState){
                gp.gameState = gp.playState;
            }
        }

        // DIALOGUE STATE: Se usa ENTER para cerrar/avanzar el diálogo
        if(gp.gameState == gp.dialogueState){
            if(code == KeyEvent.VK_ENTER){
                // Al presionar ENTER en el diálogo, volvemos al juego.
                gp.gameState = gp.playState;
                enterPress = true;
            }
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W){
            upPress = false;
        }
        if(code == KeyEvent.VK_S){
            downPress = false;
        }
        if(code == KeyEvent.VK_A){
            leftPress = false;
        }
        if(code == KeyEvent.VK_D){
            rigthPress = false;
        }
    }
    
    
    
}
