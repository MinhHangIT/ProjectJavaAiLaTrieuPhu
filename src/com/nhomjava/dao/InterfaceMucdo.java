package com.nhomjava.dao;

import java.util.ArrayList;


import com.nhomjava.entity.MucDo;

public interface InterfaceMucdo {

	public MucDo get1 (int id);
	public ArrayList<MucDo> getlist();
	public boolean them (MucDo mucdo);
	public boolean update (MucDo mucdo);
	public boolean xoa (MucDo mucdo);
}
