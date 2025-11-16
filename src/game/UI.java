package game;

import Entity.Entity;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
    
    GamePanel gp;
    KeyHandler keyH;
    Graphics2D g2;
    Font arial_40;
    BufferedImage menuImage;
    
    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        
    }
    
    public void draw(Graphics2D g2){
        this.g2 = g2;
          //TITLE STATE
        
        if(gp.gameState == gp.titleState){
        drawTitleScreen();
        //g2.setFont(arial_40);
        //g2.setColor(Color.white);
      
        
    }
       
}
        public void drawTitleScreen() {
        
       // g2.setColor(new Color(70, 120, 180));
        //g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        
        
        //TITLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Uis Adventure";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight;
        
        //g2.drawImage(pausa, 0, 0, gp.tileSize*16, gp.tileSize*12, null);
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        
        //MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        
        text = "NUEVO JUEGO";
        x = getXforCenteredText(text);
        y += gp.tileSize*4;
        g2.drawString(text, x, y);
        
        text = "CARGAR JUEGO";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        
        text = "SALIR";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
    }
    
    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getHeight();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
    
}