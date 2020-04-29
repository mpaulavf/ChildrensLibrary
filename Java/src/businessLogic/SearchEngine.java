package businessLogic;

import java.util.*;

import data.*;

public class SearchEngine {
	
	public TreeMap<String,TreeSet<Book>> genres;
	public TreeSet<Book> everyBook;
	public TreeSet<Book> booksByAuthor = new TreeSet<Book>();
	public TreeSet<Book> booksByName = new TreeSet<Book>();
	public TreeSet<Book> booksByGenre = new TreeSet<Book>();
	
	public SearchEngine(Search search) {
		everyBook = Core.getBooks();
		SearchByAuthor(search);
		SearchByName(search);
//		SearchByGenres(search);
	}
	
	private void SearchByAuthor(Search search) {
		for (Book book: this.everyBook) {
			String authorName = book.getAuthorName();
			Scanner sc = new Scanner(authorName);
			ArrayList<String> singleWordsAuthorName = new ArrayList<String>();
			while (sc.hasNext()) {
				String temp = sc.next().trim();
				singleWordsAuthorName.add(temp);
			}
			sc.close();
			for (String keyword : search.getKeywords()) {
				if(authorName.equals(keyword)) {
					booksByAuthor.add(book);
				}
				else {
					for (String singleWordAN: singleWordsAuthorName) {
							if (singleWordAN.equals(keyword)){
								booksByAuthor.add(book);
							}
					}
				}
			}
		}
	}
	
	private void SearchByName(Search search) {
		for (Book book: this.everyBook) {
			String bookName = book.getName();
			if (bookName.equals(search.getWholeSearch())) {
				booksByName.add(book);
			}
			Scanner sc = new Scanner(bookName);
			ArrayList<String> singleWordsBookName = new ArrayList<String>();
			while (sc.hasNext()) {
				String temp = sc.next().trim();
				singleWordsBookName.add(temp);
			}
			sc.close();
			for (String keyword : search.getKeywords()) {
				if(bookName.equals(keyword)) {
					booksByName.add(book);
				}
				else {
					for (String singleWordBN: singleWordsBookName) {
							if (singleWordBN.equals(keyword)){
								booksByAuthor.add(book);
							}
					}
				}
			}
		}
		
	}

	/*
	private void SearchByGenres(Search search) {
		//Core.setGenres();
		if (search.getWholeSearch().equals("")) {
			for (String genreInSearch: search.getGenres()) {
				if (this.genres.containsKey(genreInSearch)) {
					this.booksByGenres.addAll(this.genres.get(genreInSearch));
				}
			}
		}
		else {
			TreeSet<Book> booksByNameAndAuthor = new TreeSet<Book>();
			booksByNameAndAuthor.addAll(this.booksByAuthor);
			booksByNameAndAuthor.addAll(this.booksByName);
			for (String genreInSearch: search.getGenres()) {
				try {
					if (this.genres.containsKey(genreInSearch)) {
						TreeSet<Book> booksOfThisGenre = this.genres.get(genreInSearch);
						for (Book bookOfThisGenre: booksOfThisGenre) {
							if (booksByNameAndAuthor.contains(bookOfThisGenre)) {
								this.booksByGenres.add(bookOfThisGenre);
							}
						}
					}
				}
				catch (NullPointerException e) {
					System.out.println("Error en la b�squeda de g�neros");
				}
			}
		}
	}
	*/

	public TreeSet<Book> getBooksByAuthor() {
		return booksByAuthor;
	}

	public TreeSet<Book> getBooksByName() {
		return booksByName;
	}

	public TreeSet<Book> getBooksByGenre() {
		return booksByGenre;
	}

	
}