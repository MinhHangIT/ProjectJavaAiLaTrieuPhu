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
import com.nhomjava.dao.CautraloiDAO;
import com.nhomjava.dao.MucdoDAO;
import com.nhomjava.entity.CauHoi;
import com.nhomjava.entity.CauTraLoi;
import com.nhomjava.entity.MucDo;
import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;


@WebServlet("/chinhsuacauhoi")
public class ChinhsuacauhoiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ChinhsuacauhoiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	     response.setCharacterEncoding("utf-8");
		int macauhoi=Integer.parseInt(request.getParameter("idcauhoi"));
		
		
		CauhoiDAO cauhoidao=new CauhoiDAO();
		
		CauHoi cauhoi=cauhoidao.get1(macauhoi);
		
		
		request.setAttribute("cauhoi", cauhoi);
		CautraloiDAO cautraloidao=new CautraloiDAO();
		ArrayList<CauTraLoi> listcautraloi=cautraloidao.getlist(macauhoi);
	
		for (int i = 0; i < listcautraloi.size(); i++) {
			request.setAttribute("cautraloi"+i,listcautraloi.get(i) );
		}
		
		ArrayList<CauHoi> listcauhoi=cauhoidao.getlist();
		request.setAttribute("listcauhoi", listcauhoi);
		MucdoDAO mucdodao =new MucdoDAO();
		ArrayList<MucDo> listmucdo=mucdodao.getlist();
		request.setAttribute("listmucdo", listmucdo);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dis=request.getRequestDispatcher("chinhsuacauhoi.jsp");
		dis.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	     response.setCharacterEncoding("utf-8");
		int macauhoi=Integer.parseInt(request.getParameter("idcauhoi"));
		CauhoiDAO cauhoidao=new CauhoiDAO();
		CautraloiDAO cautraloidao=new CautraloiDAO();
		String cauhoi=request.getParameter("cauhoi");
		int idmucdo=Integer.parseInt(request.getParameter("mucdo"));
		String caudung=request.getParameter("caudung");
		String cautraloi1=request.getParameter("cautraloi1");
		String cautraloi2=request.getParameter("cautraloi2");
		String cautraloi3=request.getParameter("cautraloi3");
		String cautraloi4=request.getParameter("cautraloi4");
		if(cauhoi==null || request.getParameter("caudung")==null || caudung==null || cautraloi1==null || cautraloi2==null || cautraloi3==null || cautraloi4 ==null)
		{
			request.setAttribute("thongbao", "Thêm thất bại !! không để trống cac trường");
			RequestDispatcher dis=request.getRequestDispatcher("chinhsuacauhoi.jsp");
			dis.forward(request, response);
		}
		
		
		
		else {

			
			
			CauHoi ch=cauhoidao.get1(macauhoi);
			ch.setCauhoi(cauhoi);
			ch.setMucdo(idmucdo);
			boolean kiemtra1=cauhoidao.update(ch);
			if(kiemtra1==true) {
				System.out.println("thanh cong");
			}
			else {
				System.out.println("that bai 0");
			}
			ArrayList<String> listcautraloi=new ArrayList<>();
			listcautraloi.add(cautraloi1);
			listcautraloi.add(cautraloi2);
			listcautraloi.add(cautraloi3);
			listcautraloi.add(cautraloi4);
			ArrayList<CauTraLoi> cautraloi=cautraloidao.getlist(macauhoi);
			
			for(int i=0;i<cautraloi.size();i++) {
				if(caudung.equals("a") && i==0) {
					cautraloi.get(i).setCautraloi(listcautraloi.get(i));
					cautraloi.get(i).setCaudung(true);
					System.out.println("chay vao 1");
				}
				else if(caudung.equals("b") && i==1) {
					cautraloi.get(i).setCautraloi(listcautraloi.get(i));
					cautraloi.get(i).setCaudung(true);
					System.out.println("chay vao 2");
				}
				else if(caudung.equals("c") && i==2) {
					cautraloi.get(i).setCautraloi(listcautraloi.get(i));
					cautraloi.get(i).setCaudung(true);
					System.out.println("chay vao 3");
				}
				else if(caudung.equals("d") && i==3) {
					cautraloi.get(i).setCautraloi(listcautraloi.get(i));
					cautraloi.get(i).setCaudung(true);
					System.out.println("chay vao 4");
				}
				else {
					cautraloi.get(i).setCautraloi(listcautraloi.get(i));
					cautraloi.get(i).setCaudung(false);
					System.out.println("chay vao 5");
				}
				
				boolean kiemtra=cautraloidao.update(cautraloi.get(i));
				if(kiemtra==true) {
					System.out.println("update thanh cong!!!");
				}
				else
				{
					System.out.println("update that bai ");
				}
				
			}
			
			if(kiemtra1==true) {
				request.setAttribute("thongbao", "update câu hỏi thành công!!");
				RequestDispatcher dis=request.getRequestDispatcher("quanlicauhoi");
				dis.forward(request, response);
			}
			else {
				request.setAttribute("thongbao", "update câu hỏi thất bại!!");
				RequestDispatcher dis=request.getRequestDispatcher("quanlicauhoi");
				dis.forward(request, response);
			}
		}
		
		
		
		
	}

	
}
