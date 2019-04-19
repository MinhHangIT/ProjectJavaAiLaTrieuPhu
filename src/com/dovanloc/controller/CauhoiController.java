package com.dovanloc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nhomjava.dao.CauhoiDAO;
import com.nhomjava.dao.CautraloiDAO;
import com.nhomjava.dao.MucdoDAO;
import com.nhomjava.dao.TroGiupdao;
import com.nhomjava.dao.TrogiuptaikhoanDAO;
import com.nhomjava.entity.CauHoi;
import com.nhomjava.entity.CauTraLoi;
import com.nhomjava.entity.MucDo;
import com.nhomjava.entity.TroGiup;
import com.nhomjava.entity.TroGiupTaiKhoan;


@WebServlet("/cauhoi")
public class CauhoiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public CauhoiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cauthu=Integer.parseInt(request.getParameter("cauthu"));
		HttpSession sesion=request.getSession();
		int idtaikhoan=(int) sesion.getAttribute("idnguoidung");
		System.out.println("id nguoi dung la :"+idtaikhoan);
		TrogiuptaikhoanDAO trogiuptaikhoandao=new TrogiuptaikhoanDAO();
		TroGiupdao trogiupdao=new TroGiupdao();
		ArrayList<TroGiupTaiKhoan> listtrogiup=trogiuptaikhoandao.getlist(idtaikhoan);
		if(cauthu==1) {
			for(int k=0;k<listtrogiup.size();k++) {
				TroGiupTaiKhoan trogiuptaikhoan = listtrogiup.get(k);
				trogiuptaikhoan.setDadung(false);
				trogiuptaikhoandao.update(trogiuptaikhoan);
			}
		}
		System.out.println(" so luong tro giup ="+listtrogiup.size());
		for(int k=0;k<listtrogiup.size();k++) {
			if(listtrogiup.get(k).isDadung()==false) {
				TroGiup trogiup=trogiupdao.get1(listtrogiup.get(k).getIdtrogiup());
				request.setAttribute("trogiup"+k+"",trogiup.getTentrogiup());
				request.setAttribute("idtrogiup"+k+"",listtrogiup.get(k).getIdtrogiuptaikhoan());
			}
		}
		
		MucdoDAO mucdodao=new MucdoDAO();
		ArrayList<MucDo> listmucdo=mucdodao.getlist();
		MucDo mucdo=mucdodao.get1(cauthu);
		CauhoiDAO cauhoidao=new CauhoiDAO();
		ArrayList<CauHoi> listcauhoi=cauhoidao.gettheomucdo(cauthu);
		int socauhoi=listcauhoi.size();
		Random td=new Random();
		int sorandom=td.nextInt(socauhoi);
		
		if(sorandom==socauhoi) {
			sorandom=sorandom-1;
		}
		
		System.out.println("socau hoi :"+socauhoi);
		System.out.println("so ran dom:"+sorandom);
		
		CauHoi cauhoi=listcauhoi.get(sorandom);
		 CautraloiDAO cautraloidao=new CautraloiDAO();
		ArrayList<CauTraLoi> listcautraloi=cautraloidao.getlist(cauhoi.getIdcauhoi());
		for(int i=0;i<listcautraloi.size();i++) {
			request.setAttribute("mucdo"+i+"",listcautraloi.get(i).getCautraloi());
			request.setAttribute("idcautraloi"+i+"",listcautraloi.get(i).getIdcautraloi());
			System.out.println("idcautraloi"+i+":"+listcautraloi.get(i).getIdcautraloi());
			System.out.println("cautraloi"+i+":"+listcautraloi.get(i).getCautraloi());
		}
		
		request.setAttribute("idcauhoi",cauhoi.getIdcauhoi());
		request.setAttribute("cauthu",cauthu);
		request.setAttribute("cauhoi",cauhoi);
		request.setAttribute("mucdo",listmucdo);
		
		
		RequestDispatcher dis=request.getRequestDispatcher("Cauhoi.jsp");
		dis.forward(request, response);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	

}
