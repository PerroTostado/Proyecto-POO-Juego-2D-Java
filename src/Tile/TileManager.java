 package Tile;

import game.GamePanel;
import game.UtilityTool;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;


public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp){

        this.gp = gp;
        tile = new Tile[1000000];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap();
        
    }
    
    public void getTileImage(){

        try{

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/pasto1.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/pasto2.png"));
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/pasto3.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/pasto4.png"));
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/carretera(central).png"));
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/carretera(centrala).png"));
            
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/carretera(centralcdab.png"));
            
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/carretera(centralcdab2).png"));
            
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/roca1.png"));
            tile[8].collision = true;

            
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC0"));
            tile[10].collision = true;
            
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC1"));
            tile[11].collision = true;
            
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC2"));
            tile[12].collision = true;
            
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC3"));
            tile[13].collision = true;
            
            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC4"));
            tile[14].collision = true;
            
            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC5"));
            tile[15].collision = true;
            
            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC6"));
            tile[16].collision = true;
            
            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC7"));
            tile[17].collision = true;
            
            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC8"));
            tile[18].collision = true;
            
            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC9"));
            tile[19].collision = true;
            
            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC10"));
            tile[20].collision = true;
            
            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC11"));
            
            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC12"));
            
            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC13"));
            
            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC14"));
            
            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC15"));
            
            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC16"));
            
            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC17"));
            
            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC18"));
            
            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC19"));
            tile[29].collision = true;
            
            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC20"));
            tile[30].collision = true;
            
            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC21"));
            
            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC23"));
            
            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC24"));
            
            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC25"));
            
            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC26"));
            
            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC29"));
            tile[36].collision = true;
            
            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC30"));
            tile[37].collision = true;
            
            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC31"));
            
            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTIC39"));
            tile[39].collision = true;
            
            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTICED"));
            
            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTICEDA"));
            
            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTICEI"));
            
            tile[43] = new Tile();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTICEIA"));
            
            tile[44] = new Tile();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTICPA"));
            
            tile[45] = new Tile();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTICPD"));
            
            tile[46] = new Tile();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/CENTICPI"));
            
            tile[47] = new Tile();
            tile[47].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/carretera(centralcdar)"));
            
            tile[48] = new Tile();
            tile[48].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/carretera(centralcdar2)"));
            
            tile[49] = new Tile();
            tile[49].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/carretera(centralciab)"));
            
            tile[50] = new Tile();
            tile[50].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/carretera(centralciab2)"));
            
            tile[51] = new Tile();
            tile[51].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/carretera(centralciar)"));
            
            tile[52] = new Tile();
            tile[52].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/carretera(centralciar2)"));
            
            tile[53] = new Tile();
            tile[53].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/carretera(centraltab)"));
            
            tile[54] = new Tile();
            tile[54].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/carretera(centraltar)"));
            
            tile[55] = new Tile();
            tile[55].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/carretera(centraltd"));
            
            tile[56] = new Tile();
            tile[56].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/carretera(centralti"));
            
            tile[57] = new Tile();
            tile[57].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/carretera(centraltt"));
            
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void setup(int index, String imagePath, boolean collision){
        UtilityTool uTool = new UtilityTool();
        
        try{
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("res/tiles/" + imagePath + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(){
        
        try{
            InputStream is = getClass().getResourceAsStream("/res/Maps/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;
            
            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                
                String line = br.readLine();
                
                while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                    
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
            
        }catch(Exception e){
            
        }
    }
    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0; 
        
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNum = mapTileNum[worldCol][worldRow];
            
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }
            worldCol++;

            if (worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }

        }

    }

} 
