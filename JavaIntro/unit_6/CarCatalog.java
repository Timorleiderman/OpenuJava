package unit_6;
import unit_3.Car;

public class CarCatalog {

    public static final int MAX_CARS = 100;
    private Car [] _cars;
    private int _noCars;

    public CarCatalog(){
        // create the array with MAX_CARS
        _cars = new Car[MAX_CARS];
        _noCars = 0;
    }

    public boolean add(String factory, int year, long id) {

        if (_noCars == _cars.length) {
            return false;
        }

        if (indexOf( id) != -1 ){
            return false;
        }

        Car newCar = new Car(factory, year, id);
        _cars[_noCars] = newCar;
        _noCars++;

        return true;
    }

    public String toString() {
        if (_noCars == 0) {
            return "Empty Catalog";
        }
        String str = "Cars Catalog";
        for (int idx=0; idx<_noCars; idx++) {
            str += "\n" + _cars[idx].toString();
        }

        return str;
    }

    private int indexOf(long id) {

        for (int idx=0; idx < _noCars; idx++) {
            if (_cars[idx].getId() == id)
                return idx;
        }
        return -1;
    }

    public Car remove(long id) {
        int idx = indexOf(id);
        if (idx == -1) {
            return null;
        }
        Car tmp = _cars[idx];
        _cars[idx] = _cars[_noCars - 1];
        _noCars--;

        return tmp;
    }


    public Car youngest() {
        if (_noCars == 0) {
            return null;
        }

        Car young = _cars[0];
        for (int idx=1; idx < _noCars; idx++) {
            if (_cars[idx].younger(young)) {
                young = _cars[idx];
            }
        }

        return young;
    }

    public int popularYear() {
        if (_noCars == 0) {
            return -1;
        }

        int popYear = _cars[0].getYear();
        int popTimes = 1;

        for (int idx=0; idx< _noCars; idx++) {
            int count = 0;

            int year = _cars[idx].getYear();
            for (int jdx=idx; jdx<_noCars;jdx++) {
                if (_cars[jdx].getYear() == year) {
                    count++;
                }
            }

            if (popTimes < count) {
                popTimes = count;
                popYear = year;
            }
        }
        return popYear;
    }
}

