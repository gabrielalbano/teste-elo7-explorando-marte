package exploration;

public class Field {
  protected char[][] coordinates;
  private int top_x;
  private int top_y;

  public Field(int top_x, int top_y) {
    this.top_x = top_x + 1;
    this.top_y = top_y + 1;
    this.coordinates = new char[this.top_x + 1][this.top_y + 1];
  }

  public void occupySpace(int i, int j) {
    coordinates[i][j] = 'x';
  }

  public int getWidth() {
    return this.top_x;
  }

  public int getHeigth() {
    return this.top_y;
  }

  public boolean isAvailableSpace(int x, int y) {
    // Checa se o espaço a frente está fora da área do campo ou já ocupado por outra
    // sonda
    boolean x_inBounds = (x >= 0) && (x < this.top_x);
    boolean y_inBounds = (y >= 0) && (y < this.top_y);
    boolean is_unoccupied = (this.coordinates[x][y] != 'x');

    return x_inBounds && y_inBounds && is_unoccupied;
  }

}
