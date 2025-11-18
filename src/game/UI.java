package game;

import Entity.Entity;
import Objects.OBJ_Heart;
import Objects.SuperObject;
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
    BufferedImage heart_full, heart_half, heart_blank;
    Font arial_40;
    BufferedImage menuImage;
    
    // DIALOGUE
    public String currentDialogue = "";
    
    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        
        // CREATE HUD OBJECT
        SuperObject heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;
        
    }
    
    public void draw(Graphics2D g2){
        this.g2 = g2;


        //TITLE STATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        } 
        // PLAY STATE (También incluye PAUSE y DIALOGUE)
        else {

            // UI drawing: drawPlayerLife should be here too 
            drawPlayerLife(); 

            // PAUSE STATE
            if(gp.gameState == gp.pauseState){
                drawPauseScreen(); // Asumiendo que existe un método para la pantalla de pausa
            }

            // DIALOGUE STATE
            if(gp.gameState == gp.dialogueState){
                drawDialogueScreen(); // <-- Llamada al nuevo método de diálogo
            }
        }
    }
    
    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        String text = "PAUSA";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }
        
    public void drawPlayerLife(){
        
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;
        
        //DRAW MAX LIFE
        while(i < gp.player.maxLife/2){
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;    
        }
        
        //RESET VALUES
        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i = 0;
        
        //DRAW CURRENT LIFE
        while(i < gp.player.life){
            g2.drawImage(heart_half, x, y, null);
            i++;
            if(i < gp.player.life){
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
    }
    
    public void drawDialogueScreen(){

        // VENTANA
        int x = gp.tileSize*2;
        int y = gp.screenHeight - gp.tileSize*4;
        int width = gp.screenWidth - gp.tileSize*4;
        int height = gp.tileSize*3;

        drawSubWindow(x, y, width, height);

        // TEXTO
        g2.setFont(arial_40.deriveFont(Font.PLAIN, 28F));
        x += gp.tileSize; // Ajuste para que el texto no toque el borde de la ventana
        y += gp.tileSize;

        // Aquí se dibuja el texto del diálogo
        // Dividimos el texto para que quepa en la ventana
        for(String line : currentDialogue.split("\n")){
            g2.drawString(line, x, y);
            y += 40; // Espaciado entre líneas
        }

    }

    // Método auxiliar para dibujar la sub-ventana (caja de diálogo)
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