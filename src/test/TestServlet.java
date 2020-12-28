package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		String action = request.getParameter("action");
		
		if(action.equals("printGuGu1")) {
			for(int i = 2; i < 10; i++) {
				for(int j = 1; j < 10; j++) {
					out.println(i + " * " + j + " = " + i * j + "<br>");
				}
			}
		} else if(action.equals("printGuGu2")) {
			String limit = request.getParameter("limit");
			int limit2 = Integer.parseInt(limit);
			
			for(int i = 2; i <= limit2; i++) {
				for(int j = 1; j < 10; j++) {
					out.println(i + " * " + j + " = " + i * j + "<br>");
				}
			}
		} else if(action.equals("hello")) {
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			
			out.println("안녕하세요 저는 " + age + "살 " + name + "입니다.");
		}
	}
}
