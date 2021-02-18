package exploration;

public enum Movement {
  MOVE_FORWARD('M'), LEFT('L'), RIGHT('R');

  private final char shortCode;

  Movement(char code) {
    this.shortCode = code;
  }

  public char getMovementCode() {
    return this.shortCode;
  }

  public static Movement getMovement(char shortCode) {
    for (Movement m : Movement.values()) {
      if (m.shortCode == shortCode)
        return m;
    }
    throw new IllegalArgumentException();
  }

  public void doMovement(Probe probe) {
    Direction dir = probe.getDirection();
    switch (this) {
      case MOVE_FORWARD:
        probe.setDirection(dir.moveFoward());
        Position current_position = probe.getPosition();
        Position new_position = current_position.changePosition(dir);
        probe.setPosition(new_position);
        break;
      case LEFT:
        probe.setDirection(dir.turnLeft());
        break;
      case RIGHT:
        probe.setDirection(dir.turnRight());
        break;
      default:
        throw new IllegalArgumentException();
    }
  }

}