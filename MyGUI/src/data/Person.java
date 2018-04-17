package data;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Person {
private static ArrayList<Person>PersonenListe = new ArrayList<>();
public static ArrayList<Person> getPersonenListe(){
return PersonenListe;


}

public static void write2JASON() throws IOException {
	Writer writer = new FileWriter("C:\\temp\\output.json");
	Gson gson = new GsonBuilder().serializeNulls().create();
	gson.toJson(Person.getPersonenListe(), writer);
	writer.flush();
	writer.close();
}

public Person() {

}
	private String vorname;

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	private String nachname;

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	private String adresse;
	
	
	
	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}
	private String strasse;
	
	
	private String ort;
	
	
	
	private int plz;
	//
	@Override
	public String toString() {
		return getVorname() + " " + getNachname() + " " + getAdresse() + " " + getStrasse() + " " + getOrt() + " " + getPlz();
	
	}
	
}

