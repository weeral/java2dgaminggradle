package org.example.gaming2d.object;

import org.example.gaming2d.GamePanel;
import org.example.gaming2d.entity.Entity;


public class OBJ_Chest extends Entity {

    public OBJ_Chest(GamePanel gp) {
        super(gp);

        name = "Chest";
        down1 = setup("/objects/chest", gp.tileSize, gp.tileSize);
    }
}
