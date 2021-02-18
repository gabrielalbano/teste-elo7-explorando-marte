package exploration;

public enum Direction {
  NORTH('N'), EAST('E'), WEST('W'), SOUTH('S');

  private final char shortCode;

  Direction(char code) {
    this.shortCode = code;
  }

  public char getDirectionCode() {
    return this.shortCode;
  }

  public static Direction getDirection(char shortCode) {
    for (Direction m : Direction.values()) {
      if (m.shortCode == shortCode)
        return m;
    }
    throw new IllegalArgumentException();
  }

  public Direction turnLeft() {
    // Vira a sonda 90 graus para a esquerda dependendo da sua direção
    switch (this) {
      case NORTH:
        return WEST;
      case EAST:
        return NORTH;
      case SOUTH:
        return EAST;
      case WEST:
        return SOUTH;
      default:
        throw new IllegalArgumentException();
    }
  }

  public Direction turnRight() {
    // Vira a sonda 90 graus para a direita dependendo da sua direção
    switch (this) {
      case NORTH:
        return EAST;
      case EAST:
        return SOUTH;
      case SOUTH:
        return WEST;
      case WEST:
        return NORTH;
      default:
        throw new IllegalArgumentException();
    }
  }

  public Direction moveFoward() {
    return this;
  }

}