package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.Article;
import board.article.ArticleDao;

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArticleDao articleDao = new ArticleDao();
		ArrayList<Article> articles = articleDao.getArticles();

		// 1. response에게 printWriter 얻기

		// 2. 인코딩설정, ContentType 설정

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		// 3. printWirter로 html 게시판틀 작성하기
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<td>");
		out.println("제목");
		out.println("</td>");
		out.println("<td>");
		out.println("작성자");
		out.println("</td>");
		out.println("<td>");
		out.println("작성일");
		out.println("</td>");
		out.println("</tr>");

		for (int i = 0; i < articles.size(); i++) {
			out.println("<tr>");
			out.println("<td>" + articles.get(i).getTitle() + "</td>");
			out.println("<td>" + articles.get(i).getNickname() + "</td>");
			out.println("<td>" + articles.get(i).getRegDate() + "</td>");
			out.println("</tr>");
		}

		out.println("</table>");

		// 4. 작성된 html에 데이터 바인딩하기

	}

}
