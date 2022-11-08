import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Player {
  final char player = 'X';
  private int lives = 1;
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

  public int getX() {
    return x;
  }
  public void setPrevX(int x) { this.prevX = x; }
  public int getPrevX() {
    return prevX;
  }
  public void setX(int x) { this.x = x; }

  public int getY() {
    return y;
  }
  public void setPrevY(int y) { this.prevY = y; }
  public int getPrevY() {
    return prevY;
  }
  public void setY(int y) { this.y = y; }

  public Character movePlayer(Terminal t) throws InterruptedException, IOException {
    KeyStroke keyStroke = null;

    t.setCursorPosition(getX(), getY());
    t.putCharacter(player);
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
      case ArrowUp:
        setY(getY() - 2);
        setX(getX());
      case ArrowDown:
        setY(getY() + 1);
        setX(getX() + 1);
      case ArrowLeft:
        setX(getX() - 2);
      case ArrowRight:
        setX(getX() + 1);
    }
    t.setCursorPosition(getPrevX(), getPrevY());
    t.putCharacter(' ');
    t.flush();

    return c;
  }

}