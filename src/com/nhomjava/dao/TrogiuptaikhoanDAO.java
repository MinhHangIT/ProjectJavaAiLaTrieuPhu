 package com.nhomjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.nhomjava.entity.TroGiupTaiKhoan;

public class TrogiuptaikhoanDAO implements InterfaceTrogiupTaikhoan {

	@Override
	public boolean update(TroGiupTaiKhoan troGiupTaiKhoan) {
		
		Connection conn=new ConnectionDao().getConnection();
		String sql="update TROGIUPTAIKHOAN set dadung =? where idtrogiuptaikhoan= ?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setBoolean(1, troGiupTaiKhoan.isDadung());
			pre.setInt(2, troGiupTaiKhoan.getIdtrogiuptaikhoan());
			
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
	public TroGiupTaiKhoan get1(int id) {
		TroGiupTaiKhoan trogiuptaikhoan=new TroGiupTaiKhoan();
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from TROGIUPTAIKHOAN as c where c.idtrogiuptaikhoan=? ";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				trogiuptaikhoan.setIdtrogiuptaikhoan(rs.getInt("idtrogiuptaikhoan"));
				trogiuptaikhoan.setIdtaikhoan(rs.getInt("idtaikhoan"));
				trogiuptaikhoan.setIdtrogiup(rs.getInt("idtrogiup"));
				trogiuptaikhoan.setDadung(rs.getBoolean("dadung"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trogiuptaikhoan;

	}

	@Override
	public boolean them(TroGiupTaiKhoan tg) {
		Connection conn=new ConnectionDao().getConnection();
		String sql="insert into TROGIUPTAIKHOAN(idtaikhoan,idtrogiup,dadung) values (?,?.?)";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, tg.getIdtaikhoan());
			pre.setInt(2, tg.getIdtrogiup());
			pre.setBoolean(3, tg.isDadung());
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
	public ArrayList<TroGiupTaiKhoan> getlist(int idtaikhoan) {
		ArrayList<TroGiupTaiKhoan> list=new ArrayList<>();
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from TROGIUPTAIKHOAN as c where c.idtaikhoan=? ";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, idtaikhoan);
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				TroGiupTaiKhoan trogiuptaikhoan=new TroGiupTaiKhoan();
				trogiuptaikhoan.setIdtrogiuptaikhoan(rs.getInt("idtrogiuptaikhoan"));
				trogiuptaikhoan.setIdtaikhoan(rs.getInt("idtaikhoan"));
				trogiuptaikhoan.setIdtrogiup(rs.getInt("idtrogiup"));
				trogiuptaikhoan.setDadung(rs.getBoolean("dadung"));
				list.add(trogiuptaikhoan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
