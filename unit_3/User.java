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
    
    } 

}