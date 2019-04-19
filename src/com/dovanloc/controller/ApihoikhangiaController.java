package com.dovanloc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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


@WebServlet("/apihoikhangia")
public class ApihoikhangiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ApihoikhangiaController() {
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
		
		Random rd=new Random();
		int so=100;
		int ra;
		int rathuc = 0;
		for(int i=0;i<listtraloi.size();i++) {
			if(listtraloi.get(i).getCaudung()==true) {
				ra=rd.nextInt(50);
				rathuc=ra+50;
				request.setAttribute("phantramdung",rathuc);
				request.setAttribute("caudung",listtraloi.get(i).getCautraloi());
			}
		}
		System.out.println("ra thuc ="+ rathuc);
		int kai=0;
		for(int i=0;i<listtraloi.size();i++) {
			if(listtraloi.get(i).getCaudung()==false) {
				if(kai==2) {
					ra=so-rathuc;
					request.setAttribute("phantramsai2",ra);
					request.setAttribute("causai2",listtraloi.get(i).getCautraloi());
					
				}
				else{
				
				ra=rd.nextInt(so-rathuc);
				rathuc=rathuc+ra;
				
				System.out.println("ra "+kai+"---"+ra);
				
				System.out.println("ra thuc"+kai+"----"+rathuc);
				request.setAttribute("phantramsai"+kai+"",ra);
				request.setAttribute("causai"+kai+"",listtraloi.get(i).getCautraloi());
				kai++;
				}
			}
		}
		
		RequestDispatcher dis=request.getRequestDispatcher("khangia.jsp");
		dis.forward(request, response);
		
	}

}
