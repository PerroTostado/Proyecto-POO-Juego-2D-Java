
package game;

import java.awt.Rectangle;

public class EventHandler {
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY, previousEventX, previousEventY;
    boolean canTouchEvent = true;
    
    public EventHandler(GamePanel gp){
        this.gp = gp;
        
        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 10;
        eventRect.height = 10;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }

    public void checkEvent () {
 
        // Check if the player character is more than 1 tile away from the last event
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);

        if (distance > gp.tileSize) {
            canTouchEvent = true;
        }

        if (canTouchEvent == true) {
            if (hit(0, 23, 23, "right") == true) {damagePit(gp.dialogueState);}
            else if (hit(0, 24, 24, "up") == true) {healingPool(gp.dialogueState);}
            else if (hit(0, 7, 23, "any") == true) {teleport(1, 7, 23);}
            else if (hit(1, 7, 23, "any") == true) {teleport(0, 7, 23);}
        }

    }
    public boolean hit(int map, int eventCol, int eventRow, String reqDirection) {

        boolean hit = false;
        
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect.x = eventCol * gp.tileSize + eventRect.x;
        eventRect.y = eventRow * gp.tileSize + eventRect.y;
        
        if(gp.player.solidArea.intersects(eventRect)){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;
            }
        }
        
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return hit;
    }
    
    public void damagePit(int gameState){
        gp.gameState=gameState;
        gp.ui.currentDialogue = "Haz caido en una trampa";
        gp.player.life -= 1;
    }
    
    public void healingPool(int gameState){
    // Verifica si la tecla ENTER fue presionada
        if (gp.keyH.enterPress == true) { 

            // Resetear la bandera inmediatamente para evitar la activación instantánea
            gp.keyH.enterPress = false; 
            
            // Si la vida no está al máximo, curar
            if (gp.player.life < gp.player.maxLife) {

                // 1. Establece el estado de DIÁLOGO
                gp.gameState=gameState; 

                // 2. Establece el texto del diálogo
                gp.ui.currentDialogue = "Bebes el agua. \nTu vida ha sido recuperada.";

                // 3. Aplica la curación
                gp.player.life = gp.player.maxLife;
                
                gp.keyH.enterPress = true; 
            }

        }
    }
    
    public void teleport(int map, int col, int row) {

        gp.currentMap = map;
        gp.player.worldX = gp.tileSize * col;
        gp.player.worldY = gp.tileSize * row;

    }   
}