package SpringMVC.Servlet.basic.web.servlet;

/**
 * Servlet 직접 html 코드를 작성하여 웹 애플리케이션 작성 -- Form
 * Spring MVC-1
 * 강의명 : 서블릿으로 회원 관리 웹 애플리켜이션 만들기
 * @since 2022.03.20
 * @author sangdob
 */

import SpringMVC.Servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/members/newForm")
public class MemberFormServlet extends HttpServlet {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");

		PrintWriter w = resp.getWriter();

		w.write("<!DOCTYPE html>\n" +
		        "<html>\n" +
		        "<head>\n" +
			        "<meta charset=\"utf-8\">\n" +
			        "<title>MemberFormServlet</title>\n" +
		        "</head>\n" +
		        "<body>\n" +
			        "<form action=\"/servlet/members/save\" method=\"post\">\n" +
			        "   userName : <input type=\"text\" name=\"username\" />\n" +
			        "   age : <input type=\"text\" name=\"age\" />\n" +
			        "<button type=\"submit\">submit</button>\n" +
		            "</form>\n" +
		        "</body>\n" +
		        "</html>\n");
	}
}
