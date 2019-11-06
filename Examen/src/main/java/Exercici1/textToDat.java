package Exercici1;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class textToDat {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stu

		Gat c = llegirClasse("gat.txt");
		System.out.println(c);
		escriureClasse(c);
		
		

	}

	static public void escriureClasse(Gat c) {
		try {

			File f = new File("gat.dat");
			FileOutputStream fol = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fol);
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

	}

	static public Gat llegirClasse(String a) throws IOException {
		try {

			FileInputStream file = new FileInputStream(a);
			ObjectInputStream in = new ObjectInputStream(file);
			

			Gat c = (Gat) in.readObject();
System.out.println(c);
			in.close();
			file.close();
			return c;

		}

		catch (IOException ex) {
		}

		catch (ClassNotFoundException ex) {
		}
		return null;
	}
	
}
