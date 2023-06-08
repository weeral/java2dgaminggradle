package org.example.gaming2d;

import org.example.gaming2d.object.OBJ_Heart;
import org.example.gaming2d.object.OBJ_Key;
import org.example.gaming2d.object.SuperObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font pixelCraft, aDrip;
//    Font consolas_40, consolas_80B;
//    BufferedImage keyImage; // key treasure

    BufferedImage heart_full, heart_half, heart_blank;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";
    public int commandNum = 0;
    public int titleScreenState = 0; // 0: the first screen, 1: the second screen
//    double playTime; //key treasure
//    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    public UI(GamePanel gp) {
        this.gp = gp;

        try {
            InputStream inputStream = getClass().getResourceAsStream("/font/PixelCraft-2Odxo.otf");
            pixelCraft = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            inputStream = getClass().getResourceAsStream("/font/adrip1.ttf");
            aDrip = Font.createFont(Font.TRUETYPE_FONT, inputStream);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // CREATE HUD OBJECT
        SuperObject heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;

//        consolas_40 = new Font ("Consolas", Font.PLAIN, 30);
//        consolas_80B = new Font ("Consolas", Font.BOLD, 75);
//        OBJ_Key key = new OBJ_Key(gp); // key treasure
//        keyImage = key.image; // key treasure
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(pixelCraft);
//        g2.setFont(aDrip);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.white);

        // TITLE STATE
        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }

        // PLAY STATE
        if (gp.gameState == gp.playState) {
            drawPlayerLife();
        } // PAUSE STATE
        if (gp.gameState == gp.pauseState) {
            drawPlayerLife();
            drawPauseScreen();
        } // DIALOGUE STATE
        if (gp.gameState == gp.dialogueState) {
            drawPlayerLife();
            drawDialogueScreen();
        }
    }

    public void drawPlayerLife() {

        //Display player life test
        gp.player.life = 4;

        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;

        //DRAW MAX LIFE
        while (i < gp.player.maxLife/2) {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }

        // RESET
        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i = 0;

        // DRAW CURRENT LIFE
        while (i < gp.player.life) {
            g2.drawImage(heart_half, x, y, null);
            i++;
            if (i < gp.player.life) {
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }


    }

    public void drawTitleScreen() {
        if (titleScreenState == 0) {
            g2.setColor(new Color(102, 179, 250));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            // TITLE NAME
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 62F));
            String text = "Blue Boy Adventure";
            int x = getXforCenteredText(text);
            int y = gp.tileSize * 3;

            // SHADOW
            g2.setColor(Color.black);
            g2.drawString(text, x + 7, y + 7);
            // MAIN COLOR
            g2.setColor(Color.blue);
            g2.drawString(text, x, y);

            // BLUE BOY IMAGE
            x = gp.screenWidth/2 - (gp.tileSize * 2)/2;
            y += gp.tileSize * 2;
            g2.drawImage(gp.player.down1,  x, y, gp.tileSize * 2, gp.tileSize * 2, null);

            //MENU
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 42F));

            text = "NEW GAME";
            x = getXforCenteredText(text);
            y += gp.tileSize * 3.5;
            g2.setColor(Color.black);
            g2.drawString(text, x + 6, y + 6);
            g2.setColor(Color.blue);
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "LOAD GAME";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.setColor(Color.black);
            g2.drawString(text, x + 6, y + 6);
            g2.setColor(Color.blue);
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "QUIT";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.setColor(Color.black);
            g2.drawString(text, x + 6, y + 6);
            g2.setColor(Color.blue);
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString(">", x - gp.tileSize, y);
            }
        }
        else if (titleScreenState == 1) {
            g2.setColor(new Color(102, 179, 250));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            // CLASS SELECTION SCREEN

//            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,42F));


            String text = "Select your class!";
            int x = getXforCenteredText(text);
            int y = gp.tileSize * 3;
            g2.setColor(Color.black);
            g2.drawString(text, x + 6, y + 6);
            g2.setColor(Color.blue);
            g2.drawString(text, x, y);

            text = "Fighter";
            x = getXforCenteredText(text);
            y += gp.tileSize * 3;
            g2.setColor(Color.black);
            g2.drawString(text, x + 6, y + 6);
            g2.setColor(Color.blue);
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "Thief";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.setColor(Color.black);
            g2.drawString(text, x + 6, y + 6);
            g2.setColor(Color.blue);
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "Sorcerer";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.setColor(Color.black);
            g2.drawString(text, x + 6, y + 6);
            g2.setColor(Color.blue);
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "Back";
            x = getXforCenteredText(text);
            y += gp.tileSize * 2;
            g2.setColor(Color.black);
            g2.drawString(text, x + 6, y + 6);
            g2.setColor(Color.blue);
            g2.drawString(text, x, y);
            if (commandNum == 3) {
                g2.drawString(">", x - gp.tileSize, y);
            }
        }
    }

    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 125F));
        String text = "PAUSED";

        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }

    public  void drawDialogueScreen() {

        // WINDOW
        int x = gp.tileSize * 2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;

        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
        x += gp.tileSize;
        y += gp.tileSize;

        for(String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }

    }

    public void drawSubWindow(int x, int y, int width, int height) {
        Color c = new Color(0, 0, 0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);

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

