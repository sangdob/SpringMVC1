package SpringMVC.Servlet.basic.web.frontcontroller.v1;

/**
 * 다형성을 이용한 Interface Controller 부모 형태
 * Spring MVC-1
 * 강의명 : 프론트 컨트롤러 도입 - v1
 * @since 2022.03.22
 * @author sangdob
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {

	void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
