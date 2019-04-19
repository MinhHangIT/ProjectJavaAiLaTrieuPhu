package com.nhomjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nhomjava.entity.CauHoi;
import com.nhomjava.entity.CauTraLoi;

public class CautraloiDAO implements InterfaceCauTraLoi {

	@Override
	public CauTraLoi get1(int id) {
		CauTraLoi cautraloi=new CauTraLoi();
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from CAUTRALOI as c where c.idcautraloi=? ";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				cautraloi.setIdcautraloi(rs.getInt("idcautraloi"));
				cautraloi.setCautraloi(rs.getString("Cautraloi"));
				cautraloi.setCaudung(rs.getBoolean("Caudung"));
				cautraloi.setIdcautraloi(rs.getInt("idcauhoi"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cautraloi;
	}

	@Override
	public ArrayList<CauTraLoi> getlist(int idcauhoi) {
		ArrayList<CauTraLoi> list=new ArrayList<>();
		
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from CAUTRALOI as c where c.idcauhoi=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, idcauhoi);
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				CauTraLoi cautraloi=new CauTraLoi();
				cautraloi.setIdcautraloi(rs.getInt("idcautraloi"));
				cautraloi.setCautraloi(rs.getString("Cautraloi"));
				cautraloi.setCaudung(rs.getBoolean("Caudung"));
				cautraloi.setIdcauhoi(rs.getInt("idcauhoi"));
				list.add(cautraloi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean them(CauTraLoi cautraloi) {
		Connection conn=new ConnectionDao().getConnection();
		String sql="insert into CAUTRALOI(Idcautraloi,Cautraloi,Caudung,Idcauhoi) values (?,N'"+cautraloi.getCautraloi()+"',?,?)";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			
			pre.setInt(1, cautraloi.getIdcautraloi());
			
			pre.setBoolean(2, cautraloi.getCaudung());
			pre.setInt(3, cautraloi.getIdcauhoi());
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
	public boolean update(CauTraLoi cautraloi) {

		Connection conn=new ConnectionDao().getConnection();
		String sql="update CAUTRALOI set Cautraloi =N'"+cautraloi.getCautraloi()+"' , caudung =? where Idcautraloi=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			
			pre.setBoolean(1, cautraloi.getCaudung());
			pre.setInt(2, cautraloi.getIdcautraloi());
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
	public boolean xoa(CauTraLoi cautraloi) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<CauTraLoi> getlistcautraloi() {
		ArrayList<CauTraLoi> list=new ArrayList<>();
		
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from CAUTRALOI";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				CauTraLoi cautraloi=new CauTraLoi();
				cautraloi.setIdcautraloi(rs.getInt("idcautraloi"));
				cautraloi.setCautraloi(rs.getString("Cautraloi"));
				cautraloi.setCaudung(rs.getBoolean("Caudung"));
				cautraloi.setIdcauhoi(rs.getInt("idcauhoi"));
				list.add(cautraloi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
