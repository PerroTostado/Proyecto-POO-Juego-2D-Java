
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
