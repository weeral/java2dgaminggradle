package org.example.gaming2d;

import org.example.gaming2d.object.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font consolas_40, consolas_80B;
//    BufferedImage keyImage; // key treasure
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    double playTime;
    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    public UI(GamePanel gp) {
        this.gp = gp;

        consolas_40 = new Font ("Consolas", Font.PLAIN, 30);
        consolas_80B = new Font ("Consolas", Font.BOLD, 75);
//        OBJ_Key key = new OBJ_Key(gp); // key treasure
//        keyImage = key.image; // key treasure
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(consolas_40);
        g2.setColor(Color.white);

        if (gp.gameState == gp.playState) {
            //DO playstate stuff later
        }
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
    }
    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 125F));
        String text = "PAUSED";

        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }
    public int getXforCenteredText (String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}

        //KEY TREASURE
//        if (gameFinished == true) {
//            g2.setFont(consolas_40);
//            g2.setColor(Color.white);
//
//            String text;
//            int textLength;
//            int x;
//            int y;
//
//            text = "You found a NEW PLUG!!!";
//            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//            x = gp.screenWidth/2 - textLength/2;
//            y = gp.screenHeight/2 - (gp.tileSize * 3);
//            g2.drawString(text, x, y);
//
//            text = "Your Time is :" + decimalFormat.format(playTime) + " seconds !";
//            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//            x = gp.screenWidth/2 - textLength/2;
//            y = gp.screenHeight/2 + (gp.tileSize * 4);
//            g2.drawString(text, x, y);
//
//            g2.setFont(consolas_80B);
//            g2.setColor(Color.yellow);
//            text = "CONGRATS CUZZ!";
//            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//            x = gp.screenWidth/2 - textLength/2;
//            y = gp.screenHeight/2 + (gp.tileSize * 2);
//            g2.drawString(text, x, y);
//
//            gp.gameThread = null;
//
//        } else {
//            g2.setFont(consolas_40);
//            g2.setColor(Color.white);
//            g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
//            g2.drawString("x " + gp.player.hasKey, 74, 65);
//
//            // TIME
//            playTime += (double) 1/60;
//            g2.drawString("Time:"+decimalFormat.format(playTime), gp.tileSize * 12, 65);
//
//            // MESSAGE
//            if (messageOn == true) {
//                g2.setFont(g2.getFont().deriveFont(30F));
//                g2.drawString(message, gp.tileSize/2, gp.tileSize * 5);
//
//                messageCounter++;
//
//                if (messageCounter > 120) {
//                    messageCounter = 0;
//                    messageOn = false;
//                }
//            }
//        }

