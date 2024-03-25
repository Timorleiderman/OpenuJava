package unit_3;

public class UserCar {
    public static void main(String[] args) { //create new Box
    
    Car car1 = new Car("Tyoyta", 2005, 2587602);
    Car car2 = new Car("Ford", 2010, 2587602);
    Car car3 = new Car("BMWA", 2005, 7658412);
    
    System.out.println("car1 = " + car1);
    System.out.println("car2 = " + car2);
    System.out.println("car3 = " + car3);

    System.out.println("car1.older(car2) = " + car1.older(car2));
    System.out.println("car2.older(car1) = " + car2.older(car1));
    System.out.println("car3.older(car1) = " + car3.older(car1));
    System.out.println("car1.younger(car2) = " + car1.younger(car2));
    System.out.println("car2.younger(car1) = " + car2.younger(car1));

    } 

}