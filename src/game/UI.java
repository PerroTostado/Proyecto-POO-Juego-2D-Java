package game;

import Entity.*;
import Objects.OBJ_Heart;
import Objects.SuperObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import Utileria.Archivos;
public class UI {
    
    Player player;
    GamePanel gp;
    KeyHandler keyH;
    Graphics2D g2;
    BufferedImage heart_full, heart_half, heart_blank;
    Font arial_40;
    BufferedImage pausa;
    public int commandNum = 0;
    public int commandNumPause = 0;
    public int titleScreenState = 0;
    public String tempName = "Jugador UIS";
    public int tempEdad = 16;
    public String tempGenero;
    public boolean tempComunidadUIS;
    public int tempEstratoSocial;
    public String tempRol;
    
    // DIALOGUE
    public String currentDialogue = "";
    
    public UI(GamePanel gp,KeyHandler keyH,Player player){
        this.gp = gp;
        this.keyH = keyH;
        this.player = player;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        
        // CREATE HUD OBJECT
        SuperObject heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;
        
    }
    
    public void draw(Graphics2D g2) throws IOException{
        
        this.g2 = g2;
        
        
        // TITLE STATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }  
        // PLAY STATE
        if(gp.gameState == gp.playState){
            drawPlayerScreen(g2);
            drawPlayerLife();
        }
        // PAUSE STATE
        if(gp.gameState == gp.pauseState){
            drawPlayerScreen(g2);
            drawPlayerLife();
             drawPauseScreen();
        }
        // DIALOGUE STATE
        if(gp.gameState == gp.dialogueState){
            drawDialogueScreen();
            drawPlayerScreen(g2);
            drawPlayerLife(); 
        }
        // GAMEOVER STATE
        // INFO STATE
        if(gp.gameState == gp.infoState){
            drawInfoScreen();
            drawPlayerScreen(g2);
            drawPlayerLife(); 
        }
        // INVENTARY STATE
        
    }
    
    public void drawTitleScreen() throws IOException{
        
        if(titleScreenState == 0){
            
            g2.setColor(new Color(70, 120, 180));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            
            // IMAGE PAUSE
            pausa = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/menu.png"));
        
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
            int textWidth = centerText(text);
            int x = (gp.screenWidth - textWidth) / 2;
            int y = gp.tileSize*2;
            g2.drawString(text, x, y);
            
            text = "Si";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-30, y);
            }   
            
            text = "No";
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
        else if(titleScreenState == 2){
            
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));
            
            String text = "Estrato Social";
            int textWidth = centerText(text);
            int x = (gp.screenWidth - textWidth) / 2;
            int y = gp.tileSize*2;
            g2.drawString(text, x, y);
            
            text = "1";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-30, y);
            }
            
            text = "2";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-30, y);
            }
            
            text = "3";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-30, y);
            } 
            
            text = "4";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 3){
                g2.drawString(">", x-30, y);
            } 
            
            text = "5";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 4){
                g2.drawString(">", x-30, y);
            } 
            
            text = "6";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 5){
                g2.drawString(">", x-30, y);
            } 
            
            text = "Volver";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 6){
                g2.drawString(">", x-30, y);
            }    
        }
        else if (titleScreenState == 4){
            
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));
            
            String text = "Qué rol posees?";
            int textWidth = centerText(text);
            int x = (gp.screenWidth - textWidth) / 2;
            int y = gp.tileSize*2;
            g2.drawString(text, x, y);
            
            text = "Estudiante";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-30, y);
            } 
            
            text = "Profesor";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-30, y);
            } 
            
            text = "Administrativo";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-30, y);
            } 
            
            text = "Volver";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 3){
                g2.drawString(">", x-30, y);
            } 
        }   
        else if (titleScreenState == 5){
            
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));
            
            String text = "Qué tipo de estudiante eres?";
            int textWidth = centerText(text);
            int x = (gp.screenWidth - textWidth) / 2;
            int y = gp.tileSize*2;
            g2.drawString(text, x, y);
            
            text = "Pregrado";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-30, y);
            } 
            
            text = "Posgrado";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-30, y);
            } 
            
            text = "Tecnológico";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-30, y);
            } 
            
            text = "Maestría";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 3){
                g2.drawString(">", x-30, y);
            } 
            
            text = "Especialización";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 4){
                g2.drawString(">", x-30, y);
            } 
            
            text = "Doctorado";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 5){
                g2.drawString(">", x-30, y);
            } 
        }
        else if(titleScreenState == 6){
            
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));
            
            String text = "Qué tipo de profesor eres?";
            int textWidth = centerText(text);
            int x = (gp.screenWidth - textWidth) / 2;
            int y = gp.tileSize*2;
            g2.drawString(text, x, y);
            
            text = "Planta";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-30, y);
            } 
            
            text = "Cátedra";
            textWidth = centerText(text);
            x = (gp.screenWidth - textWidth) / 2;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-30, y);
            } 
        }
    }
    
    public void drawPlayerScreen(Graphics2D g2){
        BufferedImage image = null;
        
        switch (player.direction){
            case "up":
                if (player.spriteNum == 1){
                    image = player.up1;
                }
                if (player.spriteNum == 2){
                    image = player.up2;
                }
                if (player.spriteNum == 3){
                    image = player.up3;
                }
                if (player.spriteNum == 4){
                    image = player.up4;
                }
            break;  
            case "down":
                if (player.spriteNum == 1){
                    image = player.down1;
                }
                if (player.spriteNum == 2){
                    image = player.down2;
                }
                if (player.spriteNum == 3){
                    image = player.down3;
                }
                if (player.spriteNum == 4){
                    image = player.down4;
                }
            break;       
            case "left":
                if (player.spriteNum == 1){
                    image = player.left1;
                }
                if (player.spriteNum == 2){
                    image = player.left2;
                }
                if (player.spriteNum == 3){
                    image = player.left3;
                }
                if (player.spriteNum == 4){
                    image = player.left4;
                }
            break;
            case "right":
                if (player.spriteNum == 1){
                    image = player.right1;
                }
                if (player.spriteNum == 2){
                    image = player.right2;
                }
                if (player.spriteNum == 3){
                    image = player.right3;
                }
                if (player.spriteNum == 4){
                    image = player.right4;
                }
            break;
            default:image = player.down2;
        }
        g2.drawImage(image, player.screenX, player.screenY, null);
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
        
        text = "Nombre:" + tempName;
        x = 470;
        y += 30;
        g2.drawString(text, x, y);
        
        text = "Edad:" + tempEdad;
        x = 470;
        y += 30;
        g2.drawString(text, x, y);
        
        text = "Genero:" + tempGenero;
        x = 470;
        y += 30;
        g2.drawString(text, x, y);
        
        text = "Estrato:" + Integer.toString(tempEstratoSocial);
        x = 470;
        y += 30;
        g2.drawString(text, x, y);
        
        text = "Rol:" + tempRol;
        x = 470;
        y += 30;
        g2.drawString(text, x, y);
        
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