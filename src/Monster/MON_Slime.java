package Monster;

import Entity.Entity;
import game.GamePanel;
import java.awt.Rectangle;
;

public class MON_Slime extends Entity {
    public MON_Slime(GamePanel gp){
        super(gp);
        
        name = "Slime";
        speed = 1;
        maxLife =4;
        life = maxLife;
        solidArea = new Rectangle();
        solidArea.x= 3;
        solidArea.y = 18;
        solidArea.height =30;
        solidArea.width=42;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
