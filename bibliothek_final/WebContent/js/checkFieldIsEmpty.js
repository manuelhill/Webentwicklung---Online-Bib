/**
 * @author: Manuel Hill
 */

function checkFieldIsEmpty(){
	
	var searchString = document.getElementById("searchStringId").value;
	
	if(searchString == ""){
		alert("Das Suchfeld darf nicht leer sein!")
	} else if(searchString != ""){
		var form = document.getElementById("searchform");
		form.submit();
	}
}