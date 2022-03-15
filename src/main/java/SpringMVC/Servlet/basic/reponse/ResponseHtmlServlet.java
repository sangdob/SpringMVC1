package SpringMVC.Servlet.basic.reponse;

/**
 * Spring MVC-1
 * 강의명 : HTTP 응답데이터 - 단순 텍스트, HTML
 * @since 2022.03.16
 * @author sangdob
 */


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHtmlServlet", urlPatterns = "/responseHtml")
public class ResponseHtmlServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Content-Type: text/html;charset=utf-8
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");

		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("    <div>hello</div>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
