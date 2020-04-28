package businessLogic;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import basicData.SinglyLinkedList;
import data.*;
import ui.*;

public class Core {
	
	private static TreeSet<Book> books = new TreeSet<Book>();
	private static TreeMap<String,TreeSet<Book>> genres;
	
	public static void main(String[] args) {
		Random ran = new Random();

		ArrayList<String> g1 = new ArrayList<String>();
		g1.add("Cuento");
		
		Book book = new Book("Libro 0 Fabula", "123", "Pepito", g1, "", null);
		Book book1 = new Book("Libro 1 Fabula", "123", "Pepito", g1, "", null);
		Book book2 = new Book("Libro 2 Fabula", "123", "Pepito", g1, "", null);

		String code =  ran.nextInt(1000) + "." + ran.nextInt(1000);
		String code1 = ("0."+code);

		System.out.println(code1);

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
		genres.put("F�bula", new TreeSet<Book>());
		genres.put("Mitos y leyendas", new TreeSet<Book>());
		genres.put("Acci�n", new TreeSet<Book>());
		genres.put("Aventura", new TreeSet<Book>());
		genres.put("Disney", new TreeSet<Book>());
		
		for (Book book: books) {
			for (String genre : book.getGenre()) {
				genres.get(genre).add(book);
			}
		}
		
	}

	public static SinglyLinkedList<Book> createBookList (String filePath){
		SinglyLinkedList<Book> books = new SinglyLinkedList<>();

		try(BufferedReader br = new BufferedReader(filePath, StandardCharsets.UTF_8)){
			String line = br.readLine();

			while (line != null) {
				String [] attributes = line.split(",");

				Book book = createBook (attributes);

				books.insertNodeAtTail(books.head, book);

				line = br.readLine();
			}


		}catch (IOException ioe){
			ioe.printStackTrace();
		}
		return  books;
	}

	private static Book createBook(String[] metadata){
		String name = metadata[0];
		int code = metadata[1];
		String authorName = metadata[2];
		String genre = metadata [3];
		return Book (name, code, authorName, genre);
	}
}

