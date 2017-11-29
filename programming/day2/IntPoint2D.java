/*
Payton Landes
Nov. 27 2017
CP222
2D Point Class
*/

public class IntPoint2D implements IIntPoint2D{

  public int x;
  public int y;

    //Constructor
    public IntPoint2D(int x1, int y1) {
      x = x1;
      y = y1;
    }

    //Returns X coordinate
    public int getX(){
      return x;
    }

    //ReturnsY coordinate
    public int getY(){
      return y;
    }

    /**
     * Computes the manhattan distance to another point.
     * formula: abs(x1-x2) + abs(y1-y2)
     * @param o the other point
     * @returns the manhattan distance
     */
    public int manhattanDistance(IIntPoint2D o){
      int mD = (Math.abs(this.getX() - o.getX()) + Math.abs(this.getY() - o.getY()));
      return mD;
    }

    /**
     * Computes the euclidean distance to another point.
     * formula: sqrt((x1-x2)^2 + (y1-y2)^2)
     * @param o the other point
     * @returns the euclidean distance
     */
    public double distance(IIntPoint2D o){
      double dist = Math.sqrt(Math.pow(this.getX() - o.getX(),2) + Math.pow(this.getY() - o.getY(),2));
      return dist;
    }

    // The following methods make JAVA objects better behaved
    /**
     * Converts a point object to a string of the form (X,Y)
     * @returns human friendly point representation
     */
    public String toString(){
      return "(" + this.getX() + "," + this.getY() + ")";
    }

    /**
     * Determines if this point is the same as another (i.e. x1=x2 and y1=y2)
     * @returns true if this point is the same as point o
     */
    public boolean equals(IIntPoint2D o){
      return ((this.getX() == o.getX()) &&
              (this.getY() == o.getY()));
    }


    /**
     * Hashcode to support some standard library data structures
     * formula: (x<<16)+y
     * @returns the hashcode for the point
     */
    public int hashcode(){
      return ((this.getX() << 16) + this.getY());
    }

  }
