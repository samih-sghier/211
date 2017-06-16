// Name : Samih SGHIER   This program runs a table of outputs for how many meters an object falls after a certain time \\
public class WandDropTable {
	public static final double GRAVITY = 1.62;

	public static void main(String[] arg) {
		System.out.println("Time\tDistance");
		for (int time = 0; time <= 10; time++) {
			System.out.print(time);
			System.out.print("\t");
			double distance = 1.0 / 2 * GRAVITY * time * time;
			System.out.println(distance);
		}
	}
}
