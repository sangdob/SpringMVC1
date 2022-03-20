package SpringMVC.Servlet.basic.web.servlet;

/**
 * Servlet 직접 html 코드를 작성하여 웹 애플리케이션 작성 -- Save
 * Spring MVC-1
 * 강의명 : 서블릿으로 회원 관리 웹 애플리켜이션 만들기
 * @since 2022.03.20
 * @author sangdob
 */

import SpringMVC.Servlet.domain.member.Member;
import SpringMVC.Servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MemberSaveServlet.service");
		String username = req.getParameter("username");
		int age = Integer.parseInt(req.getParameter("age"));

		Member member = new Member(username, age);
		memberRepository.save(member);

		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");

		PrintWriter w = resp.getWriter();
		w.write("<html>\n" +
		        "<head>\n" +
		            " <meta charset=\"UTF-8\">\n" +
		        "</head>\n" +
		        "<body>\n" +
		            "성공\n" +
			        "<ul>\n" +
			        " <li>id="+member.getId()+"</li>\n" +
			        " <li>username="+member.getName()+"</li>\n" +
			        " <li>age="+member.getAge()+"</li>\n" +
			        "</ul>\n" +
		            "<a href=\"/index.html\">메인</a>\n" +
		        "</body>\n" +
		        "</html>");
	}
}
