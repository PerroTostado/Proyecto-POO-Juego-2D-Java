
package Entity;

import game.GamePanel;
import game.KeyHandler;
import game.UtilityTool;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public int solidAreaDefaultX;
    public int solidAreaDefaultY;
    public boolean invincible = false;
    public int invincibleCounter = 0; 
    
    public final int screenX;
    public final int screenY;
    //public final int worldStartX = 48*24;
    //public final int worldStartY = 48*24;
    public final int worldStartX = 48*7;
    public final int worldStartY = 48*23;
    
    public Player(GamePanel gp, KeyHandler keyH,int screenx,int screeny){  
        super(gp);
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        
        solidArea = new Rectangle(17, 38, 16, 9);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY =solidArea.y;
        
        setValues(screenx,screeny);
        getPlayerImage();
        
    }
    
    public void setValues(int x,int y){
        worldX = x;
        worldY = y;
        speed = 4;
        direction = "DOWN";
        
        // PLAYER STATUS
        maxLife = 6;
        life = maxLife;
        
    }
    
    public void getPlayerImage(){
             
        // Sprite player arriba
        up1 = setupMov("/res/player/walkUp_(1).png");
        up2 = setupMov("/res/player/walkUp_(2).png");
        up3 = setupMov("/res/player/walkUp_(3).png");
        up4 = setupMov("/res/player/walkUp_(4).png");
        // Sprite player abajo
        down1 = setupMov("/res/player/walkDown_(1).png");
        down2 = setupMov("/res/player/walkDown_(2).png");
        down3 = setupMov("/res/player/walkDown_(3).png");
        down4 = setupMov("/res/player/walkDown_(4).png");
        // Sprite player izquierda
        left1 = setupMov("/res/player/walkLeft_(1).png");
        left2 = setupMov("/res/player/walkLeft_(2).png");
        left3 = setupMov("/res/player/walkLeft_(3).png");
        left4 = setupMov("/res/player/walkLeft_(4).png");
        // Sprite player derecha
        right1 = setupMov("/res/player/walkRight_(1).png");
        right2 = setupMov("/res/player/walkRight_(2).png");
        right3 = setupMov("/res/player/walkRight_(3).png");
        right4 = setupMov("/res/player/walkRight_(4).png");
                  
    }

    public BufferedImage setupMov(String imageName) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(imageName));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch(IOException e) {
            e.printStackTrace();
        }
        return image;
    }
    
    public void update(){
        
        if(gp.i==1){
            worldX = worldStartX;
            worldY = worldStartY;
            gp.i = 0;
        }
        
        //CHECK EVENT
        gp.eHandler.checkEvent();
        
        if(keyH.upPress == true || keyH.downPress == true || keyH.leftPress == true || keyH.rigthPress == true){
            
            if(keyH.upPress == true){
                direction = "up";                
            }
            else if(keyH.downPress == true){
                direction = "down";                
            }
            else if(keyH.leftPress == true){
                direction = "left";           
            }
            else if(keyH.rigthPress == true){
                direction = "right";
            }
            
            // Check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            // Check NPC collision
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            //interactNPC(npcIndex);
            
            
            // If collision is false, player can move
            if(collisionOn == false){
                switch (direction){
                case "up":
                    worldY -= speed;
                    break;

                case "down":
                    worldY += speed;
                    break;

                case "left":
                    worldX -= speed;
                    break;

                case "right":
                    worldX += speed;
                    break;
                }
            }
            
            spriteCounter ++;
            if(spriteCounter > 10){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                spriteNum = 3;
                }
                else if(spriteNum == 3){
                spriteNum = 4;
                }
                else if(spriteNum == 4){
                spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }  
}
