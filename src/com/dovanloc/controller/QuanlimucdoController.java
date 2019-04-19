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


@WebServlet("/quanlimucdo")
public class QuanlimucdoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public QuanlimucdoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	     response.setCharacterEncoding("utf-8");
	     MucdoDAO mucdodao=new MucdoDAO();
	     int idmucdo=0;
	      idmucdo=Integer.parseInt(request.getParameter("idmucdo"));
	     if(idmucdo!=0) {
	    	 MucDo mucdo=mucdodao.get1(idmucdo);
	    	 
	    	 request.setAttribute("mucdo1", mucdo);
	     }
	     
	     request.setAttribute("idmucdo", idmucdo);
	    
	     
	     ArrayList<MucDo> listmucdo=mucdodao.getlist();
	     
	     request.setAttribute("mucdo", listmucdo);
	     RequestDispatcher dis=request.getRequestDispatcher("quanlimucdo.jsp");
	     dis.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	     response.setCharacterEncoding("utf-8");
	     System.out.println("chay vao day");
	     MucdoDAO mucdodao=new MucdoDAO();
	    int idmucdo=Integer.parseInt(request.getParameter("idmucdo"));
	     MucDo mucdo=mucdodao.get1(idmucdo);
	     String ten=request.getParameter("ten");
	     float diem=Float.parseFloat(request.getParameter("diem"));
	     
	     mucdo.setTenmucdo(ten);
	     mucdo.setDiem(diem);
	     
	     boolean kiemtra=mucdodao.update(mucdo);
	     if(kiemtra==true) {
	    	 request.setAttribute("thongbao", "update thành công");
	    	 ArrayList<MucDo> listmucdo=mucdodao.getlist();
		     
		     request.setAttribute("mucdo", listmucdo);
		     request.setAttribute("idmucdo", 0);
	    	 RequestDispatcher dis=request.getRequestDispatcher("quanlimucdo.jsp");
	    	 dis.forward(request, response);
	    	 System.out.println("thanh cong");
	     }
	     else {
	    	 request.setAttribute("thongbao", "update thất bại");
 ArrayList<MucDo> listmucdo=mucdodao.getlist();
		     
		     request.setAttribute("mucdo", listmucdo);
		     request.setAttribute("idmucdo", 0);
	    	 RequestDispatcher dis=request.getRequestDispatcher("quanlimucdo.jsp");
	    	 dis.forward(request, response);
	     }
	     
	}

	

}
