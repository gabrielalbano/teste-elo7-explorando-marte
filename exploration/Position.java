package exploration;

public class Position {
  private int x;
  private int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public Position changePosition(Direction dir) {
    // Se disponível, move a sonda um espaço a frente, se não, vira à esquerda até
    // encontrar um (no máximo 4 vezes)
    switch (dir) {
      case NORTH:
        return new Position(this.x, this.y + 1);
      case EAST:
        return new Position(this.x + 1, this.y);
      case SOUTH:
        return new Position(this.x, this.y - 1);
      case WEST:
        return new Position(this.x - 1, this.y);
      default:
        throw new IllegalArgumentException();
    }
  }

}