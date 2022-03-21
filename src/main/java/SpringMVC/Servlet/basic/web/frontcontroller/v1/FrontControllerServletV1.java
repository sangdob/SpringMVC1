package SpringMVC.Servlet.basic.web.frontcontroller.v1;

/**
 * FrontController URI Mapping을 위한 라우터역할
 * Spring MVC-1
 * 강의명 : 프론트 컨트롤러 도입 - v1
 * @since 2022.03.22
 * @author sangdob
 */

import SpringMVC.Servlet.basic.web.frontcontroller.v1.controller.MemberFormControllerV1;
import SpringMVC.Servlet.basic.web.frontcontroller.v1.controller.MemberListControllerV1;
import SpringMVC.Servlet.basic.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/frontController/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

	private Map<String, ControllerV1> controllerV1Map = new HashMap<>();

	public FrontControllerServletV1() {
		controllerV1Map.put("/frontController/v1/members/newForm", new MemberFormControllerV1());
		controllerV1Map.put("/frontController/v1/members/save", new MemberSaveControllerV1());
		controllerV1Map.put("/frontController/v1/members", new MemberListControllerV1());

	}


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("FrontControllerServletV1.service");

		String reqURI = req.getRequestURI();

//		다형성을 이용하여 Interface로 부모형태를 받아 Map의 Key값으로 찾아준다.
		ControllerV1 controller = controllerV1Map.get(reqURI);

		if (controller == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		controller.process(req, resp);
	}
}
