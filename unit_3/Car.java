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

    public String toString() {
        return  "( " + _factory + " , " + _year + " , " + _id + " )";
    }
}
