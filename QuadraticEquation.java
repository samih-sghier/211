
// Name:  Samih SGHIER
// Date:  09/16/2016
// CSC 211 - Lab 3 
//
// This program solves a quadratic equation, using the quadratic formula, and
// prints the two real roots, given the values of the coefficients a, b, and c,
// as input.

import java.util.*;

public class QuadraticEquation {
	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		giveIntro();
		System.out.print("Enter values for a, b, and c:");
		double x = console.nextDouble();
		double y = console.nextDouble();
		double z = console.nextDouble();

		System.out.println();
		printRoots(x, y, z);

	}

	public static void giveIntro() {
		System.out.println("Welcome");
		System.out.println("This program solves quadratic equations.");
		System.out.println();
	}
/* prints a table showing the roots of a quadratic equation involving a, b and c */
	public static void printRoots(double a, double b, double c) {
		double discriminant = b * b - 4 * a * c;
		double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
		double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
		System.out.println("First root = " + root1);
		System.out.println("First root = " + root2);

	}
}
