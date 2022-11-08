import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException, InterruptedException {

    DefaultTerminalFactory d = new DefaultTerminalFactory();
    Terminal t = d.createTerminal();
    TerminalPosition currentPosition;

    TerminalSize terminalSize = t.getTerminalSize();
    int terminalRows = terminalSize.getRows();
    int terminalCols = terminalSize.getColumns();

    Player player = new Player(1, 10, 10);

    t.setCursorVisible(false);

    boolean continueReadingInput = true;

    while (continueReadingInput) {

      Character c = player.movePlayer(t);

      if (c == Character.valueOf('q')) {
        continueReadingInput = false;
        t.clearScreen();
        String farewell = "Thanks for playing!";
        t.setCursorPosition((terminalCols / 2) - (farewell.length() / 2), terminalRows / 2);

        t.putString(farewell);
        t.flush();
        Thread.sleep(1000);
      }
    }
    t.close();

  }
}