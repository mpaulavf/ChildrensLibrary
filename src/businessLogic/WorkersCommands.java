package businessLogic;

import java.awt.image.*;
import java.io.*;
import java.util.*;

import data.Book;

public class WorkersCommands {

	public TreeMap<String, String> validWorkers = new TreeMap<String, String>();
	
	public WorkersCommands() {
		loadWorkers();
	}
	
	public void loadWorkers() {
		System.out.println("cargando la informaci�n de los trabajadores");
		try {
			final FileInputStream fileIn =
					new FileInputStream("Resources/SerializedObjects/ValidWorkers");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			this.validWorkers = (TreeMap<String,String>) objectIn.readObject();
			System.out.println(this.validWorkers.size() + " trabajadores recuperados");
			objectIn.close();
		}
		catch (IOException e) {
			System.out.println(this.validWorkers.size() + " trabajadores recuperados");
			this.validWorkers.put("12345", "54321");
			saveWorkers();
		}
		catch (ClassNotFoundException e) {
			this.validWorkers.put("12345", "54321");
			saveWorkers();
		}
	}
	
	public void saveWorkers() {
		try {
			FileOutputStream fileOut =
					new FileOutputStream("Resources/SerializedObjects/ValidWorkers");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(this.validWorkers);
			System.out.println(this.validWorkers.size() + " trabajadores guardados");
			objectOut.close();
		}
		catch (IOException e) {
			System.out.println("No se han guardado los trabajadores");
		}
	}
	
	public boolean login(String id, String pw){
	
		boolean validWorker = false;
		if (validWorkers.get(id).equals(pw)) validWorker = true; 
		return validWorker;
	}
	
	public Book infoBook(File x) {
		
		Scanner aux;
		try {
			aux = new Scanner(x);
		} catch (FileNotFoundException e) {
			return null;
		}
		aux.useDelimiter(",");
		// inicializamos variables
		String name = "";
		String code;
		String authorName = "";
		ArrayList<String> genres = new ArrayList<String>();
		String direction = "";
		BufferedImage picture = null;
		// nombre del libro
		String temp = aux.next().trim();
		name = temp;
		// code del libro
		temp = aux.next().trim();
		code = temp;
		// nombre del autor libro
		temp = aux.next().trim();
		authorName = temp;
		// genero del libro
		temp = aux.next().trim();
		int amountOfGenres = Integer.parseInt(temp);
		for (int i = 0; i<amountOfGenres; i++) {
			temp = aux.next().trim();
			genres.add(temp);
		}
		Book b = new Book(name, code, authorName, genres, direction, picture);
		aux.close();
		return b;
		
	}

	public Book addPicture(Book book, BufferedImage bI) {
		book.setPicture(bI);
		return book;
	}
	
	
	public Book addDirections(Book book, String s) {
		book.setDirection(s);
		return book;
	}
	
}