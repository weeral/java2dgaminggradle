package org.example.gaming2d.object;

import org.example.gaming2d.GamePanel;
import org.example.gaming2d.entity.Entity;


public class OBJ_Boots extends Entity {

    public OBJ_Boots(GamePanel gp) {
        super(gp);

        name = "Boots";
        down1 = setup("/objects/boots");
    }
}
