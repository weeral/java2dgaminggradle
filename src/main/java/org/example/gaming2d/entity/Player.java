package org.example.gaming2d.entity;

import org.example.gaming2d.GamePanel;
import org.example.gaming2d.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        //player area collision
        solidArea = new Rectangle();
        solidArea.x = 5;
        solidArea.y = 10;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 20;
        solidArea.height = 20;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {

            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_up_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_up_2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_down_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_down_2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_left_2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_right_2.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
            String objectName = gp.obj[i].name;

            switch (objectName) {
                case "Key":
                    gp.playSoundEffect(1);
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You got the keys to the streets!");
                    break;
                case "Door":
                    if (hasKey > 0) {
                        gp.playSoundEffect(3);
                        gp.obj[i] = null;
                        hasKey--;
                        gp.ui.showMessage("You open the door cuzz!");
                    } else {
                        gp.ui.showMessage("STUPID!!! Find the keys to the streets!");
                    }
                    System.out.println("Key:"+hasKey);
                    break;
                case "Boots":
                    gp.playSoundEffect(2);
                    speed += 2;
                    gp.obj[i] = null;
                    gp.ui.showMessage("I'M FAST AS F*&K BOYY!!!");
                    break;
                case "Chest":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSoundEffect(4);
                    break;
            }
        }
    }

    public void draw(Graphics2D g2){
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
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null); //image observer

    }
}
