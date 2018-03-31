/**
 * @author: Lukas Schütte
 */

package beans;

import java.io.Serializable;


public class Chapter implements Serializable{

    private Integer id;
    private String title;
    private String text;
    
    public Chapter(Integer id){
    	setID(id);
    }
    
    
    public void setID(int id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
    
   
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

 