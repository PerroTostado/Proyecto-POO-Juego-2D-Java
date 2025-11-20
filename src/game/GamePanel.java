
package game;

import Entity.Entity;
import Entity.Player;
import Objects.SuperObject;
import Tile.TileManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileWriter;
import javax.swing.JPanel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
    Thread gameThread;
    KeyHandler keyH;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player;
    public SuperObject obj[] = new SuperObject[10];
    public Entity monster[] = new Entity[20];
    public Entity npc[] = new Entity[10];
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
   
    //GAME STATE
    public int i = 0;
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int gameOverState = 4;
    public final int infoState = 5;
    public final int inventaryState = 6;
    
    public GamePanel() {

        keyH = new KeyHandler(this);

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
         
        tileM = new TileManager(this);

        //AQUÍ SE CARGA LA PARTIDA
        player = loadPlayerPosition();
    }
    
    public void setupGame(){
        aSetter.setNPC();
        gameState = playState;
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start(); 
    }
    
  /*public void run(){
       
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

        if(gameState == playState){ // Usamos 'playState' en lugar de 1
            player.update();
            //NPC
            for(int i = 0; i < npc.length; i++){
                if(npc[i] != null){
                    npc[i].update();
                }
            }
        }
        if(gameState == pauseState){ // Usamos 'pauseState' en lugar de 2
            // No hacer nada en pause
        }
        if(gameState == dialogueState){ // <-- Nuevo caso para dialogueState
            // No hacer nada en dialogueState
        }
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 =(Graphics2D)g;

        //TITLE SCREEN
        if(gameState == titleState){
           player.draw(g2);
           ui.draw(g2); // Llama a UI.draw en titleState para dibujar la pantalla de título
        }
        else{
            //TILE
            tileM.draw(g2);

            // OBJECTS (No se usa por ahora, pero se deja el espacio)
            // for(int i = 0; i < obj.length; i++){
            //    if(obj[i] != null){
            //        obj[i].draw(g2, this);
            //    }
            // }
            //NPC
            for(int i = 0; i< npc.length; i++){
                if(npc[i] != null){
                    npc[i].draw(g2);
                }
            }
            // PLAYER
            player.draw(g2);

            // UI drawing:
            ui.draw(g2); // <--- Llama a UI.draw en play/pause/dialogue states

            g2.dispose(); 
        }
    }
    
    


    public void savePlayerPosition(Player player) {
        try {
            File file = new File("player_position.txt");

            // Si el archivo no existe, lo crea
            if (!file.exists()) {
                file.createNewFile();
            }

            // Escribir posición
            FileWriter writer = new FileWriter(file);
            writer.write(player.worldX + "," + player.worldY);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playerNewPosition(Player player) {
        try {
            File file = new File("player_position.txt");

            // Si el archivo no existe, lo crea
            if (!file.exists()) {
                file.createNewFile();
            }

            // Escribir posición
            FileWriter writer = new FileWriter(file);
            writer.write(player.worldStartX + "," + player.worldStartY);
            writer.close(); 
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Player loadPlayerPosition() {

        try (BufferedReader reader = new BufferedReader(new FileReader("player_position.txt"))) {
            String line = reader.readLine(); 

            if (line != null) {
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);

                return new Player(this, keyH, x, y);
            }
        } 
        catch (IOException e) {
        }
        return new Player(this, keyH, screenWidth/2 - tileSize/2, screenHeight/2 - tileSize/2);
    }
    
    public void savePlayerInfo(Player player) {
        try {
            File file = new File("player_info.txt");

            // Si el archivo no existe, lo crea
            if (!file.exists()) {
                file.createNewFile();
            }

            // Escribir atributos
            FileWriter writer = new FileWriter(file);
            writer.write(player.tempGenero + "," + player.tempEstratoSocial + "," + player.tempComunidadUIS + "," + player.tempRol);
            writer.close(); 
        } 
        catch (IOException e) {
        }
    }
    
    public Player loadPlayerInfo() {

        try (BufferedReader reader = new BufferedReader(new FileReader("player_Info.txt"))) {
            String line = reader.readLine(); 

            if (line != null) {
                String[] parts = line.split(",");
                player.tempGenero = parts[0];
                player.tempEstratoSocial = Integer.parseInt(parts[1]);
                player.tempRol = parts[3];
            }
        } 
        catch (IOException e) {
        }
        return new Player(this, keyH, screenWidth/2 - tileSize/2, screenHeight/2 - tileSize/2);
    }   
}
