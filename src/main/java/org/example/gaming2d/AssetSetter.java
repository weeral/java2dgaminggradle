package org.example.gaming2d;

import org.example.gaming2d.entity.NPC_OldMan;
import org.example.gaming2d.monster.MON_GreenSlime;
import org.example.gaming2d.object.OBJ_Boots;
import org.example.gaming2d.object.OBJ_Chest;
import org.example.gaming2d.object.OBJ_Door;
import org.example.gaming2d.object.OBJ_Key;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

//        gp.obj[0] = new OBJ_Door(gp);
//        gp.obj[0].worldX = gp.tileSize * 21;
//        gp.obj[0].worldY = gp.tileSize * 21;
//
//        gp.obj[1] = new OBJ_Door(gp);
//        gp.obj[1].worldX = gp.tileSize * 23;
//        gp.obj[1].worldY = gp.tileSize * 25;

        //key treasure
//        gp.obj[0] = new OBJ_Key(gp);
//        gp.obj[0].worldX = 23 * gp.tileSize;
//        gp.obj[0].worldY = 7 * gp.tileSize;
//
//        gp.obj[1] = new OBJ_Key(gp);
//        gp.obj[1].worldX = 23 * gp.tileSize;
//        gp.obj[1].worldY = 40 * gp.tileSize;
//
//        gp.obj[2] = new OBJ_Key(gp);
//        gp.obj[2].worldX = 38 * gp.tileSize;
//        gp.obj[2].worldY = 8 * gp.tileSize;
//
//        gp.obj[3] = new OBJ_Door(gp);
//        gp.obj[3].worldX = 10 * gp.tileSize;
//        gp.obj[3].worldY = 11 * gp.tileSize;
//
//        gp.obj[4] = new OBJ_Door(gp);
//        gp.obj[4].worldX = 8 * gp.tileSize;
//        gp.obj[4].worldY = 28 * gp.tileSize;
//
//        gp.obj[5] = new OBJ_Door(gp);
//        gp.obj[5].worldX = 12 * gp.tileSize;
//        gp.obj[5].worldY = 22 * gp.tileSize;
//
//        gp.obj[6] = new OBJ_Chest(gp);
//        gp.obj[6].worldX = 10 * gp.tileSize;
//        gp.obj[6].worldY = 7 * gp.tileSize;
//
//        gp.obj[7] = new OBJ_Boots(gp);
//        gp.obj[7].worldX = 37 * gp.tileSize;
//        gp.obj[7].worldY = 42 * gp.tileSize;
    }
    public void setNPC() {

        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize * 21;
        gp.npc[0].worldY = gp.tileSize * 21;

//        gp.npc[0] = new NPC_OldMan(gp);
//        gp.npc[0].worldX = gp.tileSize * 9;
//        gp.npc[0].worldY = gp.tileSize * 10;
//
//        gp.npc[1] = new NPC_OldMan(gp);
//        gp.npc[1].worldX = gp.tileSize * 11;
//        gp.npc[1].worldY = gp.tileSize * 21;
//
//        gp.npc[2] = new NPC_OldMan(gp);
//        gp.npc[2].worldX = gp.tileSize * 31;
//        gp.npc[2].worldY = gp.tileSize * 21;
//
//        gp.npc[3] = new NPC_OldMan(gp);
//        gp.npc[3].worldX = gp.tileSize * 21;
//        gp.npc[3].worldY = gp.tileSize * 11;
//
//        gp.npc[4] = new NPC_OldMan(gp);
//        gp.npc[4].worldX = gp.tileSize * 21;
//        gp.npc[4].worldY = gp.tileSize * 31;
    }

    public void setMonster() {
//        gp.monster[0] = new MON_GreenSlime(gp);
//        gp.monster[0].worldX = gp.tileSize * 11;
//        gp.monster[0].worldY = gp.tileSize * 10;
//
//        gp.monster[1] = new MON_GreenSlime(gp);
//        gp.monster[1].worldX = gp.tileSize * 11;
//        gp.monster[1].worldY = gp.tileSize * 11;

        gp.monster[0] = new MON_GreenSlime(gp);
        gp.monster[0].worldX = gp.tileSize * 23;
        gp.monster[0].worldY = gp.tileSize * 36;

        gp.monster[1] = new MON_GreenSlime(gp);
        gp.monster[1].worldX = gp.tileSize * 23;
        gp.monster[1].worldY = gp.tileSize * 37;
    }
}
