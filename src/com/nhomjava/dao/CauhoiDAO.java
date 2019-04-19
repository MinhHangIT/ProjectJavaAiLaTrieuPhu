package com.nhomjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nhomjava.entity.CauHoi;

public class CauhoiDAO implements InterfaceCauHoi {

	@Override
	public CauHoi get1(int id) {
		CauHoi cauhoi=new CauHoi();
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from CAUHOI as c where c.idcauhoi=? ";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				cauhoi.setIdcauhoi(rs.getInt("idcauhoi"));
				cauhoi.setCauhoi(rs.getString("Cauhoi"));
				cauhoi.setMucdo(rs.getInt("idmucdo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cauhoi;
	}

	@Override
	public ArrayList<CauHoi> getlist() {
		ArrayList<CauHoi> list=new ArrayList<>();
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from CAUHOI ";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				CauHoi cauhoi=new CauHoi();
				cauhoi.setIdcauhoi(rs.getInt("idcauhoi"));
				cauhoi.setCauhoi(rs.getString("Cauhoi"));
				cauhoi.setMucdo(rs.getInt("idmucdo"));
				list.add(cauhoi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean them(CauHoi cauhoi) {
		Connection conn=new ConnectionDao().getConnection();
		String sql="insert into CAUHOI(Idcauhoi,Cauhoi,idmucdo) values (?,N'"+cauhoi.getCauhoi()+"',?)";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, cauhoi.getIdcauhoi());
			
			pre.setInt(2, cauhoi.getMucdo());
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
	public boolean update(CauHoi cauhoi) {
		
		Connection conn=new ConnectionDao().getConnection();
		String sql="update CAUHOI set Cauhoi =N'"+cauhoi.getCauhoi()+"' , Idmucdo =? where Idcauhoi=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			
			pre.setInt(1, cauhoi.getMucdo());
			pre.setInt(2, cauhoi.getIdcauhoi());
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
	public boolean xoa(CauHoi cauhoi) {
		Connection conn=new ConnectionDao().getConnection();
		String sql="delete CAUHOI where idcauhoi=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			
			pre.setInt(1, cauhoi.getIdcauhoi());
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
	public CauHoi getngaunhien(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CauHoi> gettheomucdo(int idmucdo) {
		ArrayList<CauHoi> list=new ArrayList<>();
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from CAUHOI as c where c.idmucdo=? ";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, idmucdo);
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				CauHoi cauhoi=new CauHoi();
				cauhoi.setIdcauhoi(rs.getInt("idcauhoi"));
				cauhoi.setCauhoi(rs.getString("Cauhoi"));
				cauhoi.setMucdo(rs.getInt("idmucdo"));
				list.add(cauhoi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public CauHoi gettheocauhoi(CauHoi cauhoi) {
		CauHoi ch=new CauHoi();
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from CAUHOI as c where c.Cauhoi=? ";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, cauhoi.getCauhoi());
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				ch.setIdcauhoi(rs.getInt("idcauhoi"));
				ch.setCauhoi(rs.getString("Cauhoi"));
				ch.setMucdo(rs.getInt("idmucdo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ch;
	}
	
	

}
