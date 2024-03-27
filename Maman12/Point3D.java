package Maman12;


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
    //constructors:
	/**
	* creates a new Point3D object
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
     * Empty Constructor initializes all cordiantes to (0, 0, 0)
     */
    public Point3D() {
        _x = ZERO;
        _y = ZERO;
        _z = ZERO;
    }
    /**
	* Copy Constructor
	* @param Point3D to be copied
	*/
    public Point3D(Point3D other) {
        _x = other._x;
        _y = other._y;
        _z = other._z;
    }

    /** get x cordiante
     * @return x
     */
    public double getX() {
        return _x;
    }

    /** get y cordiante
     * @return y
     */
    public double getY() {
        return _y;
    }
    /** get z cordiante
     * @return z
     */
    public double getZ() {
        return _z;
    }
    /** set x cordiante
     * @return x
     */
    public void setX(double num) {
        _x = num;
    }
    /** set y cordiante
     * @return y
     */
    public void setY(double num) {
        _y = num;
    }
    /** set z cordiante
     * @return z
     */
    public void setZ(double num) {
        _z = num;
    }
    
    /**
     * check if 2 Point3D are the same
     * @param other the Point3D to compare this Point3D to
     * @return true if the Point3D are the same
     */
    public boolean equals(Point3D other) {
        return _x == other._x && _y == other._y && _z == other._z;
    }

    /**
     * check if the _z cordinate  of this Point3D is bigger then the other
     * @param other Point3D to compare the z cordiante
     * @return true if this z cordinate bigger then other z cordinate
     */
    public boolean isAbove(Point3D other) {
        return _z > other._z;
    }
    /**
     * check if the _z cordinate of this Point3D is smaller then the other _z cordinate
     * @param other  Point3D to compare the z cordiante
     * @return true if this z cordinate smaller then other z cordinate
     */
    public boolean isUnder(Point3D other){
        return other.isAbove(this);
    }

    /**
     * check if the _y cordinate of this Point3D is bigger then the other _y cordinate
     * @param other  Point3D to compare the y cordiante
     * @return true if this y cordinate bigger then other y cordinate
     */
    public boolean isLeft(Point3D other){
        return _y < other._y;
    }

    /**
     * check if the _y cordinate of this Point3D is smaller then the other _y cordinate
     * @param other Point3D to compare the y cordiante
     * @return true if this y cordinate smaller then other y cordinate
     */
    public boolean isRight(Point3D other){
        return other.isLeft(this);
    }
    
    /**
     * check if the _x cordinate of this Point3D is bigger then the other _x cordinate
     * @param other Point3D to compare the x cordiante
     * @return true if this x cordinate bigger then other x cordinate
     */
    public boolean isBehind(Point3D other){
        return _x < other._x;
    }

    /**
     * check if the _x cordinate of this Point3D is smaller then the other _x cordinate
     * @param other Point3D to compare the x cordiante
     * @return true if this x cordinate smaller then other x cordinate
     */
    public boolean isInFrontOf(Point3D other){
        return other.isBehind(this);
    }

    /**
     * move the Point3D in x,y,z direction
     * @param dx move in x direction
     * @param dy move in y direction
     * @param dz move in z direction
     */
    public void move(double dx, double dy, double dz) {
        _x += dx;
        _y += dy;
        _z += dz;
    }

    public double distance(Point3D p) {

        double dx = Math.pow(_x - p._x, 2);
        double dy = Math.pow(_y - p._y, 2);
        double dz = Math.pow(_z - p._z, 2);

        return Math.sqrt(dx + dy + dz);
    }
    
    /**
     * returns a String that represents this Point3D 
     * @return String that represents this Point3D
	 * in the following format:
	 * (x,y,z)
     */
    public String toString() {
        return "(" + _x + "," + _y + "," + _z + ")";
    }

}
