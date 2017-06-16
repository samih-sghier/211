// NAME : Samih SGHIER  Date : 09/ 09 /2016
public class Lab2 {
	public static final int SIZE = 8;

	public static void main(String[] arg) {
		line1();
		shape();

		line1();
	}

	public static void line1() {
		for (int i = 1; i <= SIZE * 2 + 4; i++) {
			System.out.print("X");
		}
		System.out.println();
	}

	public static void shape() {
		for (int LINE = 0; LINE <= SIZE -1; LINE++) {
			System.out.print("X");

			for (int y = 1; y <= -1 * LINE + SIZE; y++) {

				System.out.print("~");
			}

			System.out.print("/");
			for (int dots = 1; dots <= (LINE *  2 ); dots++) {
				
				System.out.print(".");
			}
			System.out.print("\\");

			for (int y = 1; y <= -1 * LINE + SIZE; y++) {
				System.out.print("~");
			}
			System.out.print("X");
			System.out.println();

		}

		System.out.print("X~");
		for (int w = 1; w <= SIZE * 2; w++) {
			System.out.print("-");
		}
		System.out.print("~X");
		System.out.println();

		System.out.print("X");
		for (int s = 1; s <= SIZE; s++) {
			System.out.print("~");
		}
		System.out.print("||");
		for (int s = 1; s <= SIZE; s++) {
			System.out.print("~");
		}
		System.out.println("X");

	}
}