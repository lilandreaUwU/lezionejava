package com.itsdigitaladcademy.corsocyber.buisness;

import java.io.*;
import java.util.*;

import com.itsdigitaladcademy.corsocyber.beans.Libro;

public class LeggiFile{
File filein;
static ArrayList<Libro> scaffale= new ArrayList<Libro>();
public static void main(String[]a){
	try{
		LeggiFile lf = new LeggiFile(); //creo l'istanza leggifile
		File fileIn = new File("C:\\Users\\ACassani\\Desktop\\titoli_gennaio_marzo.txt");
		FileReader reader = new FileReader(fileIn);
		BufferedReader bReader = new BufferedReader (reader);
		String riga = bReader.readLine();
		while(riga !=null) {    //finchè ci sono righe
			 
			Libro libro = lf.creaLibro(riga);   //leggi righe
			scaffale.add(libro); 
			 riga = bReader.readLine(); 
			 
		}
	     bReader.close();
	     reader.close();

		
		
		//-----
			for(Libro libro: scaffale){
				System.out.println(libro.toString());
				
			}
			System.out.println("I libri sono: " + scaffale.size()); //stampo il numero di libri dalla grandenza(.size) della libreria
		
	} catch(Exception e){
		e.printStackTrace();//mi dice la riga dell'errore
		System.err.println("si è verificato un errore:" +e.getMessage());
		}
	}
private Libro creaLibro(String riga) {    //creo il metodo Libro, che prenderà i dati dal bean per creare il libro
	Libro libro = new Libro();
	String[] dati = new String[6];
	dati = riga.split(";");                //.split serve per separare i dati all' interno del file con un ";"
	
	libro.setCodiceSocieta(dati[0]);
	libro.setdescrizioneSocieta(dati[1]);
	libro.setisbn(dati[2]);
	libro.setcheckDigit((dati)[3].toString());
	libro.setautore(dati[4]);
	libro.settitolo(dati[5]);
	
	return libro;
}


}

