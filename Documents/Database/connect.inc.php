<?php
    $_db_host = "localhost";
    $_db_username = "root";
    $_db_passwort = "";
    $_db_datenbank = "emp_mobile";

    # Verbindung zur Datenbank herstellen
    $_link = mysql_connect($_db_host, $_db_username, $_db_passwort);

    # Prüfen ob die Verbindung geklappt hat
    if (!$_link)
        {
        # Nein, also das ganze Skript abbrechen !
        die("Keine Verbindung zur Datenbank möglich: " .
            mysql_error());
        }

    # Verbindung hat geklappt, weiter ...
    echo "Verbindung zur Datenbank erfolgreich.<br>";
    
    # Datenbank auswählen
    mysql_select_db("$_db_datenbank");
 
    
    $abfrage = "SELECT * FROM contacts";
    $ergebnis = mysql_query($abfrage);
    while($row = mysql_fetch_object($ergebnis))
        {
        echo ("$row->name \n");
        echo ("$row->surname, \n");
        echo("<br>");
        }
?>
