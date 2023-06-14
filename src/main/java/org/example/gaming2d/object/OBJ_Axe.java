package org.example.gaming2d.object;

import org.example.gaming2d.GamePanel;
import org.example.gaming2d.entity.Entity;

public class OBJ_Axe extends Entity {
    public OBJ_Axe(GamePanel gp) {
        super(gp);

        type = type_axe;
        name = "Woodcutter's Axe";
        down1 = setup("/objects/axe", gp.tileSize, gp.tileSize);
        attackValue = 2;
        attackArea.width = 30;
        attackArea.height = 30;
        description = "[" + name + "] \nAn old ass rusty ace, for \ntree chopping.";
    }
}
