package moser_aufgabe;

import java.sql.*;
import java.time.LocalDate;

import hausuebung_2.Klasse;
import hausuebung_2.Schueler;
import hausuebung_2.SchuelerZuKlasse;

public class Runner {
	public static Connection createConnection() {

		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/autoverleih", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}
	}
	
	public static void main(String[] args) {
		try {
			Connection c = createConnection();
			System.out.println("Connection erfolgreich\n");
			c.setAutoCommit(true);
			
			System.out.println("tabellen löschen");
			Verleih.dropVerleih(c);
			Autos.dropAutos(c);
			Kunden.dropKunde(c);
			System.out.println("OK");
			
			System.out.println("tabellen erstellen");
			Autos.createAutos(c);
			Kunden.createKunde(c);
			Verleih.createVerleih(c);
			System.out.println("OK");
			
			System.out.println("\nAutos einfügen");
			Autos.insertAutos(c, "Tesla Model S", "SZ-899-YC", 50000.00);
			
			
			System.out.println("\nKunden einfügen");
			Kunden.insertKunde(c, "Alois Mayer", LocalDate.of(2004, 06, 03));
			
			System.out.println("\nVerleih durchführen");
			Verleih.insertVerleih(c, "SZ-899-YC", 1, LocalDate.of(2021, 01, 01));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
