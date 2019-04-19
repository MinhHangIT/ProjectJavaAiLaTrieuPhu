package com.dovanloc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nhomjava.dao.CauhoiDAO;
import com.nhomjava.dao.MucdoDAO;
import com.nhomjava.dao.TaiKhoanDAO;
import com.nhomjava.entity.CauHoi;
import com.nhomjava.entity.MucDo;
import com.nhomjava.entity.TaiKhoan;


@WebServlet("/dangnhap")
public class Dangnhapcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Dangnhapcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("user");
		String pass=request.getParameter("pass");
		HttpSession session=request.getSession();
		TaiKhoanDAO taikhoandao=new TaiKhoanDAO();
		Boolean kiemtra=taikhoandao.dangnhap(username, pass);
		if(kiemtra==false) {
			request.setAttribute("thongbao", "Tài Khoản Hoặc Mật Khẩu Không Chính Xác!!");
			RequestDispatcher dis=request.getRequestDispatcher("home.jsp");
			dis.forward(request, response);
		}
		else {
			TaiKhoan taikhoan=taikhoandao.layid(username, pass);
			if(taikhoan.getIdtheloai()==1) {
				session.setAttribute("idnguoidung",taikhoan.getIdtaikhoan() );
				RequestDispatcher dis=request.getRequestDispatcher("Trangchu.jsp");
				dis.forward(request, response);
			}
			else {
				
				
				RequestDispatcher dis=request.getRequestDispatcher("quanlicauhoi");
				dis.forward(request, response);
			}
			
		}
		doGet(request, response);
		
		
	}

}
