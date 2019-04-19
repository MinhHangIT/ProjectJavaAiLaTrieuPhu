package com.nhomjava.dao;

import java.util.ArrayList;

import com.nhomjava.entity.CauTraLoi;

public interface InterfaceCauTraLoi {

	public CauTraLoi get1(int id);
	public ArrayList<CauTraLoi> getlist(int idcauhoi);
	public boolean them (CauTraLoi cautraloi);
	public boolean update(CauTraLoi cautraloi);
	public boolean xoa(CauTraLoi cautraloi);
	public ArrayList<CauTraLoi> getlistcautraloi();
}
