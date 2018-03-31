/**
 * @author Manuel Hill
 */

function comparePasswords(){
	var jsPassword = document.getElementById("id_password").value;
	var jsRepeatPassword = document.getElementById("id_repeatPassword").value;
	var jsUsername = document.getElementById("id_username").value
	
//	alert(jsPassword);
//	alert(jsRepeatPassword);
//	alert(jsUsername);
	
	if(jsUsername == ""){
		alert("Der Benutzername darf nicht leer sein!")
	} else if(jsPassword == ""){
		alert("Das Passwort darf nicht leer sein!")
	} else if(jsRepeatPassword == ""){
		alert("Das Feld Passwort wiederholen darf nicht leer sein!")
	} else if(jsPassword == jsRepeatPassword){
		var form = document.getElementById("register");
		form.submit();
	} else{
		alert("Die eingegebenen Passwoerter stimmen nicht ueberein");
	}
}