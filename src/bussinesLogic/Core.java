package bussinesLogic;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;

import basicData.*;
import data.*;
import ui.*;

public class Core {
	
	private static TreeSet<Book> books = new TreeSet<Book>();
	private static TreeMap<String,TreeSet<Book>> genres;
	
	public static void main(String[] args) {
		
		ArrayList<String> g1 = new ArrayList<String>();
		g1.add("Cuento");
		
		Book book = new Book("Libro 0 Fabula", "123", "Pepito", g1, "", null);
		Book book1 = new Book("Libro 1 Fabula", "123", "Pepito", g1, "", null);
		Book book2 = new Book("Libro 2 Fabula", "123", "Pepito", g1, "", null);
		
		books.add(book);
		books.add(book1);
		books.add(book2);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI(new TreeMap<String,String>(), new TreeSet<Book>());
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public static TreeMap<String,TreeSet<Book>> getGenres(){
		return genres;
	}
	public static TreeSet<Book> getBooks(){
		loadBooks();
		return books;
	}
	public static void addBook(Book book) {
		books.add(book);
		saveBooks();
	}
	public static void saveBooks() {
		try {
			FileOutputStream fileOut = new FileOutputStream("Resources/SerializedObjects/Books");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(books);
			System.out.println(books.size() + " libros guardados");
			objectOut.close();
		}
		catch (IOException e) {
			System.out.println("No se han guardado los libros");
		}
	}
	public static void loadBooks() {
		System.out.println("cargando los libros");
		try {
			final FileInputStream fileIn =
					new FileInputStream("Resources/SerializedObjects/Books");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			books = (TreeSet<Book>) objectIn.readObject();
			System.out.println(books.size() + " libros recuperados");
			setGenres();
			objectIn.close();
		}
		catch (IOException e) {
			System.out.println(books.size() + " libros recuperados");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void setGenres() {
		genres = new TreeMap<String,TreeSet<Book>>();
		genres.put("Cuento", new TreeSet<Book>());
		genres.put("Fábula", new TreeSet<Book>());
		genres.put("Mitos y leyendas", new TreeSet<Book>());
		genres.put("Acción", new TreeSet<Book>());
		genres.put("Aventura", new TreeSet<Book>());
		genres.put("Disney", new TreeSet<Book>());
		
		for (Book book: books) {
			for (String genre : book.getGenres()) {
				genres.get(genre).add(book);
			}
		}
		
	}
}