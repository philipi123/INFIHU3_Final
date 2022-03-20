package moser_aufgabe;

import java.sql.*;
import java.sql.SQLException;
import java.time.LocalDate;

public class Kunden {
	
	public static void dropKunde(Connection c) {
		try {
			Statement s = c.createStatement();
			s.executeUpdate("drop table if exists Kunde");
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void createKunde(Connection c) {
		try {
			Statement s = c.createStatement();
			s.executeUpdate("create table if not exists Kunde(id int primary key auto_increment, name varchar(20), gebdat date)");
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertKunde(Connection c, String name, LocalDate gebdat) {
		try {
			String s = "insert into Kunde (name, gebdat) values (?, ?);";
			PreparedStatement ps = c.prepareStatement(s);
			
			java.sql.Date geburtstag = java.sql.Date.valueOf(gebdat);
			ps.setString(1, name);
			ps.setDate(2, geburtstag);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
