package com.kh.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menuOrder.do")
public class MenuOrderServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mainMenu = request.getParameter("mainMenu");
		String sideMenu = request.getParameter("sideMenu");
		String drinkMenu= request.getParameter("drinkMenu");
		int price = 0;
		
		switch(mainMenu) {
		case"한우버거": price+=5000; break;
		case"밥버거": price+=4500; break;
		case"치즈버거": price+=4000; break;
		}
		
		switch(sideMenu) {
		case"감자튀김": price+=1500; break;
		case"어니언링": price+=1700; break;
		}
		
		switch(drinkMenu) {
		case"콜라": price+=1000; break;
		case"사이다": price+=1000; break;
		case"커피": price+=1500; break;
		case"밀크쉐이크": price+=2500; break;
		}
		
		//실행결과 처리 및 view단 처리 위임
		request.setAttribute("price", price);
		
		//RequestDispatcher(인터페이스)에 view단 jsp 경로 지정
		RequestDispatcher reqDispatcher = 
				request.getRequestDispatcher("/menu/menuEnd.jsp");
		reqDispatcher.forward(request, response);
	}
}
