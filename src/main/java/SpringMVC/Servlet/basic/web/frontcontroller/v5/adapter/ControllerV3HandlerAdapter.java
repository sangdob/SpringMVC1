package SpringMVC.Servlet.basic.web.frontcontroller.v5.adapter;

import SpringMVC.Servlet.basic.web.frontcontroller.ModelView;
import SpringMVC.Servlet.basic.web.frontcontroller.v3.ControllerV3;
import SpringMVC.Servlet.basic.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

	@Override
	public boolean supports(Object handler) {
		return (handler instanceof ControllerV3);
	}

	@Override
	public ModelView handler(HttpServletRequest req, HttpServletResponse resp, Object handler) throws ServletException, IOException {
		ControllerV3 controller = (ControllerV3) handler;

		Map<String, String> paramMap = createParamMap(req);
		ModelView modelView = controller.process(paramMap);

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
