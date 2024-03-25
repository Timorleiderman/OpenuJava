package unit_3;

public class UserBox {
    public static void main(String[] args) { //create new Box
    
   
    Box box1 = new Box(4, 3, 2);
    // print the box 
    System.out.println("box1 = " + box1);

    System.out.println("box1 width = " + box1.getWidth());
    box1.setWidth(-5);
    System.out.println("box1 width after setWidth(-5) = " + box1.getWidth());

    box1.setWidth(10);
    System.out.println("box1 width after setWidth(10)=" + box1.getWidth());

    Box b10 = new Box(5, 7, 4);
    Box b11 = b10;
    Box b12 = new Box(5, 7, 4);
    Box b13 = new Box(3, 6, 9);
    
    System.out.println("b10 length = " + b10.getLength());
    System.out.println("b12 length = " + b12.getLength());
    System.out.println("b13 length = " + b13.getLength());
    System.out.println("b10.longer(b12) = " + b10.longer(b12));
    System.out.println("b10.shorter(b12) = " + b10.shorter(b12));
    System.out.println("b10.longer(b13) = " + b10.longer(b13));

    } 

}