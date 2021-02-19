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

  public Position changePosition(Probe probe, Direction dir) {
    // Move a sonda um espaço a frente relativo à sua direção se houver espaço
    // disponivel, se não, vira à esquerda até encontrar um
    int new_x = this.x;
    int new_y = this.y;

    switch (dir) {
      case NORTH:
        new_y += 1;
        break;
      case EAST:
        new_x += 1;
        break;
      case SOUTH:
        new_y -= 1;
        break;
      case WEST:
        new_x -= 1;
        break;
      default:
        throw new IllegalArgumentException();
    }

    if (!probe.getField().isAvailableSpace(new_x, new_y)) {
      Position new_position = handleUnavailableSpace(probe, new_x, new_y);
      new_x = new_position.getX();
      new_y = new_position.getY();
    }

    return new Position(new_x, new_y);
  }

  public Position handleUnavailableSpace(Probe probe, int x, int y) {
    Direction dir = probe.getDirection();
    probe.setDirection(dir.turnLeft());
    Position new_position = changePosition(probe, probe.getDirection());
    return new_position;
  }

}