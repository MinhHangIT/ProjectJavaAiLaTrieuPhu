package com.nhomjava.dao;

import java.util.ArrayList;

import com.nhomjava.entity.TaiKhoan;

public interface InterfaceTaiKhoan {

	
	public TaiKhoan get1(int id) ;
	
	public ArrayList<TaiKhoan> getlist();
	
	
	public Boolean dangnhap(String taikhoan,String matkhau) ;
	
	
	public boolean themnguoidung(TaiKhoan tk);
	
	public boolean kiemtra(String username);
	
	public TaiKhoan layid(String taikhoan,String matkhau);
	
}
