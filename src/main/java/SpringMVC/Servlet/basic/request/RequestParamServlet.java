package SpringMVC.Servlet.basic.request;

/**
 * Spring MVC-1
 * 강의명 : HTTP 요청 데이터 - GET 쿼리 파라미터
 * @since 2022.03.16
 * @author sangdob
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/requestParam")
public class RequestParamServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getRequestParams(req);
		getRequestParam(req);
		getRequestParamValues(req);
	}

	private void getRequestParamValues(HttpServletRequest req) {
		System.out.println();
		System.out.println("[복수 파라미터 조회] -- START ");

		String[] paramValues = req.getParameterValues("username");

		for(String value : paramValues){
			System.out.println("username = " + value);
		}
		System.out.println("age = " + req.getParameter("age"));

		System.out.println("[복수 파라미터 조회] -- END ");
		System.out.println();
	}

	private void getRequestParam(HttpServletRequest req) {
		
		System.out.println();
		System.out.println("[단일 파라미터 조회] -- START ");

		//단일 parameter 조회
		String username = req.getParameter("username");
		String age = req.getParameter("age");

		System.out.println("username = " + username);
		System.out.println("age = " + age);

		System.out.println("[단일 파라미터 조회] -- END ");
		System.out.println();
	}

	private void getRequestParams(HttpServletRequest req) {
		System.out.println();
		System.out.println("[전체 파라미터 조회] -- START ");

		//전체 parameter 조회 Lambda함수
		req.getParameterNames().asIterator()
				.forEachRemaining(param -> System.out.println(param + " = " + req.getParameter(param)));

		System.out.println("[전체 파라미터 조회] -- END ");
		System.out.println();
	}
}
