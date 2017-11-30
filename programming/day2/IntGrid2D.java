/*
Payton Landes
Nov. 28 2017
CP222
2D Grid Class
*/
public class IntGrid2D implements IIntGrid2D{
  public int ulx;
  public int uly;
  public int lrx;
  public int lry;
  public char fill;
  public char[][] grid;

  // Make a new grid with the center point at (0,0)
  //IntGrid2D constructor takes in 5 arguments:
  //upper left x
  //upper left y
  //lower right x
  //lower right y
  //a fill value for all grid cells
  public IntGrid2D(int ulx1, int uly1, int lrx1, int lry1, char fill1) {
    ulx = ulx1;
    uly = uly1;
    lrx = lrx1;
    lry = lry1;
    fill = fill1;
    int width = lrx - ulx + 1;
    int height = uly - lry + 1;
    grid = new char[width][height];
    for (int i = 0; i < width; i++) {
      for (int h = 0; h < height; h++) {
        grid[i][h] = fill;
      }
    }
  }
  /**
   * Sets the value at a point on the grid, replacing the previous value if any.
   * @param p The coordinate to set the value of
   * @param v The value to set at the coordinate
   */
  public void setPoint(IIntPoint2D p, char v){
    grid[p.getX() - ulx][p.getY() -lry] = v;
  }

  /**
   * Gets the value at a point on the grid
   * @param p The coordinate to get the value of
   * @returns the stored value
   */
  public char getPoint(IIntPoint2D p){
    return grid[p.getX() - ulx][p.getY() - lry];
  }

  /**
   * Gets the coordinate for the upper left most location
   * @returns an IIntPoint that is the coordinate of the upper left corner
   */
  public IIntPoint2D getUpperLeftCorner(){
    IIntPoint2D p = new IntPoint2D(ulx,uly);
    return p;
  }

  /**
   * Gets the coordinate for the lower right most location
   * @returns an IIntPoint that is the lower right corner
   */
  public IIntPoint2D getLowerRightCorner(){
    IIntPoint2D p = new IntPoint2D(lrx,lry);
    return p;
  }

}
