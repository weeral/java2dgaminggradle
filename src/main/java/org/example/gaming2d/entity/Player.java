package org.example.gaming2d.entity;

import org.example.gaming2d.GamePanel;
import org.example.gaming2d.KeyHandler;
import org.example.gaming2d.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    //    public int hasKey = 0; // key treasure
    int standCounter = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        //player area collision
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 30;
        solidArea.height = 30;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";

        // PLAYER STATUS
        maxLife = 6;
        life = maxLife;
    }

    public void getPlayerImage() {

        up1 = setup("/player/boy_up_1");
        up2 = setup("/player/boy_up_2");
        down1 = setup("/player/boy_down_1");
        down2 = setup("/player/boy_down_2");
        left1 = setup("/player/boy_left_1");
        left2 = setup("/player/boy_left_2");
        right1 = setup("/player/boy_right_1");
        right2 = setup("/player/boy_right_2");
    }

//    public BufferedImage setup(String imageName) {
//        UtilityTool utilityTool = new UtilityTool();
//       BufferedImage image = null;
//
//       try {
//           image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName + ".png"));
//           image = utilityTool.scaleImage(image, gp.tileSize, gp.tileSize);
//       } catch (IOException e) {
//
//       }
//       return image;
//    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true ||
                keyH.leftPressed == true || keyH.rightPressed == true) { // player sprite doesnt move until moved

            if (keyH.upPressed == true) {
                direction = "up";
            } else if (keyH.downPressed == true) {
                direction = "down";
            } else if (keyH.leftPressed == true) {
                direction = "left";
            } else if (keyH.rightPressed) {
                direction = "right";

            }
            // CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // CHECK NPC COLLISION
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            // CHECK EVENT
            gp.eventHandler.checkEvent();

            gp.keyH.enterPressed = false;

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }


//        if (keyH.upPressed == true || keyH.downPressed == true ||
//                keyH.leftPressed == true || keyH.rightPressed == true) { // player sprite doesnt move until moved
//
//            if (keyH.upPressed == true) {
//                direction = "up";
//                y -= speed;
//            }
//            else if (keyH.downPressed == true) {
//                direction = "down";
//                y += speed;
//            }
//            else if (keyH.leftPressed == true) {
//                direction = "left";
//                x -= speed;
//            }
//            else if (keyH.rightPressed) {
//                direction = "right";
//                x += speed;
//            }
//            spriteCounter++;
//            if (spriteCounter > 12) {
//                if (spriteNum == 1) {
//                    spriteNum = 2;
//                }
//                else if (spriteNum == 2) {
//                    spriteNum = 1;
//                }
//                spriteCounter = 0;
//            }
//
//        }

        }

    }

    public void pickUpObject(int i) {
        if (i != 999) {

            //key treasure
//        if (i != 999) {
//            String objectName = gp.obj[i].name;
//
//            switch (objectName) {
//                case "Key":
//                    gp.playSoundEffect(1);
//                    hasKey++;
//                    gp.obj[i] = null;
//                    gp.ui.showMessage("You got the keys to the streets!");
//                    break;
//                case "Door":
//                    if (hasKey > 0) {
//                        gp.playSoundEffect(3);
//                        gp.obj[i] = null;
//                        hasKey--;
//                        gp.ui.showMessage("You open the door cuzz!");
//                    } else {
//                        gp.ui.showMessage("STUPID!!! Find the keys to the streets!");
//                    }
//                    System.out.println("Key:"+hasKey);
//                    break;
//                case "Boots":
//                    gp.playSoundEffect(2);
//                    speed += 2;
//                    gp.obj[i] = null;
//                    gp.ui.showMessage("I'M FAST AS F*&K BOYY!!!");
//                    break;
//                case "Chest":
//                    gp.ui.gameFinished = true;
//                    gp.stopMusic();
//                    gp.playSoundEffect(4);
//                    break;
//            }
//        }
        }
    }

    public void interactNPC(int i) {
        if (i != 999) {
            if (gp.keyH.enterPressed == true) {
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
        }
    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, null); //image observer

    }
}
