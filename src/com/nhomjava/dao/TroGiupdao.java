package com.nhomjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nhomjava.entity.CauHoi;
import com.nhomjava.entity.TroGiup;

public class TroGiupdao {

	public TroGiup get1(int id) {
		TroGiup trogiup=new TroGiup();
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from TROGIUP as c where c.idtrogiup=? ";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				trogiup.setIdtrogiup(rs.getInt("idtrogiup"));
				trogiup.setTentrogiup(rs.getString("tentrogiup"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trogiup;
	}
}
