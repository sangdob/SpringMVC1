package SpringMVC.Servlet.basic.web.frontcontroller.v2;

import SpringMVC.Servlet.basic.web.frontcontroller.MyView;
import SpringMVC.Servlet.basic.web.frontcontroller.v1.ControllerV1;
import SpringMVC.Servlet.basic.web.frontcontroller.v1.controller.MemberFormControllerV1;
import SpringMVC.Servlet.basic.web.frontcontroller.v1.controller.MemberListControllerV1;
import SpringMVC.Servlet.basic.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import SpringMVC.Servlet.basic.web.frontcontroller.v2.controller.MemberFormControllerV2;
import SpringMVC.Servlet.basic.web.frontcontroller.v2.controller.MemberListControllerV2;
import SpringMVC.Servlet.basic.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/frontController/v1/*")
public class FrontControllerServletV2 extends HttpServlet {

	private Map<String, ControllerV2> controllerV2Map = new HashMap<>();

	public FrontControllerServletV2() {
		controllerV2Map.put("/frontController/v2/members/newForm", new MemberFormControllerV2());
		controllerV2Map.put("/frontController/v2/members/save", new MemberSaveControllerV2());
		controllerV2Map.put("/frontController/v2/members", new MemberListControllerV2());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("FrontControllerServletV2.service");

		String reqURI = req.getRequestURI();

//		다형성을 이용하여 Interface로 부모형태를 받아 Map의 Key값으로 찾아준다.
		ControllerV2 controller = controllerV2Map.get(reqURI);

		if (controller == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		//process Return Myview를 Return URI
		MyView view = controller.process(req, resp);
		view.render(req, resp);
	}
}
