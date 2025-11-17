
package Objects;

import game.GamePanel;
import javax.imageio.ImageIO;

public class OBJ_Heart extends SuperObject{
    GamePanel gp;
    
    public OBJ_Heart(GamePanel gp){
        
        this.gp = gp;
        
        name = "Heart";
        /*try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/Objects/heart_full.png"));
            
        }catch(){
            
        }*/
    }
}
