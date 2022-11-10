package lanternagame;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Player {
    private final String marker = "\uD83D\uDE03";
    private final String markerLostLife = "😵";
    private final String markerDead = "💀";
    private int lives;
    private int x;
    private int y;
    private int prevX;
    private int prevY;

    public Player(int lives, int x, int y) {
        this.lives = lives;
        this.x = x;
        this.y = y;
        this.prevX = x;
        this.prevY = y;
    }

    public String getMarker() {
        return marker;
    }

    public int getLives() {
        return lives;
    }

    public int getX() {
        return x;
    }

    public void setPrevX(int x) {
        this.prevX = x;
    }

    public int getY() {
        return y;
    }

    public void setPrevY(int y) {
        this.prevY = y;
    }

    public String getMarkerLostLife() {
        return markerLostLife;
    }

    public String getMarkerDead() {
        return markerDead;
    }

    public void movePlayer(Terminal t) throws InterruptedException, IOException {
        KeyStroke keyStroke;

    t.setCursorPosition(getX(), getY());
    t.putString(marker);
    t.flush();
    setPrevX(getX());
    setPrevY(getY());

    do {
      Thread.sleep(5);
      keyStroke = t.pollInput();
    } while (keyStroke == null);

    KeyType type = keyStroke.getKeyType();
    Character c = keyStroke.getCharacter();

        switch (type) {
            case ArrowUp -> y = (y <= 0) ? 0 : y - 1;
            case ArrowDown -> y = (y >= 23) ? 23 : y + 1;
            case ArrowLeft -> x = (x <= 0) ? 0 : x - 1;
            case ArrowRight -> x = (x >= 78) ? 78 : x + 1;
        }
        t.setCursorPosition(prevX, prevY);
        t.putCharacter(' ');
        t.flush();
    }

    public boolean isAlive() {
        return lives > 0;
    }

    public void loseLife() {
        lives--;
    }
}