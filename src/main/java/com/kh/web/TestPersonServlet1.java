package com.kh.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet
 * - 웹요청을 처리할 수 있는 자바클래스
 * - 웹요청 처리기능이 있는 HttpServlet클래스를 상속해서 servlet 작성 
 * - 요청방식에 따라 doGet, doPost 오버라이드
 * 
 * */
public class TestPersonServlet1 extends HttpServlet {
	/**
	 * Get방식 요청시 처리코드
	 * - HttpServletRequest 요청관련 정보를 가진 객체 
	 * - HttpServletResponse 응답처리 관련 정보를 가진 객체 
	 * */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. 요청 인코딩처리 (GET방식은 생략가능)
		request.setCharacterEncoding("utf-8");
		
		// 2. 사용자입력값 처리 
		// ?name=김태연&color=노랑&animal=고양이&food=짜장면&food=짬봉&food=탕수육
		// 사용자입력값은 모두 문자열
		String name = request.getParameter("name"); // 대소문자 구분
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foods = request.getParameterValues("food"); //복수개의 값처리
		
		System.out.println("name = " + name);
		System.out.println("color = " + color);
		System.out.println("animal = " + animal);
		System.out.println("foods = " + (foods != null ? Arrays.toString(foods) : null));
		
		// 3. 업무로직
		
		
		
		// 4. 응답메세지 작성
		// 헤더(설정정보)
		response.setContentType("text/html; charset=utf-8");
		// 바디(html)
		PrintWriter out = response.getWriter(); //응답메세지를 대상으로 하는 문자기반 출력 스트림
		out.println("<!doctype html");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>개인취향검사결과</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>개인취향검사결과" + request.getMethod() + "</h1>" );
		out.println("<p>이름:"+ name +"</p>");
		out.println("<p>선호색상:" + color +"</p>");
		out.println("<p>선호동물:" + animal +"</p>");
		out.println("<p>선호중국음식:" + (foods != null ? Arrays.toString(foods) : "없음") +"</p>");
		out.println("</body>");
		out.println("</html>");
		
			}
}
