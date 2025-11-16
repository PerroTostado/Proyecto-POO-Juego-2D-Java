
package Entity;

import java.util.Scanner;
import game.GamePanel;
import game.KeyHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entity{
    GamePanel gp;
    Font Gigi_40;
    KeyHandler keyH;
    Graphics2D g2;
    public int commandNum = 0;
    public int titleScreenState = 0;
    
    public final int screenX;
    public final int screenY;
    
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        
        solidArea = new Rectangle(17, 38, 16, 9);
        
        setDefaultsValues();
        getPlayerImage();
        
    }
    
    public void setDefaultsValues(){
        worldX = gp.tileSize * 24;
        worldY = gp.tileSize * 24;
        speed = 4;
        direction = "DOWN";
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
            
            pausa = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/menu.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void update(){
        
        if(keyH.upPress == true || keyH.downPress == true || keyH.leftPress == true || keyH.rigthPress == true){
            
            if(keyH.upPress == true){
                direction = "UP";                
            }
            else if(keyH.downPress == true){
                direction = "DOWN";                
            }
            else if(keyH.leftPress == true){
                direction = "LEFT";           
            }
            else if(keyH.rigthPress == true){
                direction = "RIGHT";
            }
            
            // Check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
        
            // If collision is false, player can move
            if(collisionOn == false){
                switch (direction){
                case "UP":
                    worldY -= speed;
                    break;

                case "DOWN":
                    worldY += speed;
                    break;

                case "LEFT":
                    worldX -= speed;
                    break;

                case "RIGHT":
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
    
    public void draw(Graphics2D g2){
        this.g2 = g2;
        //g2.setColor(Color.white);
        //g2.drawRect(18, 26, 22, 22);
        
        //TITLE STATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
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
        // Prueba para ver la collision
        //g2.setColor(Color.red);
        //g2.fillRect(screenX+17, screenY+38, gp.tileSize-32, gp.tileSize-39);
        
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        
        g2.setFont(Gigi_40);
        g2.setColor(Color.white);
        
        if(gp.gameState == 1){
           //algo 
        }
        if(gp.gameState == 2){
            drawPauseScreen();
        }
    }
    
    public void drawPauseScreen(){
        String text = "PAUSA";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        
        g2.drawImage(pausa, 0, 0, gp.tileSize*16, gp.tileSize*12, null);
    }
    
    public void drawTitleScreen() {
        
        if(titleScreenState == 0){
           // g2.setColor(new Color(70, 120, 180));
            //g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        
        
            //TITLE NAME


            int y = gp.screenHeight/3;

            g2.drawImage(pausa, 0, 0, gp.tileSize*16, gp.tileSize*12, null);
            g2.setColor(Color.white);


            //MENU
            String text;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

            text = "NUEVO JUEGO";
            int x = getXforCenteredText(text);
            y += gp.tileSize*3.5;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-gp.tileSize, y);
            }

            text = "CARGAR JUEGO";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-gp.tileSize, y);
            }

            text = "SALIR";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-gp.tileSize, y);
        }  
      }
        else if(titleScreenState == 1){
            
            //Rellenando formulario screen
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));
            
            String text = "Dinos tu nombre";
            

            int x = getXforCenteredText(text);
            int y = gp.tileSize*3;
            g2.drawString(text, x, y);
        }
        
    }
    
    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getHeight();
        int x = gp.screenWidth/3 - length/4;
        return x;
    }

    
}
