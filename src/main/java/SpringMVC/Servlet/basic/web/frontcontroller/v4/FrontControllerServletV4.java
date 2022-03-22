package SpringMVC.Servlet.basic.web.frontcontroller.v4;

import SpringMVC.Servlet.basic.web.frontcontroller.ModelView;
import SpringMVC.Servlet.basic.web.frontcontroller.MyView;
import SpringMVC.Servlet.basic.web.frontcontroller.v3.ControllerV3;
import SpringMVC.Servlet.basic.web.frontcontroller.v4.controller.MemberFormControllerV4;
import SpringMVC.Servlet.basic.web.frontcontroller.v4.controller.MemberListControllerV4;
import SpringMVC.Servlet.basic.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/frontController/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

	private Map<String, ControllerV4> controllerV4Map = new HashMap<>();

	public FrontControllerServletV4() {
		controllerV4Map.put("/frontController/v4/members/newForm", new MemberFormControllerV4());
		controllerV4Map.put("/frontController/v4/members/save", new MemberSaveControllerV4());
		controllerV4Map.put("/frontController/v4/members", new MemberListControllerV4());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("FrontControllerServletV4.service");

		String reqURI = req.getRequestURI();

//		다형성을 이용하여 Interface로 부모형태를 받아 Map의 Key값으로 찾아준다.
		ControllerV4 controller = controllerV4Map.get(reqURI);

		if (controller == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		Map<String, String> paramMap = createParamMap(req);
		Map<String, Object> model = new HashMap<>();

		String viewName = controller.process(paramMap, model);

		MyView myView = viewResolver(viewName);

		myView.render(model, req, resp);
	}

	private MyView viewResolver(String viewName) {
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
	}


	//Parameter 값에 대한 메서드 추출
	private Map<String, String> createParamMap(HttpServletRequest req) {
		Map<String, String> paramMap = new HashMap<>();

		req.getParameterNames().asIterator()
				.forEachRemaining(name -> paramMap.put(name, req.getParameter(name)));
		return paramMap;
	}
}
