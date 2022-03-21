package SpringMVC.Servlet.basic.web.frontcontroller.v1.controller;

/**
 * 다형성을 이용한 Controller를 구현 [Form]
 * Spring MVC-1
 * 강의명 : 프론트 컨트롤러 도입 - v1
 * @since 2022.03.22
 * @author sangdob
 */

import SpringMVC.Servlet.basic.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewPath = "/WEB-INF/views/newForm.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}
}
