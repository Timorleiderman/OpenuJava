
package unit_3;


/**
* This class represent a three-dimension box.
* The sides are integers value start by 1.
* The default size is 10*10*10.
*
* @version v.0.1
* @author Timorl
*
*/
public class Box {
        // constants declaration:
        private final int MIN_DEF = 1;
        //attributes declarations:
        private int _length;
        private int _width;
        private int _height;

        /**
        * Constructor for create new box, getting the size of each side.
        *
        * @param length the length of the box, must be at least 1.
        * if value will be less than 1, it will be changed to 1.
        * @param width the width of the box, must be at least 1.
        * if value will be less than 1, it will be changed to 1.
        * @param height the height of the box, must be at least 1.
        * if value will be less than 1, it will be changed to 1.
        */
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
        public Box() {
            _length = MIN_DEF;
            _height = MIN_DEF;
            _width = MIN_DEF;
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
        public void changeSize(int deltaLength, int deltaHeight) {
            _length += deltaLength;
            _height += deltaHeight;
        }

        public int calcVolume() {
            return _height * _width * _length;
        }

        public int calcSurface() {
            return 2*( (_height*_width) + (_width*_length) + (_height*_length) );
        }

        /**
        * return the length of the box
        *
        * @return the length of the box
        */
        public int getLength() {
            return _length;
        }

        public int getWidth() {
            return _width;
        }

        public int getHeight() {
            return _height;
        }


        /**
        he length of the box to a given new length
        *
        * @param length new length, the length will be changed if and only if
        * the new length will be at least 1.
        */
        public void setLength(int length) {
            if (length >= MIN_DEF)
                _length = length;
        }

        public void setWidth(int width) {
            if (width >= MIN_DEF)
                _width = width;
        }
        
        public void setHeight(int height) {
            if (height >= MIN_DEF)
                _height = height;
            }

}