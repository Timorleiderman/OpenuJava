package Lectures.Lesson1;

import java.util.Scanner;

public class BMI {

    public static void main(String [] args) { 
    System.out.println("Enter weight and height");
    double weight;
    double height;

    Scanner scanner = new Scanner(System.in);

    weight = scanner.nextDouble();
    height = scanner.nextDouble();

    // double bmi = weight / ( height * height);
    double bmi = weight / Math.pow(height, 2);

    System.out.println("The BMI of " + weight + " & " + height + " = " + bmi);

    scanner.close();
    }
}
