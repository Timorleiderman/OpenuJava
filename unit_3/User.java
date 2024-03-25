package unit_3;

public class User {
    public static void main(String[] args) { //create new Box
    
    Car car1 = new Car("BMW", 2023, 9999);
    System.out.println("This is a Car " + car1);
    
    Box box1 = new Box(4, 3, 2);
    // print the box 
    System.out.println("box1 = " + box1);

    Box box2 = new Box(0, -1, -7);
    // print the new box, all attributes should be 1 
    System.out.println("box2 = " + box2);

    box2.changeSize(3);
    System.out.println("box2 after changeSize(3) = " + box2);

    System.out.println("volume of box1 = " + box1.calcVolume());
    System.out.println("surface of box1 = " + box1.calcSurface());

    Car car3 = new Car( car1);
    System.out.println("This is a copy Car " + car3);


    System.out.println("box1 width = " + box1.getWidth());
    box1.setWidth(-5);
    System.out.println("box1 width after setWidth(-5) = " + box1.getWidth());

    box1.setWidth(10);
    System.out.println("box1 width after setWidth(10)=" + box1.getWidth());
    
    Box b10 = new Box(5, 7, 4);
    Box b11 = b10;
    Box b12 = new Box(5, 7, 4);
    Box b13 = new Box(3, 6, 9);

    System.out.println("(b10 == b11) = " + (b10 == b11));
    System.out.println("b10.equals(b11) = " + b10.equals(b11));
    System.out.println("(b10 == b12) = " + (b10 == b12));
    System.out.println("b10.equals(b12) = " + b10.equals(b12));
    System.out.println("b12.equals(b13) = " + b12.equals(b13));


    System.out.println("car1 == car3 " + (car3 == car1));
    System.out.println("car1.equals(car3) " + car1.equals(car3));

    Account acc1 = new Account("AAA","BBB",123,1000);
    Account acc2 = new Account("AAA","BBB",123,1000);

    System.out.println("acc1 == acc2 " + (acc1 == acc2));
    System.out.println("acc1.equals(acc2) " + acc1.equals(acc2));

    } 

}