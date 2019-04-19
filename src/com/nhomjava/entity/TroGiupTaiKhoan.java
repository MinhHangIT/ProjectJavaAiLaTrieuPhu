package com.nhomjava.entity;



public class TroGiupTaiKhoan {



	private int Idtrogiuptaikhoan;
	
	private int idtaikhoan;
	
	private int idtrogiup;
	
	private boolean Dadung;

	public int getIdtrogiuptaikhoan() {
		return Idtrogiuptaikhoan;
	}

	public void setIdtrogiuptaikhoan(int idtrogiuptaikhoan) {
		Idtrogiuptaikhoan = idtrogiuptaikhoan;
	}

	public int getIdtaikhoan() {
		return idtaikhoan;
	}

	public void setIdtaikhoan(int idtaikhoan) {
		this.idtaikhoan = idtaikhoan;
	}

	public int getIdtrogiup() {
		return idtrogiup;
	}

	public void setIdtrogiup(int idtrogiup) {
		this.idtrogiup = idtrogiup;
	}

	public boolean isDadung() {
		return Dadung;
	}

	public void setDadung(boolean dadung) {
		Dadung = dadung;
	}

	
}
