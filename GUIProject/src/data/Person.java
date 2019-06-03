package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class Person {
	//
	private static ArrayList<Person> personenListe = new ArrayList<>();
	//
	private String vorname;
	private String nachname;
	private String plz = null;
	private String ort = null;
	//
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	@Override
	public String toString() {
		return getNachname() + ", " + getVorname() + " (" 
				+ getPlz() + " " + getOrt() + ")";
	}
	//
	public static ArrayList<Person> getPersonenListe() {
		return personenListe;
	}
	//
	public static void loadPersonenFromFile(String filename) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		gson.serializeNulls();
		//
		FileReader fr;
		try {
			//
			fr = new FileReader(filename);
			//
			
			//
			Person[] personen = gson.fromJson(fr, Person[].class);
			personenListe = new ArrayList<Person>(Arrays.asList(personen));
			//
			System.out.println(gson.toJson(personenListe));
			//
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
