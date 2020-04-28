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
		
		MockupGenerator mockup1 = new MockupGenerator();
		
		SinglyLinkedList <Book> libros = new SinglyLinkedList(); 
		
		mockup1.generateBooks(1000, libros);
		
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
			//setGenres();
			objectIn.close();
		}
		catch (IOException e) {
			System.out.println(books.size() + " libros recuperados");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
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
	*/
}

