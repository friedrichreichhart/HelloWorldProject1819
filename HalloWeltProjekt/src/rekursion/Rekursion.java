package rekursion;

public class Rekursion {
	
	public static void main(String[] args) {
		ausgabe1(10000);
	}
	
	public static void ausgabe1(int zahl) {
		// das ist eine Reklursion
		// das ist die Abbruchbedingung
		if (zahl == 0)
			return;
		//
		zahl = zahl / 3;
		System.out.println(zahl);
		// rekursive Aufruf
		ausgabe1(zahl);
	}
	
	

}
