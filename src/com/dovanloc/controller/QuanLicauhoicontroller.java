package com.dovanloc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhomjava.dao.CauhoiDAO;
import com.nhomjava.dao.MucdoDAO;
import com.nhomjava.entity.CauHoi;
import com.nhomjava.entity.MucDo;


@WebServlet("/quanlicauhoi")
public class QuanLicauhoicontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public QuanLicauhoicontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String thongbao=(String) request.getAttribute("thongbao");
		
		CauhoiDAO cauhoi=new CauhoiDAO();
		ArrayList<CauHoi> listcauhoi=cauhoi.getlist();
		request.setAttribute("listcauhoi", listcauhoi);
		MucdoDAO mucdodao =new MucdoDAO();
		ArrayList<MucDo> listmucdo=mucdodao.getlist();
		request.setAttribute("listmucdo", listmucdo);
		request.setAttribute("thongbao", thongbao);
		RequestDispatcher dis=request.getRequestDispatcher("admin.jsp");
		dis.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String thongbao=(String) request.getAttribute("thongbao");
		
		CauhoiDAO cauhoi=new CauhoiDAO();
		ArrayList<CauHoi> listcauhoi=cauhoi.getlist();
		request.setAttribute("listcauhoi", listcauhoi);
		MucdoDAO mucdodao =new MucdoDAO();
		ArrayList<MucDo> listmucdo=mucdodao.getlist();
		request.setAttribute("listmucdo", listmucdo);
		request.setAttribute("thongbao", thongbao);
		RequestDispatcher dis=request.getRequestDispatcher("admin.jsp");
		dis.forward(request, response);
		
	}

	

}
