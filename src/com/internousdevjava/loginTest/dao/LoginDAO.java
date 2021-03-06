package com.internousdevjava.loginTest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdevjava.loginTest.util.DBConnector;;

public class LoginDAO {
	private boolean res;
	private Connection con;
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;

	public boolean select(String id, String password){ //DAOのselectの戻りはboolean
		res = false;

		try{
			con = (Connection)DBConnector.getConnection();
			sql = "SELECT * FROM login_table WHERE";  //login_tableがテーブル名
			sql+= " id = ? AND password = ? ";

			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);

			rs = ps.executeQuery(); //更新した件数、アップデートした件数

			if(rs.next()){
				res = true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return res;
	}
}