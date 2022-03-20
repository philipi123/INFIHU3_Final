package moser_aufgabe;


import java.sql.*;
import java.sql.SQLException;
import java.time.LocalDate;

public class Verleih {

	public static void dropVerleih(Connection c) {
		try {
			Statement s1 = c.createStatement();
			s1.executeUpdate("drop table if exists Verleih;");
			s1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void createVerleih(Connection c) {
		try {
			Statement s1 = c.createStatement();
			s1.executeUpdate("create table if not exists Verleih(kennzeichen varchar(20) not null, kundenid int not null, verleihd date, rueckgabedat date, primary key(kennzeichen, kundenid, verleihd), foreign key(kennzeichen) references Auto(kennzeichen) on delete restrict, foreign key(kundenid) references Kunde(id) on delete restrict);");
			s1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertVerleih(Connection c, String kennzeichen, int kundenid, LocalDate rueckgabedat) {
		try {
			java.sql.Date beginn = java.sql.Date.valueOf(LocalDate.now());
			java.sql.Date ende = java.sql.Date.valueOf(rueckgabedat);
			
			String s = "insert into Verleih(kennzeichen, kundenid, verleihd, rueckgabedat) values (?, ?, ?, ?);";
			PreparedStatement ps = c.prepareStatement(s);
			ps.setString(1, kennzeichen);
			ps.setInt(2, kundenid);
			ps.setDate(3, beginn);
			ps.setDate(4, ende);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
