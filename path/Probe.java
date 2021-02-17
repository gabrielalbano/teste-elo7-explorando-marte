package path;

public class Probe {
  private int x_coordinate;
  private int y_coordinate;
  private char direction;

  public Probe(int x_coordinate, int y_coordinate, char direction) {
    setCoordinates(x_coordinate, y_coordinate);
    setDirection(direction);
  }

  public void setCoordinates(int x_coordinate, int y_coordinate) {
    this.x_coordinate = x_coordinate;
    this.y_coordinate = y_coordinate;
  }

  public void setDirection(char direction) {
    this.direction = direction;
  }

  public int[] getCoordinates() {
    int[] coordinates = new int[2];
    coordinates[0] = x_coordinate;
    coordinates[1] = y_coordinate;
    return coordinates;
  }

  public String getDirection() {
    return "" + this.direction;
  }

  public void TurnLeft() {
    switch (this.direction) {
      case 'N':
        setDirection('W');
        break;
      case 'E':
        setDirection('N');
        break;
      case 'S':
        setDirection('E');
        break;
      case 'W':
        setDirection('S');
        break;
    }
  }

  public void TurnRight() {
    switch (this.direction) {
      case 'N':
        setDirection('E');
        break;
      case 'E':
        setDirection('S');
        break;
      case 'S':
        setDirection('W');
        break;
      case 'W':
        setDirection('N');
        break;
    }
  }

  public void MoveFoward() {
    switch (this.direction) {
      case 'N':
        setCoordinates(this.x_coordinate, this.y_coordinate + 1);
        break;
      case 'E':
        setCoordinates(this.x_coordinate + 1, this.y_coordinate);
        break;
      case 'S':
        setCoordinates(this.x_coordinate, this.y_coordinate - 1);
        break;
      case 'W':
        setCoordinates(this.x_coordinate - 1, this.y_coordinate);
        break;
    }
  }

  public void doMovement(char instruction) {
    switch (instruction) {
      case 'L':
        TurnLeft();
        break;
      case 'R':
        TurnRight();
        break;
      case 'M':
        MoveFoward();
        break;
    }
  }

  public void doInstructions(String instructions, Field field) {
    for (int i = 0; i < instructions.length(); i++) {
      char inst = instructions.charAt(i);
      doMovement(inst);
    }
  }

  public String getFinalPosition() {
    return getCoordinates()[0] + " " + getCoordinates()[1] + " " + getDirection();
  }

}
