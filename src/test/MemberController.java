//package test;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import board.member.Member;
//import board.member.MemberDao;
//
//@WebServlet("/member")
//public class MemberController extends HttpServlet {
//	
//	MemberDao mdao = new MemberDao();
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		response.setCharacterEncoding("UTF-8");
//	    response.setContentType("text/html; charset=utf-8");
//	    
//	    PrintWriter out = response.getWriter();
//	    
//		String action = request.getParameter("action");
//		String dest = "";
//
//		if (action.equals("showLogin")) {
//			out.println("<h1>안녕하세요</h1>");
//			//dest = "WEB-INF/jsp/loginForm.jsp";
//
//		} else if (action.equals("doLogin")) {
//			dest = doLogin(request, response);
//			
//		} else if (action.equals("showMember")) {
//			dest = "WEB-INF/jsp/memberForm.jsp";
//
//		} else if (action.equals("doInsertMember")) {
//			dest = doInsertMember(request, response);
//			
//		} 
//		
//	}
//
//	private String doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//		String loginId = request.getParameter("loginId");
//		String loginPw = request.getParameter("loginPw");
//
//		Member loginedMember = mdao.getMemberByLoginIdAndLoginPw(loginId, loginPw);
//
//		if (loginedMember != null) {
//
//			// session 저장소 저장하는 법
//			HttpSession session = request.getSession();
//			session.setAttribute("loginedMember", loginedMember);
//
//			// request.setAttribute("loginedMember", loginedMember);
//			System.out.println("aa");
//			return "redirect: /web-exam1/article?action=list";
//
//		} else {
//			return "WEB-INF/jsp/loginFailed.jsp";
//		}
//	}
//
//	private String doInsertMember(HttpServletRequest request, HttpServletResponse response) {
//		String loginId = request.getParameter("loginId");
//		String loginPw = request.getParameter("loginPw");
//		String nickname = request.getParameter("nickname");
//
//		mdao.insertMember(loginId, loginPw, nickname);
//
//		return "WEB-INF/jsp/loginForm.jsp";
//	}
//
//}
