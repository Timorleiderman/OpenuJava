public class Box3D {
    private Point3D _base;
    private int _length;
    private int _width;
    private int _height;

    private final int DEFAULT_LEN = 1;

    /**
     * Empty Constructor initializes all lengths to 1 and base cordinate empty constructor for (0,0,0)
     */
    public Box3D() {
        _base = new Point3D();
        _length = DEFAULT_LEN;
        _width = DEFAULT_LEN;
        _height = DEFAULT_LEN;
    }

    /**
     * Constructor that recives the base Point3D the length, width and height
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
     * Copy constructor that recives other box
     * @param other Box3D object
     */
    public Box3D(Box3D other) {
        _base = new Point3D(other._base);
        _length = other._length;
        _width = other._width;
        _height = other._height;
    }

    /**
     * @return the length of the box
     */
    public int getLength() {
        return _length;
    }

    /**
     * @return the width of the box
     */
    public int getWidth() {
        return _width;
    }

    /**
     * @return the height of the box
     */
    public int getHeight() {
        return _height;
    }

    /**
     * @return Point3D base point
     */
    public Point3D getBase(){
        return _base;
    }

    /**
     * set the height of the box
     * @param num the height of the box
     */
    public void setHeight(int num) {
        if (num > 0)
            _height = num;
    }

    /**
     * set the width of the box
     * @param num the width of the box
     */
    public void setWidth(int num) {
        if (num > 0)
            _width = num;
    }

    /**
     * set the length of the box
     * @param num the length of the box
     */
    public void setLength(int num) {
        if (num > 0)
            _length = num;
    }

    /** 
     * set the base point
     * @param p Point3D of the base point
     */
    public void setBase(Point3D p) {
        _base = new Point3D(p);
    }

    /** check if 2 Box3D are the same 
     * @param other the Box3D to compare this box to
     * @return true if the boxs are the same
     */
    public boolean equals(Box3D other) {
        return _height == other._height && _length == other._length && _width == other._width && _base.equals(other._base);
    }

    /**
     * creates a new box based on the current and move the box to a new position
     * @param dx move in the x direction
     * @param dy move in the y direction
     * @param dz move in the z direction
     * @return a new Box3D based on the current box that moved to a new postion
     */
    public Box3D move(double dx, double dy, double dz) {

        Point3D point = new Point3D(_base);
        point.move(dx, dy, dz);
        return new Box3D(point, _length, _width, _height);

    }

    /**
     * @return the point of the upper right back corner
     */
    public Point3D getUpRightBackPoint() {
        return new Point3D(_base._x - _length, _base._y + _width, _base._z + _height);
    }

    /**
     * 
     * @return The center of the Box3D
     */
    public Point3D getCenter() {
        double x = _base._x - (_length / 2.0);
        double y = _base._y + (_width / 2.0);
        double z = _base._z + (_height / 2.0);

        return new Point3D(x, y, z);
    }

    /**
     *  calculate the distance between the centers of 2 boxs
     * @param other Box3D other box 
     * @return the distance between the 2 Box3D objects
     */
    public double distance(Box3D other) {
        return this.getCenter().distance(other.getCenter());
    }

    /**
     * @return the volume of the box
     */
    public int getVolume() {
        return _width * _height * _length;
    }

    /**
     * @param other Box3D to compare
     * @return true if the current box is larger in size then the other
     */
    public boolean isLargerCapacity(Box3D other) {
        return this.getVolume() > other.getVolume();
    }

    /**
     * checi if it is possible to put other box inside this box
     * @param other Box3D to check if it fits inside
     * @return true if other box can fir inside this box
     */
    public boolean contains(Box3D other) {
        return other._length < _length && other._height < _height && other._width < _width;
    }

    /**
     * check if the box is above the other box
     * @param other Box3D to check
     * @return true if the box is above the other
     */
    public boolean isAbove(Box3D other) {
        return other.getUpRightBackPoint().isUnder(this._base);
    }
    /**
     * @return surface area of the box
     */
    public int getSurfaceArea() {
        return 2 * ( _width * _height + _width * _length + _height * _length);
    }

    /**
     * @return String represantaion of the box
     */
    public String toString() {
        return "The base point is " + _base + ", length = " + _length + ", width = " + _width + ", height = " + _height;
    }



}
