
package game;

import Entity.NPC;

public class AssetSetter {
    GamePanel gp;
    
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void getObject(){
        
    }
    public void setNPC(){
        
        gp.npc[0] = new NPC(gp);
        gp.npc[0].worldX = gp.tileSize*21;
        gp.npc[0].worldY = gp.tileSize*21;
    }
}
