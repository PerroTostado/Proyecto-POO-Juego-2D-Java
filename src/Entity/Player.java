
package Entity;

import game.GamePanel;
import game.KeyHandler;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entity{
    GamePanel gP;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
    public Player(GamePanel gP, KeyHandler keyH){
        this.gP = gP;
        this.keyH = keyH;
        
        screenX = gP.screenWidth/2 - (gP.tileSize/2);
        screenY = gP.screenHeight/2 - (gP.tileSize/2);
        
        setDefaultsValues();
        getPlayerImage();
        direction = "DOWN";
    }
    
    public void setDefaultsValues(){
        worldX = gP.tileSize*23;
        worldY = gP.tileSize*21;
        speed = 4;
    }
    
    public void getPlayerImage(){
        
        try{
            
            // Sprite player arriba
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkUp_(1).png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkUp_(2).png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkUp_(3).png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkUp_(4).png"));
            
            // Sprite player abajo
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkDown_(1).png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkDown_(2).png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkDown_(3).png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkDown_(4).png"));
           
            // Sprite player izquierda
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkLeft_(1).png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkLeft_(2).png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkLeft_(3).png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkLeft_(4).png"));
             
            // Sprite player derecha
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkRight_(1).png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkRight_(2).png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkRight_(3).png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkRight_(4).png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void update(){
        
        if(keyH.upPress == true || keyH.downPress == true || keyH.leftPress == true || keyH.rigthPress == true){
            
            if(keyH.upPress == true){
                direction = "UP";
                worldY -= speed;
            }
            else if(keyH.downPress == true){
                direction = "DOWN";
                worldY += speed;
            }
            else if(keyH.leftPress == true){
                direction = "LEFT";
                worldX -= speed;
            }
            else if(keyH.rigthPress == true){
                direction = "RIGHT";
                worldX += speed;
            }
        
            spriteCounter ++;
            if(spriteCounter > 10){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        
    }
    
    public void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gP.tileSize, gP.tileSize);
        
        BufferedImage image = null;
        
        switch (direction){
            case "UP":
                if (spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2){
                    image = up2;
                }
                if (spriteNum == 3){
                    image = up3;
                }
                if (spriteNum == 4){
                    image = up4;
                }
                break;
                
            case "DOWN":
                if (spriteNum == 1){
                    image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                if (spriteNum == 3){
                    image = down3;
                }
                if (spriteNum == 4){
                    image = down4;
                }
                break;
                
            case "LEFT":
                if (spriteNum == 1){
                    image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
                if (spriteNum == 3){
                    image = left3;
                }
                if (spriteNum == 4){
                    image = left4;
                }
                break;
                
            case "RIGHT":
                if (spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                if (spriteNum == 3){
                    image = right3;
                }
                if (spriteNum == 4){
                    image = right4;
                }
                break;
        }
        
        g2.drawImage(image, screenX, screenY, gP.tileSize, gP.tileSize, null);
    }
}
