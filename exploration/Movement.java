package exploration;

import java.util.Optional;

public enum Movement {
  MOVE_FORWARD('M') {
    @Override
    public void doMovement(Probe probe) {
      Direction dir = probe.getDirection();
      probe.setDirection(dir.moveForward());
      Position currentPosition = probe.getPosition();
      Position newPosition = currentPosition.changePosition(probe, dir);
      probe.setPosition(newPosition);
    }
  },
  LEFT('L') {
    @Override
    public void doMovement(Probe probe) {
      Direction dir = probe.getDirection();
      probe.setDirection(dir.turnLeft());
    }
  },
  RIGHT('R') {
    @Override
    public void doMovement(Probe probe) {
      Direction dir = probe.getDirection();
      probe.setDirection(dir.turnRight());
    }
  };

  private final char shortCode;

  Movement(char code) {
    this.shortCode = code;
  }

  public static Optional<Movement> getMovement(char shortCode) {
    for (Movement m : Movement.values()) {
      if (m.shortCode == shortCode)
        return Optional.of(m);
    }
    return Optional.empty();
  }

  // realiza o movimento pedido de acordo com o comando dado
  // a posição muda apenas se o comando for MOVE_FORWARD
  public abstract void doMovement(Probe probe);

}