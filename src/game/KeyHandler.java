
package game;

import Entity.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    
    GamePanel gp;
    
    public boolean upPress, downPress, leftPress, rigthPress;
    
    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
        //Title State
        if(gp.gameState == gp.pauseState){
              
            if(code == KeyEvent.VK_W){
                gp.player.commandNumPause--;
            }
            if(gp.player.commandNumPause < 0 ){
                gp.player.commandNumPause = 2;
            }
            
            if(code == KeyEvent.VK_S){
                gp.player.commandNumPause++;
                if(gp.player.commandNumPause > 2 ){
                    gp.player.commandNumPause = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.player.commandNumPause == 0){
                    gp.gameState = 1;
                }
                if(gp.player.commandNumPause == 1){
                    gp.gameState = 1;
                    gp.savePlayerPosition(gp.player);
                }
                if(gp.player.commandNumPause == 2){
                    gp.gameState = gp.titleState;
                    gp.player.titleScreenState = 0;
                    gp.player.commandNum = 3;
                }
                
            }      
        }
            
        if(gp.gameState == gp.titleState){
            
            if(gp.player.titleScreenState == 0){
                
                if(code == KeyEvent.VK_W){
                    gp.player.commandNum--;
                    if(gp.player.commandNum < 0 ){
                        gp.player.commandNum = 2;
                    }
                }
                if(code == KeyEvent.VK_S){
                    gp.player.commandNum++;
                    if(gp.player.commandNum > 2 ){
                        gp.player.commandNum = 0;
                    }
                }
                if(code == KeyEvent.VK_ENTER){
                    if(gp.player.commandNum == 0){
                       gp.player.titleScreenState = 1;
                        //gp.gameState = gp.playState;
                    }
                    if(gp.player.commandNum == 1){
                        gp.loadPlayerPosition();
                        gp.gameState = gp.playState;
                        
                    }
                    if(gp.player.commandNum == 2){
                        System.exit(0);
                    }
                    
                }
                
            }
            
            else if(gp.player.titleScreenState == 1){
                
                if(code == KeyEvent.VK_W){
                gp.player.commandNum--;
                if(gp.player.commandNum < 0 ){
                    gp.player.commandNum = 2;
                }
            }
                if(code == KeyEvent.VK_S){
                    gp.player.commandNum++;
                    if(gp.player.commandNum > 2 ){
                        gp.player.commandNum = 0;
                    }
                }
                if(code == KeyEvent.VK_ENTER){
                    if(gp.player.commandNum == 0){
                       gp.player.titleScreenState = 2;
                       gp.player.tempGenero = "Masculino";
                        
                    }
                    if(gp.player.commandNum == 1){
                        gp.player.titleScreenState = 2;
                        gp.player.tempGenero = "Femenino";
                    }
                    if(gp.player.commandNum == 2){
                        gp.player.titleScreenState = 0;
                    }
                }
                
            }
             
            else if(gp.player.titleScreenState == 3){
                
                if(code == KeyEvent.VK_W){
                gp.player.commandNum--;
                if(gp.player.commandNum < 0 ){
                    gp.player.commandNum = 2;
                }
            }
                if(code == KeyEvent.VK_S){
                    gp.player.commandNum++;
                    if(gp.player.commandNum > 2 ){
                        gp.player.commandNum = 0;
                    }
                }
                if(code == KeyEvent.VK_ENTER){
                    if(gp.player.commandNum == 0){
                       gp.player.titleScreenState = 4;
                       gp.player.tempComunidadUIS = true;
                        
                    }
                    if(gp.player.commandNum == 1){
                        //gp.player.titleScreenState = 3;
                        gp.gameState = gp.playState;
                        gp.player.tempComunidadUIS = false;
                    }
                    if(gp.player.commandNum == 2){
                        gp.player.titleScreenState = 2;
                    }
                }
                
            } 
            else if(gp.player.titleScreenState == 2){
                
                if(code == KeyEvent.VK_W){
                gp.player.commandNum--;
                if(gp.player.commandNum < 0 ){
                    gp.player.commandNum = 6;
                }
            }
                if(code == KeyEvent.VK_S){
                    gp.player.commandNum++;
                    if(gp.player.commandNum > 6 ){
                        gp.player.commandNum = 0;
                        
                    }
                }
                if(code == KeyEvent.VK_ENTER){
                    if(gp.player.commandNum == 0){
                       gp.player.titleScreenState = 3;
                       gp.player.tempEstratoSocial = 1;
                    }
                    if(gp.player.commandNum == 1){
                        gp.player.titleScreenState = 3;
                        gp.player.tempEstratoSocial = 2;
                    }
                    if(gp.player.commandNum == 2){
                        gp.player.titleScreenState = 3;
                        gp.player.tempEstratoSocial = 3;
                    }
                    
                    if(gp.player.commandNum == 3){
                       gp.player.titleScreenState = 3;
                        gp.player.tempEstratoSocial = 4;
                    }
                    if(gp.player.commandNum == 4){
                        gp.player.titleScreenState = 3;
                        gp.player.tempEstratoSocial = 5;
                    }
                    if(gp.player.commandNum == 5){
                        gp.player.titleScreenState = 3;
                        gp.player.tempEstratoSocial = 6;
                    }
                    if(gp.player.commandNum == 6){
                        gp.player.titleScreenState = 1;
                        
                    }
                }
                
            }
            else if (gp.player.titleScreenState == 4){
                
                if(code == KeyEvent.VK_W){
                gp.player.commandNum--;
                if(gp.player.commandNum < 0 ){
                    gp.player.commandNum = 3;
                    }
                }
                if(code == KeyEvent.VK_S){
                    gp.player.commandNum++;
                    if(gp.player.commandNum > 3 ){
                        gp.player.commandNum = 0;
                    }
                }
                
                if(code == KeyEvent.VK_ENTER){
                    if(gp.player.commandNum == 0){
                       gp.player.titleScreenState = 5;
                       
                    }
                    if(gp.player.commandNum == 1){
                        gp.player.titleScreenState = 6;
                        
                    }
                    if(gp.player.commandNum == 2){
                   
                        gp.gameState = gp.playState;
                    }
                    
                    if(gp.player.commandNum == 3){
                       gp.player.titleScreenState = 3;
                        
                    }
            }

            
        }
                else if (gp.player.titleScreenState == 5){
                
                if(code == KeyEvent.VK_W){
                gp.player.commandNum--;
                if(gp.player.commandNum < 0 ){
                    gp.player.commandNum = 5;
                    }
                }
                if(code == KeyEvent.VK_S){
                    gp.player.commandNum++;
                    if(gp.player.commandNum > 5 ){
                        gp.player.commandNum = 0;
                    }
                }
                
                if(code == KeyEvent.VK_ENTER){
                    if(gp.player.commandNum == 0){
                       gp.gameState = gp.playState;
                       
                    }
                    if(gp.player.commandNum == 1){
                        gp.gameState = gp.playState;
                        
                    }
                    if(gp.player.commandNum == 2){
                   
                        gp.gameState = gp.playState;
                    }
                    
                    if(gp.player.commandNum == 3){
                       gp.gameState = gp.playState;
                        
                    }
                    if(gp.player.commandNum == 4){
                   
                        gp.gameState = gp.playState;
                    }
                    
                    if(gp.player.commandNum == 5){
                       gp.gameState = gp.playState;
                        
                    }
            }
        }
            else if (gp.player.titleScreenState == 6){
                
                if(code == KeyEvent.VK_W){
                gp.player.commandNum--;
                if(gp.player.commandNum < 0 ){
                    gp.player.commandNum = 1;
                    }
                }
                if(code == KeyEvent.VK_S){
                    gp.player.commandNum++;
                    if(gp.player.commandNum > 1 ){
                        gp.player.commandNum = 0;
                    }
                }
                
                if(code == KeyEvent.VK_ENTER){
                    if(gp.player.commandNum == 0){
                       gp.gameState = gp.playState;
                       
                    }
                    if(gp.player.commandNum == 1){
                       gp.gameState = gp.playState;
                        
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
        if(code == KeyEvent.VK_P){
            if(gp.gameState == 1){
                gp.gameState = 2;
            }
            else if(gp.gameState == 2){
                gp.gameState = 1;
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
