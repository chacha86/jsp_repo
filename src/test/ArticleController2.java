package test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.Article;
import board.article.ArticleDao;

public class ArticleController2 {
	ArticleDao dao = new ArticleDao();
	
	String doAction(HttpServletRequest request, HttpServletResponse response) {
		
		String action = request.getParameter("action");
		String dest = "";
		
		if(action.equals("list")) {
			//out.println("<h1>안녕하세요</h1>");
			dest = list(request, response);
			
		} else if(action.equals("insert")) {
			dest = insert(request, response);
		
		} else if(action.equals("update")) {
			dest = update(request, response);
			
		} else if(action.equals("delete")) {
			dest = delete(request, response);
			
		} else if(action.equals("detail")) {
			dest = detail(request, response);
			
		} else if(action.equals("showAdd")) {
			dest = "WEB-INF/jsp/addForm.jsp";
			
		} else if(action.equals("showUpdate")) {
			dest = showUpdate(request, response);
		}
		
		return dest;
	}
	
	private String showUpdate(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Article article = dao.getArticleById(id);
		request.setAttribute("myData3", article);
		
		return "WEB-INF/jsp/updateForm.jsp";
	}

	private String detail(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Article article = dao.getArticleById(id);			
		request.setAttribute("myData2", article);
		
		return "WEB-INF/jsp/detail.jsp";
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteArticle(id);
		
		return "WEB-INF/jsp/list.jsp";
	}

	private String update(HttpServletRequest request, HttpServletResponse response) {
	
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		int id = Integer.parseInt(request.getParameter("id"));
		
		dao.updateArticle(title, body, id);
		
		return detail(request, response);
	}

	private String insert(HttpServletRequest request, HttpServletResponse response) {
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		//int mid = Integer.parseInt(request.getParameter("mid"));

		dao.insertArticle(title, body, 1);
		return list(request, response);
		//response.sendRedirect("/web-exam1/article?action=list");
	}

	public String list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Article> articles = dao.getArticles();
		request.setAttribute("myData", articles);
		return "WEB-INF/jsp/list.jsp";
	}
}
