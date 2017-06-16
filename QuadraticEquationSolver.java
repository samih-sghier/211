// Name:  Samih Sghier  
// Date:  09/16/2016
// CSC 211 - Lab 3 
//
// This program solves a quadratic equation, using the quadratic formula, and
// prints the two real roots, given the values of the coefficients a, b, and c,
// as input.

// TODO: remove this comment and put any needed import statements up here...

import java.util.*;

public class QuadraticEquationSolver {
	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		System.out.println("Welcome");
		System.out.println("This program solves quadratic equations.");
		System.out.println();
		System.out.print("Enter values for a, b, and c:");
		double a = console.nextDouble();
		double b = console.nextDouble();
		double c = console.nextDouble();
		double discriminant = b * b - 4 * a * c;
		double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
		double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

		System.out.println();

		System.out.println("First root = " + root1);
		System.out.println("First root = " + root2);
		
	}
}