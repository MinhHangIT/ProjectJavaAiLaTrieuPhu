package com.nhomjava.dao;

import java.util.ArrayList;
import java.util.List;

import com.nhomjava.entity.TroGiupTaiKhoan;

public interface InterfaceTrogiupTaikhoan {
	
	public boolean update (TroGiupTaiKhoan troGiupTaiKhoan);
	
	public TroGiupTaiKhoan get1(int id);
	
	public boolean them(TroGiupTaiKhoan tg);
	
	public ArrayList<TroGiupTaiKhoan> getlist(int idtaikhoan);

}
