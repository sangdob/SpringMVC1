package SpringMVC.Servlet.basic.reponse;

/**
 * Spring MVC-1
 * 강의명 : HTTP 응답데이터 - API JSON
 * @since 2022.03.16
 * @author sangdob
 */

import SpringMVC.Servlet.basic.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/responseJson")
public class ResponseJsonServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Content-Type: application/json;charset=utf-8
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");

		HelloData helloData = new HelloData();
		helloData.setUsername("sangdob");
		helloData.setAge(26);

		String result = new ObjectMapper().writeValueAsString(helloData);
		resp.getWriter().write(result);
	}
}
