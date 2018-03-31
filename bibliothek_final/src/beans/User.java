/**
 * @author: Manuell Hill
 */

package beans;

import java.io.Serializable;

public class User implements Serializable{
		
    private Integer id;
    private String vorname;
    private String nachname;
    private String username;
    private String password;
    private int admin;
   
    public User(){
    }

    public void setId(int id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
    
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}
}

 