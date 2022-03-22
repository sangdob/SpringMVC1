package SpringMVC.Servlet.basic.web.frontcontroller.v5;

import SpringMVC.Servlet.basic.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

	boolean supports(Object handler);

	ModelView handler(HttpServletRequest req, HttpServletResponse resp, Object handler) throws ServletException, IOException;
}
