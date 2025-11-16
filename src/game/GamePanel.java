
package game;

import Entity.Player;
import Tile.TileManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    
    // Screen Settings
    final int originalTileSize = 16; // 16 x 16 Tile
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; //48 x 48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    
    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    
    
    
    // FPS
    int FPS = 60;
    
    TileManager tileM;
    KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public Player player;
    
    //GAME STATE
    public int gameState;
    public final int titleState = 0;
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
         
        tileM = new TileManager(this);
        player = new Player(this,keyH);
    }
    
    public void setupGame(){
        gameState = titleState;
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
        //gameState = 1;
    }
    
    @Override
/*  public void run(){
       
        while(gameThread != null){
                        
            double drawInterval = 1000000000/FPS; // 0,016666 seconds
            double nextDrawTime = System.nanoTime() + drawInterval;
            
            while(gameThread != null){

                // 1 Update: Character position
                update();
                // 2 Update: Draw the Screen with the updated information
                repaint();
                
                
                try {
                    double remainingTime = nextDrawTime - System.nanoTime();
                    remainingTime = remainingTime/1000000;
                    
                    if(remainingTime < 0){
                        remainingTime = 0;
                    }
                    
                    Thread.sleep((long) remainingTime);
                    
                    nextDrawTime += drawInterval;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }*/
    
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            
            if(timer >= 1000000000){
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }

    }
    
    public void update(){
        
        if(gameState == 1){
            player.update();
        }
        if(gameState == 2){
            
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 =(Graphics2D)g;
        
        //TITLE SCREEN
        if(gameState == titleState){
           player.draw(g2);
        }
        //OTHERS
        else{
                    //TILE
        tileM.draw(g2);
        
        player.draw(g2);
        
        g2.dispose();
            
           
        }
        
    }
}
