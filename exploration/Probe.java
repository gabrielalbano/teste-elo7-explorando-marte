package exploration;

public class Probe {
  private Field field;
  private Position position;
  private Direction direction;

  public Probe(Position position, Direction direction, Field field) {
    this.position = position;
    this.direction = direction;
    this.field = field;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public Position getPosition() {
    return this.position;
  }

  public Field getField() {
    return this.field;
  }

  public Direction getDirection() {
    return this.direction;
  }

  public String getFinalPosition() {
    return this.position.getX() + " " + this.position.getY() + " " + direction.getDirectionCode();
  }

}
