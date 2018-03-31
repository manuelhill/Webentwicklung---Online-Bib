/**
 * @author: Lukas Sch¸tte
 */

package beans;

import java.io.Serializable;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * assignedCategories -> Liste von CategoryBean, hierin werden die vom User in
	 * der personalProfile ausgew√§hlten Categories gespeichert
	 */
    private Integer id;
    private String title;
    private String author;
    private int year;
    
    public Book(Integer id){
    	setID(id);
    }
    
   public int getID()   {
	   return this.id;
   }
    
    public void setID(int id) {
		this.id = id;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
    
    /**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the surname
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the email
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param email the email to set
	 */
	public void setYear(int year) {
		this.year = year;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

 