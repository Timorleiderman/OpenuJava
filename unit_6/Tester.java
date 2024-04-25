package unit_6;

public class Tester {
    
    public static void main(String[] args) {
        SalariesStatistics salar = new SalariesStatistics();

        System.out.println("Best Yossi Salary: " + salar.bestSalary("Yossi"));
        System.out.println("Max in Month 10: " + salar.maxInMonth(10));
        System.out.println("Avarage in Month 10: " + salar.avrByMonth(10));
        System.out.println("bestMonth: " + salar.bestMonth());
        System.out.println("bestWorker: " + salar.bestWorker());
    }
}
