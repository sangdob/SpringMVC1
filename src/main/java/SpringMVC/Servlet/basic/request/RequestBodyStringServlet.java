package SpringMVC.Servlet.basic.request;

/**
 * Spring MVC-1
 * 강의명 : HTTP 요청 데이터 - Get 쿼리 파라미터
 * @since 2022.03.16
 * @author sangdob
 */

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/requestBodyString")
public class RequestBodyStringServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getInputStreamMessage(req, resp);
	}

	private void getInputStreamMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ServletInputStream inputStream = req.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

		System.out.println("inputstream = " + messageBody);
		resp.getWriter().write("inputstream");
	}
}
