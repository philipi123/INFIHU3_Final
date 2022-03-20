package moser_aufgabe;

import java.sql.*;
import java.time.LocalDate;

public class Autos {
	
	public static void dropAutos (Connection c) {
		try {
			Statement s = c.createStatement();
			s.executeUpdate("drop table if exists Auto");
			s.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	
}
	
	public static void createAutos (Connection c) {
		try {
			Statement s = c.createStatement();
			s.executeUpdate("create table if not exists Auto(modellname varchar(30), kennzeichen varchar(20) primary key, preis double);");
			s.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	
}
	
	public static void insertAutos (Connection c, String modellname, String kennzeichen, double preis) {
		try {
			String s = "insert into Auto(modellname, kennzeichen, preis) values (?, ?, ?);";
			
			PreparedStatement ps = c.prepareStatement(s);
			ps.setString(1, modellname);
			ps.setString(2, kennzeichen);
			ps.setDouble(3, preis);
			ps.executeUpdate();
			ps.close();
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
