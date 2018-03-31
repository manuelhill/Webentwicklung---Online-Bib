/**
 * @author: Lukas Schütte
 */
document.addEventListener("DOMContentLoaded", init);


function init()
{
	document.getElementById("btUserData").addEventListener("click", loadUserData);
}
function loadUserData()
{
    var xmlhttp = new XMLHttpRequest();
    var url="userVerwaltungServlet";
    
    xmlhttp.onreadystatechange = function()
    {
    	if (xmlhttp.readyState==4 && xmlhttp.status==200)
    	{
    		var xml = xmlhttp.responseXML;
        	var ausgabe ="<table><tr><th>Userid</th><th>Username</th><th>Vorname</th><th>Nachname</th><th>Passwort</th><th>Admin</th></tr>";
        	
        	var j = xml.getElementsByTagName("userid").length;
        	
        	ausgabe += "<tr><td>";
        	
        	for(var i=0; i < j; i++)
        	{
        		ausgabe += "<tr>";
        		ausgabe += "<td>";
        		ausgabe += xml.getElementsByTagName("userid")[i].firstChild.nodeValue;
                ausgabe += "</td>";		
            	ausgabe += "<td>";
            	ausgabe += xml.getElementsByTagName("username")[i].firstChild.nodeValue;
            	ausgabe += "</td>";
            	ausgabe += "<td>";
            	ausgabe += xml.getElementsByTagName("vorname")[i].firstChild.nodeValue;
            	ausgabe += "</td>";
            	ausgabe += "<td>";
            	ausgabe += xml.getElementsByTagName("nachname")[i].firstChild.nodeValue;
            	ausgabe += "</td>";
            	ausgabe += "<td>";
            	ausgabe += xml.getElementsByTagName("password")[i].firstChild.nodeValue;
            	ausgabe += "</td>";
            	ausgabe += "<td>";
            	ausgabe += xml.getElementsByTagName("admin")[i].firstChild.nodeValue;
            	ausgabe += "</td>";
            	ausgabe += "</tr>";
            	
        	}
        	ausgabe += "</table>";
        	document.getElementById("div_user").innerHTML = ausgabe;
    	}
    	
    }
    xmlhttp.open("GET", url, true);
        xmlhttp.send();
}
