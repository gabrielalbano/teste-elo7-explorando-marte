package path;

public class Field {
  protected char[][] coordinates;
  private int top_x;
  private int top_y;

  public Field(int top_x, int top_y) {
    this.top_x = top_x;
    this.top_y = top_y;
    this.coordinates = new char[this.top_x][this.top_y];

    for (int i = 0; i < top_x; i++) {
      for (int j = 0; j < top_y; j++) {
        this.coordinates[i][j] = '-';
      }
    }
  }

}
