
/**
 * This class represents a Box3D Object
 * 
 * @author (Timor Leiderman) 
 * @version (2024)
 */

public class Box3D {

    private Point3D _base;
    private int _length;
    private int _width;
    private int _height;

    private final int DEFAULT_LEN = 1;

    /**
     * Constructs and initializes a box with a default base point and all dimensions to 1.
     */
    public Box3D() {
        _base = new Point3D();
        _length = DEFAULT_LEN;
        _width = DEFAULT_LEN;
        _height = DEFAULT_LEN;
    }

    /**
     * Constructs and initializes a box object from a given base point and 3 integers as the dimentions of the Box
     * @param base Point3D the base point of the box
     * @param length the length of the Box3D
     * @param width the width of the Box3D
     * @param height the height of the Box3D
     */
    public Box3D(Point3D base, int length, int width, int height) {
        _base = new Point3D(base);

        if (length <= 0)
            length = DEFAULT_LEN;
        _length = length;

        if (width <= 0)
            width = DEFAULT_LEN;
        _width = width;

        if (height <= 0)
            height = DEFAULT_LEN;
        _height = height;

    }
    /**
     * Constructs and initializes a Box3D object from a given Box3D.
     * @param other the box to copy from. Contains the initialization of the base point and all dimentions.
     */
    public Box3D(Box3D other) {
        _base = new Point3D(other._base);
        _length = other._length;
        _width = other._width;
        _height = other._height;
    }

    /**
     * returns the length dimension
     * @return the length dimension
     */
    public int getLength() {
        return _length;
    }

    /**
     * returns the width dimension
     * @return the width of the box
     */
    public int getWidth() {
        return _width;
    }

    /**
     * returns the height dimension
     * @return the height of the box
     */
    public int getHeight() {
        return _height;
    }

    /**
     * returns the lower-left-front (base) Point3D of the box
     * @return the base point of the box
     */
    public Point3D getBase(){
        return _base;
    }

    /**
     * Sets the height of the box only if the given value is equal or greater than 1.
     * @param num the height of the box
     */
    public void setHeight(int num) {
        if (num > 0)
            _height = num;
    }

    /**
     * Sets the width of the box only if the given value is equal or greater than 1.
     * @param num the width of the box
     */
    public void setWidth(int num) {
        if (num > 0)
            _width = num;
    }

    /**
     * Sets the length of the box only if the given value is equal or greater than 1.
     * @param num the length of the box
     */
    public void setLength(int num) {
        if (num > 0)
            _length = num;
    }

    /** 
     * Sets the base point of the box
     * @param p Point3D of the base point
     */
    public void setBase(Point3D p) {
        _base = new Point3D(p);
    }

    /** Determines whether or not the two boxes are equal.
     * @param other a Box3D object to be compared with this Box3D
     * @return true if the boxs are the same
     */
    public boolean equals(Box3D other) {
        return _height == other._height && _length == other._length && _width == other._width && _base.equals(other._base);
    }

    /**
     * Moves the box in the (x,y,z) coordinate system to (x+dx,y+dy,z+dz) without changing the box dimensions
     * @param dx move in the x direction
     * @param dy move in the y direction
     * @param dz move in the z direction
     * @return the new box in its new location
     */
    public Box3D move(double dx, double dy, double dz) {
        Point3D point = new Point3D(_base);
        point.move(dx, dy, dz);
        return new Box3D(point, _length, _width, _height);
    }

    /**
     * Calculates and returns the upper-right-back point of this box
     * @return the point of the upper right back corner
     */
    public Point3D getUpRightBackPoint() {
        return new Point3D(_base._x - _length, _base._y + _width, _base._z + _height);
    }

    /**
     * Calculates and returns the center point of the box
     * @return the center point of the box
     */
    public Point3D getCenter() {
        double x = _base._x - (_length / 2.0);
        double y = _base._y + (_width / 2.0);
        double z = _base._z + (_height / 2.0);
        return new Point3D(x, y, z);
    }

    /**
     *  calculate the distance between the centers of 2 boxs
     * @param other a Box3D object that will be usd to calculate the distance between it to this Box3D object
     * @return the distance between two Box3D objects
     */
    public double distance(Box3D other) {
        return this.getCenter().distance(other.getCenter());
    }

    /**
     * 	Computes the volume of the box.
     * @return the volume of the box
     */
    public int getVolume() {
        return _width * _height * _length;
    }

    /**
     * Determines whether this box has a greater volume in compare to other box.
     * @param other Box3D to compare
     * @return true if the current box is larger in size then the other
     */
    public boolean isLargerCapacity(Box3D other) {
        return this.getVolume() > other.getVolume();
    }

    /**
     * Determines whether this box can contain the other box.
     * @param other Box3D to check if it fits inside
     * @return true if other box can fir inside this box
     */
    public boolean contains(Box3D other) {
        return other._length < _length && other._height < _height && other._width < _width;
    }

    /**
     * Checks if this box is above the other box.
     * @param other Box3D to check
     * @return true if the box is above the other
     */
    public boolean isAbove(Box3D other) {
        return other.getUpRightBackPoint().isUnder(this._base);
    }
    /**
     * Computes the surface area of a box.
     * @return surface area of the box
     */
    public int getSurfaceArea() {
        return 2 * ( _width * _height + _width * _length + _height * _length);
    }

    /**
     * Returns a string representation of this Box3D object.
     * @return String represantaion of the box
     */
    public String toString() {
        return "The base point is " + _base + ", length = " + _length + ", width = " + _width + ", height = " + _height;
    }

}
