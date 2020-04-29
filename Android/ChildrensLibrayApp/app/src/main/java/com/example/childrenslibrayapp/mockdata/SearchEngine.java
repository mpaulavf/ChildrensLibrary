package com.example.childrenslibrayapp.mockdata;

import android.hardware.usb.UsbInterface;

import com.example.childrenslibrayapp.objects.Book;
import com.example.childrenslibrayapp.objects.Search;
import com.example.childrenslibrayapp.structures.DynamicArray;
import com.example.childrenslibrayapp.structures.Node;
import com.example.childrenslibrayapp.structures.SinglyLinkedList;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchEngine {

    public SinglyLinkedList <Book> allBooks;
    public SinglyLinkedList <Book> booksByAuthor = new SinglyLinkedList <Book>();
    public SinglyLinkedList <Book> booksByName = new SinglyLinkedList <Book>();
    public SinglyLinkedList <Book> booksByGenre = new SinglyLinkedList <Book>();
    public SinglyLinkedList <Book> booksByCode = new SinglyLinkedList <Book>();

    public SearchEngine(Search search) {
        searchByAuthor(search);
        searchByName(search);
        searchByGenres(search);

    }

    public SinglyLinkedList <Book> getAllBooks() { return allBooks; }
    public void setAllBooks(SinglyLinkedList <Book> allBooks) { this.allBooks = allBooks; }

    public void searchByAuthor(Search search) {
        Node temp = allBooks.head;
        Book aux = (Book) temp.data;
        if (temp == null) return;
        while (true) {
            String authorName = aux.getAuthorName();
            Scanner sc = new Scanner(authorName);
            DynamicArray<String> singleAuthorName = new DynamicArray <String>();
            while (sc.hasNext()) {
                String temp = sc.next().trim();
                singleAuthorName.pushBack(temp);
            }
            sc.close();
            while (String keyword : search.getTempSearch() {
                if(authorName.equals(keyword)) {
                    booksByAuthor.add(book);
                }
                else {
                    for (String singleWordAN: singleAuthorName) {
                        if (singleWordAN.equals(keyword)){
                            booksByAuthor.add(book);
                        }
                    }
                }
            }
        }
        return booksByAuthor;
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
					System.out.println("Error en la bï¿½squeda de gï¿½neros");
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
