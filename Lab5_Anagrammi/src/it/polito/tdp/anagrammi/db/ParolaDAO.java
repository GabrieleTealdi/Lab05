package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



import it.polito.tdp.anagrammi.model.Anagramma;

public class ParolaDAO {

	public List<Anagramma> controllaParoleEsatte(List<Anagramma> soluzioni) {
		List<Anagramma> solCorrette = new ArrayList<Anagramma>();
		try {
		Connection conn = ConnectDB.getConnection();
		for(Anagramma a: soluzioni) {
			
			String sql = "select * from parola p " +
					"where p.nome = ? ";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, a.toString());
			ResultSet rs = st.executeQuery();
			if(rs.next())
				solCorrette.add(a);
		}
		conn.close();
		return solCorrette;
		
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
