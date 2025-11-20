package Entity;

import game.GamePanel;
import java.util.Random;


public class NPC extends Entity {
    
    public NPC(GamePanel gp) {
        super(gp);
        
        direction = "down";
        speed = 1;
        
        getImage();
    }
    public void getImage(){
        //acá se colocan los sprites del npc que queramos, digamos profesores
    }
    public void setAction(){
        
        actionLockCounter ++;
        
        if(actionLockCounter == 120){
            Random random = new Random();
        int i = random.nextInt(100)+1;
        
        if(i <= 25){
            direction = "up";
            
        }
        if(i > 25 && i <= 50){
            direction = "down";
        }
        if(i > 50 && i <= 75){
            direction = "left";
        }
        if(i > 75 && i <= 100){
            direction = "right";
        }
        actionLockCounter = 0;
        }
        
    }
}
