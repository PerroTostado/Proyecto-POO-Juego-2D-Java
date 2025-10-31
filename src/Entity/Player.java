
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
    
    public Player(GamePanel gP, KeyHandler keyH){
        this.gP = gP;
        this.keyH = keyH;
        
        setDefaultsValues();
        getPlayerImage();
        direction = "DOWN";
    }
    
    public void setDefaultsValues(){
        x = 100;
        y = 100;
        speed = 4;
    }
    
    public void getPlayerImage(){
        
        try{
            
            // Sprite player arriba
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkUp_(1).png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkUp_(2).png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkUp_(3).png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkUp_(4).png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkUp_(5).png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkUp_(6).png"));
            up7 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkUp_(7).png"));
            up8 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkUp_(8).png"));
            
            // Sprite player abajo
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkDown_(1).png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkDown_(2).png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkDown_(3).png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkDown_(4).png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkDown_(5).png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkDown_(6).png"));
            down7 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkDown_(7).png"));
            down8 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkDown_(8).png"));
            
            // Sprite player izquierda
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkLeft_(1).png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkLeft_(2).png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkLeft_(3).png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkLeft_(4).png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkLeft_(5).png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkLeft_(6).png"));
            left7 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkLeft_(7).png"));
            left8 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkLeft_(8).png"));
            
            // Sprite player derecha
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkRight_(1).png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkRight_(2).png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkRight_(3).png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkRight_(4).png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkRight_(5).png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkRight_(6).png"));
            right7 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkRight_(7).png"));
            right8 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkRight_(8).png"));
        
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void update(){
        if(keyH.upPress == true){
            direction = "UP";
            y -= speed;
        }
        else if(keyH.downPress == true){
            direction = "DOWN";
            y += speed;
        }
        else if(keyH.leftPress == true){
            direction = "LEFT";
            x -= speed;
        }
        else if(keyH.rigthPress == true){
            direction = "RIGHT";
            x += speed;
        }
    }
    
    public void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gP.tileSize, gP.tileSize);
        
        BufferedImage image = null;
        
        switch (direction){
            case "UP" -> image = up1;
            case "DOWN" -> image = down1;
            case "LEFT" -> image = left1;
            case "RIGHT" -> image = right1;
        }
        
        g2.drawImage(image, x, y, gP.tileSize, gP.tileSize, null);
    }
}
