package SpringMVC.Servlet.basic.request;

/**
 * Spring MVC-1
 * 강의명 : HTTP 요청 데이터 API 메시지 바디 - JSON
 * @since 2022.03.16
 * @author sangdob
 */

import SpringMVC.Servlet.basic.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/requestBodyJson")
public class RequestBodyJsonServlet extends HttpServlet {

	private ObjectMapper objectMapper = new ObjectMapper();     //Jackson library[Spring boot]

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getInputStreamJson(req);
	}

	//JSON형식으로 파싱하는 함수
	private void getInputStreamJson(HttpServletRequest req) throws IOException {
		System.out.println();
		System.out.println("[Request Body Json] -- Start");

		ServletInputStream inputStream = req.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

		System.out.println("MessageBody = " + messageBody);

		HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
		System.out.println("helloData.username = " +  helloData.getUsername());
		System.out.println("helloData.age = " + helloData.getAge());

		System.out.println("[Request Body Json] -- End");
		System.out.println();
	}
}
