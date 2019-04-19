package com.dovanloc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhomjava.dao.CauhoiDAO;
import com.nhomjava.dao.CautraloiDAO;
import com.nhomjava.entity.CauHoi;
import com.nhomjava.entity.CauTraLoi;


@WebServlet("/themcauhoi")
public class ThemcauhoiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ThemcauhoiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("vao day thanh cong!!");
		request.setCharacterEncoding("utf-8");
	     response.setCharacterEncoding("utf-8");
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
			RequestDispatcher dis=request.getRequestDispatcher("quanlicauhoi");
			dis.forward(request, response);
		}
		else {
				CauhoiDAO cauhoidao=new CauhoiDAO();
				int soluong=cauhoidao.getlist().size();
				CauHoi ch=new CauHoi();
				ch.setIdcauhoi((soluong+1));
				ch.setCauhoi(cauhoi);
				ch.setMucdo(idmucdo);
				boolean kiemtra=cauhoidao.them(ch);
				if(kiemtra==true) {
					System.out.println("them thanh cong");
				}
				else {
					System.out.println("them that bai ");
				}
				
				
				CauTraLoi ctl1=new CauTraLoi();
				CauTraLoi ctl2=new CauTraLoi();
				CauTraLoi ctl3=new CauTraLoi();
				CauTraLoi ctl4=new CauTraLoi();
				CautraloiDAO cautraloidao=new CautraloiDAO();
				int soluongcautraloi=cautraloidao.getlistcautraloi().size();
				System.out.println("so luong cau tra loi ="+soluongcautraloi);
				if(caudung.equals("a")) {
					ctl1.setIdcautraloi((soluongcautraloi+1));
					ctl1.setIdcauhoi(ch.getIdcauhoi());
					ctl1.setCautraloi(cautraloi1);
					ctl1.setCaudung(true);
					
					// -- den cau 2
					ctl2.setIdcautraloi((soluongcautraloi+2));
					ctl2.setIdcauhoi(ch.getIdcauhoi());
					ctl2.setCautraloi(cautraloi2);
					ctl2.setCaudung(false);
					
					// den cau 3
					ctl3.setIdcautraloi((soluongcautraloi+3));
					ctl3.setIdcauhoi(ch.getIdcauhoi());
					ctl3.setCautraloi(cautraloi3);
					ctl3.setCaudung(false);
					
					// den cau 4
					
					ctl4.setIdcautraloi((soluongcautraloi+4));
					ctl4.setIdcauhoi(ch.getIdcauhoi());
					ctl4.setCautraloi(cautraloi4);
					ctl4.setCaudung(false);
					
				}
				else if(caudung.equals("b")) {
					ctl1.setIdcautraloi((soluongcautraloi+1));
					ctl1.setIdcauhoi(ch.getIdcauhoi());
					ctl1.setCautraloi(cautraloi1);
					ctl1.setCaudung(false);
					
					// -- den cau 2
					ctl2.setIdcautraloi((soluongcautraloi+2));
					ctl2.setIdcauhoi(ch.getIdcauhoi());
					ctl2.setCautraloi(cautraloi2);
					ctl2.setCaudung(true);
					
					// den cau 3
					ctl3.setIdcautraloi((soluongcautraloi+3));
					ctl3.setIdcauhoi(ch.getIdcauhoi());
					ctl3.setCautraloi(cautraloi3);
					ctl3.setCaudung(false);
					
					// den cau 4
					
					ctl4.setIdcautraloi((soluongcautraloi+4));
					ctl4.setIdcauhoi(ch.getIdcauhoi());
					ctl4.setCautraloi(cautraloi4);
					ctl4.setCaudung(false);
				}
				
				else if(caudung.equals("c")) {
					ctl1.setIdcautraloi((soluongcautraloi+1));
					ctl1.setIdcauhoi(ch.getIdcauhoi());
					ctl1.setCautraloi(cautraloi1);
					ctl1.setCaudung(false);
					
					// -- den cau 2
					ctl2.setIdcautraloi((soluongcautraloi+2));
					ctl2.setIdcauhoi(ch.getIdcauhoi());
					ctl2.setCautraloi(cautraloi2);
					ctl2.setCaudung(false);
					
					// den cau 3
					ctl3.setIdcautraloi((soluongcautraloi+3));
					ctl3.setIdcauhoi(ch.getIdcauhoi());
					ctl3.setCautraloi(cautraloi3);
					ctl3.setCaudung(true);
					
					// den cau 4
					
					ctl4.setIdcautraloi((soluongcautraloi+4));
					ctl4.setIdcauhoi(ch.getIdcauhoi());
					ctl4.setCautraloi(cautraloi4);
					ctl4.setCaudung(false);
				}
				
				else if (caudung.equals("d")) {
					ctl1.setIdcautraloi((soluongcautraloi+1));
					ctl1.setIdcauhoi(ch.getIdcauhoi());
					ctl1.setCautraloi(cautraloi1);
					ctl1.setCaudung(false);
					
					// -- den cau 2
					ctl2.setIdcautraloi((soluongcautraloi+2));
					ctl2.setIdcauhoi(ch.getIdcauhoi());
					ctl2.setCautraloi(cautraloi2);
					ctl2.setCaudung(false);
					
					// den cau 3
					ctl3.setIdcautraloi((soluongcautraloi+3));
					ctl3.setIdcauhoi(ch.getIdcauhoi());
					ctl3.setCautraloi(cautraloi3);
					ctl3.setCaudung(false);
					
					// den cau 4
					
					ctl4.setIdcautraloi((soluongcautraloi+4));
					ctl4.setIdcauhoi(ch.getIdcauhoi());
					ctl4.setCautraloi(cautraloi4);
					ctl4.setCaudung(true);
				}
				
				
				boolean kiemtra11=cautraloidao.them(ctl1);
				cautraloidao.them(ctl2);
				cautraloidao.them(ctl3);
				cautraloidao.them(ctl4);
				
				
				if(kiemtra11==true) {
					request.setAttribute("thongbao", "them thanh cong");
				RequestDispatcher dis=request.getRequestDispatcher("quanlicauhoi");
				dis.forward(request, response);
				}
				else {
					System.out.println("that bai");
				}
		
		}
	}

}
