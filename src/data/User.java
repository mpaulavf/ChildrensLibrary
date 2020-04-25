package data;
import java.time.*;

public class User {
	
	private LocalDate date;
	private String search;
	
	public User(LocalDate date, String search) {
		super();
		this.date = date;
		this.search = search;
	}
	
	public String plusTwoWeeks(LocalDate today) {
		
		LocalDate twoWeeks = today.plusWeeks(2);
		return "La fecha de hoy es: " + today + "\n"
			 + "Debes devolver el libro antes del día: " + twoWeeks;
		
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}

}
