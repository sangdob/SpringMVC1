package SpringMVC.Servlet.basic.web.frontcontroller.v5;

import SpringMVC.Servlet.basic.web.frontcontroller.ModelView;
import SpringMVC.Servlet.basic.web.frontcontroller.MyView;
import SpringMVC.Servlet.basic.web.frontcontroller.v3.controller.MemberFormControllerV3;
import SpringMVC.Servlet.basic.web.frontcontroller.v3.controller.MemberListControllerV3;
import SpringMVC.Servlet.basic.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import SpringMVC.Servlet.basic.web.frontcontroller.v4.controller.MemberFormControllerV4;
import SpringMVC.Servlet.basic.web.frontcontroller.v4.controller.MemberListControllerV4;
import SpringMVC.Servlet.basic.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import SpringMVC.Servlet.basic.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import SpringMVC.Servlet.basic.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/frontController/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

	private final Map<String, Object> handlerMappingMap = new HashMap<>();
	private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

	public FrontControllerServletV5() {
		initHandlerMappingMap();
		initHandlerAdapters();
	}

	private void initHandlerMappingMap(){
		//V3
		handlerMappingMap.put("/frontController/v5/v3/members/newForm", new MemberFormControllerV3());
		handlerMappingMap.put("/frontController/v5/v3/members/save", new MemberSaveControllerV3());
		handlerMappingMap.put("/frontController/v5/v3/members", new MemberListControllerV3());

		//V4
		handlerMappingMap.put("/frontController/v5/v4/members/newForm", new MemberFormControllerV4());
		handlerMappingMap.put("/frontController/v5/v4/members/save", new MemberSaveControllerV4());
		handlerMappingMap.put("/frontController/v5/v4/members", new MemberListControllerV4());
	}

	private void initHandlerAdapters() {
		handlerAdapters.add(new ControllerV3HandlerAdapter());
		handlerAdapters.add(new ControllerV4HandlerAdapter());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Request URI정보를 연결 Handler역할
		//현재 초기화 된 Contoller에서 페이지의 정보를 찾아 Inteface에 연결된 Controller를 찾아준다.
		Object handler = getHandler(req);

		//handler에 mapping된 uri를 찾아오지 못할 경우 404에러를 나타내고 Return한다.
		if (handler == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		MyHandlerAdapter adapter = getHandlerAdapter(handler);
		ModelView modelView = adapter.handler(req, resp, handler);

		MyView myView = viewResolver(modelView.getViewName());
		myView.render(modelView.getModel(), req, resp);

	}

	private MyHandlerAdapter getHandlerAdapter(Object handler) {
		for (MyHandlerAdapter adapter : handlerAdapters) {
			if(adapter.supports(handler)){
				 return adapter;
			}
		}

		throw new IllegalArgumentException("Handler Adapter를 찾을 수 없습니다. \nhandle = " + handler);
	}

	//request로 들어온 URI를 handlerMappingMap에서 찾아 꺼낸다. 다형성 가능
	private Object getHandler(HttpServletRequest req) {
		String reqURI = req.getRequestURI();
		return handlerMappingMap.get(reqURI);
	}

	private MyView viewResolver(String viewName) {
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
	}
}
