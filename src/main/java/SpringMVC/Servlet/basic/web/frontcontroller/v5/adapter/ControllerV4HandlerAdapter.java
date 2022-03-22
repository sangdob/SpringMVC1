package SpringMVC.Servlet.basic.web.frontcontroller.v5.adapter;

import SpringMVC.Servlet.basic.web.frontcontroller.ModelView;
import SpringMVC.Servlet.basic.web.frontcontroller.v4.ControllerV4;
import SpringMVC.Servlet.basic.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof ControllerV4);
	}

	@Override
	public ModelView handler(HttpServletRequest req, HttpServletResponse resp, Object handler) throws ServletException, IOException {
		ControllerV4 controller = (ControllerV4) handler;

		Map<String, String> paramMap = createParamMap(req);
		Map<String, Object> model = new HashMap<>();
		String viewName = controller.process(paramMap, model);

		ModelView modelView = new ModelView(viewName);
		modelView.setModel(model);

		return modelView;
	}

	//Parameter 값에 대한 메서드 추출
	private Map<String, String> createParamMap(HttpServletRequest req) {
		Map<String, String> paramMap = new HashMap<>();

		req.getParameterNames().asIterator()
				.forEachRemaining(name -> paramMap.put(name, req.getParameter(name)));
		return paramMap;
	}
}
