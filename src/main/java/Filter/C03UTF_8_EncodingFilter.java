package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class C03UTF_8_EncodingFilter
 */

public class C03UTF_8_EncodingFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
				System.out.println("C03UTF_8_EncodingFilter Start -----");

				req.setCharacterEncoding("UTF-8");
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html; charset=UTF-8");
				
				chain.doFilter(req,resp);
				
				System.out.println("C03UTF_8_EncodingFilter End -----");
	}



}
