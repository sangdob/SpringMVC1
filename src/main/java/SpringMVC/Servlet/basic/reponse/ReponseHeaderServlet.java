package SpringMVC.Servlet.basic.reponse;

/**
 * Spring MVC-1
 * 강의명 : HttpServletResponse - 기본 사용법
 * @since 2022.03.16
 * @author sangdob
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "reponseHeaderServlet", urlPatterns = "/responseHeader")
public class ReponseHeaderServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Response-Status-Line
		resp.setStatus(HttpServletResponse.SC_OK);

		//Response-Headers
		resp.setHeader("content-Type", "text/plain;charset=utf-8");
		resp.setHeader("Cache-Control", "no-cache, no-store, nust-revalidate");
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("my-header", "hello");

		content(resp);
		cookie(resp);
		redirect(resp);

		PrintWriter writer = resp.getWriter();

		writer.println("ok");
	}

	private void redirect(HttpServletResponse resp) throws IOException{
		resp.setStatus(HttpServletResponse.SC_FOUND);
		resp.setHeader("Location", "/basic/hello-form.html");
	}

	private void content(HttpServletResponse resp){
		resp.setContentType("text/plain;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
	}

	private void cookie(HttpServletResponse resp){
		Cookie cookie = new Cookie("myCookie", "yes");
		cookie.setMaxAge(600);

		resp.addCookie(cookie);
	}
}
