
package Entity;

import Entity.Entity;
import java.util.Scanner;
import game.GamePanel;
import game.KeyHandler;
import game.UI;
import game.UtilityTool;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.FileWriter;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    Graphics2D g2;
    public int commandNum = 0;
    public int commandNumPause = 0;
    public int titleScreenState = 0;
    public String tempName = "Jugador UIS";
    public int tempEdad = 16;
    public String tempGenero;
    public boolean tempComunidadUIS;
    public int tempEstratoSocial;
    public String tempRol;
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;
    public boolean invincible = false;
    public int invincibleCounter = 0; 
    
    public final int screenX;
    public final int screenY;
    public final int worldStartX = 48*24;
    public final int worldStartY = 48*24;
    
    public Player(GamePanel gp, KeyHandler keyH,int screenx,int screeny){                                                                                           
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
        
            
        try {
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
            
            //Pausa
            pausa = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/menu.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
            
            
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
        if(gp.gameState == 1){
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
            g2.drawImage(image, screenX, screenY, null);
        }
        if(gp.gameState == 2){
            drawPauseScreen();
        }
        if(gp.gameState == 5){
            drawInfoScreen();
        }
    }
    
    public void drawInfoScreen(){
        
        int xBox = 450;
        int yBox = 10;
        int width = 300;
        int height = 200;
        
        drawSubWindow(xBox, yBox, width, height);
        
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(20F));
        
        String text = "Informacion del Jugador";
        int x = 470;
        int y = 40;
        g2.drawString(text, x, y);
        
        text = "Nombre:" + gp.player.tempName;
        x = 470;
        y += 30;
        g2.drawString(text, x, y);
        
        text = "Edad:" + gp.player.tempEdad;
        x = 470;
        y += 30;
        g2.drawString(text, x, y);
        
        text = "Genero:" + gp.player.tempGenero;
        x = 470;
        y += 30;
        g2.drawString(text, x, y);
        
        text = "Estrato:" + Integer.toString(gp.player.tempEstratoSocial);
        x = 470;
        y += 30;
        g2.drawString(text, x, y);
        
        text = "Rol:" + gp.player.tempRol;
        x = 470;
        y += 30;
        g2.drawString(text, x, y);
        
    }
    
    public void drawPauseScreen(){

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(42F));
            
        String text = "REANUDAR";
        int textWidth = centerText(text);
        int x = (gp.screenWidth - textWidth) / 2;
        int y = gp.tileSize*7;
        g2.drawString(text, x, y);
        if(commandNumPause == 0){
            g2.drawString(">", x-30, y);
        }

        text = "GUARDAR";
        textWidth = centerText(text);
        x = (gp.screenWidth - textWidth) / 2;
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNumPause == 1){
            g2.drawString(">", x-30, y);
        }
        
        text = "SALIR";
        textWidth = centerText(text);
        x = (gp.screenWidth - textWidth) / 2;
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNumPause == 2){
            g2.drawString(">", x-30, y);
        }
        
        g2.drawImage(pausa, 0, 0, gp.tileSize*16, gp.tileSize*12, null);
    }
    
    public void drawTitleScreen(){
        
        if(titleScreenState == 0){
            g2.setColor(new Color(70, 120, 180));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        
        
            //TITLE NAME
            int y = gp.screenHeight/3;

            g2.drawImage(pausa, 0, 0, gp.tileSize*16, gp.tileSize*12, null);
            g2.setColor(Color.white);


            //MENU
            String text;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

            text = "NUEVO JUEGO";
            int textWidth = centerText(text);
            int x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize*3.5;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-30, y);
            }

            text = "CARGAR JUEGO";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-30, y);
            }

            text = "SALIR";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-30, y);
            }
        }
        else if(titleScreenState == 1){
            
            //Rellenando formulario screen
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));
            
            String text = "Escoge tú genero";
            int textWidth = centerText(text);
            int x = (gp.screenWidth - textWidth) / 2;
            int y = gp.tileSize*2;
            g2.drawString(text, x, y);
            
            text = "Masculino";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize*3;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-30, y);
            }
            
            text = "Femenino";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-30, y);
            }
            
            text = "Volver";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-30, y);
            }       
        }
        
        else if(titleScreenState == 3){
            
            //Rellenando formulario screen
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));
            
            String text = "Eres comunidad UIS?";
            int x = getXforCenteredText(text)-42*2;
            int y = gp.tileSize*3;
            g2.drawString(text, gp.tileSize+130, y);
            
            text = "Si";
            x = getXforCenteredText(text);
            y += gp.tileSize*3;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 0){
                g2.drawString(">", gp.tileSize, y);
            }
            
            text = "No";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 1){
                g2.drawString(">", gp.tileSize, y);
            }
            
            text = "Volver";
            x = getXforCenteredText(text);
            y += gp.tileSize*2;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 2){
                g2.drawString(">", gp.tileSize, y);
            }
            
        }
        else if(titleScreenState == 2){
            
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));
            
            String text = "Estrato Social";
            int x = getXforCenteredText(text)-42*2;
            int y = gp.tileSize*3;
            g2.drawString(text, gp.tileSize+200, y);
            
            text = "1";
            x = getXforCenteredText(text)-4;
            y += gp.tileSize*2;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 0){
                g2.drawString(">", gp.tileSize, y);
            }
            
            text = "2";
            x = getXforCenteredText(text)-4;
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 1){
                g2.drawString(">", gp.tileSize, y);
            }
            
            text = "3";
            x = getXforCenteredText(text)-4;
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 2){
                g2.drawString(">", gp.tileSize, y);
            }
            
            text = "4";
            x = getXforCenteredText(text)-4;
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 3){
                g2.drawString(">", gp.tileSize, y);
            }
            
            text = "5";
            x = getXforCenteredText(text)-4;
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 4){
                g2.drawString(">", gp.tileSize, y);
            }
            
            text = "6";
            x = getXforCenteredText(text)-4;
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 5){
                g2.drawString(">", gp.tileSize, y);
            }
            text = "Volver";
            x = getXforCenteredText(text)-42*2;
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 6){
                g2.drawString(">", gp.tileSize, y);
            }
            
        }
        
        else if (titleScreenState == 4){
            
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));
            
            String text = "Qué rol posees?";
            int x = getXforCenteredText(text)-42*2;
            int y = gp.tileSize*3;
            g2.drawString(text, gp.tileSize+170, y);
            
            text = "Estudiante";
            x = getXforCenteredText(text)-42*2;
            y += gp.tileSize*2;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 0){
                g2.drawString(">", gp.tileSize, y);
            }
            
             text = "Profesor";
            x = getXforCenteredText(text)-42*2;
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 1){
                g2.drawString(">", gp.tileSize, y);
            }
            
             text = "Administrativo";
            x = getXforCenteredText(text)-42*2;
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 2){
                g2.drawString(">", gp.tileSize, y);
            }
            text = "Volver";
            x = getXforCenteredText(text)-42*2;
            y += gp.tileSize*2;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 3){
                g2.drawString(">", gp.tileSize, y);
            }
        }
        
        else if (titleScreenState == 5){
            
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));
            
            String text = "Qué tipo de estudiante eres?";
            int x = getXforCenteredText(text)-42*4;
            int y = gp.tileSize*3;
            g2.drawString(text, gp.tileSize+70, y);
            
            text = "Pregrado";
            x = getXforCenteredText(text)-42*2;
            y += gp.tileSize*2;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 0){
                g2.drawString(">", gp.tileSize, y);
            }
            
             text = "Posgrado";
            x = getXforCenteredText(text)-42*2;
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 1){
                g2.drawString(">",gp.tileSize, y);
            }
            
             text = "Tecnológico";
            x = getXforCenteredText(text)-42*2;
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 2){
                g2.drawString(">", gp.tileSize, y);
            }
            text = "Maestría";
            x = getXforCenteredText(text)-42*2;
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 3){
                g2.drawString(">", gp.tileSize, y);
            }
            text = "Especialización";
            x = getXforCenteredText(text)-42*2;
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 4){
                g2.drawString(">", gp.tileSize, y);
            }
            
             text = "Doctorado";
            x = getXforCenteredText(text)-42*2;
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 5){
                g2.drawString(">", gp.tileSize, y);
            }
        }
        else if(titleScreenState == 6){
            
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));
            
            String text = "Qué tipo de profesor eres?";
            int x = getXforCenteredText(text)-42*4;
            int y = gp.tileSize*3;
            g2.drawString(text, gp.tileSize+80, y);
            
            text = "Planta";
            x = getXforCenteredText(text)-42*2;
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 0){
                g2.drawString(">", gp.tileSize, y);
            }
            
             text = "Cátedra";
            x = getXforCenteredText(text)-42*2;
            y += gp.tileSize;
            g2.drawString(text, gp.tileSize+30, y);
            if(commandNum == 1){
                g2.drawString(">", gp.tileSize, y);
            }
        }
    }
    
    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getHeight();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
    
    public void drawSubWindow(int x, int y, int width, int height){

        // Fondo semi-transparente
        Color c = new Color(0, 0, 0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        // Borde
        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new java.awt.BasicStroke(5)); // Grosor del borde
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }
    
    public int centerText(String text){
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        return textWidth;
    }
}
