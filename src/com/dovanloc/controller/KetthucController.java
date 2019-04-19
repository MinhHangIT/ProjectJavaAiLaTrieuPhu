package com.dovanloc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ketthuc")
public class KetthucController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public KetthucController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis=request.getRequestDispatcher("Trangchu.jsp");
		dis.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}
