package com.nhomjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nhomjava.entity.CauHoi;
import com.nhomjava.entity.TaiKhoan;

public class TaiKhoanDAO implements InterfaceTaiKhoan {

	@Override
	public TaiKhoan get1(int id) {
		TaiKhoan taikhoan=new TaiKhoan();
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from TAIKHOAN as c where c.idtaikhoan=? ";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				taikhoan.setIdtaikhoan(rs.getInt("idtaikhoan"));
				taikhoan.setTentaikhoan(rs.getString("Tentaikhoan"));
				taikhoan.setMatkhau(rs.getString("matkhau"));
				taikhoan.setDiachi(rs.getString("diachi"));
				taikhoan.setIdtheloai(rs.getInt("idtheloai"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return taikhoan;
		
	}

	@Override
	public ArrayList<TaiKhoan> getlist() {
		
		ArrayList<TaiKhoan> list=new ArrayList<>();
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from TAIKHOAN ";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				TaiKhoan taikhoan=new TaiKhoan();
				taikhoan.setIdtaikhoan(rs.getInt("idtaikhoan"));
				taikhoan.setTentaikhoan(rs.getString("Tentaikhoan"));
				taikhoan.setMatkhau(rs.getString("matkhau"));
				taikhoan.setDiachi(rs.getString("diachi"));
				taikhoan.setIdtheloai(rs.getInt("idtheloai"));
				list.add(taikhoan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Boolean dangnhap(String ktaikhoan, String matkhau) {
		TaiKhoan taikhoan=new TaiKhoan();
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from TAIKHOAN as c where c.tentaikhoan=? and c.matkhau=? ";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, ktaikhoan);
			pre.setString(2, matkhau);
			
			
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				taikhoan.setIdtaikhoan(rs.getInt("idtaikhoan"));
				taikhoan.setTentaikhoan(rs.getString("Tentaikhoan"));
				taikhoan.setMatkhau(rs.getString("matkhau"));
				taikhoan.setDiachi(rs.getString("diachi"));
				taikhoan.setIdtheloai(rs.getInt("idtheloai"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(taikhoan.getTentaikhoan()!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean themnguoidung(TaiKhoan tk) {
		Connection conn=new ConnectionDao().getConnection();
		String sql="insert into TAIKHOAN(tentaikhoan,matkhau,diachi,idtheloai) values (?,?,?,?)";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, tk.getTentaikhoan());
			pre.setString(2, tk.getMatkhau());
			pre.setString(3, tk.getDiachi());
			pre.setInt(3, tk.getIdtheloai());
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
	public boolean kiemtra(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TaiKhoan layid(String ktaikhoan, String matkhau) {
		TaiKhoan taikhoan=new TaiKhoan();
		Connection conn=new ConnectionDao().getConnection();
		String sql="select * from TAIKHOAN as c where c.tentaikhoan=? and c.matkhau=? ";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, ktaikhoan);
			pre.setString(2, matkhau);
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
				taikhoan.setIdtaikhoan(rs.getInt("idtaikhoan"));
				taikhoan.setTentaikhoan(rs.getString("Tentaikhoan"));
				taikhoan.setMatkhau(rs.getString("matkhau"));
				taikhoan.setDiachi(rs.getString("diachi"));
				taikhoan.setIdtheloai(rs.getInt("idtheloai"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return taikhoan;
	}

}
