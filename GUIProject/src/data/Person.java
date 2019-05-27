package data;

import java.util.ArrayList;

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

}
