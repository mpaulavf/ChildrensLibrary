package data;
import java.time.*;
import java.util.*;

public class Search {
	
	private ArrayList<String> keywords;
	private String wholeSearch;
	private ArrayList<String> genres;
	
	public Search(String wholeSearch, ArrayList<String> genres) {
		super();
		this.wholeSearch = wholeSearch;
		this.genres = genres;
	}
	
	public String setKeywords(String s) {
		return s;
	}
	
	public LocalDate returnTime(LocalDate d) {
		return d;
	}
	
	public ArrayList<String> getKeywords() {
		Scanner sc = new Scanner(wholeSearch);
		this.keywords = new ArrayList<String>();
		while (sc.hasNext()) {
			String temp = sc.next().trim();
			this.keywords.add(temp);
		}
		sc.close();
		return this.keywords;
	}
	public void setKeywords(ArrayList<String> keywords) {
		this.keywords = keywords;
	}
	
	public String getWholeSearch() {
		return wholeSearch;
	}
	public void setWholeSearch(String wholeSearch) {
		this.wholeSearch = wholeSearch;
	}
	
	public ArrayList<String> getGenres() {
		return genres;
	}
	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}

}
