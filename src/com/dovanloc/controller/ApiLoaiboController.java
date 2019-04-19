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


@WebServlet("/apiloaibo")
public class ApiLoaiboController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ApiLoaiboController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idcauhoi=Integer.parseInt(request.getParameter("idcauhoi"));
		int idtrogiup=Integer.parseInt(request.getParameter("idtrogiup"));
		TrogiuptaikhoanDAO trogiuptaikhoandao=new TrogiuptaikhoanDAO();
		TroGiupTaiKhoan trogiuptaikhoan=trogiuptaikhoandao.get1(idtrogiup);
		trogiuptaikhoan.setDadung(true);
		trogiuptaikhoandao.update(trogiuptaikhoan);
		
		CautraloiDAO cautraloidao=new CautraloiDAO();
		ArrayList<CauTraLoi> listtraloi=cautraloidao.getlist(idcauhoi);
		
		int i=0;
		for(int n=0;n<listtraloi.size();n++) {
			
			
			if(listtraloi.get(n).getCaudung()==false) {
				request.setAttribute("idcausai",listtraloi.get(n).getIdcautraloi());
				System.out.println("cau sai id="+listtraloi.get(n).getIdcautraloi());
				
				i++;
				if(i==1) {
					break;
				}
			}
		}
		
		for(int n=0;n<listtraloi.size();n++) {
			
			
			if(listtraloi.get(n).getCaudung()==true) {
				request.setAttribute("idcaudung",listtraloi.get(n).getIdcautraloi());
				System.out.println("id cau dung="+listtraloi.get(n).getIdcautraloi());
			}
		}
		

		for(int j=0;j<listtraloi.size();j++) {
			request.setAttribute("mucdo"+j+"",listtraloi.get(j).getCautraloi());
			request.setAttribute("idcautraloi"+j+"",listtraloi.get(j).getIdcautraloi());
		}
		RequestDispatcher dis=request.getRequestDispatcher("conlai.jsp");
		dis.forward(request, response);
		
	}

}
