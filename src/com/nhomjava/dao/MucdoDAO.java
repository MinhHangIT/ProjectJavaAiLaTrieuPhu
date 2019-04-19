package com.nhomjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nhomjava.entity.CauHoi;
import com.nhomjava.entity.MucDo;

public class MucdoDAO implements InterfaceMucdo {

	@Override
	public MucDo get1(int id) {
		
		MucDo mucdo=new MucDo();
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from MUCDO as c where c.idmucdo=? ";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				mucdo.setIdmucdo(rs.getInt("idmucdo"));
				mucdo.setTenmucdo(rs.getString("tenmucdo"));
				mucdo.setDiem(rs.getFloat("diem"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mucdo;
	}

	@Override
	public ArrayList<MucDo> getlist() {
		ArrayList<MucDo> list=new ArrayList<>();
		
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from MUCDO";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
		
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				MucDo mucdo=new MucDo();
				mucdo.setIdmucdo(rs.getInt("idmucdo"));
				mucdo.setTenmucdo(rs.getString("tenmucdo"));
				mucdo.setDiem(rs.getFloat("diem"));
				list.add(mucdo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean them(MucDo mucdo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(MucDo mucdo) {
		Connection conn=new ConnectionDao().getConnection();
		String sql="update MUCDO set Tenmucdo =N'"+mucdo.getTenmucdo()+"' , Diem =? where Idmucdo=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			
			pre.setFloat(1, mucdo.getDiem());
			pre.setInt(2, mucdo.getIdmucdo());
			int tmp=pre.executeUpdate();
			if (tmp==1) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean xoa(MucDo mucdo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
