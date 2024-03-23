
package unit_3;

public class Box {
        // constants declaration:
        private final int MIN_DEF = 1;
        //attributes declarations:
        private int _length;
        private int _width;
        private int _height;
    //constructors
    public Box(int length, int width, int height) {
        if (length < MIN_DEF)
            length = MIN_DEF;
        _length = length;

        if (width < MIN_DEF)
            width = MIN_DEF;
        _width = width;

        if (height < MIN_DEF)
            height = MIN_DEF;
        _height = height;
    }

    public String toString() {
        // build and return the String of the object
        return "(" + _length + ", " + _width + ", " + _height + ")";
        }

    public void changeSize(int delta) {
        //vchange attribute only if valid after adding delta
        if (_length + delta >= MIN_DEF && 
            _width + delta >= MIN_DEF && 
            _height + delta >= MIN_DEF) {

            _length += delta;
            _width += delta;
            _height += delta;
        }
    }

    public int calcVolume() {
        return _height * _width * _length;
    }

    public int calcSurface() {
        return 2*( (_height*_width) + (_width*_length) + (_height*_length) );
    }
}