package com.dovanloc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhomjava.dao.CautraloiDAO;
import com.nhomjava.dao.TrogiuptaikhoanDAO;
import com.nhomjava.entity.CauTraLoi;
import com.nhomjava.entity.TroGiupTaiKhoan;

@WebServlet("/apihoidapan")
public class ApihoidapanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public ApihoidapanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idcauhoi=Integer.parseInt(request.getParameter("idcauhoi"));
		int idtrogiup=Integer.parseInt(request.getParameter("idtrogiup"));
		System.out.println("id tro giup la "+idtrogiup);
		TrogiuptaikhoanDAO trogiuptaikhoandao=new TrogiuptaikhoanDAO();
		TroGiupTaiKhoan trogiuptaikhoan=trogiuptaikhoandao.get1(idtrogiup);
		System.out.println("id tro giup la :"+trogiuptaikhoan.getIdtrogiuptaikhoan());
		trogiuptaikhoan.setDadung(true);
		trogiuptaikhoandao.update(trogiuptaikhoan);
		
		CautraloiDAO cautraloidao=new CautraloiDAO();
		ArrayList<CauTraLoi> listtraloi=cautraloidao.getlist(idcauhoi);
		
		
		for(int n=0;n<listtraloi.size();n++) {
			
			
			if(listtraloi.get(n).getCaudung()==true) {
				request.setAttribute("caudung",listtraloi.get(n).getCautraloi());
				System.out.println("id cau dung="+listtraloi.get(n).getIdcautraloi());
			}
			
		}
		RequestDispatcher dis=request.getRequestDispatcher("hoidapan.jsp");
		dis.forward(request, response);
	}

}
