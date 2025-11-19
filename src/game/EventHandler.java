
package game;

import java.awt.Rectangle;

public class EventHandler {
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;
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
 
        // Lógica para resetear la bandera de evento
        if(canTouchEvent == false){
            if(hit(23, 23, "any") == false){
                canTouchEvent = true; // El jugador ha salido de la casilla, puede volver a tocar el evento
            }
        }
        
        // Ejecución del evento solo si puede ser tocado
        if(canTouchEvent == true) {
            if(hit(23,23,"any") == true){
                damagePit(gp.dialogueState);
                canTouchEvent = false; // Bloquea el evento después de activarlo
            }
        }
        
        if(hit(24, 24, "any") == true){ 
            healingPool(gp.dialogueState);
        }

    }
    public boolean hit(int eventCol, int eventRow, String reqDirection) {

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
        // Verifica si la tecla ENTER fue presionada Y la vida no está al máximo.
        if (gp.keyH.enterPress == true) { 
            
            if (gp.player.life < gp.player.maxLife) {
                
                // 1. Establece el estado de DIÁLOGO
                gp.gameState=gameState; 
                
                // 2. Establece el texto del diálogo
                gp.ui.currentDialogue = "Bebes el agua. \nTu vida ha sido recuperada.";

                // 3. Aplica la curación
                gp.player.life = gp.player.maxLife; // Curación completa según el video
                
            } else {
                
                // 1. Establece el estado de DIÁLOGO
                gp.gameState=gameState; 

                // 2. Mensaje si la vida ya está completa
                gp.ui.currentDialogue = "Tu vida ya está al máximo. No necesitas curarte.";
            }
        }
    }
}
