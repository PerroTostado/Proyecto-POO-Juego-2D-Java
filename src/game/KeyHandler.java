
package game;

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
                    }
                    if(gp.player.commandNum == 1){
                        //add later
                    }
                    if(gp.player.commandNum == 2){
                        System.exit(0);
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
