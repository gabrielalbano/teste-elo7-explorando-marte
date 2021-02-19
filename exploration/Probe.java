package exploration;

public class Probe {
  private Field field;
  private Position position;
  private Direction direction;

  public Probe(Position position, Direction direction, Field field) {
    this.field = field;
    this.position = position;
    this.direction = direction;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public void occupyPosition(Position position) {
    int i = position.getX();
    int j = position.getY();
    this.field.coordinates[i][j] = 'x';
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
