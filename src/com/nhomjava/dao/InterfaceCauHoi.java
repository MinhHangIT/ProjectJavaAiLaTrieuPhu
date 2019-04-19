package com.nhomjava.dao;

import java.util.ArrayList;

import com.nhomjava.entity.CauHoi;

public interface InterfaceCauHoi {
	
	public CauHoi get1(int id);
	public ArrayList<CauHoi> getlist();
	public boolean them (CauHoi cauhoi);
	public boolean update(CauHoi cauhoi);
	public boolean xoa(CauHoi cauhoi);
	
	public CauHoi getngaunhien(int id);
	
	public ArrayList<CauHoi> gettheomucdo(int idmucdo);
	
	public  CauHoi gettheocauhoi(CauHoi cauhoi);
}
