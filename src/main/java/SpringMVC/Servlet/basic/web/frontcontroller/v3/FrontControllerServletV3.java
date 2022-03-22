package SpringMVC.Servlet.basic.web.frontcontroller.v3;

import SpringMVC.Servlet.basic.web.frontcontroller.ModelView;
import SpringMVC.Servlet.basic.web.frontcontroller.MyView;
import SpringMVC.Servlet.basic.web.frontcontroller.v3.controller.MemberFormControllerV3;
import SpringMVC.Servlet.basic.web.frontcontroller.v3.controller.MemberListControllerV3;
import SpringMVC.Servlet.basic.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/frontController/v3/*")
public class FrontControllerServletV3 extends HttpServlet {
	private Map<String, ControllerV3> controllerV3Map = new HashMap<>();

	public FrontControllerServletV3() {
		controllerV3Map.put("/frontController/v3/members/newForm", new MemberFormControllerV3());
		controllerV3Map.put("/frontController/v3/members/save", new MemberSaveControllerV3());
		controllerV3Map.put("/frontController/v3/members", new MemberListControllerV3());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("FrontControllerServletV3.service");

		String reqURI = req.getRequestURI();

//		다형성을 이용하여 Interface로 부모형태를 받아 Map의 Key값으로 찾아준다.
		ControllerV3 controller = controllerV3Map.get(reqURI);

		if (controller == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		Map<String, String> paramMap = createParamMap(req);

		ModelView modelView = controller.process(paramMap);

		String viewName = modelView.getViewName();
		MyView myView = viewResolver(viewName);

		myView.render(modelView.getModel() , req, resp);
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
