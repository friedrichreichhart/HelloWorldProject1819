package basics;

public class Schleife {
	public static void main(String[] args) {
		// FOR-Schleife
		// 1. variable dekleration & zuweisung
		// 2. die bedinung
		// 3. increment / decrement
		for (int i = 0; i < 10; i=i+1) {
			System.out.println("Zahl: " + i);
		}
		//
		int j = 0;
		for (; j < 100;) {
			System.out.println(j);
			j = j+1;
		}
	}
}
