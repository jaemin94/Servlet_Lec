package Filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Type.Role;


public class C04Permission_Filter implements Filter {
       
	// 페이지별 권한정보 저장 Map
	// /user.do	- Role.Role_User
	// /Admin.do	- Role.Role_Admin
	Map<String,Role> pageGradeMap = new HashMap();

	public void init(FilterConfig filterConfig) throws ServletException {
		
		pageGradeMap.put("/user.do",Role.Role_User );	// 0
		pageGradeMap.put("/admin.do",Role.Role_Admin );	// 1
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// 전
		System.out.println("C04Permission_Filter Start --------");
		
		// 세션에서 Role 가져오기
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Role userRole = (Role) session.getAttribute("ROLE");
		if(userRole==null) {
			throw new ServletException("Role 이 없는 익명 계정입니다.");
		}
		
		// Map에서 Page별 Role 가져오기
		String reqUri = req.getRequestURI();	// URI	: http://localhost:8080/C01JSP/index.html
												// URI	: /C01JSP/index.html
		Role pageRole =pageGradeMap.get(reqUri);
		
		if(userRole.ordinal()<pageRole.ordinal())
		{
			throw new ServletException("권한이 부족한 계정으로 페이지 요청을 합니다");
		}
		
		chain.doFilter(req, response);
		
		// 후
		System.out.println("C04Permission_Filter End --------");
	}


}
