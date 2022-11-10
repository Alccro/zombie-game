public class Zombie {
  private final String symbol = "🧟‍";
  private int x;
  private int y;

  public Zombie(SpawnField spawnField) {
    this.x = spawnField.getX();
    this.y = spawnField.getY();
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public String getSymbol() {
    return symbol;
  }

  //calculates where to move zombie
  public void moveZombie(int playerX, int playerY) {
    int distanceX = x - playerX;
    int distanceY = y - playerY;
    //check distance regardless of position
    if(Math.abs(distanceX) == Math.abs(distanceY)){
      x= distanceX > 0 ? (x -1) : (x + 1);
    }
    if ( Math.abs(distanceX) > Math.abs(distanceY)) {
      //check is x/y is pos or neg and move accordingly
      x = distanceX >= 0 ? (x - 1) : (x + 1);
    } else{
      y = distanceY >= 0 ? (y - 1) : (y + 1);
    }
    //Add random movement to separate double trouble
    if ((Math.random() * 100 > 85)){
      y += 1;
    }
  }
  public boolean hasCaughtPlayer(Zombie zombie, int playerX, int playerY){
    if (x == playerX && y == playerY){
      return true;
    }
    return false;
  }
}