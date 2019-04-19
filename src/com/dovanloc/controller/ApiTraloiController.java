package com.dovanloc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhomjava.dao.CautraloiDAO;
import com.nhomjava.dao.MucdoDAO;
import com.nhomjava.entity.MucDo;


@WebServlet("/traloi")
public class ApiTraloiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ApiTraloiController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iddapan=Integer.parseInt(request.getParameter("madapan"));
		int idmucdo=Integer.parseInt(request.getParameter("cauthu"));
		MucdoDAO mucdodao=new MucdoDAO();
		CautraloiDAO cautraloidao=new CautraloiDAO();
		if(cautraloidao.get1(iddapan).getCaudung()==true) {
			System.out.println("đúng");
			
			MucDo mucdo=mucdodao.get1(idmucdo);
			request.setAttribute("diemso",mucdo.getDiem());
			request.setAttribute("caubn",idmucdo);
			RequestDispatcher dis=request.getRequestDispatcher("dung.jsp");
			dis.forward(request, response);
		}
		else
		{
			int idmucdotruoc=idmucdo-1;
			if(idmucdotruoc==0) {
				request.setAttribute("diemso",0);
			}
			else {
				MucDo mucdo=mucdodao.get1(idmucdotruoc);
				request.setAttribute("diemso",mucdo.getDiem());
			}
			System.out.println("sai");
			RequestDispatcher dis=request.getRequestDispatcher("sai.jsp");
			dis.forward(request, response);
		}
	
	}

}
