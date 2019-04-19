package com.dovanloc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhomjava.dao.TaiKhoanDAO;
import com.nhomjava.entity.TaiKhoan;


@WebServlet("/quanlinguoidung")
public class QuanlinguoidungController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public QuanlinguoidungController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
	     response.setCharacterEncoding("utf-8");
		TaiKhoanDAO taikhoandao=new TaiKhoanDAO();
		ArrayList<TaiKhoan> listtaikhoan=taikhoandao.getlist();
		request.setAttribute("taikhoan", listtaikhoan);
		RequestDispatcher dis=request.getRequestDispatcher("quanlitaikhoan.jsp");
		dis.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}
