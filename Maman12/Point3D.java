 


/**
 * This class represents a Point3D Object
 * 
 * @author (Timor Leiderman) 
 * @version (2024)
 */
public class Point3D {
    double _x;
    double _y;
    double _z;

    private final int ZERO = 0;
	/**
	* Constructs and initializes a Point3D from the specified xyz coordinates.
	* @param x the x cordinate
	* @param y the y cordinate
	* @param z the z cordinate
	*/
    public Point3D(double x, double y, double z) {
        _x = x;
        _y = y;
        _z = z;
    }
    /**
     * Constructs and initializes a Point3D to (0,0,0).
     */
    public Point3D() {
        _x = ZERO;
        _y = ZERO;
        _z = ZERO;
    }
    /**
	* Constructs and initializes a Point3D from the specified Point3D.
	* @param Point3D the Point3D which the new instance initialization will be based on
	*/
    public Point3D(Point3D other) {
        _x = other._x;
        _y = other._y;
        _z = other._z;
    }

    /** 
     * returns the x coordinate
     * @return the value of the x coordinate
     */
    public double getX() {
        return _x;
    }

    /** 
     * returns the y coordinate
     * @return the value of the y coordinate
     */
    public double getY() {
        return _y;
    }
    /** 
     * returns the z coordinate
     * @return the value of the z coordinate
     */
    public double getZ() {
        return _z;
    }
    /**
     * sets the x coordinate to the given x
     * @param num the - x value to set
     */
    public void setX(double num) {
        _x = num;
    }
    /**
     * sets the y coordinate to the given y
     * @param num the - y value to set
     */
    public void setY(double num) {
        _y = num;
    }
    /**
     * sets the z coordinate to the given z
     * @param num the - z value to set
     */
    public void setZ(double num) {
        _z = num;
    }
    
    /**
     * Determines whether or not two points are equal.
     * @param other a Point3D object to be compared with this Point3D
     * @return true if the Point3D are the same
     */
    public boolean equals(Point3D other) {
        return _x == other._x && _y == other._y && _z == other._z;
    }

    /**
     * Checks if this point is above the other point. (z axis)
     * @param other The point to check whether this point is above it
     * @return rue if this point is above the other point, false otherwise
     */
    public boolean isAbove(Point3D other) {
        return _z > other._z;
    }
    /**
     * Checks if this point is under the other point. (z axis)
     * @param other  The point to check whether this point is under it
     * @return true if this point is under the other point, false otherwise
     */
    public boolean isUnder(Point3D other){
        return other.isAbove(this);
    }

    /**
     * Checks if this point is to the left of the other point. (y axis)
     * @param other The point to check whether this point is left of it
     * @return true if this point is to the left of the other point, false otherwise
     */
    public boolean isLeft(Point3D other){
        return _y < other._y;
    }

    /**
     * Checks if this point is to the right of the other point. (y axis)
     * @param other The point to check whether this point is right of it
     * @return true if this point is to the right of the other point, false otherwise
     */
    public boolean isRight(Point3D other){
        return other.isLeft(this);
    }
    
    /**
     * Checks if this point is behind the other point. (x axis)
     * @param other  The point to check whether this point behind it
     * @return true if this point is behind the other point, false otherwise
     */
    public boolean isBehind(Point3D other){
        return _x < other._x;
    }

    /**
     * Checks if this point is in front of the other point. (x axis)
     * @param other Point3D to compare the x cordiante
     * @return true if this x cordinate smaller then other x cordinate
     */
    public boolean isInFrontOf(Point3D other){
        return other.isBehind(this);
    }

    /**
     * Moves the Point3D in location (x,y,z), by dx along the x axis, by dy along the y axis and dz along the z axis so that it now represents the Point3D in the following 3D coordintes (x+dx,y+dy,z+dz).
     * @param dx the addtion for coordinate x value
     * @param dy the addtion for coordinate y value
     * @param dz the addtion for coordinate z value
     */
    public void move(double dx, double dy, double dz) {
        _x += dx;
        _y += dy;
        _z += dz;
    }

    /**
     * Returns the distance between this point and other point p.
     * @param p the other point
     * @return he distance between the two points
     */
    public double distance(Point3D p) {

        double dx = Math.pow(_x - p._x, 2);
        double dy = Math.pow(_y - p._y, 2);
        double dz = Math.pow(_z - p._z, 2);

        return Math.sqrt(dx + dy + dz);
    }
    
    /**
     * Returns a string representation of this Point3D.
     */
    public String toString() {
        return "(" + _x + "," + _y + "," + _z + ")";
    }

}
