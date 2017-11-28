/*
Payton Landes
Nov. 27 2017
CP222
2D Point Class
*/

public class IntPoint2D {

  public int x;
  public int y;

    //Constructor
    public IntPoint2D(int x1, int y1) {
      x = x1;
      y = y1;
    }

    //Returns X coordinate
    public int getX(){
      return this.x;
    }

    //ReturnsY coordinate
    public int getY(){
      return this.y;
    }

    /**
     * Computes the manhattan distance to another point.
     * formula: abs(x1-x2) + abs(y1-y2)
     * @param o the other point
     * @returns the manhattan distance
     */
    public int manhattanDistance(IntPoint2D o){
      int mD = (Math.abs(this.x - o.x) + Math.abs(this.y - o.y));
      return mD;
    }

    /**
     * Computes the euclidean distance to another point.
     * formula: sqrt((x1-x2)^2 + (y1-y2)^2)
     * @param o the other point
     * @returns the euclidean distance
     */
    public double distance(IntPoint2D o){
      double dist = Math.sqrt(Math.pow(this.x - o.x,2) + Math.pow(this.y - o.y,2));
      return dist;
    }

    // The following methods make JAVA objects better behaved
    /**
     * Converts a point object to a string of the form (X,Y)
     * @returns human friendly point representation
     */
    public String toString(){
      return "(" + this.x + "," + this.y + ")";
    }

    /**
     * Determines if this point is the same as another (i.e. x1=x2 and y1=y2)
     * @returns true if this point is the same as point o
     */
    public boolean equals(IntPoint2D o){
      return ((this.x == o.getX()) &&
              (this.y == o.getY()));
    }


    /**
     * Hashcode to support some standard library data structures
     * formula: (x<<16)+y
     * @returns the hashcode for the point
     */
    public int hashcode(){
      return ((this.x << 16) + this.y);
    }

  }
