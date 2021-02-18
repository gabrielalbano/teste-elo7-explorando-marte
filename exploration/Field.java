package exploration;

public class Field {
  protected char[][] coordinates;
  private int top_x;
  private int top_y;

  public Field(int top_x, int top_y) {
    this.top_x = top_x;
    this.top_y = top_y;
    this.coordinates = new char[this.top_x][this.top_y];
  }

  public int getWidth() {
    return this.top_x;
  }

  public int getHeigth() {
    return this.top_y;
  }

  public boolean isSpaceAvailable(int x, int y) {
    // Checa se o espaço a frente está fora da área do campo ou já ocupado por outra
    // sonda
    boolean x_inBounds = (x >= 0) && (x < getWidth());
    boolean y_inBounds = (y >= 0) && (y < getHeigth());
    while (!x_inBounds && !y_inBounds) {
      return true;
    }
    return false;

  }

}
