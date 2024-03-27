package Maman12;

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
    public int getLenght() {
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
     * set the lenght of the box
     * @param num the lenght of the box
     */
    public void getLength(int num) {
        if (num > 0)
            _length = num;
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

    public Point3D getCenter() {
        
        return new Point3D();
    }
    /**
     * @return String represantaion of the box
     */
    public String toString() {
        return "The base point is " + _base + ", length = " + _length + ", width = " + _width + ", height = " + _height;
    }



}
