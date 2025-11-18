
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
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }

    public void checkEvent () {
        // El daño debe ocurrir SÓLO si el evento no ha sido tocado recientemente
        if (canTouchEvent) {
             // Evento en columna 13, fila 9
            if(hit(13,9,"any") == true){ // Cambié a "any" para que se active sin importar la dirección
                damagePit();
                canTouchEvent = false; // Bloquea el evento temporalmente
            }
        }
        
        // Si el jugador se aleja del evento, lo desbloqueamos
        // Es un ejemplo simple, puedes hacer que se desbloquee con un timer.
        if(hit(13,9,"any") == false){
            canTouchEvent = true;
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
    
    public void damagePit(){
        if (gp.player.invincible == false) {
            
            // 1. Reducir la vida
            gp.player.life -= 1; 
            
            // 2. Establecer invulnerabilidad
            gp.player.invincible = true;
            gp.player.invincibleCounter = 0; // Asume que tienes un contador en la clase Player/Entity
            
            // 3. (Opcional) Notificar o hacer algún sonido
            System.out.println("¡Daño recibido! Vida actual: " + gp.player.life);
        }

    }
}
