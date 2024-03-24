package unit_3;
// 
public class Car {

    private final int DEF_YEAR = 2000;
    private String _factory;
    private long _id;
    private int _year;

    public Car(String factory, int year, long id) {
        _factory = factory;

        if (year < 1000 && year > 9999) {
            year = DEF_YEAR;
        }
        _year = year;
        _id = id;
    }
    // constructor with 2 inputs
    public Car(String factory, long id) {
        _factory = factory;
        _year = DEF_YEAR;
        _id = id;
    }

    // copy constructor
    public Car( Car car) {
        _factory = car._factory;
        _id = car._id;
        _year = car._year;
    }

    public String toString() {
        return  "( " + _factory + " , " + _year + " , " + _id + " )";
    }
}
