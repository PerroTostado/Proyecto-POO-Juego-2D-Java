
package Entity;

import game.GamePanel;
import game.KeyHandler;
import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends Entity{
    GamePanel gP;
    KeyHandler keyH;
    
    public Player(GamePanel gP, KeyHandler keyH){
        this.gP = gP;
        this.keyH = keyH;
        
        setDefaultsValues();
    }
    
    public void setDefaultsValues(){
        x = 100;
        y = 100;
        speed = 4;
    }
    
    public void update(){
        if(keyH.upPress == true){
            y -= speed;
        }
        else if(keyH.downPress == true){
            y += speed;
        }
        else if(keyH.leftPress == true){
            x -= speed;
        }
        else if(keyH.rigthPress == true){
            x += speed;
        }
    }
    
    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(x, y, gP.tileSize, gP.tileSize);
    }
}
