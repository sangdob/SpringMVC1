package SpringMVC.Servlet.basic.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {
	private String viewPath;

	public MyView(String viewPath) {
		this.viewPath = viewPath;
	}

	public void render(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}

	public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		modelToRequestAttribute(model, req);
		render(req, resp);
	}

	private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest req) {
		model.forEach((key, value) -> req.setAttribute(key, value));
	}

	private MyView viewResolver(String viewName) {
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
	}
}
