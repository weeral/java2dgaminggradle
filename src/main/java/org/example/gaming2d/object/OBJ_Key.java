package org.example.gaming2d.object;

import org.example.gaming2d.GamePanel;
import org.example.gaming2d.entity.Entity;



public class OBJ_Key extends Entity {

    public OBJ_Key(GamePanel gp) {
        super(gp);

        name = "Key";
        down1 = setup("/objects/key", gp.tileSize, gp.tileSize);
    }
}
