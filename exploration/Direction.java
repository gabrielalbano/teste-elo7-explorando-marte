package exploration;

import java.util.*;

public enum Direction {
  NORTH('N') {
    @Override
    public Direction turnLeft() {
      return WEST;
    }
    @Override
    public Direction turnRight() {
      return EAST;
    }
  },

  EAST('E') {
    @Override
    public Direction turnLeft() {
      return NORTH;
    }
    @Override
    public Direction turnRight() {
      return SOUTH;
    }

  }, WEST('W') {
    @Override
    public Direction turnLeft() {
      return SOUTH;
    }
    @Override
    public Direction turnRight() {
      return NORTH;
    }

  }, SOUTH('S') {
    @Override
    public Direction turnLeft() {
      return EAST;
    }
    @Override
    public Direction turnRight() {
      return WEST;
    }
  };

  private final char shortCode;

  Direction(char code) {
    this.shortCode = code;
  }

  public char getDirectionCode() {
    return this.shortCode;
  }

  public static Optional<Direction> getDirection(char shortCode) {
    for (Direction m : Direction.values()) {
      if (m.shortCode == shortCode)
        return Optional.of(m);
    }
    return Optional.empty();
  }

  public abstract Direction turnLeft();

  public abstract Direction turnRight();

  public Direction moveForward() {
    // A sonda continua na mesma direção
    return this;
  }

}