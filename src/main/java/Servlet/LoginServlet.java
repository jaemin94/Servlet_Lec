package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Type.Role;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet LoginServlet Start -----");
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("doPost LoginServlet Start -----");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		System.out.println("userid : " + userid);
		System.out.println("pwd : " + pwd);
		
//		PrintWriter out = response.getWriter();
//		out.print("USERID : " + userid);
//		out.print("PWD : " + pwd);
		
//		ROLE 부여(in Session) - 일반계정 : user / 관리자 계정 : admin
		HttpSession session = request.getSession();
		if(userid.equals("user")) {
			session.setAttribute("ROLE", Role.Role_User);
		}else if(userid.equals("admin")) {
			session.setAttribute("ROLE", Role.Role_Admin);
		}
		
		// Redirect /main.do 로 이동
		response.sendRedirect(request.getContextPath() +"/main.do");
		
	}

}
