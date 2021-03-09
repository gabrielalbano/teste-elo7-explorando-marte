package exploration;

import java.util.Optional;

public class Position {
  private final int x;
  private final int y;

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
    int newX = this.x;
    int newY = this.y;

    switch (dir) {
      case NORTH:
        newY += 1;
        break;
      case EAST:
        newX += 1;
        break;
      case SOUTH:
        newY -= 1;
        break;
      case WEST:
        newX -= 1;
        break;
      default:
        throw new IllegalArgumentException();
    }

    if (!probe.getField().isAvailableSpace(newX, newY)) {
      Position newPosition = handleUnavailableSpace(probe);
      newX = newPosition.getX();
      newY = newPosition.getY();
    }

    return new Position(newX, newY);
  }

  public Position handleUnavailableSpace(Probe probe) {
    Optional<Direction> optDir = Optional.ofNullable(probe.getDirection());
    Direction dir = optDir.orElseThrow(IllegalArgumentException::new);
    probe.setDirection(dir.turnLeft());
    return changePosition(probe, dir);
  }

}