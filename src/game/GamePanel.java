
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    
    // Screen Settings
    final int originalTileSize = 16; // 16 x 16 Tile
    final int scale = 3;
    
    final int tileSize = originalTileSize * scale; //48 x 48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenRow; // 768 pixels
    final int screenHeight = tileSize * maxScreenCol; // 576 pixels
    
    // FPS
    int FPS = 60;
    
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    
    // Deafault positions from player
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    
    public GamePanel(){
         this.setPreferredSize(new Dimension(screenHeight, screenWidth));
         this.setBackground(Color.black);
         this.setDoubleBuffered(true);
         this.addKeyListener(keyH);
         this.setFocusable(true);
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run(){
        while(gameThread != null){
            
//          System.out.println("El juego se esta ejecutando...");
            
            double drawInterval = 1000000000/FPS; // 0,016666 seconds
            double nextDrawTime = System.nanoTime() + drawInterval;
            
            while(gameThread != null){

                // 1 Update: Character position
                update();
                // 2 Update: Draw the Screen with the updated information
                repaint();
                
                double remainiingTime = nextDrawTime - System.nanoTime();
            }
            
        }
    }
    
    public void update(){
        if(keyH.upPress == true){
            playerY -= playerSpeed;
        }
        else if(keyH.downPress == true){
            playerY += playerSpeed;
        }
        else if(keyH.leftPress == true){
            playerX -= playerSpeed;
        }
        else if(keyH.leftPress == true){
            playerX += playerSpeed;
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 =(Graphics2D)g;
        
        g2.setColor(Color.white);
        
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        
        g2.dispose();
    }
}
